package es.uv.isw.sparrow.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import es.uv.isw.sparrow.bean.User;

public interface UserDAO {
	public User findById(int id) throws SQLException;
	public ArrayList<User> getAllUsers() throws SQLException;
	public User findByUsername(String uname) throws SQLException;
	public ArrayList<User> findByName(String n) throws SQLException;
	public void insert(User e) throws SQLException;
	public void delete(User e) throws SQLException;
	public String findByUsernameAndEmail(String username, String email) throws SQLException;
}
