package com.example.taxdocument.nfe.model;

import com.fincatto.documentofiscal.nfe400.classes.NFModalidadeFrete;
import com.fincatto.documentofiscal.nfe400.classes.nota.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TransportNfeModel {

    //Freight forwarder information
    private NFModalidadeFrete modalidadeFrete;
    private NFNotaInfoTransportador transportador;
    private NFNotaInfoRetencaoICMSTransporte icmsTransporte;

    //Type of transport
    private NFNotaInfoVeiculo veiculo;
    private List<NFNotaInfoReboque> reboques;
    private String vagao;
    private String balsa;

    //Volumes
    private List<NFNotaInfoVolume> volumes;

}
