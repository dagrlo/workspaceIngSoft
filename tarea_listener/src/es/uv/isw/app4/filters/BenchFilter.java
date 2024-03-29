package es.uv.isw.app4.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter("/pages/*")
public class BenchFilter implements Filter {

	private static final Logger logger = LogManager.getLogger(LoggingFilter.class.getName());
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;		
		long tIni=System.currentTimeMillis();
		
		chain.doFilter(request, response);
		long tTotal=System.currentTimeMillis()-tIni;
		
		logger.info("BenchFilter: "+tTotal+" mS para la peticion "+req.getPathInfo());
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
