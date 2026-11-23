package com.xmail.customer_service.exception.custom;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(UUID customerUuid) {
        super("customer not found with uuid: "+customerUuid);
    }
}
