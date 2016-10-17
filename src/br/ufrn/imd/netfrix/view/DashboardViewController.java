package br.ufrn.imd.netfrix.view;

import br.ufrn.imd.netfrix.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DashboardViewController {
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
}
