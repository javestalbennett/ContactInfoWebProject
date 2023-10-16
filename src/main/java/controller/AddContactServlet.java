package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactEntry;

/**
 * Servlet implementation class AddContactServlet
 */
@WebServlet("/addContactServlet")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		
		// create a new list item object and add contact to database
		ContactEntry li = new ContactEntry(name, phoneNumber);
		ContactInfoHelper dao = new ContactInfoHelper();
		dao.insertContact(li);
		
		// refresh the page
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
