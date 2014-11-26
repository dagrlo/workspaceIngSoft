package es.uv.isw.app5.beans;

import java.util.ArrayList;

/**
 * The interface to our model or a user
 */
public interface UserBean {
	// the username field
    public String getUsername();
    public void setUsername(String username);
    
    // the password field
    public String getPassword();
    public void setPassword(String password);
    
    // the language field
    public String getLanguage();
    public void setLanguage(String language);
    
    // business methods to perform login
    public boolean doLogin();
    public boolean isLoggedIn();
    
    public void setCategorias(ArrayList<String> lista);
    public String getCategorias();
}
