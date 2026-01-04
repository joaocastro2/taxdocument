package com.example.taxdocument.nfe.dto.icms;

import jakarta.validation.constraints.NotBlank;

public record IcmsModalityDto(
        @NotBlank(message = "Icms Modality code is required")
        String icmsModalityCodeDto,

        @NotBlank(message = "Icms Description is required")
        String icmsDescDto
){}
