package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS53;

import java.math.BigDecimal;

public class Icms53Mapper {

    public NFNotaInfoItemImpostoICMS53 map(IcmsTaxDto.Icms53Dto dto) {
        NFNotaInfoItemImpostoICMS53 nfeIcms53 = new NFNotaInfoItemImpostoICMS53();

        nfeIcms53.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms53.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo(dto.situation()));

        nfeIcms53.setQuantidadeBaseCalculo(new BigDecimal(dto.adRemBaseQuantity()));

        nfeIcms53.setPercentualAliquota(new BigDecimal(dto.adRemTaxRate()));

        nfeIcms53.setValorOperacao(new BigDecimal(dto.taxValue()));

        if (dto.percentageDeferral() != null) {
            nfeIcms53.setPercentualDiferimento(new BigDecimal(dto.percentageDeferral()));
        }

        if (dto.valueDeferral() != null) {
            nfeIcms53.setValorTributoDiferido(new BigDecimal(dto.valueDeferral()));
        }
        if (dto.valueTotal() != null) {
            nfeIcms53.setValorTributo(new BigDecimal(dto.valueTotal()));
        }

        return nfeIcms53;
    }
}