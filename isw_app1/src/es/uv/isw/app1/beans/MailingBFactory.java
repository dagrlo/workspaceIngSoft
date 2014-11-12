package es.uv.isw.app1.beans;

public class MailingBFactory {
	public static MailingBean newInstance(){
		return new MailingBeanImpl();
	}

}
