package com.xmail.customer_service.service;

import com.xmail.customer_service.dto.CustomerResponseDto;
import com.xmail.customer_service.entity.Customer;
import com.xmail.customer_service.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;


    static final UUID CUSTOMER_UUID = UUID.fromString("9f4c2a1b-7e3d-4b8a-9c12-6d5e8f0a3b2c");

    @Test
    void test_shouldReturnTheCorrectMappedEntityDto() {

        Customer customerTonyStark = new Customer(1L, "Tony", "Stark", "tonystark@libero.it", CUSTOMER_UUID);

        when(customerRepository.findByCustomerUuid(CUSTOMER_UUID)).thenReturn(Optional.of(customerTonyStark));

        //testing if the code works searching using customer uuid
        CustomerResponseDto customerFromUuid = customerService.getCustomerByUuid(CUSTOMER_UUID);

        assertEquals(CUSTOMER_UUID, customerFromUuid.customerUuid());

        // testing if the mapper to customer to customerDto works
        CustomerResponseDto tonyStarkDto = customerService.mapCustomerResponseDto(customerTonyStark);

        assertEquals(tonyStarkDto.customerEmail(), customerTonyStark.getCustomerEmail());


    }

}
