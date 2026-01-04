package com.example.taxdocument.nfe.dto.tax;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record IpiTaxDto(
        @NotBlank String producerCnpj,
        @NotBlank String sealCode,
        @NotNull BigInteger sealQuantity,
        @NotBlank String framingCode,
        @Valid TaxableIpiDto taxableIpi,
        @Valid NonTaxableIpiDto nonTaxableIpi
) {

    public record IpiCstDto(
            @NotBlank String code,
            String description
    ){}

    public record TaxableIpiDto(
            @Valid @NotNull IpiCstDto situation,
            String baseValue,
            String taxRate,
            String quantity,
            String unitValue,
            @NotBlank String taxValue
    ) {}

    public record NonTaxableIpiDto(
            @Valid @NotNull IpiCstDto situation
    ) {}
}
