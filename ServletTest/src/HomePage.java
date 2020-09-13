
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomePage
 */
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomePage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("----------------Log out, Back to HomePage----------------");
			request.getSession().setAttribute("login", false);
			response.sendRedirect("/ServletTest");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Send UserName and password~~~~~~~~~~~~~~~~");
		response.setContentType("text/html;charset=UTF-8");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		PrintWriter pw = response.getWriter();
		if ( (password.equals("123") && userName.equals("SIMON")) 
				|| (boolean) request.getSession().getAttribute("login") 
		   ) {
			request.setAttribute("name", "аи╙Ы");
			request.getSession().setAttribute("login", true);
			System.out.println(HomePageSessionListener.getCount());
			request.setAttribute("count",HomePageSessionListener.getCount());
			request.getRequestDispatcher("/WEB-INF/jsp/Hello.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("html/index.html").include(request, response);
			pw.println("Sorry Wrong Password~<br/>");
		}
	}

}
