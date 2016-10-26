package br.ufrn.imd.netfrix.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.netfrix.model.Season;
import br.ufrn.imd.netfrix.model.VideoCategory;
import br.ufrn.imd.netfrix.util.DataBase;
import sun.print.resources.serviceui;

public class VideoCategoryDao {
	public static VideoCategory searchVideoCategory(int id) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM video_category WHERE id=" + id;
		
		try {
			ResultSet rs = DataBase.dbExecuteQuery(query);
			VideoCategory videoCategory = getVideoCategoryFromResultSet(rs);
			return videoCategory;
		} catch (SQLException e) {
            System.out.println("While searching a season with " + id + " id, an error occurred: " + e);
            throw e;
		}
	}
	
	private static VideoCategory getVideoCategoryFromResultSet(ResultSet rs) throws SQLException, ClassNotFoundException {
		VideoCategory videoCategory = null;
		VideoDao videoDao = new VideoDao();
		CategoryDao categoryDao = new CategoryDao();
		
		if (rs.next()) {
			videoCategory = new VideoCategory();
			videoCategory.setVideo(videoDao.searchVideo(rs.getInt("video_id")));
			videoCategory.setCategory(categoryDao.searchCategories(rs.getInt("category_id")));
		}
		
		return videoCategory;
	}

	// Do not need update method
	
	public static void deleteVideoCategory(int videoId, int categoryId) throws SQLException, ClassNotFoundException {
		String query = "DELETE * FROM video_category WHERE video_id = " + videoId + " AND category_id = " + categoryId + "; ";
		
		try {
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while DELETE a relatioship with videoId = " + videoId + " and categoryId = " + categoryId + " " + e);
			throw e;
		} 
	}
	
	public static void insertVideoCategory(VideoCategory videoCategory) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO season("
				+ "video_id, "
				+ "category_id)"
				+ "VALUES ("
				+ videoCategory.getVideo().getId() + ", " 
				+ videoCategory.getCategory().getId() 
				+ ");";
		
		try {
			DataBase.dbExecuteUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error occurred while INSERT a videoCategory: " + e);
			throw e;
		}
	}
}
