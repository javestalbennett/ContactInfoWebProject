/**
 * @author Joshua Vestal-Bennett - javestalbennett
 * CIS175 - Fall 2023
 * Oct 16, 2023
 */
// package and import statements
package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}
	public User(String userName) {
		super();
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" +
				userName + "]";
	}
}
