package com.example.taxdocument.nfe.model;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImposto;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductNfeModel {

    //Identification and values
    private String codigo;
    private String descricao;
    private String ncm;
    private String cest;
    private String cfop;
    private String unidadeComercial;
    private BigDecimal quantidadeComercial;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotalBruto;

    //Taxation
    private NFNotaInfoItemImposto imposto;

    //Other Values
    private BigDecimal valorDesconto;
    private BigDecimal valorFrete;

}
