/**
 * @author Joshua Vestal-Bennett - javestalbennett
 * CIS175 - Fall 2023
 * Oct 18, 2023
*/


import java.util.List;

import controller.UserHelper;
import model.User;

/**
 * 
 */
public class UserTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create new user
		User bill = new User("Bill");
		UserHelper uh = new UserHelper();
		
		// add new user to list
		uh.insertUser(bill);
		
		//create new user
		User jim = new User("Jim");
		
		// add new user to list
		uh.insertUser(jim);
		
		// print list
		List<User> allUsers = uh.showAllUsers();
		for(User a: allUsers) {
		System.out.println(a.toString());
		}

	}

}
