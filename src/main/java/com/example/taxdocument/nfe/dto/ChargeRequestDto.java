package com.example.taxdocument.nfe.dto;

import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoFatura;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.simpleframework.xml.core.Validate;

import java.util.List;

public record ChargeRequestDto(

        @Valid
        @NotNull(message = "Invoice details are required.")
        NFInvoiceRequestDto invoice,

        @Valid
        @NotEmpty(message = "A nota deve ter pelo menos uma parcela")
        List<NFInstallmentRequestDto> installments

) {
}
