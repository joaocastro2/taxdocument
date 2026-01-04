package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaxIcmsSTRequestDto(
        @Valid
        @NotNull(message = "NF origin Dto cannot be null.")
        NFOriginDto nfOriginDto,

        @Valid
        @NotNull(message = "Icms Tax cannot be null.")
        IcmsTaxDto icmsTaxDto,

        @NotBlank(message = "ValueBCICMSSTRetainedUFSender is required.")
        String ValueBCICMSSTRetainedUFSender,

        @NotBlank(message = "aliqSuportConsFinal is required.")
        String aliqSuportConsFinal,

        @NotBlank(message = "substitutedValueICMS is required.")
        String substitutedValueICMS,

        @NotBlank(message = "valueICMSSTRetainedUFSender is required.")
        String valueICMSSTRetainedUFSender,

        @NotBlank(message = "valueBaseCalcFundCombatPovertyDto is required.")
        String valueBCFundCombatPovertySTDto,

        @NotBlank(message = "percentage fund to combat poverty is required.")
        String percentageFundCombatPovertySTDto,

        @NotBlank(message = "value Fund To Combat Poverty is required.")
        String valueFundCombatPovertySTDto,

        @NotBlank(message = "valueDestinationBCICMSSTUFDestination is required.")
        String valueDestinationBCICMSSTUFDestination,

        @NotBlank(message = "valueICMSSTUFDestination is required.")
        String valueICMSSTUFDestination,

        @NotBlank(message = "valueICMSSTUFDestination is required.")
        String percentageReductionBCEffective,

        @NotBlank(message = "valueBCEffective is required.")
        String valueBCEffective,

        @NotBlank(message = "percentageAliquotICMSEffective is required.")
        String percentageAliquotICMSEffective,

        @NotBlank(message = "valueICMSEffective is required.")
        String valueICMSEffective
) {
}
