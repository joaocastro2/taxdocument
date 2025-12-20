package com.example.taxdocument.nfe.model;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoFatura;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoParcela;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChargeNfeModel {

    //charge types
    private NFNotaInfoFatura fatura;
    private List<NFNotaInfoParcela> parcelas;

}