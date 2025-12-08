package com.example.taxdocument.nfe.model;

import com.fincatto.documentofiscal.nfe400.classes.NFEndereco;
import com.fincatto.documentofiscal.nfe400.classes.NFRegimeTributario;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IssuerNfeModel {

    //Basic identification
    private String cnpj;
    private String cpf;
    private String razaoSocial;
    private String nomeFantasia;

    //Registration
    private String inscricaoEstadual;
    private String inscricaoEstadualST;
    private String inscricaoMunicipal;
    private String cnae;

    //Tax Regime
    private NFRegimeTributario regimeTributario;

    //wmixvideo library address complex object
    private NFEndereco endereco;

}
