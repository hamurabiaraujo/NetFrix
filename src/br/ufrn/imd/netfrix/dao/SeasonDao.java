package br.ufrn.imd.netfrix.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.netfrix.model.Season;
import br.ufrn.imd.netfrix.util.DataBase;

public class SeasonDao {
	public static Season searchSeason(int id) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM season WHERE id=" + id;
		
		try {
			ResultSet rs = DataBase.dbExecuteQuery(query);
			Season season = getSeasonFromResultSet(rs);
			return season;
		} catch (SQLException e) {
            System.out.println("While searching a season with " + id + " id, an error occurred: " + e);
            throw e;
		}
	}
	
	private static Season getSeasonFromResultSet(ResultSet rs) throws SQLException {
		Season season = null;
		
		if(rs.next()) {
			season = new Season();
			season.setId(rs.getInt("id"));
			season.setNumber(rs.getInt("number"));
			//season.setSeries(series);
			//TODO set a series object 
		}
		return season;
	}
	
	public static void updateSeason(Season season) throws SQLException, ClassNotFoundException {
		String query = 	"UPDATE season SET" + 
						"  number=" + season.getNumber() + 
						", id_series=" + season.getSeries().getId() + 
						"WHERE id = " + season.getId() + ";";
		
		try {
			DataBase.dbExecuteQuery(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while UPDATE season with id=" + season.getId() + " " + e);
			throw e;
		}
	}
	
	public static void deleteSeason(int id) throws SQLException, ClassNotFoundException {
		String query = "DELETE FROM season WHERE id = " + id + ";";
		
		try {
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while DELETE season with id=" + id + " " + e);
			throw e;
		}
	}
	
	public static void insertSeason(Season season) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO season("
				+ "number, "
				+ "id_series)"
				+ "VALUES ("
				+ season.getNumber() + ", " 
				+ season.getSeries().getId() 
				+ ");";
		
		try {
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while INSERT season: " + e);
			throw e;
		}
	}
}
