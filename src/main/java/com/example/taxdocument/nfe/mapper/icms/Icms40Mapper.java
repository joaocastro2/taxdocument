package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaMotivoDesoneracaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS40;

import java.math.BigDecimal;

public class Icms40Mapper {

    public NFNotaInfoItemImpostoICMS40 map(IcmsTaxDto.Icms40Dto dto) {
        NFNotaInfoItemImpostoICMS40 nfeIcms40 = new NFNotaInfoItemImpostoICMS40();

        // 1. Origem e CST (40, 41 ou 50 vindo do DTO)
        nfeIcms40.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms40.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo(dto.situation()));

        // 2. Desoneração (Obrigatória em alguns tipos de isenção)
        if (dto.exemptionValue() != null && !dto.exemptionValue().isBlank()) {
            nfeIcms40.setValorICMSDesoneracao(new BigDecimal(dto.exemptionValue()));

            if (dto.exemptionReason() != null) {
                // Mapeia o motivo da desoneração/isenção
                nfeIcms40.setMotivoDesoneracaoICMS(NFNotaMotivoDesoneracaoICMS.valueOfCodigo(dto.exemptionReason().codigo()));
            }
        }

        return nfeIcms40;
    }
}