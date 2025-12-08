package com.example.taxdocument.nfe.model;

import com.fincatto.documentofiscal.nfe310.classes.NFEndereco;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFIndicadorIEDestinatario;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReceiverNfeModel {

    //Identification
    private String cnpj;
    private String cpf;
    private String idEstrangeiro;

    //Registration
    private String razaoSocial;
    private String email;

    //fiscal indicators
    private String inscricaoEstadual;
    private String inscricaoSuFrama;
    private String inscricaoMunicipal;
    private NFIndicadorIEDestinatario indicadorIEDestinatario;

    //wmixvideo library address complex object
    private NFEndereco endereco;

}
