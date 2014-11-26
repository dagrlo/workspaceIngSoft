package es.uv.isw.app5.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import es.uv.isw.app5.beans.UserBeanImpl;
import es.uv.isw.app5.beans.UserBeanFactory;

public class LoginAction implements Action {
	/** The name of the UserBean in the session */
    public static final String USERBEAN_ATTR = "userbean";
    
    /** parameters shared with the JSP page */
    private static final String NAME_PARAM = "username";
    private static final String PASSWORD_PARAM = "password";
    
    /**
     * Perform this action.  Try to log the user in based on the username
     * and password in the submitted request
     */
    
	@Override
	public boolean performAction(HttpServletRequest req, ServletContext context) {
        // read the username and password from the request
        String username = req.getParameter(NAME_PARAM);
        String password = req.getParameter(PASSWORD_PARAM);
        
        // get the UserBean from the session
        HttpSession session = req.getSession();
        UserBeanImpl ub = (UserBeanImpl) session.getAttribute(USERBEAN_ATTR);
        
        // if the UserBean doesn't exist, create it
        if (ub == null) {
            ub = UserBeanFactory.newInstance();
            session.setAttribute(USERBEAN_ATTR, ub); 
        }
        
        // set the parameters in the bean
        if (username != null) {
      	  ub.setUsername(username);
      	  ub.setPassword(password);
        }
        
        // try to login
        return ub.doLogin();
	}
}
