package br.ufrn.imd.netfrix.view;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.netfrix.MainApp;
import br.ufrn.imd.netfrix.util.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {

	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtPassword;
	@FXML
	private Button btnLogin;
	@FXML
	private Label loginMsgError;
	
	public LoginViewController() {
	}
	
	@FXML
	private void handleLoginClick() throws ClassNotFoundException, SQLException {
	    String email =  this.txtEmail.getText();
	    String password = this.txtPassword.getText();
	    tryLogin(email, password);
	}
	
	public void tryLogin(String email, String password) throws SQLException, ClassNotFoundException {
		String query = "SELECT id FROM users WHERE email = '" + email + "' AND password = '" + password + "'";
		
		try {
			ResultSet result = DataBase.dbExecuteQuery(query);
			
			if (result.next()) {
				try {
					new DashboardViewController().start(new Stage());
					MainApp.primaryStage.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				loginMsgError.setText("Ops, informações erradas");
			}
		} catch (SQLException e) {
            System.out.println("While searching an user with " + email + " email, an error occurred: " + e);
            
            throw e;
        }
	}
}
