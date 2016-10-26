package br.ufrn.imd.netfrix.model;

public class FavoriteVideo {
	private Video 	video;
	private User 	user;
	
	public FavoriteVideo() {}
	
	public FavoriteVideo(Video video, User user) {
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
