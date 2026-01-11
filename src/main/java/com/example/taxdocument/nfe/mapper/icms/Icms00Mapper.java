package com.example.taxdocument.nfe.mapper.icms;

import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS00;

import java.math.BigDecimal;

public class Icms00Mapper {

    private NFNotaInfoItemImpostoICMS00 mapIcms00(IcmsTaxDto.Icms00Dto dto) {
        NFNotaInfoItemImpostoICMS00 nfeIcms00 = new NFNotaInfoItemImpostoICMS00();

        nfeIcms00.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms00.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("00"));

        if (dto.icmsModality() != null) {
            nfeIcms00.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.valueOfCodigo(dto.icmsModality().icmsModalityCodeDto()));
        }

        nfeIcms00.setValorBaseCalculo(new BigDecimal(dto.baseValue()));
        nfeIcms00.setPercentualAliquota(new BigDecimal(dto.percentageRate()));
        nfeIcms00.setValorTributo(new BigDecimal(dto.taxValue()));

        return nfeIcms00;
    }

}
