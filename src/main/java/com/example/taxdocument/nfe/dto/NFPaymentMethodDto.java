package com.example.taxdocument.nfe.dto;

import java.time.LocalDate;

public record NFPaymentMethodDto(

        NFPaymentIndicatorDto paymentIndicatorDto,
        NFPaymentFormDto paymentFormDto,
        String descPaymentFormDto,
        String paymentValue,
        LocalDate PaymentDate,
        String cnpjTransactionalPayment,
        String ufTransactionalPayment,
        NFCardDto cardDto

) {
}
