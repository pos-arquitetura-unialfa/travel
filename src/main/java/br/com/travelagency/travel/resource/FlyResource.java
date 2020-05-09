package br.com.travelagency.travel.resource;

import br.com.travelagency.travel.consumer.FlyReservationClient;
import br.com.travelagency.travel.dto.FlyReserveDTO;
import br.com.travelagency.travel.enums.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController("/fly")
public class FlyResource {

    @Autowired
    private FlyReservationClient flyReservationClient;

    @PostMapping
    List<FlyReserveDTO> findReserves(@RequestParam String clientName, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateTimeDeparture, @RequestParam(required = false) ServiceStatus serviceStatus) {
        return this.flyReservationClient.findReserves(clientName, dateTimeDeparture, serviceStatus);
    }

    @PostMapping
    FlyReserveDTO reserve(@RequestBody FlyReserveDTO reserve) {
        return this.flyReservationClient.reserve(reserve);
    }
}
