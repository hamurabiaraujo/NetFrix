package br.ufrn.imd.model;

import javafx.beans.property.IntegerProperty;

public class Season {
	private IntegerProperty id;
	private IntegerProperty number;
	private IntegerProperty idSeries;
	
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
	
	public int getIdSeries() {
		return idSeries.get();
	}
	
	public IntegerProperty getIdSeriesProperty() {
		return idSeries;
	}
	
	public void setIdSeries(int idSeries) {
		this.idSeries.set(idSeries);
	}
}
