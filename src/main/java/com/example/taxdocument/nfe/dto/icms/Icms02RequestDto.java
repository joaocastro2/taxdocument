package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Icms02RequestDto(
        @Valid
        @NotNull(message = "Nf Origin cannot be null")
        NFOriginRequestDto nfOriginDto,

        @Valid
        @NotNull(message = "Tax situation cannot be null")
        IcmsTaxRequestDto icmsTaxDto,

        @NotBlank(message = "Calculation basis is required.")
        String calculationbasisDto,

        @NotBlank(message = "Percentage Rate is required.")
        String percentageRateDto,

        @NotBlank(message = "Tax Value is required.")
        String taxValueDto
) {}
