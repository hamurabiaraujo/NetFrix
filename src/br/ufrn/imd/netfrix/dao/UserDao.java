package br.ufrn.imd.netfrix.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.netfrix.model.User;
import br.ufrn.imd.netfrix.util.DataBase;

public class UserDao {
	public static User findUser(int id) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM users WHERE id=" + id;
		
		try {
			ResultSet rs = DataBase.dbExecuteQuery(query);
			User user = getUserFromResultSet(rs);
			return user;
		} catch (SQLException e) {
			System.out.println("While finding an user with " + id + "id, and an error occurred: " + e);
			throw e;
		}
	}

	private static User getUserFromResultSet(ResultSet rs) throws SQLException {
		User user = null;
		
		if (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setDateOfBirth(rs.getDate("date_of_birth"));
			user.setIsAdmin(rs.getBoolean("is_admin"));
			user.setPassword(rs.getString("password"));
		}
		
		return user;
	}
	
	public static void updateUser(User user) throws SQLException, ClassNotFoundException {
		String query = "UPDATE users SET" +
					   " name = " + user.getName() +
					   ", email = " + user.getEmail() +
					   ", date_of_birth = " + new java.sql.Date(user.getDateOfBirth().getTime()) +
					   ", is_admin = " + user.getIsAdmin() +
					   ", password = " + user.getPassword() +
					   " WHERE id = " + user.getId() + ";";
		
		try	{
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while UPDATE User with id = " + user.getId() + " " + e);
		}
	}
	
	public static void deleteUser(int id) throws SQLException, ClassNotFoundException {
		String query = "DELETE FROM users WHERE id = " + id + ";";
		
		try {
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while DELETE user with id = " + id + " " + e);
			throw e;
		}
	}
	
	public static void insertUser(User user) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO users ("
				+ "email, name, date_of_birth, password, is_admin) VALUES ("
				+ "'" + user.getEmail() + "', "
				+ "'" + user.getName() + "', "
				+ "'" + new java.sql.Date(user.getDateOfBirth().getTime()) + "', "
				+ "'" + user.getPassword() + "', "
				+ user.getIsAdmin() + ");";

		try {
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while INSERT user: " + e);
			throw e;
		}
	}
}
