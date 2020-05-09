package br.com.travelagency.travel.resource;

import br.com.travelagency.travel.consumer.CarReservationClient;
import br.com.travelagency.travel.dto.CarReserveDTO;
import br.com.travelagency.travel.enums.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController("/car")
public class CarResource {

    @Autowired
    private CarReservationClient carReservationClient;

    @PostMapping
    List<CarReserveDTO> findReserves(@RequestParam String clientName, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate initialDate, @RequestParam(required = false) ServiceStatus serviceStatus) {
        return this.carReservationClient.findReserves(clientName, initialDate, serviceStatus);
    }

    @PostMapping
    CarReserveDTO reserve(@RequestBody CarReserveDTO reserve) {
        return this.carReservationClient.reserve(reserve);
    }
}
