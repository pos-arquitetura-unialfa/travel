package br.com.travelagency.travel.dto;

import br.com.travelagency.travel.enums.ServiceStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FlyReserveDTO {

    private Long id;
    private String clientName;
    private String departureCity;
    private String destinationCity;
    private BigDecimal price;
    private LocalDateTime dateTimeDeparture;
    private ServiceStatus serviceStatus;

}
