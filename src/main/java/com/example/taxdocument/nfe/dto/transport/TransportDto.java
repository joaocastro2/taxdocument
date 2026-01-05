package com.example.taxdocument.nfe.dto.transport;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record TransportDto(
        @NotNull(message = "Modalidade do frete é obrigatória")
        String freightMode,

        @Valid TransporterDto transportador,
        @Valid TransportIcmsDto icmsTransporte,
        @Valid VeiculoDto veiculo,

        List<@Valid VeiculoDto> reboques,
        String vagao,
        String balsa,

        List<@Valid VolumeDto> volumes
) {

    public record TransporterDto(
            String cnpj,
            String cpf,
            String name,
            String stateRegistration,
            String address,
            String cityName,
            String state
    ) {}

    public record TransportIcmsDto(
            @NotBlank String serviceValue,
            @NotBlank String baseValue,
            @NotBlank String taxRate,
            @NotBlank String taxValue,
            @NotBlank String cfop,
            @NotBlank String cityCode
    ) {}

    public record VeiculoDto(
            String plate,
            String state,
            String rntc
    ) {}

    public record VolumeDto(
            String quantity,
            String type,
            String brand,
            String numbering,
            String netWeight,
            String grossWeight,
            List<String> seals
    ) {}
}