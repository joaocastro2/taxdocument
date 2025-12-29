package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginRequestDto;
import com.example.taxdocument.nfe.dto.product.ProductRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Icms10RequestDto(
        @Valid
        @NotNull(message = "Nf Origin cannot be null.")
        NFOriginRequestDto nfOriginDto,

        @Valid
        @NotNull(message = "Tax situation cannot be null.")
        IcmsTaxRequestDto icmsTaxDto,

        @Valid
        @NotNull(message = "Icms Modality cannot be null.")
        IcmsModalityRequestDto icmsModalityDto,

        @NotBlank(message = "Calculation basis is required.")
        String calculationbasisDto,

        @NotBlank(message = "Percentage Rate is required.")
        String percentageRateDto,

        @NotBlank(message = "Tax Value is required.")
        String taxValueDto,

        @NotBlank(message = "valueBaseCalcFundCombatPovertyDto is required.")
        String valueBaseCalcFundCombatPovertyDto,

        @NotBlank(message = "percentage fund to combat poverty is required.")
        String percentageFundCombatPovertyDto,

        @NotBlank(message = "value Fund To Combat Poverty is required.")
        String valueFundCombatPovertyDto,

        @Valid
        @NotNull(message = "Icms Has modality cannot be null.")
        IcmsHasModalityBC modalityHasBcDto,

        @NotBlank(message = "percentageMarginValueAddedICMSST is required.")
        String percentageMarginValueAddedICMSSTDto,

        @NotBlank(message = "percentageReductionBCICMSSTDto is required.")
        String percentageReductionBCICMSSTDto,

        @NotBlank(message = "valueBCICMSST is required.")
        String valueBCICMSSTDto,

        @NotBlank(message = "percentageAliquotTaxICMSST is required.")
        String percentageAliquotTaxICMSSTDto,

        @NotBlank(message = "Value ICMSST is required.")
        String valueICMSSTDto,

        @NotBlank(message = "valueBCFundCombatPovertyST is required.")
        String valueBCFundCombatPovertySTDto,

        @NotBlank(message = "percentageFundCombatPovertySTDto is required.")
        String percentageFundCombatPovertySTDto,

        @NotBlank(message = "valueFundToCombatPovertyST is required.")
        String valueFundToCombatPovertySTDto,

        @NotBlank(message = "valueExemptedICMSSTDto is required.")
        String valueExemptedICMSSTDto,

        @Valid
        @NotBlank(message = "IcmsExcemptionReasonDto is required.")
        IcmsExcemptionReasonDto exceptionReasonICMSSTDto

) {}
