package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactEntry;

/**
 * Servlet implementation class editContactServlet
 */
@WebServlet("/editContactServlet")
public class editContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editContactServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContactInfoHelper dao = new ContactInfoHelper();
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ContactEntry itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setName(name);
		itemToUpdate.setPhoneNumber(phoneNumber);
		dao.updateItem(itemToUpdate);
		getServletContext().getRequestDispatcher("/viewAllContactsServlet").forward(request, response);
	}

}
