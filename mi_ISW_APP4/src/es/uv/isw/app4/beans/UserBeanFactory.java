package es.uv.isw.app4.beans;

/**
 * A very simple factory to create UserBeanImpls
 * @author diaz
 */
public class UserBeanFactory {
	/**
	 * Generate a new instance of UserBeanImpl
	 */
    public static UserBean newInstance() {
        return new UserBeanImpl();
    }
}
