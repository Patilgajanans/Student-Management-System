package com.jspider.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspider.springmvc.pojo.StudentPOJO;

@Repository
public class StudentRepository {
	
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
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	
	public StudentPOJO addStudent(String name, String email, String contact, String address) {
		
		openConnection();
		entityTransaction.begin();
		
		long contact1 = Long.parseLong(contact);
		StudentPOJO pojo =null;
		
		try {
			contact1 = Long.parseLong(contact);
			pojo = new StudentPOJO();
			pojo.setName(name.toUpperCase());
			pojo.setContact(contact1);
			pojo.setEmail(email.toLowerCase());
			pojo.setAddress(address.toUpperCase());
			entityManager.persist(pojo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		entityTransaction.commit();
		closeConnection();
		return pojo;
	}

	public StudentPOJO searchStudent(int id) {
		openConnection();
		entityTransaction.begin();
		
		StudentPOJO student = entityManager.find(StudentPOJO.class, id);
		
		entityTransaction.commit();
		closeConnection();
		
		return student;
	}

	public List<StudentPOJO> displayStudents() {
		openConnection();
		entityTransaction.begin();
		
		String jpql="from StudentPOJO";
		
		query = entityManager.createQuery(jpql);
		List<StudentPOJO> students =query.getResultList();
		
		entityTransaction.commit();
		closeConnection();
		
		return students;
	}

	public StudentPOJO deleteStudent(int id) {
		openConnection();
		entityTransaction.begin();
		
		StudentPOJO student = entityManager.find(StudentPOJO.class, id);
		if (student!= null) {
			entityManager.remove(student);
		}
		
		entityTransaction.commit();
		closeConnection();
		return student;
	}

	public List<StudentPOJO> searchStudent(String attr, String value) {
		openConnection();
		entityTransaction.begin();
		
		switch (attr) {
		case "id":
				{	
					int id = Integer.parseInt(value);
					query = entityManager.createQuery("select std from StudentPOJO std where id = :n");
					query.setParameter("n", id);
					break;
				}
		case "name":
				{
					query = entityManager.createQuery("select std from StudentPOJO std where name = :n");
					query.setParameter("n", value.toUpperCase());
					break;
				}
		case "email":
				{
					query = entityManager.createQuery("select std from StudentPOJO std where email = :n");
					query.setParameter("n", value.toLowerCase());
					break;
				}
		case "contact":
				{
					long num = Long.parseLong(value);
					query = entityManager.createQuery("select std from StudentPOJO std where contact = :n");
					query.setParameter("n", num);
					break;
				}
				
		case "address":
				{
					query = entityManager.createQuery("select std from StudentPOJO std where address = :n");
					query.setParameter("n", value.toUpperCase());
					break;
				}
		default :{
			
			break;
		}
		}
		List<StudentPOJO>students=query.getResultList();
		
		entityTransaction.commit();
		closeConnection();
		return students;
	}

	public StudentPOJO editStudent(int id, String name, String email, long contact, String address) {
		
		openConnection();
		entityTransaction.begin();
		
		StudentPOJO pojo = entityManager.find(StudentPOJO.class, id);
		
		System.out.println(name + " " + id + " "+ email + " "+ contact + " "+address);
		
		if (pojo != null) {
			pojo.setName(name.toUpperCase());
			pojo.setContact(contact);
			pojo.setEmail(email.toLowerCase());
			pojo.setAddress(address.toUpperCase());
			entityManager.persist(pojo);
			System.out.println(pojo + "from repository");
		}
		
		entityTransaction.commit();
		closeConnection();
		
		return pojo;
	}
	
	
	
}
