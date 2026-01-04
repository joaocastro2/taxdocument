package com.example.taxdocument.nfe.dto.product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public record ProductNfeDto(
        @NotBlank String productCode,
        @NotBlank String descCode,
        @NotBlank String productNcm,
        @NotBlank String productCest,
        @NotBlank String productCfop,
        @NotBlank String comercialUnity,
        @NotEmpty BigDecimal quantity,
        @NotEmpty BigDecimal unitValue,
        @NotEmpty BigDecimal totalGrossValue,
        @Valid ItemTaxDto itemTax,
        @NotEmpty BigDecimal discountValue,
        @NotEmpty BigDecimal freightValue
){}
