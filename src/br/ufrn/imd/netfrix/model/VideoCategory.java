package br.ufrn.imd.netfrix.model;

public class VideoCategory {
	private Video video;
	private Category category;
	
	public VideoCategory() {}
	
	public VideoCategory(Video video, Category category) {
		this.video 		= video;
		this.category 	= category;
	}
	
	public Video getVideo() {
		return video;
	}
	
	public void setVideo(Video video) {
		this.video = video;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
}
