package com.example.taxdocument.nfe.dto.issuer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IssuerRequestDto(
    @Valid
    @NotBlank(message = "The cnpj of Issuer cannot be null")
    String issuerCnpjDto,

    @Valid
    @NotBlank(message = "The cpf of Issuer cannot be null")
    String issuerCpfDto,

    @Valid
    @NotBlank(message = "Company name cannot be null")
    String issuerCompName,

    @Valid
    @NotBlank(message = "trade number cannot be null")
    String issuerTradeNDto,

    @Valid
    @NotBlank(message = "State regime cannot be null")
    String issuerStateRegDto,

    @Valid
    @NotBlank(message = "State Regime ST cannot be null")
    String issuerStateRegSTDto,

    @Valid
    @NotBlank(message = "Municipal regime cannot be null")
    String municipalRegDto,

    @Valid
    @NotBlank(message = "cnae Cannot be null")
    String cnaeDto,

    @Valid
    @NotNull(message = "Tax Regime cannot be null")
    NFTaxRegimeDto taxRegimeDto,

    @Valid
    @NotNull(message = "The Adress cannot be null")
    NFAdressDto adressDto
) {

    public record NFTaxRegimeDto(
            @NotBlank(message = "Cod Regime is required")
            String codRegimeDto,

            @NotBlank(message = "Desc Regime is required")
            String descRegimeDto
    ){}

    public record NFAdressDto(
            @NotBlank(message = "Public space is required")
            String publicSpaceDto,

            @NotBlank(message = "Adress number is required")
            String adressNumberDto,

            @NotBlank(message = "Complement is required")
            String complementDto,

            @NotBlank(message = "neighborHood is required")
            String neighborhoodDto,

            @NotBlank(message = "municipalityCode is required")
            String municipalityCodeDto,

            @NotBlank(message = "municipality description is required")
            String descricaoMunicipioDto,

            @NotBlank(message = "uf is required")
            String ufDto,

            @NotBlank(message = "cep is required")
            String cepDto,

            @NotNull(message = "Country code is required")
            DFPais countryCodeDto,

            @NotBlank(message = "country description")
            String countryDescDto,

            @NotBlank(message = "phone number is required")
            String phoneDto
    ){}

    public record DFPais(

    ){}

}
