package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Icms51RequestDto(
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

        @NotBlank(message = "Tax benefit code is required.")
        String taxBenefitCodeDto,

        @NotBlank(message = "Value BC icms is required.")
        String valueBCIcmsDto,

        @NotBlank(message = "Tax percentage Dto is required.")
        String taxPercentageDto,

        @NotBlank(message = "Operation icms value is required.")
        String operationIcmsValueDto,

        @NotBlank(message = "Deferral percentage value is required.")
        String deferralpercentageValueDto,

        @NotBlank(message = "Icms value is required.")
        String icmsValue,

        @NotBlank(message = "valueBaseCalcFundCombatPovertyDto is required.")
        String valueBCFundCombatPovertyDto,

        @NotBlank(message = "percentage fund to combat poverty is required.")
        String percentageFundCombatPovertyDto,

        @NotBlank(message = "value Fund To Combat Poverty is required.")
        String valueFundCombatPovertyDto,

        @NotBlank(message = "Deferral percentage combate poverty is required.")
        String deferralPercentageCombatPovertyDto,

        @NotBlank(message = "Deferral value combate poverty is required.")
        String deferralValuePercentageCombatPovertyDto,

        @NotBlank(message = "Efetive value combate poverty is required.")
        String efetiveValuePercentageCombatPovertyDto
) {
}
