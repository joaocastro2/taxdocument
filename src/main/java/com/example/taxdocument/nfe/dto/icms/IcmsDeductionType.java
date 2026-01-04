package com.example.taxdocument.nfe.dto.icms;

import jakarta.validation.constraints.NotBlank;

public record IcmsDeductionType(
        @NotBlank(message = "Icms deduction tipe dto is required.")
        String deductTipeCodeDto,

        @NotBlank(message = "Icms deduction tipe is required.")
        String deductTipedescDto
) {
}
