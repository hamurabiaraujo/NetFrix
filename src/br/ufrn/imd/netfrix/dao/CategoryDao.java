package br.ufrn.imd.netfrix.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.netfrix.model.Category;
import br.ufrn.imd.netfrix.util.DataBase;

public class CategoryDao {
	public static Category searchCategories(int id) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM categories WHERE id=" + id;
		
		try {
			ResultSet rs = DataBase.dbExecuteQuery(query);
			Category categories = getCategoryFromResultSet(rs);
			return categories;
		} catch (SQLException e) {
            System.out.println("While searching a category with " + id + ", an error occurred: " + e);
            throw e;
		}
	}
	
	private static Category getCategoryFromResultSet(ResultSet rs) throws SQLException {
		Category category = null;
		
		if(rs.next()) {
			category = new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
		}
		return category;
	}
	
	public static void updateCategory(Category category) throws SQLException, ClassNotFoundException {
		String query = 	"UPDATE series SET" + 
						"  name=" + category.getName() + 
						"WHERE id = " + category.getId() + ";";
		
		try {
			DataBase.dbExecuteQuery(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while UPDATE category with id=" + category.getId() + " " + e);
			throw e;
		}
	}
	
	public static void deleteCategory(int id) throws SQLException, ClassNotFoundException {
		String query = "DELETE * FROM categories WHERE id = " + id + ";";
		
		try {
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while DELETE category with id=" + id + " " + e);
			throw e;
		}
	}
	
	public static void insertCategory(Category category) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO categories("
				+ "name)"
				+ "VALUES ("
				+ category.getName()
				+ ");";
		try {
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while INSERT a category: " + e);
			throw e;
		} 
	}
}
