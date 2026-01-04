package com.example.taxdocument.nfe.dto.tax;

import jakarta.validation.Valid;
import java.time.YearMonth;

public record IbsCbsTaxDto(
        String situationCode,      // CST
        String classificationCode, // cClassTrib
        @Valid IbsCbsValueDto values,
        @Valid MonophasicDto monophasic,
        @Valid AdjustmentDto adjustment
) {
    public record IbsCbsValueDto(
            String baseValue,
            String ibsTaxValue,
            String cbsTaxValue,
            String ibsTaxRate,
            String cbsTaxRate
    ) {}

    public record MonophasicDto(
            String quantity,
            String adRemIbs,
            String adRemCbs,
            String ibsValue,
            String cbsValue
    ) {}

    public record AdjustmentDto(
            YearMonth referencePeriod,
            String ibsAdjustment,
            String cbsAdjustment
    ) {}
}