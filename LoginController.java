package golfLeague;



import java.io.IOException;
import java.sql.SQLException;



import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

//import javafx.scene.control.TextArea;

import javafx.scene.control.TextField;



public class LoginController  {

	@FXML
	Label errorDisplay;

	@FXML
	Button btnSubmit = new Button();

	@FXML
	Button btnClear = new Button();

	@FXML
	Button btnNewUser = new Button();

	@FXML
	TextField txtUser;

	@FXML
	TextField txtPass;

	JDBC_Connector mysqlAccess = new JDBC_Connector();
	
	golfMain show = new golfMain();
	public void initialize() {

		errorDisplay.setVisible(false);

		btnSubmit.setOnAction(e -> {
			submit();
		});

		btnClear.setOnAction(e -> {
			clear();
		});


		btnNewUser.setOnAction(e -> {
			newUser();
		});

	}
	
	
	public void submit(){
		String user = txtUser.getText();
		String pass = txtPass.getText();

		try {

			// validate that the username entered has the correct corresponding password
			if(pass.equals(mysqlAccess.getPassword(user))){
				System.out.println("pass good");
				if(mysqlAccess.getType(user).equals("Player")){
					System.out.println("PLayer");
					show.showPlayer();
					errorDisplay.setVisible(false);
				} else if (mysqlAccess.getType(user).equals("Coach")) {
					show.showCoach();
					errorDisplay.setVisible(false);
				}else if (mysqlAccess.getType(user).equals("Admin")){
					// make this hardcoded for strings, not using database
					show.showAdmin();

					errorDisplay.setVisible(false);
				}

			}else{
				errorDisplay.setVisible(true);
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			errorDisplay.setVisible(true);
			System.out.println("SQL");
			e1.printStackTrace();

		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clear(){
		txtUser.clear();
		txtPass.clear();
		errorDisplay.setVisible(false);
	}
	
	public void newUser(){
		try {
			show.showCreateUser2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}