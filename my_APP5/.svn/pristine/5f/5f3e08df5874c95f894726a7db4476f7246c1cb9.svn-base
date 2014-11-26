package es.uv.isw.app5.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import es.uv.isw.app5.beans.UserBeanImpl;

public class LanguageAction implements Action {
    /** attribute name for the language element in the JSP page */
    private static final String LANGUAGE_PARAM = "language";
    
    /**
     * Perform this action.  Set the language property in the UserBean
     */
	@Override
	public boolean performAction(HttpServletRequest req, ServletContext context) {
        // read the parameter from the request
        String language = req.getParameter(LANGUAGE_PARAM);
        
        // set it in the UserBean
        HttpSession session = req.getSession();
        UserBeanImpl ub = (UserBeanImpl) session.getAttribute(LoginAction.USERBEAN_ATTR);
        ub.setLanguage(language);
        
        // We suceeded
        return true;
	}
}
