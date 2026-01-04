package com.example.taxdocument.nfe.dto.tax;

public record IcmsDestinyDto(
        String baseValueDestiny,
        String fcpBaseValueDestiny,
        String fcpTaxRateDestiny,
        String internalTaxRateDestiny,
        String interstateTaxRate,
        String sharingPercentage,
        String fcpTaxValueDestiny,
        String icmsInterstateDestinyValue,
        String icmsInterstateOriginValue
) {}