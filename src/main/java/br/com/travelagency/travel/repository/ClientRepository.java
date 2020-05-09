package br.com.travelagency.travel.repository;

import br.com.travelagency.travel.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByNameIgnoreCase(String name);

}
