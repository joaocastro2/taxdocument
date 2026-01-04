package com.example.taxdocument.nfe.dto.tax;

import jakarta.validation.constraints.NotBlank;

public record ImportTaxDto(
        @NotBlank String baseValue,
        @NotBlank String customsExpenseValue,
        @NotBlank String importTaxValue,
        @NotBlank String IOFValue
) {
}
