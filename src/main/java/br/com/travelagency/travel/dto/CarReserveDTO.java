package br.com.travelagency.travel.dto;

import br.com.travelagency.travel.enums.ServiceStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CarReserveDTO {

    private Long id;
    private String carModel;
    private String clientName;
    private BigDecimal dailyPrice;
    private LocalDate initialDate;
    private LocalDate endDate;
    private ServiceStatus serviceStatus;

}
