/**
 * @author Joshua Vestal-Bennett - javestalbennett
 * CIS175 - Fall 2023
 * Oct 16, 2023
 */
//package and import statements
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;

public class UserHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ContactInfo");

	public void insertUser(User s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	public List<User> showAllUsers() {
		EntityManager em = emfactory.createEntityManager();
		List<User> allUsers = em.createQuery("SELECT s FROM User s").getResultList();
		return allUsers;
	}
	public User findUser(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> typedQuery = em.createQuery("select uh from User uh where uh.userName = :selectedName", User.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		User foundUser;
		try {
			foundUser = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundUser = new User(nameToLookUp);
		}
		em.close();
		return foundUser;
	}
}