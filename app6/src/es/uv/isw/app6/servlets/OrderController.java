package es.uv.isw.app6.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uv.isw.app6.beans.Item;
import es.uv.isw.app6.beans.ShoppingCart;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PRODUCT_PARAM = "product";
	private static final String QUANTITY_PARAM = "quantity";
	private static final String ORDER_ATTR = "orders";
	private static final String ITEM_ATTR = "item";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product;
		int quantity;
		
		// Read the parameters from the request
		product = request.getParameter(PRODUCT_PARAM);
		try {
			quantity = Integer.parseInt(request.getParameter(QUANTITY_PARAM));
		}
		catch (Exception e) {
			quantity = 1;
		}
		
		// Build a new order item
		Item item = new Item(new Date(), product, quantity);
		
		// Find orders from session
		HttpSession session = request.getSession();
		ShoppingCart orders = (ShoppingCart)session.getAttribute(ORDER_ATTR);
		
		// Perform the business method
		orders.addOrder(item);
		
		// Store item in request
		request.setAttribute(ITEM_ATTR, item);
				
		// Store a copy of the updated bean in the session context
		session.setAttribute(ORDER_ATTR, orders);
		
		// Choose a page based on the result
		String nextPage = "/showitem.jsp";
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
