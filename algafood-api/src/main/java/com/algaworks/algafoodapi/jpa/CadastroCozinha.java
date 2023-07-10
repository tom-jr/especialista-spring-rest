package com.algaworks.algafoodapi.jpa;

import com.algaworks.algafoodapi.domain.models.Cozinha;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Cozinha> consultarCozinha() {

        List<String> cozinhaNomes = entityManager.createQuery("SELECT nome FROM Cozinha ", String.class).getResultList();
        System.out.println(cozinhaNomes);

        List<EntityGeneral> general = entityManager
                .createQuery("SELECT NEW com.algaworks.algafoodapi.jpa.EntityGeneral(co.id, co.nome) FROM Cozinha co",
                        EntityGeneral.class).getResultList();

        System.out.println(general.get(0).getIdentifier());
        System.out.println(general.get(0).getName());
        return entityManager.createQuery("FROM Cozinha", Cozinha.class).getResultList();
    }
}
