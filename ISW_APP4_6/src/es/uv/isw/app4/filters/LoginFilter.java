package es.uv.isw.app4.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import es.uv.isw.app4.beans.UserBean;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/pages/*")
public class LoginFilter implements Filter {
	private static final long serialVersionUID = 1L;
	private static final String USERNAME_PARAM = "username";
	private static final String PASSWORD_PARAM = "password";
	private static final String USERBEAN_ATTR = "userbean";
	private static final String CONTROLLER_PREFIX = "/pages";

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		System.out.println("tengo la sesion");
		UserBean userBean = (UserBean)session.getAttribute(USERBEAN_ATTR);
		System.out.println("pillo el bean");
		
		if (!userBean.isLoggedIn()){
			System.out.println("NO logeado");
			String username = request.getParameter(USERNAME_PARAM);
			String password = request.getParameter(PASSWORD_PARAM);
			System.out.println("Pillo los parametros. USR: "+username+" pass: "+password);
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
