package com.onroad.config.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistEngine {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("neusamoda");

    public PersistEngine(){

    }

    public EntityManagerFactory getInstance(){
        return emf;
    }

    public EntityManager getConnection(){
        return emf.createEntityManager();
    }

    public EntityManager createConnection(){
        return emf.createEntityManager();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
