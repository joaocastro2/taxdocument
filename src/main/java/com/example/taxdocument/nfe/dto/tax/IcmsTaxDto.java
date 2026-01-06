package com.example.taxdocument.nfe.dto.tax;


import com.example.taxdocument.nfe.dto.icms.*;

import jakarta.validation.Valid;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;


public record IcmsTaxDto(
        @NotBlank String icmsTaxCode,
        @NotBlank String icmsTaxDesc,
        @Valid Icms00Dto icms00,
        @Valid Icms02Dto icms02,
        @Valid Icms10Dto icms10,
        @Valid Icms15Dto icms15,
        @Valid Icms20Dto icms20,
        @Valid Icms30Dto icms30,
        @Valid Icms40Dto icms40,
        @Valid Icms51Dto icms51,
        @Valid Icms53Dto icms53,
        @Valid Icms60Dto icms60,
        @Valid Icms61Dto icms61,
        @Valid Icms70Dto icms70,
        @Valid Icms90Dto icms90,
        @Valid IcmsSn101Dto icmsSn101,
        @Valid IcmsSn102Dto icmsSn102,
        @Valid IcmsSn201Dto icmsSn201,
        @Valid IcmsSn202Dto icmsSn202,
        @Valid IcmsSn500Dto icmsSn500,
        @Valid IcmsSn900Dto icmsSn900
){

    public record PovertyFundDto(
            @NotBlank String baseValue,
            @NotBlank String taxRate,
            @NotBlank String taxValue
    ) {}

    public record SubstitutionTaxDto(
            @Valid @NotNull IcmsHasModalityBC modality,
            String mvaRate,
            String reductionRate,
            @NotBlank String baseValue,
            @NotBlank String taxRate,
            @NotBlank String taxValue,
            @Valid PovertyFundDto fcp
    ) {}

    public record ReductionDto(
            @NotBlank String reductionPercentage,
            @NotBlank String baseValue,
            @NotBlank String taxRate,
            @NotBlank String taxValue
    ) {}

    public record OriginTaxDto(
            String codigo,
            String descricao
    ){}

    public record Icms00Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @Valid @NotNull IcmsModalityDto icmsModality,
            @NotBlank String baseValue,
            @NotBlank String percentageRate,
            @NotBlank String taxValue,
            @Valid PovertyFundDto povertyFund
    ){}

    public record Icms02Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @NotBlank String baseValue,
            @NotBlank String percentageRate,
            @NotBlank String taxValue
    ) {}

    public record Icms10Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @Valid @NotNull IcmsModalityDto icmsModality,
            @NotBlank String baseValue,
            @NotBlank String percentageRate,
            @NotBlank String taxValue,
            @Valid PovertyFundDto povertyFund,
            @Valid @NotNull SubstitutionTaxDto substitutionTax
    ) {}

    public record Icms15Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @NotBlank String adRemBaseQuantity,
            @NotBlank String adRemTaxRate,
            @NotBlank String taxValue,
            @NotBlank String whBaseQuantity,
            @NotBlank String whTaxRate,
            @NotBlank String whTaxValue,
            @NotBlank String reductionPercentage,
            @Valid @NotNull NFReasonForReductionADREM reasonReduction
    ){}

    public record Icms20Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @Valid @NotNull IcmsModalityDto modalidadeBCICMS,
            @NotBlank String situation,
            @Valid @NotNull ReductionDto reduction,
            @Valid PovertyFundDto povertyFund,
            @NotBlank String excemptionValue,
            @Valid @NotNull IcmsExcemptionReasonDto extemptionReason,
            @Valid @NotNull IcmsDeductionType deductionTipe
    ){}

    public record Icms30Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @Valid @NotNull SubstitutionTaxDto substitutionTax,
            @NotBlank String exemptionValue,
            @Valid @NotNull IcmsExcemptionReasonDto exemptionReason,
            @Valid @NotNull IcmsDeductionType deductionType
    ){}

    public record Icms40Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            String exemptionValue,
            @Valid IcmsExcemptionReasonDto exemptionReason
    ){}

    public record Icms51Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @Valid IcmsModalityDto modality,
            @Valid ReductionDto reduction,
            @Valid PovertyFundDto povertyFund,
            String percentageDeferral,
            String valueDeferral,
            String valueTotal
    ){}

    public record Icms53Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @NotBlank String adRemBaseQuantity,
            @NotBlank String adRemTaxRate,
            @NotBlank String taxValue,
            String percentageDeferral,
            String valueDeferral,
            String valueTotal
    ){}

    public record IcmsEffectiveDto(
            String percentageReductionBCEffective,
            String valueBCEffective,
            String percentageAliquotICMSEffective,
            String valueICMSEffective
    ) {}

    public record Icms60Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            String baseValueSTRetained,
            String taxValueSTRetained,
            @Valid PovertyFundDto povertyFundRetained,
            @Valid IcmsEffectiveDto effective
    ){}

    public record Icms61Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @NotBlank String whBaseQuantity,
            @NotBlank String whTaxRate,
            @NotBlank String whTaxValue
    ){}

    public record Icms70Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @Valid @NotNull IcmsModalityDto modality,
            @Valid @NotNull ReductionDto reduction,
            @Valid PovertyFundDto povertyFund,
            @Valid @NotNull SubstitutionTaxDto substitutionTax
    ){}

    public record Icms90Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @Valid IcmsModalityDto modality,
            @Valid ReductionDto reduction,
            @Valid SubstitutionTaxDto substitutionTax,
            @Valid PovertyFundDto povertyFund,
            String creditTaxRate,
            String creditValue
    ){}

    public record IcmsSn101Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @NotBlank String creditTaxRate, // pCredSN
            @NotBlank String creditValue // vCredICMSSN
    ) {}

    public record IcmsSn102Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation
    ) {}

    public record IcmsSn201Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @Valid @NotNull SubstitutionTaxDto substitutionTax,
            @NotBlank String creditTaxRate,
            @NotBlank String creditValue

    ) {}

    public record IcmsSn202Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @Valid @NotNull SubstitutionTaxDto substitutionTax
    ) {}

    public record IcmsSn500Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            String baseValueSTRetained,
            String taxValueSTRetained,
            @Valid PovertyFundDto povertyFundRetained,
            @Valid IcmsEffectiveDto effective
    ) {}

    public record IcmsSn900Dto(
            @Valid @NotNull OriginTaxDto nfOrigin,
            @NotBlank String situation,
            @Valid IcmsModalityDto modality,
            @Valid ReductionDto reduction,
            @Valid SubstitutionTaxDto substitutionTax,
            @Valid PovertyFundDto povertyFund,
            String creditTaxRate,
            String creditValue
    ) {}

}