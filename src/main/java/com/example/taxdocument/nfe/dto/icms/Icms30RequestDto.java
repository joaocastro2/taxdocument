package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Icms30RequestDto(
        @Valid
        @NotNull(message = "NF origin Dto cannot be null.")
        NFOriginRequestDto nfOriginDto,

        @Valid
        @NotNull(message = "Icms Tax cannot be null.")
        IcmsTaxRequestDto icmsTaxDto,

        @Valid
        @NotNull(message = "Icms Has modality cannot be null.")
        IcmsHasModalityBC modalidadeBCICMSDto,

        @NotBlank(message = "Percentage Margin Value Added ICMSST is required.")
        String percentageMarginValueAddedICMSSTDto,

        @NotBlank(message = "Reduction Percentage Calculation Basis is required.")
        String reductionPercentageBCICMSSTDto,

        @NotBlank(message = "Calculation basis value is required.")
        String valueBcICMSSTDto,

        @NotBlank(message = "Tax percentage calculation basis is required.")
        String taxPercentageBCICMSSTDto,

        String valueBCFundCombatPovertySTDto,

        @NotBlank(message = "percentage fund to combat poverty is required.")
        String percentageFundCombatPovertySTDto,

        @NotBlank(message = "value Fund To Combat Poverty is required.")
        String valueFundCombatPovertySTDto,

        @NotBlank(message = "ICMS Tax excemption value is required.")
        String taxExcemptionValue,

        @Valid
        @NotNull(message = "Excemption reason cannot be null.")
        IcmsExcemptionReasonDto extemptionReasonDto,

        @Valid
        @NotNull(message = "Deduction tipe cannot be null.")
        IcmsDeductionTipe DeductionTipeDto

) {
}
