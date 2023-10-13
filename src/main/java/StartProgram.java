import java.util.List;
import java.util.Scanner;

import controller.ContactInfoHelper;
import model.ContactEntry;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static ContactInfoHelper cih = new ContactInfoHelper();

	// adds a contact to the table
	private static void addAnItem() {
		System.out.print("Enter a name: ");
		String name = in.nextLine();
		System.out.print("Enter a phone number: ");
		String phoneNumber = in.nextLine();
		ContactEntry toAdd = new ContactEntry(name, phoneNumber);
		cih.insertContact(toAdd);

	}

	// deletes a contact from the table
	private static void deleteAnItem() {
		System.out.print("Enter the name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter the phone number to delete: ");
		String phoneNumber = in.nextLine();
		ContactEntry toAdd = new ContactEntry(name, phoneNumber);
		cih.deleteContact(toAdd);

	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Name");
		System.out.println("2 : Search by Phone Number");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ContactEntry> foundContacts = null;
		if (searchBy == 1) {
			System.out.print("Enter the contact name: ");
			String name = in.nextLine();
			foundContacts = cih.searchForItemByName(name);

		} else {
			System.out.print("Enter the item: ");
			String phoneNumber = in.nextLine();
			foundContacts = cih.searchForItemByPhoneNumber(phoneNumber);


		}

		if (!foundContacts.isEmpty()) {
			System.out.println("Found Results.");
			for (ContactEntry l : foundContacts) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ContactEntry toEdit = cih.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getPhoneNumber() + " from " + toEdit.getName());
			System.out.println("1 : Update Name");
			System.out.println("2 : Update Phone Number");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			} else if (update == 2) {
				System.out.print("New Phone Number: ");
				String newPhoneNumber = in.nextLine();
				toEdit.setPhoneNumber(newPhoneNumber);
			}

			cih.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();
	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome contact list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an contact");
			System.out.println("*  2 -- Edit an contact");
			System.out.println("*  3 -- Delete an contact");
			System.out.println("*  4 -- View the contact");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				cih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}
	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<ContactEntry> allItems = cih.showAllContacts();
		for(ContactEntry singleItem : allItems)
		{
			System.out.println(singleItem.returnContactDetails());
		}
	}

}