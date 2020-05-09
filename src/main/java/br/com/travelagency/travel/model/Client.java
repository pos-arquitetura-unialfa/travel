package br.com.travelagency.travel.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "CLIENTES")
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NOME")
    private String name;

    @Column(name = "PROFISSAO")
    private String profession;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "consumer")
    private List<Address> address;

}
