package com.example.taxdocument.nfe.dto;

public record NFCardDto(

        NFPaymentIntegrationDto paymentIntegrationDto,
        String cardInfocnpjDto,
        NFCardOperatorDto cardOperatorDto,
        String authOpCardDto,
        String cnpjBenefPayment,
        String iTermPayment

) {
}
