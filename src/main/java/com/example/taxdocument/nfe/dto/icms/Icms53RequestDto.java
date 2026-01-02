package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Icms53RequestDto(
        @Valid
        @NotNull(message = "NF origin Dto cannot be null.")
        NFOriginRequestDto nfOriginDto,

        @Valid
        @NotNull(message = "Icms Tax cannot be null.")
        IcmsTaxRequestDto icmsTaxDto,

        @NotBlank(message = "Calculation basis quantity is required.")
        String calcBasysQuantityDto,

        @NotBlank(message = "Tax percentage Dto is required.")
        String taxPercentageDto,

        @NotBlank(message = "Operation value is required.")
        String operationValueDto,

        @NotBlank(message = "Deferral percentage value is required.")
        String deferralpercentageDto,

        @NotBlank(message = "Deferral tax Value is required.")
        String deferralTaxValue,

        @NotBlank(message = "Tax value is required.")
        String taxValue
) {
}
