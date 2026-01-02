package com.example.taxdocument.nfe.dto.icms;

import jakarta.validation.constraints.NotBlank;

public record NFReasonForReductionADREM(
        @NotBlank(message = "Reason for reduction code is required.")
        String reasonFRcodeDto,

        @NotBlank(message = "Reason for reduction description is required.")
        String reasonFRdescDto
) {
}
