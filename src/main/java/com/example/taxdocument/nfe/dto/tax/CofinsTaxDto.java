package com.example.taxdocument.nfe.dto.tax;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CofinsTaxDto(
        @Valid CofinsAliquotDto aliquota,           // CST 01, 02
        @Valid CofinsQuantityDto quantidade,       // CST 03
        @Valid CofinsNonTaxableDto naoTributavel,  // CST 04 a 09
        @Valid CofinsOthersDto outrasOperacoes,    // CST 49, 50 a 99
        @Valid CofinsStDto cofinsst                // COFINS ST (Substituição Tributária)
) {
    // Componente comum para a Situação Tributária
    public record CofinsCstDto(@NotBlank String code, String description) {}

    // Grupos que calculam sobre o valor (Alíquota %)
    public record CofinsAliquotDto(
            @Valid @NotNull CofinsCstDto situation,
            @NotBlank String baseValue,      // vBC
            @NotBlank String taxRate,       // pCOFINS
            @NotBlank String taxValue        // vCOFINS
    ) {}

    // Grupos que calculam sobre unidade (Quantidade)
    public record CofinsQuantityDto(
            @Valid @NotNull CofinsCstDto situation,
            @NotBlank String quantitySold,   // qBCProd
            @NotBlank String adRemRate,      // vAliqProd
            @NotBlank String taxValue        // vCOFINS
    ) {}

    // Grupos de Isenção ou Suspensão
    public record CofinsNonTaxableDto(
            @Valid @NotNull CofinsCstDto situation
    ) {}

    // Grupo para situações genéricas (CST 99)
    public record CofinsOthersDto(
            @Valid @NotNull CofinsCstDto situation,
            String baseValue,
            String taxRate,
            String quantitySold,
            String adRemRate,
            @NotBlank String taxValue
    ) {}

    // Grupo de COFINS ST (Substituição Tributária)
    public record CofinsStDto(
            String baseValue,
            String taxRate,
            String quantitySold,
            String adRemRate,
            @NotBlank String taxValue,
            String sumIndicator // indSomaCOFINSST
    ) {}
}