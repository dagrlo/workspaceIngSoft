package es.uv.isw.app5.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public interface Dispatcher {
	// Called after initialization
	public void setContext(ServletContext context) throws IOException;
	// Called for each request
	public String getNextPage(HttpServletRequest req, ServletContext context);
}
