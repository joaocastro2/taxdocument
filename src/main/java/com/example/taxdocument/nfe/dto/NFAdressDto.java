package com.example.taxdocument.nfe.dto;

import com.fincatto.documentofiscal.DFPais;

public record NFAdressDto(

    String logradouro,

    String numero,

    String complemento,

    String bairro,

    String codigoMunicipio,

    String descricaoMunicipio,

    String uf,

    String cep,

    DFPais codigoPais,

    String descricaoPais,

    String telefone

) {
}
