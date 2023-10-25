package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactEntry;
import model.ListDetails;
import model.User;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContactInfoHelper lih = new ContactInfoHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		String userName = request.getParameter("userName");
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<ContactEntry> selectedItemsInList = new ArrayList<ContactEntry>();
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0)
		{
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ContactEntry c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		User user = new User(userName);
		ListDetails sld = new ListDetails(listName, user);
		sld.setListOfContacts(selectedItemsInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
