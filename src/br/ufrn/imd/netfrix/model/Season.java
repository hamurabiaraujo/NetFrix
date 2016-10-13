package br.ufrn.imd.netfrix.model;

import javafx.beans.property.IntegerProperty;

public class Season {
	private IntegerProperty id;
	private IntegerProperty number;
	private Series series;
	
	public Season() {}
	
	public Season(int id, int number, Series series) {
		this.id.set(id);
		this.number.set(number);
		this.series = series;
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
	
	public int getNumber() {
		return number.get();
	}
	
	public IntegerProperty getNumberProperty() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number.set(number);
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}
}
