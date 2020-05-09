package br.com.travelagency.travel.consumer;

import br.com.travelagency.travel.dto.FlyReserveDTO;
import br.com.travelagency.travel.enums.ServiceStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient("fly")
public interface FlyReservationClient {

    @RequestMapping("/flyReserves")
    List<FlyReserveDTO> findReserves(@RequestParam String clientName, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateTimeDeparture, @RequestParam(required = false) ServiceStatus serviceStatus);

    @RequestMapping(method= RequestMethod.POST, value="/flyReserves")
    FlyReserveDTO reserve(@RequestBody FlyReserveDTO flyReserveDTO);

}
