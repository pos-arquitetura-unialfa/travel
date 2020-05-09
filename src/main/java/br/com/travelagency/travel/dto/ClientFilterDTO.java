package br.com.travelagency.travel.dto;

import lombok.Data;

@Data
public class ClientFilterDTO {

    private String name;

    public ClientFilterDTO() {
        super();
    }

    public ClientFilterDTO(String name) {
        this.name = name;
    }
}
