package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.AddressBook;
import model.Contact;

/**
 * Servlet implementation class addAddressBookServlet
 */
@WebServlet("/addAddressBookServlet")
public class addAddressBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAddressBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/new-addressbook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactDAO contactDAO = new ContactDAO();
		String name = request.getParameter("name");
	
		String[] selectedContact = request.getParameterValues("allContactsToAdd");
		List<Contact> selectedContactInList = new ArrayList<Contact>();
		if (selectedContact != null && selectedContact.length > 0) {
			for (int i = 0; i < selectedContact.length; i++) {
				Contact c = contactDAO.searchForContactById(Integer.parseInt(selectedContact[i]));
				selectedContactInList.add(c);
			}
		}

		AddressBook ab = new AddressBook(name, java.time.LocalDate.now());
		ab.setContacts(selectedContactInList);
		AddressBookDAO addressBookDAO = new AddressBookDAO();
		addressBookDAO.insertAddressBook(ab);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
