package br.ufrn.imd.model;

public class Favorite_Series {
	private Series series;
	private User user;
	
	public Favorite_Series() {}
	
	public Favorite_Series(Series series, User user) {
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
