package com.railway.connections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	EntityManagerFactory emf;

	public PersistenceManager() {
		emf = Persistence.createEntityManagerFactory("mysql");
		}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close() {
		emf.close();
	}
}
