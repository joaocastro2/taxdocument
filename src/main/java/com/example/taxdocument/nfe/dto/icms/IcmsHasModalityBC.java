package com.example.taxdocument.nfe.dto.icms;

import jakarta.validation.constraints.NotBlank;

public record IcmsHasModalityBC(
        @NotBlank(message = "Icms Has modality is required")
        String icmsModalityBcDto,

        @NotBlank(message = "Icms Description has Modality is required")
        String icmsDescModalityDto
) {}
