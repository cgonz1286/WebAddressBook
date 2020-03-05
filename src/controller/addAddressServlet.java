package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;


/**
 * Servlet implementation class addAddressServlet
 */
@WebServlet("/addAddressServlet")
public class addAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/new-address.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String addressName = request.getParameter("addressName");
		if (city.isEmpty() || state.isEmpty() || zip.isEmpty() || addressName.isEmpty()) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			Address newAddress = new Address(city, state, zip, addressName);
			AddressDAO addressDAO = new AddressDAO();
			addressDAO.insertAddress(newAddress);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
