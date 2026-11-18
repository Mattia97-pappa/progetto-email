package com.xmail.migrations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Testcontainers
@SpringBootTest()
public class DockerTest {


    static final int V1_1_CHECKSUM =799947649;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Container
    @ServiceConnection
    public static PostgreSQLContainer postgresql = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("devDbTest")
            .withUsername("sa")
            .withPassword("sa");


@Test
void test_checkIfWeAreUsingDbOfTest(){
String currentDb = jdbcTemplate.queryForObject("SELECT current_database();", String.class);
    assertEquals(postgresql.getDatabaseName(),currentDb);
}

@Test
    void test_isflyWayWorking(){
    int numberOfCustomer = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM customers where customer_surname = 'Pappacena'", Integer.class);
    assertEquals(1,numberOfCustomer);
}

@Test
    void test_verifyCheckSumIsCorrect(){
    int checkSumv1 = jdbcTemplate.queryForObject("SELECT checksum FROM flyway_schema_history where version= '1.1'", Integer.class);
assertEquals(V1_1_CHECKSUM, checkSumv1);

}

}
