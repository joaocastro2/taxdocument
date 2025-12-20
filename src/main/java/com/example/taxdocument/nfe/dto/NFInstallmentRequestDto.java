package com.example.taxdocument.nfe.dto;

public record NFInstallmentRequestDto(

        String installmentNumber,
        String maturityDate,
        String installmentValue

) {
}
