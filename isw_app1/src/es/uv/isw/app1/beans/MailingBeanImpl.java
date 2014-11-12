package es.uv.isw.app1.beans;

public class MailingBeanImpl implements MailingBean {

	private String first = "";
	private String last = "";
	private String email = "";
	
	@Override
	public String getFirst() {
		return first;
	}

	@Override
	public void setFirst(String first) {
		this.first=first;

	}

	@Override
	public String getLast() {
		return last;
	}

	@Override
	public void setLast(String last) {
		this.last=last;

	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public void setEmail(String email) {
		this.email=email;

	}

	@Override
	public boolean doSubscribe() {
		if (email.contains("@"))
			return true;
		else
			return false;
	}

	@Override
	public String getErrorString() {
		return "This string doesn't seem to represent a valid e-mail address";
	}

}
