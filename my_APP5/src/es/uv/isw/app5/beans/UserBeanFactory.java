package es.uv.isw.app5.beans;

public class UserBeanFactory {
	public static final UserBeanImpl newInstance() {
		return new UserBeanImpl();
	}
}
