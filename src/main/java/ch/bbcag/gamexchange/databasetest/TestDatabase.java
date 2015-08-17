package ch.bbcag.gamexchange.databasetest;

import java.io.IOException;
import java.sql.Connection;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestDatabase
 */
@WebServlet(urlPatterns={"/TestDatabase"})
public class TestDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource
	DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestDatabase() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection con = ds.getConnection();
			if (con.isValid(10)) {
				System.out.println("Connected");
			}
			con.close();
		} catch (Exception ex) {
			System.out.println("Failed to connect");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
