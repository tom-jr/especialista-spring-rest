package com.algaworks.algafoodapi.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class EntityGeneral {
    private Long identifier;
    private String name;


    public EntityGeneral() {}
    public EntityGeneral(Long identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }
}
