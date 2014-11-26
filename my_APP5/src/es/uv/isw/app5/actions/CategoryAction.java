package es.uv.isw.app5.actions;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import es.uv.isw.app5.beans.UserBeanImpl;

public class CategoryAction implements Action{

	//http://localhost:8080/my_APP5/pages/pages/pages/workflow?category=Dystopian&category=Horror&category=Mystery
	 private static final String CATEGORY_ACTION = "category";
	 
	@Override
	public boolean performAction(HttpServletRequest req, ServletContext context) {
				
		ArrayList<String> lista=new ArrayList<String>(Arrays.asList(req.getParameterValues(CATEGORY_ACTION)));
		
	    HttpSession session = req.getSession();
	    UserBeanImpl ub = (UserBeanImpl) session.getAttribute(LoginAction.USERBEAN_ATTR);
	    ub.setCategorias(lista);
		return true;
	}
	
	

}
