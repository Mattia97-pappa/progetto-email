package com.xmail.customer_service.controller;

import com.xmail.customer_service.dto.CustomerResponseDto;
import com.xmail.customer_service.service.CustomerService;
import com.xmail.model.customer.CustomerInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

@Autowired
CustomerService customerService;

@GetMapping("/allCustomerWithoutFIlter")
    public ResponseEntity<List<CustomerInformation>> getAllCustomerWithoutFilter(){
        return ResponseEntity.ok(customerService.getAllCustomerWithoutFilter());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CustomerResponseDto> getCustomerByUuid(@PathVariable UUID uuid){

    return ResponseEntity.ok(customerService.getCustomerByUuid(uuid));
    }

}
