package com.example.taxdocument.nfe.dto.tax;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record TotalNfeDto(
        @Valid IcmsTotalDto icmsTotal,
        @Valid IssqnTotalDto issqnTotal,
        @Valid RetentionsTotalDto retentions,

        @NotBlank(message = "O valor total da NF é obrigatório")
        String totalValue
) {
    public record IcmsTotalDto(
            String baseValue,
            String icmsValue,
            String icmsDesonValue,
            String fcpValue,
            String bcStValue,
            String stValue,
            String fcpStValue,
            String fcpStRetValue,
            String prodValue,
            String freightValue,
            String insuranceValue,
            String discountValue,
            String iiValue,
            String ipiValue,
            String ipiDevolValue,
            String pisValue,
            String cofinsValue,
            String otherValue
    ) {}

    public record IssqnTotalDto(
            String totalServicesValue,
            String baseValue,
            String issValue,
            String pisValue,
            String cofinsValue
    ) {}

    public record RetentionsTotalDto(
            String pRetPIS,
            String vRetPIS,
            String pRetCOFINS,
            String vRetCOFINS,
            String pRetCSLL,
            String vRetCSLL,
            String vBCIRRF,
            String vIRRF,
            String vBCRetPrev,
            String vRetPrev
    ) {}
}