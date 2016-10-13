package br.ufrn.imd.netfrix.model;

public class Favorite_Video {
	private Video 	video;
	private User 	user;
	
	public Favorite_Video() {}
	
	public Favorite_Video(Video video, User user) {
		this.video 	= video;
		this.user 	= user;
	}
	
	public Video getVideo() {
		return video;
	}
	
	public void setVideo(Video video) {
		this.video = video;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
