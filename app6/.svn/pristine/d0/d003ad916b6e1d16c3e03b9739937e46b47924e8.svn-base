package es.uv.isw.app6.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uv.isw.app6.beans.ShoppingCart;

/**
 * Servlet implementation class OrderClose
 */
@WebServlet("/OrderClose")
public class OrderClose extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ORDER_ATTR = "orders";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderClose() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Clear session
		HttpSession session = request.getSession();
		//session.invalidate();
		
		// Create a new Shopping Cart
    	ShoppingCart orders = new ShoppingCart();
    	session.setAttribute(ORDER_ATTR, orders);				

    	// Choose next page
		String nextPage = "/additem.jsp";
		// Transfer control to the selected view
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
