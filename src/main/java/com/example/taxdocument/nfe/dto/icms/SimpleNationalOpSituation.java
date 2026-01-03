package com.example.taxdocument.nfe.dto.icms;

import jakarta.validation.constraints.NotBlank;

public record SimpleNationalOpSituation(
        @NotBlank(message = "Simple national Code is required.")
        String SimpleNationalCodeDto,

        @NotBlank(message = "Simple national description is required.")
        String SimpleNationalDesDto
) {
}
