package br.com.travelagency.travel.resource;

import br.com.travelagency.travel.dto.ClientFilterDTO;
import br.com.travelagency.travel.enums.ServiceStatus;
import br.com.travelagency.travel.model.Client;
import br.com.travelagency.travel.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/clients")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @GetMapping
    private List<Client> findAll() {
        return this.clientService.findAll();
    }

    @GetMapping("/{name}")
    private List<Client> find(@PathVariable String name) {
        return this.clientService.findByFilter(new ClientFilterDTO(name));
    }

    @PostMapping
    public Client save(@RequestBody Client client){
        return this.clientService.save(client);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client){
        client.setId(id);
        return this.clientService.save(client);
    }

}
