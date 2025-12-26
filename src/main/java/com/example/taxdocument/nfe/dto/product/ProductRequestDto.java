package com.example.taxdocument.nfe.dto.product;

import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoItemImposto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import javax.crypto.Mac;
import java.math.BigDecimal;

public record ProductRequestDto(

        @NotBlank(message = "Product code is required")
        String productCodeDto,

        @NotBlank(message = "Desc code is required")
        String descCodeDto,

        @NotBlank(message = "NCM product is required")
        String productNcmDto,

        @NotBlank(message = "Product Cest is required")
        String productCestDto,

        @NotBlank(message = "Product CFOP is required")
        String productCfop,

        @NotBlank(message = "Comercial unity is required")
        String comercialUnityDto,

        @NotEmpty(message = "Quantity Is required")
        BigDecimal quantityDto,

        @NotEmpty(message = "Unit Value is required")
        BigDecimal unitValueDto,

        @NotEmpty(message = "Total Gross Value is required")
        BigDecimal totalGrossValueDto,

        @NotNull(message = "Product tax is required")
        NFNotaInfoItemImposto productTaxDto,

        @NotEmpty(message = "Discount Value is required")
        BigDecimal discountValue,

        @NotEmpty(message = "Freight Value is required")
        BigDecimal freightValue

) {

    public record NFNotaInfoItemImposto(

            String valorTotalTributos,

            NFNotaInfoItemImpostoICMS icms,

            NFNotaInfoItemImpostoIPI ipi,

            NFNotaInfoItemImpostoImportacao impostoImportacao,


            NFNotaInfoItemImpostoISSQN issqn,

            NFNotaInfoItemImpostoPIS pis,

            NFNotaInfoItemImpostoPISST pisst,

            NFNotaInfoItemImpostoCOFINS cofins,

            NFNotaInfoItemImpostoCOFINSST cofinsst,

            NFNotaInfoItemImpostoICMSUFDestino icmsUfDestino,


            NFNotaInfoItemImpostoIS is,


            NFNotaInfoItemImpostoIBSCBS ibsCbs
    ){}

    public record NFNotaInfoItemImpostoICMS(

            NFNotaInfoItemImpostoICMS00 icms00,

            NFNotaInfoItemImpostoICMS02 icms02,

            NFNotaInfoItemImpostoICMS10 icms10,

            NFNotaInfoItemImpostoICMS15 icms15,

            NFNotaInfoItemImpostoICMS20 icms20,

            NFNotaInfoItemImpostoICMS30 icms30,

            NFNotaInfoItemImpostoICMS40 icms40,

            NFNotaInfoItemImpostoICMS51 icms51,

            NFNotaInfoItemImpostoICMS53 icms53,

            NFNotaInfoItemImpostoICMS60 icms60,

            NFNotaInfoItemImpostoICMS61 icms61,

            NFNotaInfoItemImpostoICMS70 icms70,

            NFNotaInfoItemImpostoICMS90 icms90,

            NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado,

            NFNotaInfoItemImpostoICMSST icmsst,

            NFNotaInfoItemImpostoICMSSN101 icmssn101,

            NFNotaInfoItemImpostoICMSSN102 icmssn102,

            NFNotaInfoItemImpostoICMSSN201 icmssn201,

            NFNotaInfoItemImpostoICMSSN202 icmssn202,

            NFNotaInfoItemImpostoICMSSN500 icmssn500,

            NFNotaInfoItemImpostoICMSSN900 icmssn900

    ){}

    public record NFNotaInfoItemImpostoICMS00(

            NFOrigem origem,

            NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

            NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS,

            String valorBaseCalculo,

            String percentualAliquota,

            String valorTributo,

            String percentualFundoCombatePobreza,

            String valorFundoCombatePobreza

    ){}

    public record NFOrigem(

            String codigo,
            String descricao

    ){}

    public record NFNotaInfoImpostoTributacaoICMS(

            String codigo,
            String descricao

    ){}

    public record NFNotaInfoItemModalidadeBCICMS(

            String codigo,
            String descricao

    ){}

    public record NFNotaInfoItemImpostoICMS02(
            NFOrigem origem,

            NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

            String quantidadeBaseCalculo,

            String percentualAliquota,

            String valorTributo
    ){}

    public record NFNotaInfoItemImpostoICMS10(

            NFOrigem origem,

            NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

            NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS,

            String valorBaseCalculo,

            String percentualAliquota,

            String valorTributo,

            String valorBaseCalculoFundoCombatePobreza,

            String percentualFundoCombatePobreza,

            String valorFundoCombatePobreza,

            NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST,

            String percentualMargemValorAdicionadoICMSST,

            String percentualReducaoBCICMSST,

            String valorBCICMSST,

            String percentualAliquotaImpostoICMSST,

            String valorICMSST,

            String valorBCFundoCombatePobrezaST,

            String percentualFundoCombatePobrezaST,

            String valorFundoCombatePobrezaST,

            String valorICMSSTDesonerado,

            NFNotaMotivoDesoneracaoICMS motivoDesoneracaoICMSST

    ){}

    public record NFNotaInfoItemModalidadeBCICMSST(

            String codigo,
            String descricao

    ){}

    public record NFNotaMotivoDesoneracaoICMS(
            String codigo,
            String descricao
    ){}

    public record NFNotaInfoItemImpostoICMS15(

            NFOrigem origem,

            NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

            String quantidadeBaseCalculo,

            String percentualAliquota,

            String valorTributo,

            String quantidadeBaseCalculoTributadaSujeitaRetencao,

            String percentualAliquotaRetencao,

            String valorTributoRetencao,

            String percentualReducaoAliquota,

            NFNotaMotivoReducaoADREM motivoReducao

    ){}

    public record NFNotaMotivoReducaoADREM(

            String codigo,
            String descricao

    ){}

    public record NFNotaInfoItemImpostoICMS20(
            NFOrigem origem,

            NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

            NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS,

            String percentualReducaoBC,

            String valorBCICMS,

            String percentualAliquota,

            String valorTributo,

            String valorBCFundoCombatePobreza,

            String percentualFundoCombatePobreza,

            String valorFundoCombatePobreza,

            String valorICMSDesoneracao,

            NFNotaMotivoDesoneracaoICMS desoneracao,

            NFTipoDeducaoIcms indicaDeduzDesoneracao

    ){}

    public record NFTipoDeducaoIcms(

            String codigo,
            String descricao

    ){}

    public record NFNotaInfoItemImpostoICMS30(

            NFOrigem origem,

            NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

            NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST,

            String percentualMargemValorAdicionadoICMSST,

            String percentualReducaoBCICMSST,

            String valorBCICMSST,

            String percentualAliquotaImpostoICMSST,

            String valorImpostoICMSST,

            String valorBCFundoCombatePobrezaST,

            String percentualFundoCombatePobrezaST,

            String valorFundoCombatePobrezaST,

            String valorICMSDesoneracao,

            NFNotaMotivoDesoneracaoICMS desoneracao,

            NFTipoDeducaoIcms indicaDeduzDesoneracao

    ){}

    public record NFNotaInfoItemImpostoICMS40(

            NFOrigem origem,

            NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

            String valorICMSDesoneracao,

            NFNotaMotivoDesoneracaoICMS motivoDesoneracaoICMS,

            NFTipoDeducaoIcms indicaDeduzDesoneracao

    ){}

    public record NFNotaInfoItemImpostoICMS51(

            NFOrigem origem,

            NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

            NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS,

            String percentualReducaoBC,

            String codigoBeneficioFiscalRBC,

            String valorBCICMS,

            String percentualICMS,

            String valorICMSOperacao,

            String percentualDiferimento,

            String valorICMSDiferimento,

            String valorICMS,

            String valorBCFundoCombatePobreza,

            String percentualFundoCombatePobreza,

            String valorFundoCombatePobreza,

            String percentualDiferimentoFundoCombatePobreza,

            String valorDiferimentoFundoCombatePobreza,

            String valorEfetivoFundoCombatePobreza

    ){}


    public record NFNotaInfoItemImpostoICMS53(

            NFOrigem origem,

            NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

            String quantidadeBaseCalculo,

            String percentualAliquota,

            String valorOperacao,

            String percentualDiferimento,

            String valorTributoDiferido,

            String valorTributo

    ){}

    public record NFNotaInfoItemImpostoICMS60(

            NFOrigem origem,

            NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

            String valorBCICMSSTRetido,

            String percentualAliquotaICMSSTConsumidorFinal,

            String valorICMSSubstituto,

            String valorICMSSTRetido,

            String valorBCFundoCombatePobrezaRetidoST,

            String percentualFundoCombatePobrezaRetidoST,

            String valorFundoCombatePobrezaRetidoST,

            String percentualReducaoBCEfetiva,

            String valorBCEfetiva,

            String percentualAliquotaICMSEfetiva,

            String valorICMSEfetivo

    ){}

    public record NFNotaInfoItemImpostoICMS61(

            NFOrigem origem,

            NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

            String quantidadeBaseCalculo,

            String percentualAliquota,

            String valorTributo

    ){}

    public record NFNotaInfoItemImpostoICMS70(

            NFOrigem origem,

            NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

            NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS,

            String percentualReducaoBC,

            String valorBC,

            String percentualAliquota,

            String valorTributo,

            String valorBCFundoCombatePobreza,

            String percentualFundoCombatePobreza,

            String valorFundoCombatePobreza,

            NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST,

            String percentualMargemValorAdicionadoICMSST,

            String percentualReducaoBCICMSST,

            String valorBCST,

            String percentualAliquotaImpostoICMSST,

            String valorICMSST,

            String valorBCFundoCombatePobrezaST,

            String percentualFundoCombatePobrezaST,

            String valorFundoCombatePobrezaST,

            String valorICMSDesoneracao,

            NFNotaMotivoDesoneracaoICMS desoneracao,

            String valorICMSSTDesonerado,

            NFNotaMotivoDesoneracaoICMS motivoDesoneracaoICMSST,

            NFTipoDeducaoIcms indicaDeduzDesoneracao

    ){}

    public record NFNotaInfoItemImpostoICMS90(

    NFOrigem origem,

    NFNotaInfoImpostoTributacaoICMS situacaoTributaria,

    NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS,

    String valorBC,

    String percentualReducaoBC,

    String percentualAliquota,

    String valorTributo,

    String valorBCFundoCombatePobreza,

    String percentualFundoCombatePobreza,

    String valorFundoCombatePobreza,

    NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST,

    String percentualMargemValorAdicionadoICMSST,

    String percentualReducaoBCICMSST,

    String valorBCST,

    String percentualAliquotaImpostoICMSST,

    String valorICMSST,

    String valorBCFundoCombatePobrezaST,

    String percentualFundoCombatePobrezaST,

    String valorFundoCombatePobrezaST,

    String valorICMSDesoneracao,

    NFNotaMotivoDesoneracaoICMS desoneracao,

    String valorICMSSTDesonerado,

    NFNotaMotivoDesoneracaoICMS motivoDesoneracaoICMSST,

    NFTipoDeducaoIcms indicaDeduzDesoneracao

    ){}

}
