package com.example.taxdocument.nfe.mapper;

import com.example.taxdocument.nfe.dto.issuer.InfoRequestDto;
import com.example.taxdocument.nfe.dto.issuer.IssuerRequestDto;
import com.example.taxdocument.nfe.dto.product.ItemTaxDto;
import com.example.taxdocument.nfe.dto.product.ProductNfeDto;
import com.example.taxdocument.nfe.dto.tax.IcmsTaxDto;
import com.example.taxdocument.nfe.mapper.icms.Icms20Mapper;
import com.example.taxdocument.nfe.mapper.icms.Icms30Mapper;
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
        NFNotaInfoItemImpostoICMS container = new NFNotaInfoItemImpostoICMS();



        return container;
    }
}