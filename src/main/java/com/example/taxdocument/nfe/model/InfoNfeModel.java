package com.example.taxdocument.nfe.model;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InfoNfeModel {

    //Identification
    private Integer cUf;
    private String natOp;
    private Integer mod;
    private Integer serie;
    private Integer nNf;
    private LocalDateTime dhEmi;
    private Integer cNF;

    //Control data
    private Integer tpNF;
    private Integer cMunFG;
    private Integer tpImp;
    private Integer tpEmis;
    private Integer cDV;
    private Integer tpAmb;

    //Details of the operation
    private Integer indFinal;
    private Integer indPres;
    private Integer procEmi;
    private String verProc;
    private Integer indIntermed;

}