package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaMotivoDesoneracaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS30;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;

import java.math.BigDecimal;

public class Icms30Mapper {

    public NFNotaInfoItemImpostoICMS30 map(IcmsTaxDto.Icms30Dto dto) {
        NFNotaInfoItemImpostoICMS30 nfeIcms30 = new NFNotaInfoItemImpostoICMS30();

        nfeIcms30.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms30.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("30"));

        if (dto.substitutionTax() != null) {
            var st = dto.substitutionTax();

            nfeIcms30.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.valueOfCodigo(st.modality().icmsModalityBcDto()));

            if (st.mvaRate() != null) {
                nfeIcms30.setPercentualMargemValorAdicionadoICMSST(new BigDecimal(st.mvaRate()));
            }

            if (st.reductionRate() != null) {
                nfeIcms30.setPercentualReducaoBCICMSST(new BigDecimal(st.reductionRate()));
            }

            nfeIcms30.setValorBCICMSST(new BigDecimal(st.baseValue()));
            nfeIcms30.setPercentualAliquotaImpostoICMSST(new BigDecimal(st.taxRate()));
            nfeIcms30.setValorImpostoICMSST(new BigDecimal(st.taxValue()));
        }

        if (dto.exemptionValue() != null && !dto.exemptionValue().isBlank()) {
            nfeIcms30.setValorICMSDesoneracao(new BigDecimal(dto.exemptionValue()));

            if (dto.exemptionReason() != null) {
                nfeIcms30.setDesoneracao(NFNotaMotivoDesoneracaoICMS.valueOfCodigo(dto.exemptionReason().codigo()));
            }
        }

        return nfeIcms30;
    }
}