package com.xmail.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CustomerInformation extends CustomerLight{


    private String customerEmail;

}
