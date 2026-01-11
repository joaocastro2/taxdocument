package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.*;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS20;

import java.math.BigDecimal;

public class Icms20Mapper {

    private NFNotaInfoItemImpostoICMS20 mapIcms20(IcmsTaxDto.Icms20Dto dto) {
        NFNotaInfoItemImpostoICMS20 nfeIcms20 = new NFNotaInfoItemImpostoICMS20();

        nfeIcms20.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms20.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("20"));

        if (dto.modalidadeBCICMS() != null) {
            nfeIcms20.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.valueOfCodigo(dto.modalidadeBCICMS().icmsModalityCodeDto()));
        }

        nfeIcms20.setPercentualReducaoBC(new BigDecimal(dto.reduction().reductionPercentage()));

        nfeIcms20.setValorBCICMS(new BigDecimal(dto.reduction().baseValue()));
        nfeIcms20.setPercentualAliquota(new BigDecimal(dto.reduction().taxRate()));
        nfeIcms20.setValorTributo(new BigDecimal(dto.reduction().taxValue()));

        if (dto.povertyFund() != null) {
            var fcp = dto.povertyFund();

            nfeIcms20.setValorBCFundoCombatePobreza(new BigDecimal(fcp.baseValue()));
            nfeIcms20.setPercentualFundoCombatePobreza(new BigDecimal(fcp.taxRate()));
            nfeIcms20.setValorFundoCombatePobreza(new BigDecimal(fcp.taxValue()));
        }

        if (dto.excemptionValue() != null && !dto.excemptionValue().isBlank()) {
            nfeIcms20.setValorICMSDesoneracao(new BigDecimal(dto.excemptionValue()));

            if (dto.extemptionReason() != null) {
                nfeIcms20.setDesoneracao(NFNotaMotivoDesoneracaoICMS.valueOfCodigo(dto.extemptionReason().codigo()));
            }

            if (dto.deductionTipe() != null) {
                nfeIcms20.setIndicaDeduzDesoneracao(NFTipoDeducaoIcms.valueOfCodigo(dto.deductionTipe().deductTipeCodeDto()));
            }
        }

        return nfeIcms20;
    }

}
