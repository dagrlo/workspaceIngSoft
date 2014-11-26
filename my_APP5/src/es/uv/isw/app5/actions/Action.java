package es.uv.isw.app5.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public interface Action {
	public boolean performAction(HttpServletRequest req, ServletContext context);
}
