package br.ufrn.imd.netfrix.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.netfrix.model.Season;
import br.ufrn.imd.netfrix.model.Video;
import br.ufrn.imd.netfrix.util.DataBase;

public class VideoDao {
	public static Video searchVideo(int id) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM video WHERE id=" + id;
		
		try {
			ResultSet rs = DataBase.dbExecuteQuery(query);
			Video video = getVideoFromResultSet(rs);
			return video;
		} catch (SQLException e) {
            System.out.println("While searching a video with " + id + " id, an error occurred: " + e);
            throw e;
		}
	}
	
	private static Video getVideoFromResultSet(ResultSet rs) throws SQLException {
		Video video = null;
		
		if(rs.next()) {
			video = new Video();
			video.setId(rs.getInt("id"));
			video.setDescription(rs.getString("description"));
			video.setDirector(rs.getString("director"));
			video.setDuration(rs.getInt("duration"));
			video.setEpisode(rs.getInt("episode"));
			video.setSeason(new Season().setId(rs.getInt("id_season")));
			video.setImage(rs.getString("image"));
			video.setMainActor(rs.getString("main_actor"));
			video.setMinAge(rs.getInt("min_age"));
			video.setName(rs.getString("name"));
			video.setRegistrationDate(rs.getDate("registration_date"));
			video.setYear(rs.getInt("year"));
		}
		return video;
	}
	
	public static void updateVideo(Video video) throws SQLException, ClassNotFoundException {
		String query = 	"UPDATE video SET" + 
						"  name=" + video.getName() + 
						", description=" + video.getDescription() + 
						", year=" + video.getYear() +
						", duration=" + video.getDuration() +
						", director=" + video.getDirector() + 
						", main_actor=" + video.getMainActor() +
						", main_age=" + video.getMinAge() + 
						", registration_date=" + video.getRegistrationDate() + 
						", image=" + video.getImage() + 
						", id_season=" + video.getSeason().getId() + 
						", episode=" + video.getEpisode() +
						"WHERE id = " + video.getId() + ";";
		
		try {
			DataBase.dbExecuteQuery(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while UPDATE Video with id=" + video.getId() + " " + e);
			throw e;
		}
	}
	
	public static void deleteVideo(int id) throws SQLException, ClassNotFoundException {
		String query = "DELETE FROM video WHERE id = " + id + ";";
		
		try {
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while DELETE video with id=" + id + " " + e);
			throw e;
		}
	}
	
	public static void insertVideo(Video video) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO video("
				+ "name, "
				+ "description, "
				+ "year, "
				+ "duration, "
				+ "director, "
				+ "main_actor, "
				+ "main_age, "
				+ "registration_date, "
				+ "image, "
				+ "id_season, "
				+ "episode)"
				+ "VALUES ("
				+ video.getName() + ", " 
				+ video.getDescription() + ", "
				+ video.getYear() + ", "
				+ video.getDuration() + ", "
				+ video.getDirector() + ", "
				+ video.getMainActor() + ", "
				+ video.getMinAge() + ", "
				+ video.getRegistrationDate() + ", "
				+ video.getImage() + ", "
				+ video.getSeason().getId() + ", "
				+ video.getEpisode()
				+ ");";
		
		try {
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while INSERT video: " + e);
			throw e;
		}
	}
}
