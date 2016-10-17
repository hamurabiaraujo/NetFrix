package br.ufrn.imd.netfrix;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class MainApp extends Application {
	
	public static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		MainApp.primaryStage = primaryStage;
		MainApp.primaryStage.setResizable(false);
        MainApp.primaryStage.setTitle("Netfrix");

        showLogin();
	}

	public void showLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LoginView.fxml"));
            AnchorPane loginView = (AnchorPane) loader.load();
            
            Scene scene = new Scene(loginView);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
