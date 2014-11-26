package es.uv.isw.app5.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import es.uv.isw.app5.beans.UserBeanImpl;
import es.uv.isw.app5.beans.UserBeanFactory;

public class RestartAction implements Action {
    /**
     * Perform this action.  Invalidate the session and create a new 
     * UserBean to replace the old one.
     */
	@Override
	public boolean performAction(HttpServletRequest req, ServletContext context) {
        // invalidate the current session
        req.getSession().invalidate();
     
        // create a new one, and add a new UserBean to it
        HttpSession session = req.getSession();
        UserBeanImpl ub = UserBeanFactory.newInstance();
        session.setAttribute(LoginAction.USERBEAN_ATTR, ub);   
        return true;
	}
}
