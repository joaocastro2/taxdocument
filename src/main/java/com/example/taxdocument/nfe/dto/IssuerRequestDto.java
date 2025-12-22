package com.example.taxdocument.nfe.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record IssuerRequestDto(

    @Valid
    @NotNull(message = "The cnpj of Issuer cannot be null")
    String issuerCnpjDto,

    @Valid
    @NotNull(message = "The cpf of Issuer cannot be null")
    String issuerCpfDto,

    @Valid
    @NotNull(message = "Company name cannot be null")
    String issuerCompName,

    @Valid
    @NotNull(message = "trade number cannot be null")
    String issuerTradeNDto,

    @Valid
    @NotNull(message = "State regime cannot be null")
    String issuerStateRegDto,

    @Valid
    @NotNull(message = "State Regime ST cannot be null")
    String issuerStateRegSTDto,

    @Valid
    @NotNull(message = "Municipal regime cannot be null")
    String municipalRegDto,

    @Valid
    @NotNull(message = "cnae Cannot be null")
    String cnaeDto,

    @Valid
    @NotNull(message = "Tax Regime cannot be null")
    NFTaxRegimeDto taxRegimeDto,

    @Valid
    @NotNull(message = "The Adress cannot be null")
    NFAdressDto adressDto

) {
}
