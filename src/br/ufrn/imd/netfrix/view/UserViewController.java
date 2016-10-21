package br.ufrn.imd.netfrix.view;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufrn.imd.netfrix.dao.UserDao;
import br.ufrn.imd.netfrix.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserViewController {
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtEmail;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private TextField txtDateOfBirth;
	@FXML
	private RadioButton radioIsAdmin;
	@FXML
	private Button btnSave;
	@FXML
	private javafx.scene.control.Button closeButton;
	
	public UserViewController() {
		
	}
	
	@FXML
	private void handleSaveClick() throws ClassNotFoundException, SQLException, ParseException {
		String name = txtName.getText();
		String email = txtEmail.getText();
		System.out.println(txtPassword.getText());
		String password = txtPassword.getText();
		String dateOfBirthStr = txtDateOfBirth.getText();
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		Date dateOfBirth = format.parse(dateOfBirthStr);
		Boolean isAdmin = radioIsAdmin.isSelected();
		
		if (name != null && email != null && password != null) {
			User user = new User(email, password, name, isAdmin, dateOfBirth);
			UserDao.insertUser(user);
			Stage stage = (Stage) closeButton.getScene().getWindow();
		    stage.close();
		}
	}
}
