package es.uv.isw.app3.beans;

public interface MailingBean {
	
	// First name
	public String getFirst();
	public void setFirst(String first);
	
	// Last name
	public String getLast();
	public void setLast(String last);
	
	// email address
	public String getEmail();
	public void setEmail(String email);
	
	// business method
	public boolean doSubscribe();
	
	// subscription result
	public String getErrorString();
}
