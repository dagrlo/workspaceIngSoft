package es.uv.isw.app1.beans;

public class MailingBean {
	private String first = "";
	private String last = "";
	private String email = "";
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public boolean doSubscribe() {
		if (email.contains("@"))
			return true;
		else
			return false;
	}
	public String getErrorString() {
		return "This string doesn't seem to represent a valid e-mail address";
	}
}
