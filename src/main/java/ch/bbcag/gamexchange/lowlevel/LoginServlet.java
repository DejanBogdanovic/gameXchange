package ch.bbcag.gamexchange.lowlevel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch.bbcag.gamexchange.lowlevel.dao.UserDaoImpl;
import ch.bbcag.gamexchange.lowlevel.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		UserDaoImpl userDao = new UserDaoImpl();
		String useremail = request.getParameter("userEmail");
		String userpassword = request.getParameter("userPassword");
		RequestDispatcher dispatcherNormal = request.getRequestDispatcher("dashboard.jsp");
		RequestDispatcher dispatcherError = request.getRequestDispatcher("login.jsp");

		HttpSession session = request.getSession();

		// Check if session already exists
		if (session.getAttribute("user") == null) {
			
			try {
				user = userDao.getByEMail(useremail);

				if(user == null || !user.getUserPassword().equals(userpassword)) {
					request.setAttribute("errorLogin", "Wrong E-Mail or Password");
					dispatcherError.forward(request, response);
				} else if(user.getUserPassword().equals(userpassword)) { 
					session.setAttribute("user", user);
					LOGGER.info("Successfull loged in as " + useremail);
					dispatcherNormal.forward(request, response);					
				}			
				
			} catch (SQLException e) {
				LOGGER.severe("Failed to get user with email " + useremail);
				e.printStackTrace();
			}

		} else {

			user = (User) session.getAttribute("user");
			LOGGER.info("Welcome back! You are logged in as " + user.getUserEmail());
			dispatcherNormal.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
