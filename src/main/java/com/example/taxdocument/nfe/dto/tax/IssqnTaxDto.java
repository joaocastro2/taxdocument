package com.example.taxdocument.nfe.dto.tax;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IssqnTaxDto(
        @NotBlank String baseValue,
        @NotBlank String taxRate,
        @NotBlank String taxValue,
        @NotNull Integer cityCode,
        @NotBlank String serviceListItem,

        String deductionValue,
        String otherValue,
        String unconditionalDiscountValue,
        String conditionalDiscountValue,
        String issRetentionValue,

        @Valid @NotNull IssIndicatorDto issExigibility,

        String serviceCode,
        Integer incidenceCityCode,
        String countryCode,
        String processNumber,

        @Valid @NotNull FiscalIncentiveDto fiscalIncentive
) {

    public record IssIndicatorDto(
            @NotBlank String code,
            String description
    ) {}

    public record FiscalIncentiveDto(
            @NotBlank String code,
            String description
    ) {}
}