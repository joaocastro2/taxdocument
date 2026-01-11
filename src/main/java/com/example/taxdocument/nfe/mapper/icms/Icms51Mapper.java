package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS51;

import java.math.BigDecimal;

public class Icms51Mapper {

    public NFNotaInfoItemImpostoICMS51 map(IcmsTaxDto.Icms51Dto dto) {
        NFNotaInfoItemImpostoICMS51 nfeIcms51 = new NFNotaInfoItemImpostoICMS51();

        // 1. Origem e CST (51 - Diferimento)
        nfeIcms51.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo(dto.situation()));

        // 2. Modalidade da BC
        if (dto.modality() != null) {
            nfeIcms51.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.valueOfCodigo(dto.modality().icmsModalityCodeDto()));
        }

        // 3. Dados de Base de Cálculo e Redução (Se houver)
        if (dto.reduction() != null) {
            var red = dto.reduction();
            if (red.reductionPercentage() != null) {
                nfeIcms51.setPercentualReducaoBC(new BigDecimal(red.reductionPercentage()));
            }
            nfeIcms51.setValorBCICMS(new BigDecimal(red.baseValue()));
            nfeIcms51.setPercentualICMS(new BigDecimal(red.taxRate()));
            nfeIcms51.setValorICMSOperacao(new BigDecimal(red.taxValue())); // Valor do ICMS como se não houvesse diferimento
        }

        // 4. Campos específicos de Diferimento
        if (dto.percentageDeferral() != null) {
            nfeIcms51.setPercentualDiferimento(new BigDecimal(dto.percentageDeferral()));
        }
        if (dto.valueDeferral() != null) {
            nfeIcms51.setValorICMSDiferimento(new BigDecimal(dto.valueDeferral()));
        }
        if (dto.valueTotal() != null) {
            nfeIcms51.setValorICMS(new BigDecimal(dto.valueTotal())); // Valor do ICMS efetivamente devido
        }

        // 5. Fundo de Combate à Pobreza (FCP)
        if (dto.povertyFund() != null) {
            var fcp = dto.povertyFund();
            nfeIcms51.setValorBCFundoCombatePobreza(new BigDecimal(fcp.baseValue()));
            nfeIcms51.setPercentualFundoCombatePobreza(new BigDecimal(fcp.taxRate()));
            nfeIcms51.setValorFundoCombatePobreza(new BigDecimal(fcp.taxValue()));
        }

        return nfeIcms51;
    }
}