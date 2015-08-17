package ch.bbcag.gamexchange.lowlevel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet(urlPatterns={"/welcome"})
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public WelcomeServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String client = request.getHeader("User-Agent");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");

		if (userName == null) {
			userName = "Stranger";
		}

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello " + userName + "<br>You are using: " + client);
		out.println("</body></html>");
		
//		throw new ServletException("Dies ist eine Test-Exception");

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
