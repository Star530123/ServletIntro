

import java.io.IOException;

import javax.servlet.DispatcherType;
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
 * Servlet Filter implementation class HomePageFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = {"/*"})
public class HomePageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HomePageFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if(req.getSession().getAttribute("login") == null) {
			req.getSession().setAttribute("login", false);
		}
		System.out.println("Filter : before HomePage");
		// ¡ô¡ô¡ô¡ô¡ô¡ô¡ô¡ô before service
		chain.doFilter(request, response);
		// ¡õ¡õ¡õ¡õ¡õ¡õ¡õ¡õ after service
		boolean login = (boolean) req.getSession().getAttribute("login");
		if(login) {
			System.out.println("§Aµn¤J·È");
		}
		System.out.println("Filter : after HomePage");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
