package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMSSN101;
import java.math.BigDecimal;

public class IcmsSn101Mapper {

    public NFNotaInfoItemImpostoICMSSN101 map(IcmsTaxDto.IcmsSn101Dto dto) {
        NFNotaInfoItemImpostoICMSSN101 nfeIcms101 = new NFNotaInfoItemImpostoICMSSN101();

        nfeIcms101.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));

        nfeIcms101.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo(dto.situation()));

        nfeIcms101.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal(dto.creditTaxRate()));
        nfeIcms101.setValorCreditoICMSSN(new BigDecimal(dto.creditValue()));

        return nfeIcms101;
    }
}