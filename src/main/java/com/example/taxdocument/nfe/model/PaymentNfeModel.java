package com.example.taxdocument.nfe.model;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoFormaPagamento;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentNfeModel {

    //Payment info.
    private List<NFNotaInfoFormaPagamento> detalhamentoFormasPagamento;
    private String valorTroco;

}
