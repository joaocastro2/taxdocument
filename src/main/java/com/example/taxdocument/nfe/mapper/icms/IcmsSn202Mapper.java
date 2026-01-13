package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMSSN202;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;

import java.math.BigDecimal;

public class IcmsSn202Mapper {

    public NFNotaInfoItemImpostoICMSSN202 map(IcmsTaxDto.IcmsSn202Dto dto) {
        NFNotaInfoItemImpostoICMSSN202 nfeIcms202 = new NFNotaInfoItemImpostoICMSSN202();

        nfeIcms202.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo(dto.situation()));

        if (dto.substitutionTax() != null) {
            var st = dto.substitutionTax();
            nfeIcms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.valueOfCodigo(st.modality().icmsModalityBcDto()));

            if (st.mvaRate() != null) {
                nfeIcms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal(st.mvaRate()));
            }
            if (st.reductionRate() != null) {
                nfeIcms202.setPercentualReducaoBCICMSST(new BigDecimal(st.reductionRate()));
            }

            nfeIcms202.setValorBCICMSST(new BigDecimal(st.baseValue()));
            nfeIcms202.setPercentualAliquotaImpostoICMSST(new BigDecimal(st.taxRate()));
            nfeIcms202.setValorICMSST(new BigDecimal(st.taxValue()));
        }

        return nfeIcms202;
    }
}