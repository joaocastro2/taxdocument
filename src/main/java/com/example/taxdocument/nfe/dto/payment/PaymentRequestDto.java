package com.example.taxdocument.nfe.dto.payment;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record PaymentRequestDto(
        @Valid
        @NotEmpty(message = "Payment method cannot be null")
        List<NFPaymentMethodDto> paymentMethodDto,

        @NotBlank(message = "Payment change cannot be null")
        String changeDto
) {
    public record NFPaymentMethodDto (
            @Valid
            @NotNull(message = "Payment indicator cannot be null")
            NFPaymentIndicatorDto paymentIndicatorDto,

            @Valid
            @NotNull(message = "PaymentForm cannot be null")
            NFPaymentFormDto paymentFormDto,

            @NotBlank(message = "Desc Payment cannot be null")
            String descPaymentFormDto,

            @NotBlank(message = "Payment Value cannot be null")
            String paymentValue,

            @NotNull(message = "Payment Date is required")
            LocalDate paymentDate,

            @NotBlank(message = "Cnpj Transactional Payment cannot be null")
            String cnpjTransactionalPayment,

            @NotBlank(message = "Uf Transactional Payment cannot be null")
            String ufTransactionalPayment,

            @Valid
            @NotNull(message = "Card info. Cannot be null")
            NFCardDto cardDto
    ){}

    public record NFPaymentIndicatorDto (
            @NotBlank(message = "Payment Indicator Code cannot be null")
            String codeDto,

            @NotBlank(message = "Payment desc indicator cannot be null")
            String descDto
    ){}

    public record NFPaymentFormDto (

            @NotBlank(message = "Cod M payment cannot be null")
            String codMPaymentDto,

            @NotBlank(message = "Desc M payment cannot be null")
            String descMPaymentDto
    ){}

    public record NFCardDto(
            @Valid
            @NotNull(message = "Payment Integration cannot be null")
            NFPaymentIntegrationDto paymentIntegrationDto,

            @NotBlank(message = "Info card cannot be null")
            String cardInfocnpjDto,

            @Valid
            @NotNull(message = "Card operator cannot be null")
            NFCardOperatorDto cardOperatorDto,

            @NotBlank(message = "Ahtorization OP cannot be null")
            String authOpCardDto,

            @NotBlank(message = "Cnpj Bnenef Payment cannot be null")
            String cnpjBenefPayment,

            @NotBlank(message = "I Term Payment cannot be null")
            String iTermPayment

    ){}

    public record NFPaymentIntegrationDto(

            @NotBlank(message = "Cod Int cannot be null")
            String codIntDto,

            @NotBlank(message = "Desc Int cannot be null")
            String descIntDto
    ){}

    public record NFCardOperatorDto(
            @NotBlank(message = "Operator cod cannot be null")
            String operatorCodDto,

            @NotBlank(message = "Desc operator cannot be null")
            String descOperatorDto
    ){}

}
