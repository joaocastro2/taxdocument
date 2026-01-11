package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS70;

import java.math.BigDecimal;

public class Icms70Mapper {

    public NFNotaInfoItemImpostoICMS70 map(IcmsTaxDto.Icms70Dto dto) {
        NFNotaInfoItemImpostoICMS70 nfeIcms70 = new NFNotaInfoItemImpostoICMS70();

        nfeIcms70.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo(dto.situation()));

        if (dto.modality() != null) {
            nfeIcms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.valueOfCodigo(dto.modality().icmsModalityCodeDto()));
        }

        if (dto.reduction() != null) {
            var red = dto.reduction();
            nfeIcms70.setPercentualReducaoBC(new BigDecimal(red.reductionPercentage()));
            nfeIcms70.setValorBC(new BigDecimal(red.baseValue()));
            nfeIcms70.setPercentualAliquota(new BigDecimal(red.taxRate()));
            nfeIcms70.setValorTributo(new BigDecimal(red.taxValue()));
        }

        if (dto.substitutionTax() != null) {
            var st = dto.substitutionTax();
            nfeIcms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.valueOfCodigo(st.modality().icmsModalityBcDto()));

            if (st.mvaRate() != null) {
                nfeIcms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal(st.mvaRate()));
            }
            if (st.reductionRate() != null) {
                nfeIcms70.setPercentualReducaoBCICMSST(new BigDecimal(st.reductionRate()));
            }

            nfeIcms70.setValorBCST(new BigDecimal(st.baseValue()));
            nfeIcms70.setPercentualAliquotaImpostoICMSST(new BigDecimal(st.taxRate()));
            nfeIcms70.setValorICMSST(new BigDecimal(st.taxValue()));
        }

        if (dto.povertyFund() != null) {
            var fcp = dto.povertyFund();
            nfeIcms70.setValorBCFundoCombatePobrezaST(new BigDecimal(fcp.baseValue()));
            nfeIcms70.setPercentualFundoCombatePobrezaST(new BigDecimal(fcp.taxRate()));
            nfeIcms70.setValorFundoCombatePobrezaST(new BigDecimal(fcp.taxValue()));
        }

        return nfeIcms70;
    }
}