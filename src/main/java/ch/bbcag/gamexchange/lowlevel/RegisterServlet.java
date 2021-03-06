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
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger(RegisterServlet.class.getName());

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		UserDaoImpl daoImpl = new UserDaoImpl();
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setLastname(request.getParameter("lastname"));
		user.setUserEmail(request.getParameter("userEmail"));
		user.setUserPassword(request.getParameter("userPassword"));
		user.setUserName(request.getParameter("userName"));
		user.setDateOfBirth(request.getParameter("dateOfBirth"));
		user.setDomicile(request.getParameter("domicile"));
		user.setPostcode(request.getParameter("postcode"));
		user.setCountry(request.getParameter("country"));
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		
		try {
			daoImpl.create(user);
			HttpSession session = request.getSession();
			session.setAttribute("user", daoImpl.getByEMail(user.getUserEmail()));
		} catch (SQLException e) {
			LOGGER.severe("Failed to create a new user");
			e.printStackTrace();
		}

		dispatcher.forward(request, response);

	}

}