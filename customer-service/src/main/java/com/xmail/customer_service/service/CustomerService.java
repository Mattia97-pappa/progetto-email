package com.xmail.customer_service.service;

import com.xmail.customer_service.dto.CustomerResponseDto;
import com.xmail.customer_service.entity.Customer;
import com.xmail.customer_service.exception.custom.CustomerNotFoundException;
import com.xmail.customer_service.persistence.CustomerDao;
import com.xmail.customer_service.repository.CustomerRepository;
import com.xmail.model.customer.CustomerInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    CustomerRepository customerRepository;

    //taking customer list using mybatis
    public List<CustomerInformation> getAllCustomerWithoutFilter() {
        return customerDao.getAllCustomerWithoutFilter();
    }

    public CustomerResponseDto getCustomerByUuid(UUID customerUuid) {

        Customer customer = customerRepository.findByCustomerUuid(customerUuid)
                .orElseThrow(() -> new CustomerNotFoundException(customerUuid));

        return mapCustomerResponseDto(customer);
    }


    CustomerResponseDto mapCustomerResponseDto(Customer c){

        return new CustomerResponseDto(
                c.getCustomerUuid(), c.getCustomerName(), c.getCustomerSurname(),
                c.getCustomerEmail());
    }

}
