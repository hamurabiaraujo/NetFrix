package br.ufrn.imd.netfrix.model;

public class Video_Category {
	private Video video;
	private Category category;
	
	public Video_Category() {}
	
	public Video_Category(Video video, Category category) {
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
