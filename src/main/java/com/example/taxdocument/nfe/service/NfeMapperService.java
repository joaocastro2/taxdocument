package com.example.taxdocument.nfe.service;

import com.example.taxdocument.nfe.dto.icms.NFReasonForReductionADREM;
import com.example.taxdocument.nfe.dto.issuer.InfoRequestDto;
import com.example.taxdocument.nfe.dto.issuer.IssuerRequestDto;
import com.example.taxdocument.nfe.dto.product.ItemTaxDto;
import com.example.taxdocument.nfe.dto.product.ProductNfeDto;
import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.example.taxdocument.nfe.model.InfoNfeModel;
import com.example.taxdocument.nfe.model.IssuerNfeModel;
import com.example.taxdocument.nfe.model.ProductNfeModel;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.*;
import com.fincatto.documentofiscal.nfe400.classes.nota.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NfeMapperService {

    public InfoNfeModel mapInfo(InfoRequestDto dto) {
        if (dto == null) return null;

        return InfoNfeModel.builder()
                .cUf(dto.ufCodeDto())
                .natOp(dto.natOperationDto())
                .mod(dto.modelDto())
                .serie(dto.serieDto())
                .nNf(dto.numberNfDto())
                .dhEmi(dto.dateTimeEmissionDto())
                .cNF(dto.numericCodeDto())
                .tpNF(dto.typeNfDto())
                .cMunFG(dto.triggEventDto())
                .tpImp(dto.impTypeDto())
                .tpEmis(dto.EmiTypeDto())
                .cDV(dto.checkDigitDto())
                .tpAmb(dto.ambTypeDto())
                .indFinal(dto.finalIndDto())
                .indPres(dto.indPressDto())
                .procEmi(dto.procEmiDto())
                .verProc(dto.verProcDto())
                .indIntermed(dto.indIntermedDto())
                .build();
    }

    public IssuerNfeModel mapIssuer(IssuerRequestDto dto) {
        if (dto == null) return null;

        return IssuerNfeModel.builder()
                .cnpj(dto.issuerCnpjDto())
                .cpf(dto.issuerCpfDto())
                .razaoSocial(dto.issuerCompName())
                .nomeFantasia(dto.issuerTradeNDto())
                .inscricaoEstadual(dto.issuerStateRegDto())
                .inscricaoEstadualST(dto.issuerStateRegSTDto())
                .inscricaoMunicipal(dto.municipalRegDto())
                .cnae(dto.cnaeDto())
                .regimeTributario(dto.taxRegimeDto()
                        != null ? NFRegimeTributario.valueOfCodigo(dto.taxRegimeDto().codRegimeDto()) : null)
                .endereco(mapEndereco(dto.adressDto()))
                .build();
    }

    private NFEndereco mapEndereco(IssuerRequestDto.NFAdressDto dto) {
        if (dto == null) return null;

        NFEndereco endereco = new NFEndereco();
        endereco.setLogradouro(dto.publicSpaceDto());
        endereco.setNumero(dto.adressNumberDto());
        endereco.setComplemento(dto.complementDto());
        endereco.setBairro(dto.neighborhoodDto());
        endereco.setCodigoMunicipio(dto.municipalityCodeDto());
        endereco.setDescricaoMunicipio(dto.descricaoMunicipioDto());

        if (dto.ufDto() != null) {
            endereco.setUf(DFUnidadeFederativa.valueOfCodigo(dto.ufDto()));
        }

        endereco.setCep(dto.cepDto());
        endereco.setTelefone(dto.phoneDto());
        endereco.setCodigoPais("1058");

        return endereco;
    }

    public List<ProductNfeModel> mapProductList(List<ProductNfeDto> dtos) {
        if (dtos == null) return null;
        return dtos.stream().map(this::mapProduct).collect(Collectors.toList());
    }

    private ProductNfeModel mapProduct(ProductNfeDto dto) {
        if (dto == null) return null;

        return ProductNfeModel.builder()
                .codigo(dto.productCode())
                .descricao(dto.descCode())
                .ncm(dto.productNcm())
                .cest(dto.productCest())
                .cfop(dto.productCfop())
                .unidadeComercial(dto.comercialUnity())
                .quantidadeComercial(dto.quantity())
                .valorUnitario(dto.unitValue())
                .valorTotalBruto(dto.totalGrossValue())
                .valorDesconto(dto.discountValue())
                .valorFrete(dto.freightValue())
                .imposto(mapItemTax(dto.itemTax()))
                .build();
    }

    private NFNotaInfoItemImposto mapItemTax(ItemTaxDto dto) {
        if (dto == null) return null;

        NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();

        if (dto.totalValue() != null && !dto.totalValue().isBlank()) {
            imposto.setValorTotalTributos(new BigDecimal(dto.totalValue()));
        }

        if (dto.icms() != null) {
            imposto.setIcms(mapIcms(dto.icms()));
        }

        return imposto;
    }

    private NFNotaInfoItemImpostoICMS mapIcms(IcmsTaxDto dto) {
        NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();

        if (dto.icms00() != null) {
            icms.setIcms00(mapIcms00(dto.icms00()));
        } else if (dto.icms10() != null) {
            icms.setIcms10(mapIcms10(dto.icms10()));
        }

        return icms;
    }

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

    private NFNotaInfoItemImpostoICMS10 mapIcms10(IcmsTaxDto.Icms10Dto dto) {
        NFNotaInfoItemImpostoICMS10 nfeIcms10 = new NFNotaInfoItemImpostoICMS10();

        nfeIcms10.setOrigem(NFOrigem.valueOfCodigo(dto.nfOrigin().codigo()));
        nfeIcms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("10"));

        if (dto.icmsModality() != null) {
            nfeIcms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.valueOfCodigo(dto.icmsModality().icmsModalityCodeDto()));
        }
        nfeIcms10.setValorBaseCalculo(new BigDecimal(dto.baseValue()));
        nfeIcms10.setPercentualAliquota(new BigDecimal(dto.percentageRate()));
        nfeIcms10.setValorTributo(new BigDecimal(dto.taxValue()));

        var st = dto.substitutionTax();
        if (st != null) {
            nfeIcms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.valueOfCodigo(String.valueOf(st.modality())));

            if (st.mvaRate() != null && !st.mvaRate().isBlank()) {
                nfeIcms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal(st.mvaRate()));
            }

            if (st.reductionRate() != null && !st.reductionRate().isBlank()) {
                nfeIcms10.setPercentualReducaoBCICMSST(new BigDecimal(st.reductionRate()));
            }

            nfeIcms10.setValorBCICMSST(new BigDecimal(st.baseValue()));
            nfeIcms10.setPercentualAliquotaImpostoICMSST(new BigDecimal(st.taxRate()));
            nfeIcms10.setValorICMSST(new BigDecimal(st.taxValue()));
        }

        if (dto.povertyFund() != null) {
            var fcp = dto.povertyFund();
            nfeIcms10.setPercentualFundoCombatePobrezaST(new BigDecimal(fcp.taxRate()));
            nfeIcms10.setValorFundoCombatePobrezaST(new BigDecimal(fcp.taxValue()));
        }

        return nfeIcms10;
    }

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