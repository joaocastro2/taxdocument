package com.example.taxdocument.nfe.dto.charge;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ChargeRequestDto(
        @Valid
        @NotNull(message = "Invoice details are required.")
        NFInvoiceRequestDto invoiceDto,

        @Valid
        @NotEmpty(message = "A nota deve ter pelo menos uma parcela")
        List<NFInstallmentRequestDto> installmentsDto
) {
    public record NFInvoiceRequestDto(
            @NotBlank(message = "Invoice Number is required")
            String invoiceNumber,

            @NotBlank(message = "Invoice original value is required")
            String invoiceOriginalValue,

            @NotBlank(message = "Discount Value is required")
            String invoiceDiscountValue,

            @NotBlank(message = "NetValue is required")
            String invoiceNetValue
    ){}

    public record NFInstallmentRequestDto(
            @NotBlank(message = "Installment number is required")
            String installmentNumber,

            @NotBlank(message = "Maturity date is required")
            String maturityDate,

            @NotBlank(message = "Installment value is required")
            String installmentValue
    ){}

}

//test