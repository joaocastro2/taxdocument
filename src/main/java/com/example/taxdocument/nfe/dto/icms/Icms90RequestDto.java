package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Icms90RequestDto(
        @Valid
        @NotNull(message = "NF origin Dto cannot be null.")
        NFOriginRequestDto nfOriginDto,

        @Valid
        @NotNull(message = "Icms Tax cannot be null.")
        IcmsTaxRequestDto icmsTaxDto,

        @Valid
        @NotNull(message = "Icms modality calculation base cannot be null.")
        IcmsModalityRequestDto icmsModalityBCDto,

        @NotBlank(message = "Value BC is required.")
        String valueBCDto,

        @NotBlank(message = "Reduction percentage is required.")
        String percentageReductBCDto,

        @NotBlank(message = "Tax value is required.")
        String taxValueDto,

        @NotBlank(message = "valueBaseCalcFundCombatPovertyDto is required.")
        String valueBCFundCombatPovertyDto,

        @NotBlank(message = "percentage fund to combat poverty is required.")
        String percentageFundCombatPovertyDto,

        @NotBlank(message = "value Fund To Combat Poverty is required.")
        String valueFundCombatPovertyDto,

        @Valid
        @NotNull(message = "Icms Has modality Calculation base is required.")
        IcmsHasModalityBC modalityBCICMSSTDto,

        @Valid
        @NotNull(message = "Percentage margin value added ICMSST is required.")
        String percentageMarginValueAddedICMSSTDto,

        @NotBlank(message = "Percentage reduction calculation base ICMSST is reqiured.")
        String percentageReductionBCICMSSTDto,

        @NotBlank(message = "Value calculation base is required.")
        String valueBCSTDto,

        @NotBlank(message = "percentageAliquotTaxICMSST is required.")
        String percentageAliquotTaxICMSSTDto,

        @NotBlank(message = "Value ICMSST is required.")
        String valueICMSSTDto,

        @NotBlank(message = "valueBaseCalcFundCombatPovertyDto is required.")
        String valueBCFundCombatPovertySTDto,

        @NotBlank(message = "percentage fund to combat poverty is required.")
        String percentageFundCombatPovertySTDto,

        @NotBlank(message = "value Fund To Combat Poverty is required.")
        String valueFundCombatPovertySTDto,

        @NotBlank(message = "Icms Value Tax Relief is required.")
        String icmsValueReliefDto,

        @Valid
        @NotNull(message = "Tax relief is required.")
        IcmsExcemptionReasonDto taxReliefDto,

        @NotBlank(message = "Tax relief value is required.")
        String taxReliefICMSSTValueDto,

        @Valid
        @NotNull(message = "IcmsExcemptionReason is required")
        IcmsExcemptionReasonDto motivoDesoneracaoICMSSTDto,

        @Valid
        @NotNull(message = "Indicates deducts exemption is required.")
        IcmsDeductionTipe indicatesDeductsExemptionDto
) {
}
