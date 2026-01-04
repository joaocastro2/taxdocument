package com.example.taxdocument.nfe.dto.tax;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PisTaxDto(
        @Valid PisAliquotDto aliquota,
        @Valid PisQuantityDto quantidade,
        @Valid PisNonTaxableDto naoTributado,
        @Valid PisOthersDto outrasOperacoes,
        @Valid PisStDto pisst
) {
    public record PisCstDto(
            @NotBlank String code,
            String description
    ) {}

    public record PisAliquotDto(
            @Valid @NotNull PisCstDto situation,
            @NotBlank String baseValue,
            @NotBlank String taxRate,
            @NotBlank String taxValue
    ) {}

    public record PisQuantityDto(
            @Valid @NotNull PisCstDto situation,
            @NotBlank String quantitySold,
            @NotBlank String adRemRate,
            @NotBlank String taxValue
    ) {}

    public record PisNonTaxableDto(@Valid @NotNull PisCstDto situation) {}

    public record PisOthersDto(
            @Valid @NotNull PisCstDto situation,
            String baseValue,
            String taxRate,
            String quantitySold,
            String adRemRate,
            @NotBlank String taxValue
    ) {}

    public record PisStDto(
            String baseValue,
            String taxRate,
            String quantitySold,
            String adRemRate,
            @NotBlank String taxValue,
            String sumIndicator
    ) {}
}