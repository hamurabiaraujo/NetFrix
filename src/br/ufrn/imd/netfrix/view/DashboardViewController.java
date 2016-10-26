package br.ufrn.imd.netfrix.view;

import java.sql.SQLException;

import br.ufrn.imd.netfrix.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DashboardViewController {
	@FXML
	private Button btnManagementUser;

	public DashboardViewController() {
	}

	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/DashboardView.fxml"));
            AnchorPane dashboardView = (AnchorPane) loader.load();
            Scene scene = new Scene(dashboardView);
            
			stage.setScene(scene);
			stage.setMaximized(true);
			stage.setTitle("Netfrix");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
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

	@FXML
	private void handleManagementUserClick() throws ClassNotFoundException, SQLException {
	    showUsersView(new Stage());
	}
}
