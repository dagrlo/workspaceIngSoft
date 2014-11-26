package es.uv.isw.app5.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/pages/*")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTROLLER_PREFIX = "/pages";
	private static final String DISPATCHER_ATTR = "Dispatcher";
	private static final String DISPATCHER_PREFIX = "es.uv.isw.app5.servlets.";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		
		System.out.println("FrontController: Entrando.");

		//Get the last element of the request in lower case
		String reqPath = request.getPathInfo();
		System.out.println("FrontController: reqPath(1): " + reqPath);
		reqPath = reqPath.replaceAll(CONTROLLER_PREFIX,"");
		System.out.println("FrontController: reqPath(2): " + reqPath);
		reqPath = Character.toUpperCase(reqPath.charAt(1)) + reqPath.substring(2).toLowerCase();
		
		System.out.println("FrontController: reqPath(3): " + reqPath);

		// Find the dispatcher in the session
		Dispatcher dispatcher = (Dispatcher)session.getAttribute(reqPath + DISPATCHER_ATTR);
		
		System.out.println("FrontController: dispatcher: " + reqPath + DISPATCHER_ATTR);

		
		// If no dispatcher was found, create one
		if (dispatcher == null) {
			String className = reqPath + "Dispatcher";
			try {
				System.out.println("FrontController: Dispatcher es nulo. ");
				System.out.println("FrontController: Cargando la clase " + DISPATCHER_PREFIX + className);
				Class<?> c = Class.forName(DISPATCHER_PREFIX + className);
				dispatcher = (Dispatcher)c.newInstance();
			}
			catch (Exception ex) {
				throw new ServletException("Can't find class " + className, ex);
			}

			// Store the dispatcher in the session
			dispatcher.setContext(context);
			session.setAttribute(reqPath + DISPATCHER_ATTR, dispatcher);
			System.out.println("FrontController: Attribute '" + reqPath + DISPATCHER_ATTR + "' : " + dispatcher);

		}
		
		// Use the dispatcher to find the next page
		String nextPage = dispatcher.getNextPage(request, context);
		System.out.println("FrontController: Siguiente página: /" + nextPage);
		
		// Make sure we don't cache dynamic data
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		// Forward control to the view
		RequestDispatcher forwarder = request.getRequestDispatcher("/" + nextPage);
		forwarder.forward(request, response);
		//request.getRequestDispatcher("/" + nextPage).forward(request, response);	
	}

}
