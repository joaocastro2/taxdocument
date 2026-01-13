package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMSSN500;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;

import java.math.BigDecimal;

public class IcmsSn500Mapper {

    public NFNotaInfoItemImpostoICMSSN500 map(IcmsTaxDto.IcmsSn500Dto dto) {
        NFNotaInfoItemImpostoICMSSN500 nfeIcms500 = new NFNotaInfoItemImpostoICMSSN500();

        nfeIcms500.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms500.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo(dto.situation()));

        if (dto.baseValueSTRetained() != null) {
            nfeIcms500.setValorBCICMSSTRetido(new BigDecimal(dto.baseValueSTRetained()));
        }
        if (dto.taxValueSTRetained() != null) {
            nfeIcms500.setValorICMSSTRetido(new BigDecimal(dto.taxValueSTRetained()));
        }

        if (dto.povertyFundRetained() != null) {
            var fcp = dto.povertyFundRetained();
            nfeIcms500.setValorBCFundoCombatePobrezaRetidoST(new BigDecimal(fcp.baseValue()));
            nfeIcms500.setPercentualFundoCombatePobrezaRetidoST(new BigDecimal(fcp.taxRate()));
            nfeIcms500.setValorFundoCombatePobrezaRetidoST(new BigDecimal(fcp.taxValue()));
        }

        if (dto.effective() != null) {
            var eff = dto.effective();
            nfeIcms500.setPercentualReducaoBCEfetiva(new BigDecimal(eff.percentageReductionBCEffective()));
            nfeIcms500.setValorBCEfetiva(new BigDecimal(eff.valueBCEffective()));
            nfeIcms500.setPercentualAliquotaICMSEfetiva(new BigDecimal(eff.percentageAliquotICMSEffective()));
            nfeIcms500.setValorICMSEfetivo(new BigDecimal(eff.valueICMSEffective()));
        }

        return nfeIcms500;
    }
}