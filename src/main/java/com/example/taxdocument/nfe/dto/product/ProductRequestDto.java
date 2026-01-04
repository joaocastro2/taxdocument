package com.example.taxdocument.nfe.dto.product;

import com.example.taxdocument.nfe.dto.icms.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.YearMonth;

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

            Icms00RequestDtoj icms00,

            Icms02RequestDto icms02,

            Icms10RequestDto icms10,

            Icms15RequestDto icms15,

            Icms20RequestDto icms20,

            Icms30RequestDto icms30,

            Icms40RequestDto icms40,

            Icms51RequestDto icms51,

            Icms53RequestDto icms53,

            Icms60RequestDto icms60,

            Icms61RequestDto icms61,

            Icms70RequestDto icms70,

            Icms90RequestDto icms90,

            IcmsSharedRequestDto icmsPartilhado,

            TaxIcmsSTRequestDto icmsst,

            Icms101RequestDto icmssn101,

            Icms102RequestDto icmssn102,

            Icms201RequestDto icmssn201,

            Icms202RequestDto icmssn202,

            Icms500RequestDto icmssn500,

            Icms900RequestDto icmssn900

    ){}

    public record NFNotaInfoItemImpostoIPI(
            String cnpjProdutor,

            String codigoSelo,

            BigInteger quantidadeSelo,

            String codigoEnquadramento,

            NFNotaInfoItemImpostoIPITributado tributado,

            NFNotaInfoItemImpostoIPINaoTributado naoTributado

    ){}

    public record NFNotaInfoItemImpostoIPITributado(
            NFNotaInfoSituacaoTributariaIPI situacaoTributaria,

            String valorBaseCalculo,

            String percentualAliquota,

            String quantidade,

            String valorUnidadeTributavel,

            String valorTributo
    ){}

    public record NFNotaInfoSituacaoTributariaIPI(
            String codigo,
            String descricao
    ){}

    public record NFNotaInfoItemImpostoIPINaoTributado(
            NFNotaInfoSituacaoTributariaIPI situacaoTributaria
    ){}

    public record NFNotaInfoItemImpostoImportacao(
            String valorBaseCalculo,

            String valorDespesaAduaneira,

            String valorImpostoImportacao,

            String valorIOF
    ){}

    public record NFNotaInfoItemImpostoISSQN(
            String valorBaseCalculo,

            String valorAliquota,

            String valor,

            Integer codigoMunicipio,

            String itemListaServicos,

            String valorDeducao,

            String valorOutro,

            String valorDescontoIncondicionado,

            String valorDescontoCondicionado,

            String valorRetencaoISS,

            NFNotaInfoItemIndicadorExigibilidadeISS indicadorExigibilidadeISS,

            String codigoServico,

            String codigoMunicipioIncidenciaImposto,

            String codigoPais,

            String numeroProcesso,

            NFNotaInfoItemIndicadorIncentivoFiscal indicadorIncentivoFiscal

    ){}

    public record NFNotaInfoItemIndicadorExigibilidadeISS(
            String codigo,
            String descricao
    ){}

    public record NFNotaInfoItemIndicadorIncentivoFiscal(
            String codigo,
            String descricao
    ){}

    public record NFNotaInfoItemImpostoPIS(
            NFNotaInfoItemImpostoPISAliquota aliquota,

            NFNotaInfoItemImpostoPISQuantidade quantidade,

            NFNotaInfoItemImpostoPISNaoTributado naoTributado,

            NFNotaInfoItemImpostoPISOutrasOperacoes outrasOperacoes
    ){}

    public record NFNotaInfoItemImpostoPISAliquota(
            NFNotaInfoSituacaoTributariaPIS situacaoTributaria,

            String valorBaseCalculo,

            String percentualAliquota,

            String valorTributo
    ){}

    public record NFNotaInfoSituacaoTributariaPIS(
            String codigo,
            String descricao
    ){}

    public record NFNotaInfoItemImpostoPISQuantidade(
            NFNotaInfoSituacaoTributariaPIS situacaoTributaria,

            String quantidadeVendida,

            String valorAliquota,

            String valorTributo
    ){}
    public record NFNotaInfoItemImpostoPISNaoTributado(
            NFNotaInfoSituacaoTributariaPIS situacaoTributaria,

            String quantidadeVendida,

            String valorAliquota,

            String valorTributo
    ){}

    public record NFNotaInfoItemImpostoPISOutrasOperacoes(
            NFNotaInfoSituacaoTributariaPIS situacaoTributaria,

            String valorBaseCalculo,

            String percentualAliquota,

            String quantidadeVendida,

            String valorAliquota,

            String valorTributo
    ){}

    public record NFNotaInfoItemImpostoPISST(
            String valorBaseCalculo,

            String percentualAliquota,

            String quantidadeVendida,

            String valorAliquota,

            String valorTributo,

            NFIndicadorSomaPISST indicadorSomaPISST
    ){}

    public record NFIndicadorSomaPISST(
            String codigo,
            String descricao
    ){}

    public record NFNotaInfoItemImpostoCOFINS(
            NFNotaInfoItemImpostoCOFINSAliquota aliquota,

            NFNotaInfoItemImpostoCOFINSQuantidade quantidade,

            NFNotaInfoItemImpostoCOFINSNaoTributavel naoTributavel,

            NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes
    ){}

    public record NFNotaInfoItemImpostoCOFINSAliquota(
            NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria,

            String valorBaseCalculo,

            String percentualAliquota,

            String valor
    ){}

    public record NFNotaInfoSituacaoTributariaCOFINS(
            String codigo,
            String descricao
    ){}

    public record NFNotaInfoItemImpostoCOFINSQuantidade(
            NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria,

            String quantidadeVendida,

            String valorAliquota,

            String valorTributo
    ){}

    public record NFNotaInfoItemImpostoCOFINSNaoTributavel(
            NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria
    ){}

    public record NFNotaInfoItemImpostoCOFINSOutrasOperacoes(
            NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria,

            String valorBaseCalculo,

            String percentualCOFINS,

            String quantidadeVendida,

            String valorAliquota,

            String valorCOFINS
    ){}

    public record NFNotaInfoItemImpostoCOFINSST(
            String valorBaseCalculo,

            String percentualAliquota,

            String quantidadeVendida,

            String valorAliquotaCOFINS,

            String valorCOFINS,

            NFIndicadorSomaCofinsST indicadorSomaCOFINSST
    ){}

    public record NFIndicadorSomaCofinsST(
            String codigo,
            String descricao
    ){}

    public record NFNotaInfoItemImpostoICMSUFDestino(
            String valorBaseCalculoDestino,

            String valorBCFundoCombatePobrezaDestino,

            String percentualRelativoFundoCombatePobrezaDestino,

            String percentualAliquotaInternaDestino,

            String percentualInterestadual,

            String percentualProvisorioPartilha,

            String valorRelativoFundoCombatePobrezaDestino,

            String valorICMSInterestadualDestino,

            String valorICMSInterestadualRemetente
    ){}

    public record NFNotaInfoItemImpostoIS(
            NFNotaInfoImpostoTributacaoIS cstIS,

            String cClassTribIS,


            String vBCIS,

            String pIS,

            String pISEspec,

            String uTrib,

            String qTrib,

            String vIS
    ){}

    public record NFNotaInfoImpostoTributacaoIS(
            String codigo,
            String descricao
    ){}

    public record NFNotaInfoItemImpostoIBSCBS(
            NFNotaInfoImpostoTributacaoIBSCBS cst,

            String cClassTrib,

            String indicadorNaturezaOperacaoDoacao,

            NFNotaInfoItemImpostoIBSCBSTIBS gIBSCBS,

            NFNotaInfoItemImpostoIBSCBSMonofasia gIBSCBSMono,

            NFNotaInfoItemImpostoIBSCBSTransfCred gTransfCred,

            NFNotaInfoItemImpostoIBSCBSCredPresIBSZFM gCredPresIBSZFM,

            NFNotaInfoIBSCBSGrupoEstornoCredito grupoEstornoCredito,

            NFNotaInfoItemImpostoIBSCBSGCredPresOper grupoCreditoPresumidoOperacao,

            GrupoAjusteCompetencia grupoAjusteCompetencia
    ){
        public record GrupoAjusteCompetencia(
                YearMonth dataCompetenciaApuracao,
                String valorIBS,
                String valorCBS
        ){}
    }

    public record NFNotaInfoImpostoTributacaoIBSCBS(
            String codigo,
            String descricao,
            Integer indGIBSCBS,
            Integer indGIBSCBSMono,
            Integer indGRed,
            Integer indGDif,
            Integer indGTransfCred,
            boolean indNFe,
            boolean indNFCe,
            boolean indCTe,
            boolean indCteOS,
            boolean indBPe,
            boolean indBPeTM,
            boolean indNF3e,
            boolean indNFCom,
            boolean indNFSe
    ){}

    public record NFNotaInfoItemImpostoIBSCBSTIBS(
            String vBC,

            GIBSUF gIBSUF,

            GIBSMun gIBSMun,

            String vIBS,

            GCBS gCBS,

            GTribRegular gTribRegular,

            GTribCompraGov gTribCompraGov

    ){
        public record GIBSUF(
                String pIBSUF,

                GDif gDif,

                GDevTrib gDevTrib,

                GRed gRed,

                String vIBSUF
        ){}
        public record GDif(
                String pDif,
                String vDif
        ){}
        public record GDevTrib(
                String vDevTrib // UB25 // UB44
        ){}
        public record GRed(
                String pRedAliq, // UB27 // UB46
                String pAliqEfet
        ){}
        public record GIBSMun(
                String pIBSMun,
                GDif gDif,
                GDevTrib gDevTrib,
                GRed gRed,
                String vIBSMun
        ){}
        public record GCBS(
                String pCBS,
                GDif gDif,
                GDevTrib gDevTrib,
                GRed gRed,
                String vCBS
        ){}
        public record GTribRegular(
                NFNotaInfoImpostoTributacaoIBSCBS cstReg,
                String cClassTribReg,
                String pAliqEfetRegIBSUF,
                String vTribRegIBSUF,
                String pAliqEfetRegIBSMun,
                String vTribRegIBSMun,
                String pAliqEfetRegCBS,
                String vTribRegCBS
        ){}
        public record GTribCompraGov(
                String pAliqIBSUF,
                String vTribIBSUF,
                String pAliqIBSMun,
                String vTribIBSMun,
                String pAliqCBS,
                String vTribCBS
        ){}
    }
    public record NFNotaInfoItemImpostoIBSCBSMonofasia(
            NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao gMonoPadrao,

            NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten gMonoReten,

            NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet gMonoRet,

            NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif gMonoDif,

            String vTotIBSMonoItem,

            String vTotCBSMonoItem
    ){
        public record NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao(
                String qBCMono,
                String adRemIBS,
                String adRemCBS,
                String vIBSMono,
                String vCBSMono
        ){}
        public record NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten(
                String qBCMonoReten,
                String adRemIBSReten,
                String vIBSMonoReten,
                String adRemCBSReten,
                String vCBSMonoReten
        ){}
        public record NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet(
                String qBCMonoRet,
                String adRemIBSRet,
                String vIBSMonoRet,
                String adRemCBSRet,
                String vCBSMonoRet
        ){}
        public record NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif(
                String pDifIBS,
                String vIBSMonoDif,
                String pDifCBS,
                String vCBSMonoDif
        ){}
    }
    public record NFNotaInfoItemImpostoIBSCBSTransfCred(
            String vIBS,
            String vCBS
    ){}

    public record NFNotaInfoItemImpostoIBSCBSCredPresIBSZFM(
            LocalDate anoMesReferenciaApuracao,
            String tpCredPresIBSZFM,
            String vCredPresIBSZFM
    ){}

    public record NFNotaInfoIBSCBSGrupoEstornoCredito(
            String valorIbsEstornado,
            String valorCbsEstornado
    ){}
    public record NFNotaInfoItemImpostoIBSCBSGCredPresOper(
            String valorBaseCalculoCreditoPresumido,
            String classificacaoCreditoPresumido,
            GCredPres grupoIBSCreditoPresumido,
            GCredPres grupoCBSCreditoPresumido
    ){
        public record GCredPres(
                String pCredPres,
                String vCredPres,
                String vCredPresCondSus
        ){}
    }


}
