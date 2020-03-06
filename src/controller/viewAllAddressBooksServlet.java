package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressBook;
import model.Contact;

/**
 * Servlet implementation class ViewAllAddressBooksServlets
 */
@WebServlet("/viewAllAddressBooksServlet")
public class viewAllAddressBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllAddressBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddressBookDAO addressBookDAO = new AddressBookDAO();

		List<AddressBook> abc = addressBookDAO.showAllAddressBooks();
		request.setAttribute("allAddressBooks", abc);
		
		String path = "/addressbooks-list.jsp";
		
		if(abc.isEmpty()){
			System.out.println("Nothing found");
			path = "/index.html";
		}

		getServletContext().getRequestDispatcher("/addressbooks-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
