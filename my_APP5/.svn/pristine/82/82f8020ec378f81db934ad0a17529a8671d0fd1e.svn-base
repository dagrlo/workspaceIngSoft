package es.uv.isw.app5.beans;

public class UserBeanImpl implements UserBean {
	private String username = ""; 
	private String password = "";
	private String language = "En";
	private boolean loggedIn = false;

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getLanguage() {
		return language;
	}

	@Override
	public void setLanguage(String language) {
		this.language = language;

	}
	
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

	@Override
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public String toString() {
		return "UserBean: (" + username + ", " + password + ") Logged: " + loggedIn;
	}
}
