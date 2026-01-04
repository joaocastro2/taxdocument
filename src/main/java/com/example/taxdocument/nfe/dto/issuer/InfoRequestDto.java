package com.example.taxdocument.nfe.dto.issuer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record InfoRequestDto(
        @Valid
        @NotEmpty(message = "The numeric state code cannot be empty.")
        Integer ufCodeDto,

        @Valid
        @NotBlank(message = "The nature of the operation cannot be zero.")
        String natOperationDto,

        @Valid
        @NotEmpty(message = "Document template cannot be empty.")
        Integer modelDto,

        @Valid
        @NotEmpty(message = "Tax document series cannot be empty.")
        Integer serieDto,

        @Valid
        @NotEmpty(message = "The sequential number of the invoice cannot be empty.")
        Integer numberNfDto,

        @Valid
        @NotBlank(message = "Date and hour cannot be empty.")
        LocalDateTime dateTimeEmissionDto,

        @Valid
        @NotEmpty(message = "The numeric code cannot be empty")
        Integer numericCodeDto,

        @Valid
        @NotEmpty(message = "NF type cannot be empty.")
        Integer typeNfDto,

        @Valid
        @NotEmpty(message = "IBGE code of the municipality where the operation took place cannot be empty.")
        Integer triggEventDto,

        @Valid
        @NotEmpty(message = "Impression type cannot be empty.")
        Integer impTypeDto,

        @Valid
        @NotEmpty(message = "Emission type cannot be empty.")
        Integer EmiTypeDto,

        @Valid
        @NotEmpty(message = "The last digit of the Access Key cannot be empty.")
        Integer checkDigitDto,

        @Valid
        @NotEmpty(message = "Ambient type cannot be empty.")
        Integer ambTypeDto,

        @Valid
        @NotEmpty(message = "Consumidor Final cannot be empty.")
        Integer finalIndDto,

        @Valid
        @NotEmpty(message = "Buyer Presence cannot be empty.")
        Integer indPressDto,

        @Valid
        @NotEmpty(message = "Emission presence cannit be empty.")
        Integer procEmiDto,

        @Valid
        @NotBlank(message = "Process version cannot be null")
        String verProcDto,

        @Valid
        @NotEmpty(message = "Intermediate Indicator cannot be empty")
        Integer indIntermedDto){
}
