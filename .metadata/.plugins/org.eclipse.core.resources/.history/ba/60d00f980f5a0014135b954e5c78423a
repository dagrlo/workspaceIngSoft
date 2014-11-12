package es.uv.isw.app1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uv.isw.app1.beans.MailingBean;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/ListController")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FIRST_PARAM = "first";
	private static final String LAST_PARAM = "last";
	private static final String EMAIL_PARAM = "email";
	private static final String MAILINGBEAN_ATTR = "mailingbean";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Read the parameters from the request
		String first = request.getParameter(FIRST_PARAM);
		String last = request.getParameter(LAST_PARAM);
		String email = request.getParameter(EMAIL_PARAM);
		
		// Get the mailing bean
		MailingBean mb = new MailingBean();
		
		// Set the parameters into the bean
		mb.setFirst(first);
		mb.setLast(last);
		mb.setEmail(email);
		
		// Store a copy of the bean in the request context.
		request.setAttribute(MAILINGBEAN_ATTR, mb);
		
		// Perform the business method
		boolean result = mb.doSubscribe();
		
		// Choose a page based on the result
		String nextPage = "/success.jsp";
		if (!result) 
			nextPage = "/failure.jsp";
		
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
