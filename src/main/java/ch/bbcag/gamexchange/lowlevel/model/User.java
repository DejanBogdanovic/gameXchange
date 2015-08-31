package ch.bbcag.gamexchange.lowlevel.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String lastname;
	private String userEmail;
	private String userPassword;
	private String userName;
	private Double balance = 0.0;
	private String dateOfBirth;
	private String domicile;
	private String postcode;
	private String country;

	public User() {

	}

	public User(String email, String password) {
		this.userEmail = email;
		this.userPassword = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		return "[" + getUserId() + "," + getUserEmail() + "]";
	}

	public static User fromResultSet(ResultSet rs) throws SQLException {
		User user = new User();

		user.setUserId(Integer.valueOf(rs.getInt("userId")));
		user.setName(rs.getString("name"));		
		user.setLastname(rs.getString("lastname"));		
		user.setUserEmail(rs.getString("userEmail"));
		user.setUserPassword(rs.getString("userPassword"));		
		user.setUserName(rs.getString("userName"));
		user.setBalance(rs.getDouble("balance"));		
		user.setDateOfBirth(rs.getString("dateOfBirth"));
		user.setDomicile(rs.getString("domicile"));
		user.setPostcode(rs.getString("postcode"));
		user.setCountry(rs.getString("country"));
		return user;
	}

}
