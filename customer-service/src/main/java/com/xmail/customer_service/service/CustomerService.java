package com.xmail.customer_service.service;

import com.xmail.customer_service.persistence.CustomerDao;
import com.xmail.model.customer.CustomerInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public List<CustomerInformation> getAllCustomerWithoutFilter(){
        return customerDao.getAllCustomerWithoutFilter();
    }

}
