package com.example.taxdocument.nfe.dto.icms;

import com.example.taxdocument.nfe.dto.origin.NFOriginRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Icms40RequestDto(
        @Valid
        @NotNull(message = "NF origin Dto cannot be null.")
        NFOriginRequestDto nfOriginDto,

        @Valid
        @NotNull(message = "Icms Tax cannot be null.")
        IcmsTaxRequestDto icmsTaxDto,

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
