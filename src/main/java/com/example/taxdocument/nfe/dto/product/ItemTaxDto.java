package com.example.taxdocument.nfe.dto.product;

import com.example.taxdocument.nfe.dto.tax.*;
import jakarta.validation.Valid;

public record ItemTaxDto(
        String totalValue,
        @Valid IcmsTaxDto icms,
        @Valid IpiTaxDto ipi,
        @Valid ImportTaxDto importTax,
        @Valid IssqnTaxDto issqn,
        @Valid PisTaxDto pis,
        @Valid CofinsTaxDto cofins,
        @Valid IcmsDestinyDto icmsDestiny,
        @Valid IbsCbsTaxDto ibsCbsTax
){}
