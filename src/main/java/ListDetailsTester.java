/**
 * @author Joshua Vestal-Bennett - javestalbennett
 * CIS175 - Fall 2023
 * Oct 18, 2023
 */

import java.util.ArrayList;
import java.util.List;
import controller.ListDetailsHelper;
import controller.UserHelper;
import model.ContactEntry;
import model.ListDetails;
import model.User;

/**
 * 
 */
public class ListDetailsTester 
{
	public static void main(String[] args) {
		User cameron = new User("Cameron");
		ListDetailsHelper ldh = new ListDetailsHelper();
		UserHelper uh = new UserHelper();
		uh.insertUser(cameron);

		ContactEntry john = new ContactEntry("John", "321");
		ContactEntry jane = new ContactEntry("Jane", "123");

		List<ContactEntry> cameronsItems = new ArrayList<ContactEntry>();
		cameronsItems.add(john);
		cameronsItems.add(jane);


		ListDetails cameronList = new ListDetails("Cameron's List", cameron);
		cameronList.setListOfContacts(cameronsItems);
		ldh.insertNewListDetails(cameronList);

		List<ListDetails> allLists = ldh.getLists();
		for (ListDetails a : allLists) 
		{
			System.out.println(a.toString());
		}
	}
}
