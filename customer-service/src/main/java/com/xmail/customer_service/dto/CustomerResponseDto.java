package com.xmail.customer_service.dto;

import java.util.UUID;

public record CustomerResponseDto(
        UUID customerUuid,
        String customerName,
        String customerSurname,
        String customerEmail
) {
}
