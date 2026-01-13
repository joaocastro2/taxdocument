package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMSSN102;
// Classe de Enum correta para a v5.0.40
import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;

public class IcmsSn102Mapper {

    public NFNotaInfoItemImpostoICMSSN102 map(IcmsTaxDto.IcmsSn102Dto dto) {
        NFNotaInfoItemImpostoICMSSN102 nfeIcms102 = new NFNotaInfoItemImpostoICMSSN102();

        nfeIcms102.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));

        nfeIcms102.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo(dto.situation()));

        return nfeIcms102;
    }
}