package ch.bbcag.gamexchange.lowlevel.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String surname;
	private String userEmail;
	private String userPassword;
	private String userName;
	private Double balance = 0.0;

	public User() {

	}

	public User(String email, String password) {
		this.userEmail = email;
		this.userPassword = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getUserId() {
		return id;
	}

	public void setUserId(int id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String useremail) {
		this.userEmail = useremail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userpassword) {
		this.userPassword = userpassword;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String toString() {
		return "[" + getUserId() + "," + getUserEmail() + "]";
	}

	public static User fromResultSet(ResultSet rs) throws SQLException {
		User user = new User();

		int id = Integer.valueOf(rs.getInt("userId"));
		user.setUserId(id);

		String name = rs.getString("name");
		user.setName(name);
		
		String surname = rs.getString("surname");
		user.setSurname(surname);
		
		String email = rs.getString("userEmail");
		user.setUserEmail(email);

		String password = rs.getString("userPassword");
		user.setUserPassword(password);
		
		String username = rs.getString("userName");
		user.setUserName(username);

		Double balance = rs.getDouble("balance");
		user.setBalance(balance);

		return user;
	}

}
