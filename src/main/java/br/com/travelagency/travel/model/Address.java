package br.com.travelagency.travel.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ENDERECO")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "PAIS")
    private String contry;

    @Column(name = "ESTADO")
    private String state;

    @Column(name = "CIDADE")
    private String city;

    @Column(name = "BAIRRO")
    private String district;

    @Column(name = "CEP")
    private String zipCode;

    @Column(name = "RUA")
    private String street;

    @Column(name = "COMPLEMENTO")
    private String complement;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Client client;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", contry='" + contry + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                ", complement='" + complement + '\'' +
                ", consumer=" + client +
                '}';
    }
}
