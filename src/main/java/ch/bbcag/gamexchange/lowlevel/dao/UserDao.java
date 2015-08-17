package ch.bbcag.gamexchange.lowlevel.dao;

import java.sql.SQLException;
import java.util.List;

import ch.bbcag.gamexchange.lowlevel.model.User;

public interface UserDao {
  public List<User> getAll() throws SQLException;
  public User getById(int id) throws SQLException;
  public User getByEMail(String mail) throws SQLException;
  public void create(User user) throws SQLException;
  public void update(User user) throws SQLException;
  public void delete(User user) throws SQLException;
}