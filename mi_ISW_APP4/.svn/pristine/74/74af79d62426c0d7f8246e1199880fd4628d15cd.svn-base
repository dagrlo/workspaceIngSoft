package es.uv.isw.app4.beans;
/**
 * An implmentation of the mailing bean interface, using local
 * variables as storage.
 */
public class UserBeanImpl implements UserBean {
    /** the username */
    private String username;
    
    /** the password */
    private String password;
    
    /** whether the user is logged in or not */
    private boolean loggedIn;
    
    
    public UserBeanImpl() {
   	 username = "";
   	 password = "";
   	 loggedIn = false;
   }

	/**
     * Get the user name
     * @return user name
     */
	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * Set the user name
	 */
	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get the password
	 * @return password
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

    /**
     * Business method to actually perform login. This method
     * just checks that the password exists and is longer than 3
     * characters long
     */
	@Override
	public boolean doLogin() {
		if (password == null || password.length() < 3) {
			loggedIn = false;
		}
		else {
			loggedIn = true;
		}
		return loggedIn;
	}
   /**
    * Determine if we are currently logged in or not
    */
	@Override
	public boolean isLoggedIn() {
		return loggedIn;
	}
}
