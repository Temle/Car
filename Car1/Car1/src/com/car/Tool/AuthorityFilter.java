package com.car.Tool;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
@WebFilter(filterName="authority",urlPatterns = { "/*" })
public class AuthorityFilter implements Filter {
	
	private String logPage="/index.jsp";

    /**
     * Default constructor. 
     */
    public AuthorityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String request_uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String uri = request_uri.substring(contextPath.length());
		if (req.getSession().getAttribute("user") == null) {
			/*if (uri.equals(logPage) || request_uri.indexOf("resource/") > 0
					|| request_uri.indexOf("WEB-INF/content/") > 0
					|| uri.equals("/Car/user-login.action")|| uri.equals("/Car/user-register.action")) {
				chain.doFilter(request, response);
				return;
			}*/
			if (uri.equals(logPage) || request_uri.indexOf("resource/") > 0
					|| request_uri.indexOf("WEB-INF/content/") > 0
					|| uri.equals("/Car/user-login.action")
					|| uri.equals("/Car/user-register.action")) {
				chain.doFilter(request, response);
				return;
			}
			else
			{
				res.sendRedirect("index.jsp");
			}
		}
		else chain.doFilter(request, response);
		
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
