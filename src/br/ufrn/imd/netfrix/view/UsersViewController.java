package br.ufrn.imd.netfrix.view;

import java.sql.ResultSet;

import br.ufrn.imd.netfrix.dao.UserDao;
import br.ufrn.imd.netfrix.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
	
	private ObservableList<User> users;
	
	public UsersViewController() {
	}
	
	@FXML
	private void initialize() {
		users = FXCollections.observableArrayList();
		
	    try{            
	        ResultSet rs = UserDao.getUsers();  
	        while(rs.next()){
	            User u = new User();
	            u.setId(rs.getInt("id"));
	            u.setName(rs.getString("name"));
	            u.setEmail(rs.getString("email"));
	            u.setDateOfBirth(rs.getDate("date_of_birth"));
	            u.setIsAdmin(rs.getBoolean("is_admin"));
	            
	            users.add(u);                  
	        }
	        
	        userTable.setItems(users);
	    }
	    catch(Exception e){
	          e.printStackTrace();
	          System.out.println("Error on Building Data");            
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

}
