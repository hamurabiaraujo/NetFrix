package br.ufrn.imd.netfrix.model;

public class FavoriteSeries {
	private Series series;
	private User user;
	
	public FavoriteSeries() {}
	
	public FavoriteSeries(Series series, User user) {
		this.series = series;
		this.user	= user;
	}
	
	public Series getSeries() {
		return series;
	}
	
	public void setSeries(Series series) {
		this.series = series;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
