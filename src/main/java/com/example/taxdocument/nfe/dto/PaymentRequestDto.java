package com.example.taxdocument.nfe.dto;

import java.util.List;

public record PaymentRequestDto(

        List<NFPaymentMethodDto> paymentMethodDto,
        String changeDto

) {
}
