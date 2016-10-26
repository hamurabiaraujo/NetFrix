package br.ufrn.imd.netfrix.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.netfrix.model.Series;
import br.ufrn.imd.netfrix.util.DataBase;

public class SeriesDao {
	public static Series searchSeries(int id) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM series WHERE id=" + id;
		
		try {
			ResultSet rs = DataBase.dbExecuteQuery(query);
			Series series = getSeriesFromResultSet(rs);
			return series;
		} catch (SQLException e) {
            System.out.println("While searching a series with " + id + " id, an error occurred: " + e);
            throw e;
		}
	}
	
	private static Series getSeriesFromResultSet(ResultSet rs) throws SQLException {
		Series series= null;
		
		if(rs.next()) {
			series = new Series();
			series.setId(rs.getInt("id"));
			series.setName(rs.getString("name"));
		}
		return series;
	}
	
	public static void updateSeries(Series series) throws SQLException, ClassNotFoundException {
		String query = 	"UPDATE series SET" + 
						"  name=" + series.getName() + 
						"WHERE id = " + series.getId() + ";";
		
		try {
			DataBase.dbExecuteQuery(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while UPDATE series with id=" + series.getId() + " " + e);
			throw e;
		}
	}
	
	public static void deleteSeries(int id) throws SQLException, ClassNotFoundException {
		String query = "DELETE * FROM series WHERE id = " + id + ";";
		
		try {
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while DELETE series with id=" + id + " " + e);
			throw e;
		}
	}
	
	public static void insertSeries(Series series) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO series("
				+ "name)"
				+ "VALUES ("
				+ series.getName()
				+ ");";
		try {
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while INSERT series: " + e);
			throw e;
		}
	}
}
