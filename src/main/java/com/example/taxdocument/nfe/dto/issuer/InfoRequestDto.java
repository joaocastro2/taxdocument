package com.example.taxdocument.nfe.dto.issuer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record InfoRequestDto(
        @Valid Integer ufCodeDto,
        @Valid String natOperationDto,
        @Valid Integer modelDto,
        @Valid Integer serieDto,
        @Valid Integer numberNfDto,
        @Valid LocalDateTime dateTimeEmissionDto,
        @Valid Integer numericCodeDto,
        @Valid Integer typeNfDto,
        @Valid Integer triggEventDto,
        @Valid Integer impTypeDto,
        @Valid Integer EmiTypeDto,
        @Valid Integer checkDigitDto,
        @Valid Integer ambTypeDto,
        @Valid Integer finalIndDto,
        @Valid Integer indPressDto,
        @Valid Integer procEmiDto,
        @Valid String verProcDto,
        @Valid Integer indIntermedDto){
}
