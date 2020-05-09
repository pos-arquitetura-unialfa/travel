package br.com.travelagency.travel.dto;

import br.com.travelagency.travel.enums.ServiceStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class HotelReserveDTO {

    private Long id;
    private String clientName;
    private String cityName;
    private String hotelName;
    private BigDecimal price;
    private LocalDate initialDate;
    private LocalDate endDate;
    private ServiceStatus serviceStatus;

}
