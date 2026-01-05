package com.example.taxdocument.nfe.dto;

import com.example.taxdocument.nfe.dto.Receiver.ReceiverDto;
import com.example.taxdocument.nfe.dto.finance.ChargeRequestDto;
import com.example.taxdocument.nfe.dto.finance.PaymentRequestDto;
import com.example.taxdocument.nfe.dto.issuer.InfoRequestDto;
import com.example.taxdocument.nfe.dto.issuer.IssuerRequestDto;
import com.example.taxdocument.nfe.dto.product.ProductNfeDto;
import com.example.taxdocument.nfe.dto.tax.TotalNfeDto;
import com.example.taxdocument.nfe.dto.transport.TransportDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record NfeRequestDto(
        @Valid @NotNull InfoRequestDto info,
        @Valid @NotNull IssuerRequestDto issuer,
        @Valid @NotNull ReceiverDto receiver,
        @Valid @NotEmpty List<ProductNfeDto> products,
        @Valid TransportDto transport,
        @Valid TotalNfeDto totals,
        @Valid @NotNull ChargeRequestDto charge,
        @Valid @NotNull PaymentRequestDto payment
) {}