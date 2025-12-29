package com.example.taxdocument.nfe.dto.icms;

import jakarta.validation.constraints.NotBlank;

public record IcmsTaxRequestDto(
        @NotBlank(message = "Icms Tax code is required")
        String icmsTaxCodeDto,

        @NotBlank(message = "Icms Tax description is required")
        String icmsTaxDescDto
) {
}
