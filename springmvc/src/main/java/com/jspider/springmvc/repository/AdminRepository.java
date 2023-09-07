package com.jspider.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspider.springmvc.pojo.AdminPOJO;

@Repository
public class AdminRepository {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Query query;
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Student");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

	public AdminPOJO checkAdmin(String username, String password) {
		openConnection();
		entityTransaction.begin();
		
		query = entityManager.createQuery("select admin from AdminPOJO admin where username = :u and password = :p");
		query.setParameter("u", username);
		query.setParameter("p", password);
		
		List<AdminPOJO> admins=null;
		admins = query.getResultList();
		
		AdminPOJO admin=null;
		if (!admins.isEmpty() && admins != null ) {
			
			admin=(AdminPOJO)query.getSingleResult();
		}
		
		entityTransaction.commit();
		closeConnection();
		
		return admin;
			
	}

	public AdminPOJO createAdmin(String username, String password) {
		openConnection();
		entityTransaction.begin();
		
				
		query =entityManager.createQuery("select admin from AdminPOJO admin where username = :n");
		query.setParameter("n", username);
		
		List<AdminPOJO> admins=null;
		admins = query.getResultList();
		AdminPOJO admin = null;
		if (admins == null || admins.isEmpty() ) {
			admin =new AdminPOJO();
			admin.setUsername(username);
			admin.setPassword(password);
			entityManager.persist(admin);
		}
		entityTransaction.commit();
		closeConnection();
		
		return admin;
	}

	public AdminPOJO checkAdmin() {
		openConnection();
		entityTransaction.begin();
		
		query = entityManager.createQuery("from AdminPOJO");
		
		List<AdminPOJO> admins = query.getResultList();
		
		if (admins.isEmpty()) {
			entityTransaction.commit();
			closeConnection();
			return null;
		}
		
		return admins.get(0);
	}

}
