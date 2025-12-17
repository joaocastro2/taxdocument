package com.example.taxdocument.nfe.model;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoICMSTotal;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoISSQNTotal;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoRetencoesTributos;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TotalNfeModel {

    //Total taxes
    private NFNotaInfoICMSTotal icmsTotal;
    private NFNotaInfoISSQNTotal issqnTotal;
    private NFNotaInfoRetencoesTributos retencoesTributos;

    //Final Total
    private String vNFTot;

}
