package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS60;

import java.math.BigDecimal;

public class Icms60Mapper {

    public NFNotaInfoItemImpostoICMS60 map(IcmsTaxDto.Icms60Dto dto) {
        NFNotaInfoItemImpostoICMS60 nfeIcms60 = new NFNotaInfoItemImpostoICMS60();

        nfeIcms60.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms60.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo(dto.situation()));

        if (dto.baseValueSTRetained() != null) {
            nfeIcms60.setValorBCICMSSTRetido(new BigDecimal(dto.baseValueSTRetained()));
        }
        if (dto.taxValueSTRetained() != null) {
            nfeIcms60.setValorICMSSTRetido(new BigDecimal(dto.taxValueSTRetained()));
        }

        if (dto.povertyFundRetained() != null) {
            var fcp = dto.povertyFundRetained();
            nfeIcms60.setValorBCFundoCombatePobrezaRetidoST(new BigDecimal(fcp.baseValue()));
            nfeIcms60.setPercentualFundoCombatePobrezaRetidoST(new BigDecimal(fcp.taxRate()));
            nfeIcms60.setValorFundoCombatePobrezaRetidoST(new BigDecimal(fcp.taxValue()));
        }

        if (dto.effective() != null) {
            var eff = dto.effective();
            nfeIcms60.setPercentualReducaoBCEfetiva(new BigDecimal(eff.percentageReductionBCEffective()));
            nfeIcms60.setValorBCEfetiva(new BigDecimal(eff.valueBCEffective()));
            nfeIcms60.setPercentualAliquotaICMSEfetiva(new BigDecimal(eff.percentageAliquotICMSEffective()));
            nfeIcms60.setValorICMSEfetivo(new BigDecimal(eff.valueICMSEffective()));
        }

        return nfeIcms60;
    }
}