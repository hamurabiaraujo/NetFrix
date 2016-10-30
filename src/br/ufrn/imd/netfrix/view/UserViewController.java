package br.ufrn.imd.netfrix.view;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufrn.imd.netfrix.MainApp;
import br.ufrn.imd.netfrix.dao.UserDao;
import br.ufrn.imd.netfrix.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
	
	private Boolean editAction;
	
	private User user;
	
	public UserViewController() {
		this.editAction = false;
		this.user = null;
	}
	
	@FXML
	private void handleSaveClick() throws ClassNotFoundException, SQLException, ParseException {
		String name = txtName.getText();
		String email = txtEmail.getText();
		String password = txtPassword.getText();
		String dateOfBirthStr = txtDateOfBirth.getText();
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		Date dateOfBirth = format.parse(dateOfBirthStr);
		Boolean isAdmin = radioIsAdmin.isSelected();
		
		if (name != null && email != null && password != null) {
			if (this.editAction) {
				User user = new User(this.user.getId(), email, password, name, isAdmin, dateOfBirth);
				UserDao.updateUser(user);
			} else {
				User user = new User(email, password, name, isAdmin, dateOfBirth);
				UserDao.insertUser(user);
			}
			
			showUsersView(new Stage());
			
			Stage stage = (Stage) btnSave.getScene().getWindow();
		    stage.close();
		}
	}
	
	public void setUser(User user) {
		this.user = user;
		
		if (user != null) {
			txtName.setText(user.getName());
			txtEmail.setText(user.getEmail());
			txtPassword.setText(user.getPassword());
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			txtDateOfBirth.setText(df.format(user.getDateOfBirth()));
			radioIsAdmin.setSelected(user.getIsAdmin());
			
			this.editAction = true;
		}
	}
	
	public void showUsersView(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/UsersView.fxml"));
            AnchorPane usersView = (AnchorPane) loader.load();

            Scene scene = new Scene(usersView);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
