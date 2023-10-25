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
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editListDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		ListDetailsHelper dao = new ListDetailsHelper();
		ContactInfoHelper cih = new ContactInfoHelper();
		UserHelper uh = new UserHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String userName = request.getParameter("userName");
		//find our add the new user
		User newUser = uh.findUser(userName);
		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<ContactEntry> selectedItemsInList = new ArrayList<ContactEntry>();
			for (int i = 0; i < selectedItems.length; i++) {
				System.
				out.println(selectedItems[i]);
				ContactEntry c = cih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setListOfContacts(selectedItemsInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<ContactEntry> selectedItemsInList = new ArrayList<ContactEntry>();
			listToUpdate.setListOfContacts(selectedItemsInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setUser(newUser);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}
}

