package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMSSN201;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;

import java.math.BigDecimal;

public class IcmsSn201Mapper {

    public NFNotaInfoItemImpostoICMSSN201 map(IcmsTaxDto.IcmsSn201Dto dto) {
        NFNotaInfoItemImpostoICMSSN201 nfeIcms201 = new NFNotaInfoItemImpostoICMSSN201();

        nfeIcms201.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms201.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo(dto.situation()));

        if (dto.substitutionTax() != null) {
            var st = dto.substitutionTax();
            nfeIcms201.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.valueOfCodigo(st.modality().icmsModalityBcDto()));

            if (st.mvaRate() != null) {
                nfeIcms201.setPercentualMargemValorAdicionadoICMSST(new BigDecimal(st.mvaRate()));
            }
            if (st.reductionRate() != null) {
                nfeIcms201.setPercentualReducaoBCICMSST(new BigDecimal(st.reductionRate()));
            }

            nfeIcms201.setValorBCICMSST(new BigDecimal(st.baseValue()));
            nfeIcms201.setPercentualAliquotaImpostoICMSST(new BigDecimal(st.taxRate()));
            nfeIcms201.setValorICMSST(new BigDecimal(st.taxValue()));
        }

        nfeIcms201.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal(dto.creditTaxRate()));
        nfeIcms201.setValorCreditoICMSSN(new BigDecimal(dto.creditValue()));

        return nfeIcms201;
    }
}