package br.ufrn.imd.netfrix.view;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.netfrix.MainApp;
import br.ufrn.imd.netfrix.dao.UserDao;
import br.ufrn.imd.netfrix.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UsersViewController {
	@FXML
	private TableView<User> userTable;
	@FXML
	private TableColumn<User, String> nameColumn;
	
	@FXML
	private Label nameLabel;
	@FXML
	private Label emailLabel;
	@FXML
	private Label dateOfBirthLabel;
	@FXML
	private Label isAdminLabel;
	@FXML
	private Button btnNew;
	
	private ObservableList<User> users;
	
	public UsersViewController() {
	}
	
	@FXML
	private void initialize() {
		users = FXCollections.observableArrayList();
		
	    try{            
	        ResultSet rs = UserDao.getUsers();
	        while(rs.next()){
	            User u = new User(
	            		rs.getInt("id"),
	            		rs.getString("email"),
	            		rs.getString("password"),
	            		rs.getString("name"),
	            		rs.getBoolean("is_admin"),
	            		rs.getDate("date_of_birth")
	            	);
	            
	            users.add(u);                  
	        }
	        
	        userTable.setItems(users);
	    }
	    catch(Exception e){
	          e.printStackTrace();
	          System.out.println("Error on Building Data " + e);            
	    }
		
        nameColumn.setCellValueFactory(
        		cellData -> cellData.getValue().getNameProperty());
        
        showUserDetails(null);

		userTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showUserDetails(newValue));
	}
	
	private void showUserDetails(User user) {
		if (user != null) {
    		nameLabel.setText(user.getName());
    		emailLabel.setText(user.getEmail());
    		dateOfBirthLabel.setText(user.getDateOfBirth().toString());
    		
    		if (user.getIsAdmin()) {
    			isAdminLabel.setText("Sim");
    		} else {
    			isAdminLabel.setText("Não");
    		}
    	} else {
    		nameLabel.setText("");
    		emailLabel.setText("");
    		dateOfBirthLabel.setText("");
    		isAdminLabel.setText("");
    	}
	}
	
	private void showUserView(Stage stage, User user) {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/UserView.fxml"));
            AnchorPane userView = (AnchorPane) loader.load();
            
            if (user != null) {
            	UserViewController userViewController = loader.<UserViewController>getController();
            	userViewController.setUser(user);
            }

            Scene scene = new Scene(userView);
            stage.setScene(scene);
            stage.show();
            
            Stage actual_stage = (Stage) btnNew.getScene().getWindow();
		    actual_stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleNewUserClick() throws ClassNotFoundException, SQLException {
	    showUserView(new Stage(), null);
	}

	@FXML
	private void handleEditUserClick() throws ClassNotFoundException, SQLException {
		User selectedUser = userTable.getSelectionModel().getSelectedItem();
		
		if (selectedUser != null) {
			showUserView(new Stage(), selectedUser);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Nenhuma seleção");
            alert.setHeaderText("Nenhum usuário selecionado");
            alert.setContentText("Por favor, selecione um usuário na tabela.");
            alert.showAndWait();
		}
	}
	
	@FXML
	private void handleRemoveUserClick() throws ClassNotFoundException, SQLException {
		User selectedUser = userTable.getSelectionModel().getSelectedItem();
		
		if (selectedUser != null) {
			try	{
				UserDao.deleteUser(selectedUser.getId());
				
				this.initialize();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error to delelting User");
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Nenhuma seleção");
            alert.setHeaderText("Nenhum usuário selecionado");
            alert.setContentText("Por favor, selecione um usuário na tabela.");
            alert.showAndWait();
		}
	}
}
