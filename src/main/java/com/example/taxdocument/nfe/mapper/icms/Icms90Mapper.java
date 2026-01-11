package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS90;

import java.math.BigDecimal;

public class Icms90Mapper {

    public NFNotaInfoItemImpostoICMS90 map(IcmsTaxDto.Icms90Dto dto) {
        NFNotaInfoItemImpostoICMS90 nfeIcms90 = new NFNotaInfoItemImpostoICMS90();

        nfeIcms90.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo(dto.situation()));

        if (dto.modality() != null) {
            nfeIcms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.valueOfCodigo(dto.modality().icmsModalityCodeDto()));
        }

        if (dto.reduction() != null) {
            var red = dto.reduction();
            if (red.reductionPercentage() != null) {
                nfeIcms90.setPercentualReducaoBC(new BigDecimal(red.reductionPercentage()));
            }
            nfeIcms90.setValorBC(new BigDecimal(red.baseValue()));
            nfeIcms90.setPercentualAliquota(new BigDecimal(red.taxRate()));
            nfeIcms90.setValorTributo(new BigDecimal(red.taxValue()));
        }

        if (dto.substitutionTax() != null) {
            var st = dto.substitutionTax();
            nfeIcms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.valueOfCodigo(st.modality().icmsModalityBcDto()));

            if (st.mvaRate() != null) {
                nfeIcms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal(st.mvaRate()));
            }
            if (st.reductionRate() != null) {
                nfeIcms90.setPercentualReducaoBCICMSST(new BigDecimal(st.reductionRate()));
            }

            nfeIcms90.setValorBCST(new BigDecimal(st.baseValue()));
            nfeIcms90.setPercentualAliquotaImpostoICMSST(new BigDecimal(st.taxRate()));
            nfeIcms90.setValorICMSST(new BigDecimal(st.taxValue()));
        }

        if (dto.povertyFund() != null) {
            var fcp = dto.povertyFund();
            nfeIcms90.setValorBCFundoCombatePobrezaST(new BigDecimal(fcp.baseValue()));
            nfeIcms90.setPercentualFundoCombatePobrezaST(new BigDecimal(fcp.taxRate()));
            nfeIcms90.setValorFundoCombatePobrezaST(new BigDecimal(fcp.taxValue()));
        }

        if (dto.creditTaxRate() != null) {
            nfeIcms90.setPercentualAliquotaImpostoICMSST(new BigDecimal(dto.creditTaxRate()));
        }
        if (dto.creditValue() != null) {
            nfeIcms90.setValorICMSST(new BigDecimal(dto.creditValue()));
        }

        return nfeIcms90;
    }
}