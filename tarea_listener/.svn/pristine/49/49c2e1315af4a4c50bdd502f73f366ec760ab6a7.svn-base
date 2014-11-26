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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.uv.isw.app4.beans.MailingBean;
import es.uv.isw.app4.beans.UserBean;

/**
 * Servlet Filter implementation class LoggingFilter
 */
@WebFilter("/pages/*")
public class LoggingFilter implements Filter {
	private static final String USERBEAN_ATTR = "userbean";
	private static final String MAILINGBEAN_ATTR = "mailingbean";
	private static final Logger logger = LogManager.getLogger(LoggingFilter.class.getName());

    /**
     * Default constructor. 
     */
    public LoggingFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		// Find userbean from session
		HttpSession session = req.getSession(true);

		// Nivel de log de la peticion
		// logger.trace()
		// logger.debug()
		// logger.info()
		// logger.warn()
		// logger.error()
		// logger.fatal();
		logger.info("LoggingFilter: Starting...");

		logger.debug("Request values:");
		logger.debug("  Remote host: " + req.getRemoteHost() + " (" + req.getRemoteAddr() + ")");
		logger.debug("  Remote user: " + req.getRemoteUser());
		logger.debug("  URL:         " + req.getRequestURI());
		logger.info("  Path Info:   " + req.getPathInfo());

		// pass the request along the filter chain
		chain.doFilter(request, response);

		if (session != null) {
			logger.info("Session parameters:");
			UserBean userBean = (UserBean)session.getAttribute(USERBEAN_ATTR);
			if (userBean != null) {
				logger.info("  Is user '" + userBean.getUsername() + "' logged? : " + userBean.isLoggedIn());
				logger.debug("  User '" + userBean.getUsername() + "' has password '" + userBean.getPassword() + "'.");
			}
			else {
				logger.info("No login session bean!");
			}
		}		
		// Find mailingbean from request
		MailingBean mb = (MailingBean)req.getAttribute(MAILINGBEAN_ATTR);
		if (mb != null) {
			logger.info("Request bean:");
			logger.info("  Request parameters: " + mb.getFirst() + " " + mb.getLast() + 
					" (" + mb.getEmail() + ")");
		}
		logger.info("LoggingFilter: End.");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {}
}
