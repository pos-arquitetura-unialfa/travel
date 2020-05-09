package br.com.travelagency.travel.resource;

import br.com.travelagency.travel.consumer.HotelReservationClient;
import br.com.travelagency.travel.dto.HotelReserveDTO;
import br.com.travelagency.travel.enums.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController("/hotel")
public class HotelResource {

    @Autowired
    private HotelReservationClient hotelReservationClient;

    @PostMapping
    List<HotelReserveDTO> findReserves(@RequestParam String clientName, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate initialDate, @RequestParam(required = false) ServiceStatus serviceStatus) {
        return this.hotelReservationClient.findReserves(clientName, initialDate, serviceStatus);
    }

    @PostMapping
    HotelReserveDTO reserve(@RequestBody HotelReserveDTO reserve) {
        return this.hotelReservationClient.reserve(reserve);
    }
}
