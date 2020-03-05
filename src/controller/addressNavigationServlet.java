package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;

/**
 * Servlet implementation class addressNavigationServlet
 */
@WebServlet("/addressNavigationServlet")
public class addressNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addressNavigationServlet() {
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
				String act = request.getParameter("doThisToItem");

				String path = "/viewAllAddressesServlet";

				if (act.equals("delete")) {
					try {
						Integer tempId = Integer.parseInt(request.getParameter("id"));
						Address toDelete = addressDAO.searchForAddressById(tempId);
						addressDAO.deleteAddress(toDelete);

					} catch (NumberFormatException e) {
						System.out.println("Forgot to select an Address");
					}

				} else if (act.equals("edit")) {
					try {
						Integer tempId = Integer.parseInt(request.getParameter("id"));
						Address toEdit = addressDAO.searchForAddressById(tempId);
						request.setAttribute("toEdit", toEdit);
						path = "/edit-address.jsp";
					} catch (NumberFormatException e) {
						System.out.println("Forgot to select an address");
					}

				} else if (act.equals("add")) {
					path = "/index.html";

				}

				getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
