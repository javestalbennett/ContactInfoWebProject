/**
 * @author Joshua Vestal-Bennett - javestalbennett
 * CIS175 - Fall 2023
 * Sep 13, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ContactEntry;

/**
 * 
 */
public class ContactInfoHelper 
{
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("ContactInfo");

	public ContactInfoHelper() 
	{

	}


	public void insertContact(ContactEntry ce)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ce);
		em.getTransaction().commit();
		em.close();
	}

	public List<ContactEntry> showAllContacts()
	{
		EntityManager em = emfactory.createEntityManager();
		List<ContactEntry> allItems = em.createQuery("SELECT i FROM ContactEntry i").getResultList();
		return allItems;
	}

	public void deleteContact(ContactEntry toDelete) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ContactEntry> typedQuery = 
				em.createQuery("select ce from ContactEntry ce where ce.name = :selectedName and ce.phoneNumber = :selectedPhoneNumber", ContactEntry.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedPhoneNumber", toDelete.getPhoneNumber());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		ContactEntry result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}


	/**
	 * @param idToEdit
	 * @return
	 */
	public ContactEntry searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ContactEntry found = em.find(ContactEntry.class, idToEdit);
		em.close();
		return found;
	}


	/**
	 * @param toEdit
	 */
	public void updateItem(ContactEntry toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}


	/**
	 * @param name
	 * @return
	 */
	public List<ContactEntry> searchForItemByName(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ContactEntry> typedQuery = em.createQuery("select ce from ContactEntry ce where ce.name = :selectedName", ContactEntry.class);
		typedQuery.setParameter("selectedName", name);
		List<ContactEntry> foundContacts = typedQuery.getResultList();
		em.close();
		return foundContacts;
	}


	/**
	 * @param phoneNumber
	 * @return
	 */
	public List<ContactEntry> searchForItemByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ContactEntry> typedQuery = em.createQuery("select ce from ContactEntry ce where ce.phoneNumber = :selectedPhoneNumber", ContactEntry.class);
		typedQuery.setParameter("selectedPhoneNumber", phoneNumber);
		List<ContactEntry> foundContacts = typedQuery.getResultList();
		em.close();
		return foundContacts;
	}

	public void cleanUp(){
		emfactory.close();
	}
}
