package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.Contact;



/**
 * Servlet implementation class addContactServlet
 */
@WebServlet("/addContactServlet")
public class addContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		getServletContext().getRequestDispatcher("/new-contact.jsp").forward(request, response);

		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddressDAO addressDAO = new AddressDAO();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		

		String[] selectedAddress = request.getParameterValues("allAddressesToAdd");
		List<Address> selectedAddressInList = new ArrayList<Address>();
		if (selectedAddress != null && selectedAddress.length > 0) {
			for (int i = 0; i < selectedAddress.length; i++) {
				Address a = addressDAO.searchForAddressById(Integer.parseInt(selectedAddress[i]));
				selectedAddressInList.add(a);
			}
		}

		Contact c = new Contact(firstName, lastName);
		c.setAddress(selectedAddressInList);
		ContactDAO contactDAO = new ContactDAO();
		contactDAO.insertContact(c);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
