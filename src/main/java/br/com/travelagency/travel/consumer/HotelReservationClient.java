package br.com.travelagency.travel.consumer;

import br.com.travelagency.travel.dto.CarReserveDTO;
import br.com.travelagency.travel.dto.HotelReserveDTO;
import br.com.travelagency.travel.enums.ServiceStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient("hotel")
public interface HotelReservationClient {

    @RequestMapping("/hotelReserves")
    List<HotelReserveDTO> findReserves(@RequestParam String clientName, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate initialDate, @RequestParam(required = false) ServiceStatus serviceStatus);

    @RequestMapping(method= RequestMethod.POST, value="/hotelReserves")
    HotelReserveDTO reserve(@RequestBody HotelReserveDTO hotelReserveDTO);

}
