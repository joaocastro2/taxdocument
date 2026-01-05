package com.example.taxdocument.nfe.dto.Receiver;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReceiverDto(
        String cnpj,
        String cpf,
        String foreignerId,

        @NotBlank(message = "Razão social é obrigatória")
        String name,

        @Email(message = "E-mail inválido")
        String email,

        String stateRegistration,
        String suframaRegistration,
        String municipalRegistration,

        @NotBlank(message = "Indicador de IE é obrigatório")
        String ieIndicator,

        @Valid
        @NotNull(message = "Endereço do destinatário é obrigatório")
        AddressDto address
) {
    public record AddressDto(
            @NotBlank String street,
            @NotBlank String number,
            String complement,
            @NotBlank String neighborhood,
            @NotBlank String cityCode,
            @NotBlank String cityName,
            @NotBlank String state,
            @NotBlank String zipCode,
            String countryCode,
            String countryName,
            String phone
    ) {}
}