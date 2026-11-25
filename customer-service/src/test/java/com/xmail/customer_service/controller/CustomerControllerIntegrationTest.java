package com.xmail.customer_service.controller;


import com.xmail.customer_service.dto.CustomerResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import tools.jackson.databind.json.JsonMapper;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest()
@AutoConfigureMockMvc
public class CustomerControllerIntegrationTest {


    static final String CUSTOMER_UUID = "9f4c2a1b-7e3d-4b8a-9c12-6d5e8f0a3b2c";
    static final String STARK_EXPECTED_JSON_PATH = "expected/customer-tony-stark.json";

    @Container
    @ServiceConnection
    public static PostgreSQLContainer postgresql = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("devDbTest")
            .withUsername("sa")
            .withPassword("sa");

    @Autowired
    private JsonMapper jsonMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void test_shouldReturnAllCustomerWithoutFilter() throws Exception {

        mockMvc.perform(get("/customer/allCustomerWithoutFIlter")).
                andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    void test_shouldReturTheNewCustomer() throws Exception {


        jdbcTemplate.update("""
                INSERT INTO customers (customer_name, customer_surname, customer_email, customer_uuid)
                VALUES ('Tony', 'Stark', 'stark@example.com', CAST(? AS uuid))
                """, CUSTOMER_UUID);

        ResultActions resultactions = mockMvc.perform(get("/customer/" + CUSTOMER_UUID))
                .andExpect(status().isOk());

        String body = resultactions.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        CustomerResponseDto actualCustomerResponseDto = jsonMapper.readValue(body, CustomerResponseDto.class);

        String expected = new ClassPathResource(STARK_EXPECTED_JSON_PATH)
                .getContentAsString(StandardCharsets.UTF_8);

        CustomerResponseDto expectedDtoCustomer = jsonMapper.readValue(expected, CustomerResponseDto.class);

        assertEquals(expectedDtoCustomer, actualCustomerResponseDto);


    }


}
