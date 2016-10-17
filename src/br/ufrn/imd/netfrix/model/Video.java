package br.ufrn.imd.netfrix.model;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Video {
	private IntegerProperty 		id;
	private StringProperty 			name;
	private StringProperty 			description;
	private IntegerProperty			year;
	private IntegerProperty			duration;
	private StringProperty			director;
	private StringProperty			mainActor;
	private IntegerProperty			minAge;
	private ObjectProperty<Date> 	registrationDate;
	private StringProperty			image;
	private Season					season;
	private IntegerProperty			episode;
	
	public Video() {}
	
	public Video(
			String name, 
			String description, 
			String director, 
			String mainActor, 
			String image, 
			int minAge,
			int year, 
			int duration, 
			int idSeason, 
			int episode) {
		this.name 			= new SimpleStringProperty(name);
		this.description 	= new SimpleStringProperty(description);
		this.director		= new SimpleStringProperty(director);
		this.mainActor		= new SimpleStringProperty(mainActor);
		this.image			= new SimpleStringProperty(image);
		this.minAge			= new SimpleIntegerProperty(minAge);
		this.year			= new SimpleIntegerProperty(year);
		this.duration		= new SimpleIntegerProperty(duration);
		this.idSeason		= new SimpleIntegerProperty(idSeason);
		this.episode		= new SimpleIntegerProperty(episode);
	}

	public int getId() {
		return id.get();
	}
	
	public IntegerProperty getIdProperty() {
		return id;
	}

	public void setId(int id) {
		this.id.set(id);
	}
	
	public String getName() {
		return name.get();
	}

	public StringProperty getNameProperty() {
		return name;
	}

	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getDescription() {
		return description.get();
	}

	public StringProperty getDescriptionProperty() {
		return description;
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	public int getYear() {
		return year.get();
	}
	
	public IntegerProperty getYearProperty() {
		return year;
	}

	public void setYear(int year) {
		this.year.set(year);
	}
	
	public int getDuration() {
		return duration.get();
	}

	public IntegerProperty getDurationProperty() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration.set(duration);
	}
	
	public String getDirector() {
		return director.get(); 
	}

	public StringProperty getDirectorProperty() {
		return director;
	}

	public void setDirector(String director) {
		this.director.set(director);
	}
	
	public String getMainActor() {
		return mainActor.get();
	}

	public StringProperty getMainActorProperty() {
		return mainActor;
	}

	public void setMainActor(String mainActor) {
		this.mainActor.set(mainActor);
	}

	public int getMinAge() {
		return minAge.get();
	}
	
	public IntegerProperty getMinAgeProperty() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge.set(minAge);
	}

	public Date getRegistrationDate() {
		return registrationDate.get();
	}
	
	public ObjectProperty<Date> getRegistrationDateProperty() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate.set(registrationDate);
	}
	
	public String getImage() {
		return image.get();
	}

	public StringProperty getImageProperty() {
		return image;
	}

	public void setImage(String image) {
		this.image.set(image);
	}
	
	public void setSeason(Season season) {
		this.season = season;
	}
	
	public Season getSeason() {
		return season;
	}
	
	public int getEpisode() {
		return episode.get();
	}

	public IntegerProperty getEpisodeProperty() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode.set(episode);
	}
}
