package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Icms15RequestDto(
        @Valid
        @NotNull(message = "NF origin Dto cannot be null.")
        NFOriginRequestDto nfOriginDto,

        @Valid
        @NotNull(message = "Icms Tax cannot be null.")
        IcmsTaxRequestDto icmsTaxDto,

        @NotBlank(message = "Calculation basis is required.")
        String calculationBasisDto,

        @NotBlank(message = "Percentage Rate is required.")
        String percentageRateDto,

        @NotBlank(message = "Tax Value is required.")
        String taxValueDto,

        @NotBlank(message = "Taxable Base quantity subject With Holdding is required.")
        String taxableBaseQttySubjectWhDto,

        @NotBlank(message = "Percentage rate with holdding is required.")
        String percentageRateWhDto,

        @NotBlank(message = "Tax value With Holdding is required")
        String taxValueWhDto,

        @NotBlank(message = "Tax percentage recuction is required.")
        String taxPercentageReductDto,

        @Valid
        @NotNull(message = "Reason for reduction ADREM cannot be null.")
        NFReasonForReductionADREM reasonReductionADREMDto

        ) {
}
