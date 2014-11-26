package es.uv.isw.sparrow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.uv.isw.sparrow.bean.User;

public class MySQLUserDAO implements UserDAO {
	private static String FINDBYID = 
			"SELECT id, username, password, eMail, nombre, apellidos, sexo, idioma" +
			"  FROM users" +
			" WHERE id = ?";

		private static String INSERT =
			"INSERT INTO users(username, password, eMail, nombre, apellidos, sexo, idioma) " +
			"VALUES (?, ?, ?, ?, ?, ?, ?)";

		private static String DELETE =
			"DELETE FROM users" +
			" WHERE id = ?";

		private static String READALL =
			"SELECT id, username, password, eMail, nombre, apellidos, sexo, idioma" +
		    "  FROM users" +
		    " ORDER BY id";

		private static String FINDBYUSERNAME = 
				"SELECT id, username, password, eMail, nombre, apellidos, sexo, idioma" +
				"  FROM users" +
				" WHERE username = ?";

		private static String FINDBYNAME =
			"SELECT id, username, password, eMail, nombre, apellidos, sexo, idioma" +
		    "  FROM users" +
			" WHERE apellidos LIKE %?%";
		
		private static String FINDBYUSERNAMEANDMAIL = 
				"SELECT password" +
				"  FROM users" +
				" WHERE username = ? AND eMail = ?";

		private Connection conn = null;
		
		public MySQLUserDAO() {
			super();
			try {
				conn = SparrowConnFactory.getConnection();
			} catch (Exception e) {
				System.out.println("MySQLUserDao: Error obteniendo conexión a la base de datos.");
				System.out.println("MySQLUserDao: " + e.getMessage());
			}
		}

	@Override
	public User findById(int id) throws SQLException {
		User user = null;
		PreparedStatement sqlQuery = conn.prepareStatement(FINDBYID);
		sqlQuery.setInt(1, id);

		ResultSet rs = sqlQuery.executeQuery();
		rs.last();
		int rowcount = rs.getRow();
		if (rowcount == 1) {
			rs.first();
			user = new User();
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.seteMail(rs.getString(4));
			user.setNombre(rs.getString(5));
			user.setApellidos(rs.getString(6));
			user.setSexo(rs.getString(7));
			user.setIdioma(rs.getString(8));
		}
		return user;
	}
	
	@Override
	public String findByUsernameAndEmail(String username, String email) throws SQLException {
		String password = null;
		PreparedStatement sqlQuery = conn.prepareStatement(FINDBYUSERNAMEANDMAIL);
		
		sqlQuery.setString(1, username);
		sqlQuery.setString(2, email);

		ResultSet rs = sqlQuery.executeQuery();
		rs.last();
		int rowcount = rs.getRow();
		if (rowcount == 1) {
			rs.first();
			password = rs.getString(1);			
		}
		return password;
	}

	@Override
	public ArrayList<User> getAllUsers() throws SQLException {
		ArrayList<User> users = new ArrayList<User>();
		PreparedStatement sqlQuery = conn.prepareStatement(READALL);
		
		ResultSet rs = sqlQuery.executeQuery();
		rs.beforeFirst();
		while (rs.next()) {
			User user = new User(rs.getString("username"), rs.getString("password"), 
				rs.getString("eMail"),rs.getString("nombre"), rs.getString("apellidos"), 
				rs.getString("sexo"), rs.getString("idioma"));
			user.setId(rs.getInt("id"));
			
			users.add(user);
		}
		return users;
	}

	@Override
	public ArrayList<User> findByName(String n) throws SQLException {
		ArrayList<User> users = new ArrayList<User>();
		PreparedStatement sqlQuery = conn.prepareStatement(FINDBYNAME);
		sqlQuery.setString(1, n);
		
		ResultSet rs = sqlQuery.executeQuery();
		rs.beforeFirst();
		while (rs.next()) {
			User user = new User(rs.getString("username"), rs.getString("password"), 
				rs.getString("eMail"), rs.getString("nombre"), rs.getString("apellidos"), 
				rs.getString("sexo"), rs.getString("idioma"));
			user.setId(rs.getInt("id"));
			
			users.add(user);
		}
		return users;
	}

	@Override
	public void insert(User e) throws SQLException {
		PreparedStatement sqlQuery = conn.prepareStatement(INSERT);
		
		sqlQuery.setString(1, e.getUsername());
		sqlQuery.setString(2, e.getPassword());
		sqlQuery.setString(3, e.geteMail());
		sqlQuery.setString(4, e.getNombre());
		sqlQuery.setString(5, e.getApellidos());
		sqlQuery.setString(6, e.getSexo());
		sqlQuery.setString(7, e.getIdioma());
		
		sqlQuery.executeUpdate();
		//conn.commit();
	}

	@Override
	public void delete(User e) throws SQLException {
		PreparedStatement sqlQuery = conn.prepareStatement(DELETE);
		sqlQuery.setInt(1, e.getId());
		sqlQuery.executeUpdate();
	}

	@Override
	public User findByUsername(String uname) throws SQLException {
		User user = null;
		PreparedStatement sqlQuery = conn.prepareStatement(FINDBYUSERNAME);
		sqlQuery.setString(1, uname);

		ResultSet rs = sqlQuery.executeQuery();
		rs.last();
		int rowcount = rs.getRow();
		if (rowcount == 1) {
			rs.first();
			user = new User();
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.seteMail(rs.getString(4));
			user.setNombre(rs.getString(5));
			user.setApellidos(rs.getString(6));
			user.setSexo(rs.getString(7));
			user.setIdioma(rs.getString(8));
		}		
		return user;
	}

}
