package ch.bbcag.gamexchange.lowlevel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import ch.bbcag.gamexchange.lowlevel.model.User;

public class UserDaoImpl implements UserDao {
	private final static Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public UserDaoImpl() {
		try{
			DataSource ds = (DataSource) InitialContext.doLookup("Onlineshop");
			con = ds.getConnection();
			if(con.isValid(10)) {
				LOGGER.info("Connection successful");
			}
		} catch(Exception ex) {
			LOGGER.severe("Connection failed");
		}
	}
	
	@Override
	public List<User> getAll() throws SQLException {
		LOGGER.info("Get all users from database");
		List<User> users = new ArrayList<User>();
		
		ps = con.prepareStatement("SELECT userId, name, lastname, usereEail, userPassword, userName, balance, dateOfBirth, domicile, postcode, country FROM user");
		rs = ps.executeQuery();
		
		while(rs.next()) {
			users.add(User.fromResultSet(rs));
		}
		return users;
	}

	@Override
	public User getById(int id) throws SQLException {
		LOGGER.info("Get user by id " + id);
		User user = null;
		
		ps = con.prepareStatement("SELECT userId, name, lastname, userEmail, userPassword, userName, balance, dateOfBirth, domicile, postcode, country FROM user WHERE userId = ?");
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		if(rs.next()) {
			user = User.fromResultSet(rs);
		}
		
		return user;
	}

	@Override
	public User getByEMail(String mail) throws SQLException {
		LOGGER.info("Get user by mail " + mail);
		User user = null;
		
		ps = con.prepareStatement("SELECT userId, name, lastname, userEmail, userPassword, userName, balance, dateOfBirth, domicile, postcode, country FROM user WHERE userEmail = ?");
		ps.setString(1, mail);
		
		rs = ps.executeQuery();
		if(rs.next()) {
			user = User.fromResultSet(rs);
		}
		return user;
	}

	@Override
	public void create(User user) throws SQLException {
//		LOGGER.info("Create user");
		
		String sql = "INSERT INTO user (name, lastname, userEmail, userPassword, userName, balance, dateOfBirth, domicile, postcode, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getLastname());
		ps.setString(3, user.getUserEmail());
		ps.setString(4, user.getUserPassword());
		ps.setString(5, user.getUserName());
		ps.setDouble(6, user.getBalance());
		ps.setString(7, user.getDateOfBirth());
		ps.setString(8, user.getDomicile());
		ps.setString(9, user.getPostcode());
		ps.setString(10, user.getCountry());
		ps.executeUpdate();

	}

	@Override
	public void update(User user) throws SQLException {
		LOGGER.info("Update user with email " + user.getUserEmail());
		
		ps = con.prepareStatement("UPDATE user SET name = ?, lastname = ?, userEmail = ?, userPassword = ?, userName = ?, balance = ?, , dateOfBirth = ?, domicile = ?, postcode = ?, country = ? WHERE userId = ?");
		ps.setString(1, user.getName());
		ps.setString(2, user.getLastname());
		ps.setString(3, user.getUserEmail());
		ps.setString(4, user.getUserPassword());
		ps.setString(5, user.getUserName());
		ps.setDouble(6, user.getBalance());
		ps.setString(7, user.getDateOfBirth());
		ps.setString(8, user.getDomicile());
		ps.setString(9, user.getPostcode());
		ps.setString(10, user.getCountry());
		ps.setInt(11, user.getUserId());
		ps.executeUpdate();
		
	}

	@Override
	public void delete(User user) throws SQLException {
		LOGGER.info("Delete user with mail");
		
		ps = con.prepareStatement("DELETE FROM user WHERE userId = ?");
		ps.setInt(1, user.getUserId());
		ps.executeUpdate();
		
	}

}
