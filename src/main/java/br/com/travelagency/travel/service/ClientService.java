package br.com.travelagency.travel.service;

import br.com.travelagency.travel.dto.ClientFilterDTO;
import br.com.travelagency.travel.enums.ServiceStatus;
import br.com.travelagency.travel.model.Client;

import java.time.LocalDate;
import java.util.List;

public interface ClientService {

    List<Client> findAll();

    List<Client> findByFilter(ClientFilterDTO filter);

    Client save(Client client);

}
