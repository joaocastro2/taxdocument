package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS61;

import java.math.BigDecimal;

public class Icms61Mapper {

    public NFNotaInfoItemImpostoICMS61 map(IcmsTaxDto.Icms61Dto dto) {
        NFNotaInfoItemImpostoICMS61 nfeIcms61 = new NFNotaInfoItemImpostoICMS61();

        // 1. Origem e CST (61)
        nfeIcms61.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms61.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo(dto.situation()));

        if (dto.whBaseQuantity() != null) {
            nfeIcms61.setQuantidadeBaseCalculo(new BigDecimal(dto.whBaseQuantity()));
        }

        if (dto.whTaxRate() != null) {
            nfeIcms61.setPercentualAliquota(new BigDecimal(dto.whTaxRate()));
        }

        if (dto.whTaxValue() != null) {
            nfeIcms61.setValorTributo(new BigDecimal(dto.whTaxValue()));
        }

        return nfeIcms61;
    }
}