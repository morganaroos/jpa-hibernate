package main.Conection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectionFactory {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate");

    public EntityManager getConnection() {
        return emf.createEntityManager();
    }
}
