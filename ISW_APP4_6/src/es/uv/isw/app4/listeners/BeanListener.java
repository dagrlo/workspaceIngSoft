package es.uv.isw.app4.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import es.uv.isw.app4.beans.UserBean;
import es.uv.isw.app4.beans.UserBeanFactory;

/**
 * Application Lifecycle Listener implementation class BeanListener
 *
 */
@WebListener
public class BeanListener implements HttpSessionListener {
	private static final String USERBEAN_ATTR = "userbean";
    /**
     * Default constructor. 
     */
    public BeanListener() {        
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent session)  {
    	System.out.println("SESION INICIADA");
    	UserBean userBean = (UserBean)session.getSession().getAttribute(USERBEAN_ATTR);
    	if (userBean==null){
    		
    		userBean = UserBeanFactory.newInstance();
    		session.getSession().setAttribute(USERBEAN_ATTR, userBean);
    		System.out.println("BEAN CREADO");
    	}
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
