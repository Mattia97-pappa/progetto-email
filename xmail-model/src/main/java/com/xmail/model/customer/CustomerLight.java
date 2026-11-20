package com.xmail.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerLight {


    private Integer customerId;
    private String customerUuid;
    private String customerName;
    private String customerSurname;

}
