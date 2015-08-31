package ch.bbcag.gamexchange.lowlevel;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.bbcag.gamexchange.lowlevel.dao.UserDaoImpl;
import ch.bbcag.gamexchange.lowlevel.model.User;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet(urlPatterns={"/editProfile"})
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		try {
			daoImpl.update(user);
			request.setAttribute("Changes saved", "Your changes were saved successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("Changes not saved", "Your changes could not be saved. Please try it later again.");
		}
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
