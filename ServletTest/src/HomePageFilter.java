

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class HomePageFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, servletNames = { "homeYEAH" })
public class HomePageFilter implements Filter {
	
	// 要使用的話要記得改
	static final String JDBC_DRIVER="org.mariadb.jdbc.Driver";
	static final String DB_URL="jdbc:mariadb://localhost:3306/ttplab";
	static final String USER_NAME="userName";
	static final String PASSWORD="password";

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
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		}catch(Exception e) {
			
		}
		request.setAttribute("db", conn);
		System.out.println("Filter : before HomePage");
		// ↑↑↑↑↑↑↑↑ before service
		chain.doFilter(request, response);
		// ↓↓↓↓↓↓↓↓ after service
		System.out.println("Filter : after HomePage");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
