package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Icms00RequestDto(
        @Valid
        @NotNull(message = "NF Origin request is required.")
        NFOriginRequestDto nfOriginDto,

        @Valid
        @NotNull(message = "Icms tax cannot be null.")
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

        @NotBlank(message = "percentage fund to combat poverty is required.")
        String percentageFundCombatPovertyDto,

        @NotBlank(message = "value Fund To Combat Poverty is required.")
        String valueFundCombatPovertyDto
) {}
