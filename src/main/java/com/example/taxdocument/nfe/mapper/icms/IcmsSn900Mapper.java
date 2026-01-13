package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMSSN900;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;

import java.math.BigDecimal;

public class IcmsSn900Mapper {

    public NFNotaInfoItemImpostoICMSSN900 map(IcmsTaxDto.IcmsSn900Dto dto) {
        NFNotaInfoItemImpostoICMSSN900 nfeIcms900 = new NFNotaInfoItemImpostoICMSSN900();

        nfeIcms900.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo(dto.situation()));

        if (dto.modality() != null) {
            var mod = dto.modality();
            nfeIcms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.valueOfCodigo(mod.icmsModalityCodeDto()));
        }

        if (dto.reduction() != null) {
            nfeIcms900.setPercentualReducaoBC(new BigDecimal(dto.reduction().reductionPercentage()));
        }

        if (dto.substitutionTax() != null) {
            var st = dto.substitutionTax();
            nfeIcms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.valueOfCodigo(st.modality().icmsModalityBcDto()));

            if (st.mvaRate() != null) nfeIcms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal(st.mvaRate()));
            if (st.reductionRate() != null) nfeIcms900.setPercentualReducaoBCICMSST(new BigDecimal(st.reductionRate()));

            nfeIcms900.setValorBCICMSST(new BigDecimal(st.baseValue()));
            nfeIcms900.setPercentualAliquotaImpostoICMSST(new BigDecimal(st.taxRate()));
            nfeIcms900.setValorICMSST(new BigDecimal(st.taxValue()));
        }

        if (dto.creditTaxRate() != null) {
            nfeIcms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal(dto.creditTaxRate()));
        }
        if (dto.creditValue() != null) {
            nfeIcms900.setValorCreditoICMSSN(new BigDecimal(dto.creditValue()));
        }

        return nfeIcms900;
    }
}