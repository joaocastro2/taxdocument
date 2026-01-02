package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Icms20RequestDto(
        @Valid
        @NotNull(message = "NF origin Dto cannot be null.")
        NFOriginRequestDto nfOriginDto,

        @Valid
        @NotNull(message = "Icms Tax cannot be null.")
        IcmsTaxRequestDto icmsTaxDto,

        @Valid
        @NotNull(message = "Icms modality cannot be null.")
        IcmsModalityRequestDto modalidadeBCICMSDto,

        @NotBlank(message = "Reduction percentage is required.")
        String redutionPercentageBCDto,

        @NotBlank(message = "Value BC icms is required.")
        String valueBCIcmsDto,

        @NotBlank(message = "Tax percentage Dto is required.")
        String taxPercentageDto,

        @NotBlank(message = "Tax value is required.")
        String taxValueDto,

        @NotBlank(message = "valueBaseCalcFundCombatPovertyDto is required.")
        String valueBCFundCombatPovertyDto,

        @NotBlank(message = "percentage fund to combat poverty is required.")
        String percentageFundCombatPovertyDto,

        @NotBlank(message = "value Fund To Combat Poverty is required.")
        String valueFundCombatPovertyDto,

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
