package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Icms60RequestDto(
        @Valid
        @NotNull(message = "NF origin Dto cannot be null.")
        NFOriginRequestDto nfOriginDto,

        @Valid
        @NotNull(message = "Icms Tax cannot be null.")
        IcmsTaxRequestDto icmsTaxDto,

        @NotBlank(message = "valueBCICMSSTRetained is required")
        String valueBCICMSSTRetainedDto,

        @NotBlank(message = "percentageAliquotICMSSTConsumerFinal is required.")
        String percentageAliquotICMSSTConsumerFinalDto,

        @NotBlank(message = "Icms substituited value is required.")
        String icmsVaalueSubstitutedDto,

        @NotBlank(message = "Icms Retained value is required.")
        String icmsValueRetainedDto,

        @NotBlank(message = "valueBaseCalcFundCombatPovertyDto is required.")
        String valueBCFundCombatPovertySTDto,

        @NotBlank(message = "percentage fund to combat poverty is required.")
        String percentageFundCombatPovertySTDto,

        @NotBlank(message = "value Fund To Combat Poverty is required.")
        String valueFundCombatPovertySTDto,

        @NotBlank(message = "Icms Retained value is required.")
        String percentageRetainedBcEfetiveDto,

        @NotBlank(message = "Icms efetive value Dto is required.")
        String icmsEfetiveValueDto
) {
}
