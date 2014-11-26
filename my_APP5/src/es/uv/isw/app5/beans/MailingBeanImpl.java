package es.uv.isw.app5.beans;

/**
 * 
 * @author diaz
 * 
 * An implementation of the mailing bean interface, using local
 * local variables as storage.
 *
 */
public class MailingBeanImpl implements MailingBean {
	// First name
	private String first = "";
	
	// Last names
	private String last = "";
	
	// email address
	private String email = "";
	
	/**
	 * Create a new MailingBeanImpl
	 */
	public MailingBeanImpl() {
	}

	/**
	 * Get the first name
	 * @return first name
	 */
	@Override
	public String getFirst() {
		return first;
	}
	
	/**
	 * Set the first name
	 */
	@Override
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Get the last name
	 * @return last name
	 */
	@Override
	public String getLast() {
		return last;
	}

	/**
	 * Set the last name
	 */
	@Override
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * Get the email address
	 * @return email address
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email address
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
    /**
     * Process a subscription to the mailing list.  The doesn't actually
     * do anything other than verify the address has an '@' character in it.
     * @return true if email address is valid, false otherwise
     */
	@Override
	public boolean doSubscribe() {
		if (email.contains("@"))
			return true;
		else
			return false;
	}
	
   /**
    * Get the error string for the most recent attempt to subscribe.
    */
	@Override
	public String getErrorString() {
		return "This string doesn't seem to represent a valid e-mail address";
	}
}
