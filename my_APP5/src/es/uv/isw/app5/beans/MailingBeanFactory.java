package es.uv.isw.app5.beans;
/**
 * 
 * @author diaz
 *
 * A very simple factory class to generate MailingBeans
 * 
 */
public class MailingBeanFactory {
	/**
	 * Generate a new mailing bean.
	 * @return MailingBean
	 */
	public static MailingBean newInstance() {
		return new MailingBeanImpl();
    }
}
