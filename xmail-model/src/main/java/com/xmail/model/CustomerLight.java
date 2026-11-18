package com.xmail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerLight {


    private Integer customerId;
    private String customerName;
    private String customerSurname;

}
