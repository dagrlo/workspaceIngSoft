package es.uv.isw.app3.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uv.isw.app3.beans.UserBean;
import es.uv.isw.app3.beans.UserBeanFactory;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/pages/*")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USERNAME_PARAM = "username";
	private static final String PASSWORD_PARAM = "password";
	private static final String USERBEAN_ATTR = "userbean";
	private static final String CONTROLLER_PREFIX = "/pages";

	/**
	 * Default constructor. 
	 */
	public FrontController() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// The default next page
		String nextPage = request.getPathInfo().replaceAll(CONTROLLER_PREFIX,"");

		// Find userbean from session
		HttpSession session = request.getSession(true);
		UserBean userBean = (UserBean)session.getAttribute(USERBEAN_ATTR);
		
		if (userBean == null) {
         userBean = UserBeanFactory.newInstance();
         session.setAttribute(USERBEAN_ATTR, userBean);
			nextPage = "/login.jsp";
		}
		else if (!userBean.isLoggedIn()) {
			// Read request parameters
			String username = request.getParameter(USERNAME_PARAM);
			String password = request.getParameter(PASSWORD_PARAM);

			// Record username and password values
			userBean.setUsername(username);
			userBean.setPassword(password);
			//session.setAttribute(USERBEAN_ATTR, userBean);
		
			// Attempt to login
			boolean result = userBean.doLogin();
								
			if (!result) {
				nextPage = "/login.jsp";
			}
		}
		// Transfer control to the selected page controller
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}