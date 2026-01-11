package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaMotivoReducaoADREM;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS15;

import java.math.BigDecimal;

public class Icms15Mapper {

    private NFNotaInfoItemImpostoICMS15 mapIcms15(IcmsTaxDto.Icms15Dto dto) {
        NFNotaInfoItemImpostoICMS15 nfeIcms15 = new NFNotaInfoItemImpostoICMS15();

        nfeIcms15.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms15.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("15"));

        nfeIcms15.setQuantidadeBaseCalculo(new BigDecimal(dto.adRemBaseQuantity()));
        nfeIcms15.setPercentualAliquota(new BigDecimal(dto.adRemTaxRate()));
        nfeIcms15.setValorTributo(new BigDecimal(dto.taxValue()));

        nfeIcms15.setQuantidadeBaseCalculoTributadaSujeitaRetencao(new BigDecimal(dto.whBaseQuantity()));
        nfeIcms15.setPercentualAliquotaRetencao(new BigDecimal(dto.whTaxRate()));
        nfeIcms15.setValorTributoRetencao(new BigDecimal(dto.whTaxValue()));

        if (dto.reductionPercentage() != null) {
            nfeIcms15.setPercentualReducaoAliquota(new BigDecimal(dto.reductionPercentage()));
        }

        if (dto.reasonReduction() != null) {
            nfeIcms15.setMotivoReducao(NFNotaMotivoReducaoADREM.valueOfCodigo(dto.reasonReduction().reasonFRcodeDto()));
        }

        return nfeIcms15;
    }


}
