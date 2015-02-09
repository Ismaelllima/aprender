package br.com.aprender.livraria.modelo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaDaJPA {

    @Produces
    @ApplicationScoped
    public EntityManagerFactory criaEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("persistence");
    }

    @Produces
    public EntityManager criaEntityManager(EntityManagerFactory factory) {
        return factory.createEntityManager();
    }

    public void fechaManager(@Disposes EntityManager manager) {
        manager.close();
    }

    public void fechaFactory(@Disposes EntityManagerFactory factory) {
        factory.close();
    }

}
