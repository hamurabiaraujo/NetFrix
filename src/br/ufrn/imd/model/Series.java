package br.ufrn.imd.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Series {
	private IntegerProperty id;
	private StringProperty 	name;
	
	public Series() {}
	
	public Series(int id, String name) {
		this.id.set(id);
		this.name.set(name);
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
}
