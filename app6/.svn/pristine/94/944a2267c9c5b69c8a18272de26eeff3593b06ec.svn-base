package es.uv.isw.app6.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import es.uv.isw.app6.beans.ShoppingCart;

/**
 * Application Lifecycle Listener implementation class OrderListener
 *
 */
@WebListener
public class OrderListener implements HttpSessionListener {	
	public static final String ORDER_ATTR = "orders";

	/**
     * Default constructor. 
     */
    public OrderListener() {}

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
    	ShoppingCart orders = new ShoppingCart();
    	HttpSession session = arg0.getSession();
    	session.setAttribute(ORDER_ATTR, orders);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
    	HttpSession session = arg0.getSession();
       	session.removeAttribute(ORDER_ATTR);
    }	
}
