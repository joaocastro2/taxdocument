package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IcmsSharedRequestDto(
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

        @NotBlank(message = "Percentage Tax Rate is required.")
        String percentageTaxRate,

        @NotBlank(message = "Icms value is required.")
        String icmsValue,

        @Valid
        @NotNull(message = "Icms modality is required.")
        IcmsHasModalityBC modalidadeBCICMSST,

        @NotBlank(message = "percentageMarginValueAddedICMSST is required.")
        String percentageMarginValueAddedICMSST,

        @NotBlank(message = "percentageReductionBCICMSST is required.")
        String percentageReductionBCICMSST,

        @NotBlank(message = "Value BCICMSST is required.")
        String valueBCICMSST,

        @NotBlank(message = "Percentage Tax Aliquot ICMSST.")
        String percentageTaxAliquotICMSST,

        @NotBlank(message = "Value ICMSST.")
        String valueICMSST,

        @NotBlank(message = "Percentage BC self operation.")
        String percentageBCSelfOperation,

        @NotBlank(message = "uf ICMSST is required.")
        String ufICMSST
) {
}
