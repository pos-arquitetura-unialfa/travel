package br.com.travelagency.travel.service;

import br.com.travelagency.travel.dto.ClientFilterDTO;
import br.com.travelagency.travel.enums.ServiceStatus;
import br.com.travelagency.travel.exception.ResourceNotFounException;
import br.com.travelagency.travel.model.Client;
import br.com.travelagency.travel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Client> findByFilter(ClientFilterDTO filter) {
        return repository.findByNameIgnoreCase(filter.getName());
    }

    @Override
    @Transactional
    public Client save(Client client) {
        if(client.getId() != null) {
            Client managedClient = repository.findById(client.getId()).orElseThrow(ResourceNotFounException::new);
            this.updateManagedClient(managedClient, client);
            this.save(managedClient);
        }
        return repository.save(client);
    }

    private void updateManagedClient(Client managedClient, Client updatedClient) {
        managedClient.setName(updatedClient.getName());
        managedClient.setBirthDate(updatedClient.getBirthDate());
        managedClient.setProfession(updatedClient.getProfession());
    }
}
