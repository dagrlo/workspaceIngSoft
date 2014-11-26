package es.uv.isw.app6.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderSelect
 */
@WebServlet("/OrderSelect")
public class OrderSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACTION_PARAM = "action";
	private static final String NEW_VALUE = "Add a new Item";
	private static final String FINISH_VALUE = "Finish";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSelect() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Read the parameters from the request
		String nextPage;
		String action = request.getParameter(ACTION_PARAM);

		// Choose a page based on action
		if (NEW_VALUE.equals(action)) {
			nextPage = "/additem.jsp";
		}
		else if (FINISH_VALUE.equals(action)) {
			nextPage = "/showshoppingcart.jsp";
		}
		else {
			nextPage = "/error.jsp";
		}
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
