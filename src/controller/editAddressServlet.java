package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;

/**
 * Servlet implementation class editAddressServlet
 */
@WebServlet("/editAddressServlet")
public class editAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editAddressServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddressDAO addressDAO = new AddressDAO();
		
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String addressName = request.getParameter("addressName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		Address toUpdate = addressDAO.searchForAddressById(tempId);
		toUpdate.setCity(city);
		toUpdate.setState(state);
		toUpdate.setZip(zip);
		toUpdate.setAddressName(addressName);
				
		AddressDAO.updateAddress(toUpdate);

		getServletContext().getRequestDispatcher("/viewAllAddressesServlet").forward(request, response);
	}

}
