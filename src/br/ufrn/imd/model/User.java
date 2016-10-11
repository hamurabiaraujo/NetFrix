package br.ufrn.imd.model;

import java.util.Date;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
	private IntegerProperty id;
	private StringProperty email;
	private StringProperty password;
	private StringProperty name;
	private BooleanProperty isAdmin;
	private ObjectProperty<Date> dateOfBirth;
	
	public User() {}
	
	public User(
			String email,
			String password,
			String name,
			Boolean isAdmin,
			Date dateOfBirth ) {
		this.email = new SimpleStringProperty(email);
		this.password = new SimpleStringProperty(password);
		this.name = new SimpleStringProperty(name);
		this.isAdmin = new SimpleBooleanProperty(isAdmin);
		this.dateOfBirth = new SimpleObjectProperty<Date>(dateOfBirth);
	}

	public String getEmail() {
		return email.get();
	}
	
	public StringProperty getEmailProperty() {
		return email;
	}

	public void setEmail(String email) {
		this.email.set(email);
	}
	
	public String getPassword() {
		return password.get();
	}

	public StringProperty getPasswordProperty() {
		return password;
	}

	public void setPassword(String password) {
		this.password.set(password);
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
	
	public Boolean getIsAdmin() {
		return isAdmin.get();
	}

	public BooleanProperty getIsAdminProperty() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin.set(isAdmin);
	}
	
	public Date getDateOgBirth() {
		return dateOfBirth.get();
	}
	
	public ObjectProperty<Date> getDateOfBirthProperty() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth.set(dateOfBirth);
	}
}
