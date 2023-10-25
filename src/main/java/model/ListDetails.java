/**
 * @author Joshua Vestal-Bennett - javestalbennett
 * CIS175 - Fall 2023
 * Oct 18, 2023
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ContactEntry> listOfContacts;
	@ManyToOne
	private User user;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the listOfContacts
	 */
	public List<ContactEntry> getListOfContacts() {
		return listOfContacts;
	}

	/**
	 * @param listOfContacts the listOfContacts to set
	 */
	public void setListOfContacts(List<ContactEntry> listOfContacts) {
		this.listOfContacts = listOfContacts;
	}

	

	public ListDetails(int id, String listName, User user, List<ContactEntry> listOfContacts) {
		this.id = id;
		this.listName = listName;
		this.user = user;
		this.listOfContacts = listOfContacts;
	}

	public ListDetails(String listName, User user, List<ContactEntry> listOfContacts) {
		this.listName = listName;
		this.user = user;
		this.listOfContacts = listOfContacts;
	}

	public ListDetails(String listName, User user) {
		this.listName = listName;
		this.user = user;
	}
	
	public ListDetails() {
		
	}

}
