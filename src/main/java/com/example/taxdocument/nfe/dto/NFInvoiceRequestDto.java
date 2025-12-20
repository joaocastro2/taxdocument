package com.example.taxdocument.nfe.dto;

public record NFInvoiceRequestDto(

        String invoiceNumber,
        String originalValue,
        String discountValue,
        String netValue

) {
}
