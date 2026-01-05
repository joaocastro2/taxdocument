package com.example.taxdocument.nfe.model;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NfeFullModel {

    private InfoNfeModel info;
    private IssuerNfeModel issuer;
    private ReceiverNfeModel receiver;
    private List<ProductNfeModel> products;
    private TransportNfeModel transport;
    private TotalNfeModel totals;
    private ChargeNfeModel charge;
    private PaymentNfeModel payment;

}