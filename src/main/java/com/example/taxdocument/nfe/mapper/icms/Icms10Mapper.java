package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS10;

import java.math.BigDecimal;

public class Icms10Mapper {

    private NFNotaInfoItemImpostoICMS10 mapIcms10(IcmsTaxDto.Icms10Dto dto) {
        NFNotaInfoItemImpostoICMS10 nfeIcms10 = new NFNotaInfoItemImpostoICMS10();

        nfeIcms10.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("10"));

        if (dto.icmsModality() != null) {
            nfeIcms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.valueOfCodigo(dto.icmsModality().icmsModalityCodeDto()));
        }
        nfeIcms10.setValorBaseCalculo(new BigDecimal(dto.baseValue()));
        nfeIcms10.setPercentualAliquota(new BigDecimal(dto.percentageRate()));
        nfeIcms10.setValorTributo(new BigDecimal(dto.taxValue()));

        var st = dto.substitutionTax();
        if (st != null) {
            nfeIcms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.valueOfCodigo(String.valueOf(st.modality())));

            if (st.mvaRate() != null && !st.mvaRate().isBlank()) {
                nfeIcms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal(st.mvaRate()));
            }

            if (st.reductionRate() != null && !st.reductionRate().isBlank()) {
                nfeIcms10.setPercentualReducaoBCICMSST(new BigDecimal(st.reductionRate()));
            }

            nfeIcms10.setValorBCICMSST(new BigDecimal(st.baseValue()));
            nfeIcms10.setPercentualAliquotaImpostoICMSST(new BigDecimal(st.taxRate()));
            nfeIcms10.setValorICMSST(new BigDecimal(st.taxValue()));
        }

        if (dto.povertyFund() != null) {
            var fcp = dto.povertyFund();
            nfeIcms10.setPercentualFundoCombatePobrezaST(new BigDecimal(fcp.taxRate()));
            nfeIcms10.setValorFundoCombatePobrezaST(new BigDecimal(fcp.taxValue()));
        }

        return nfeIcms10;
    }

}
