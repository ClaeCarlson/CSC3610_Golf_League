package golfLeague;



import java.io.IOException;
import java.sql.SQLException;



import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

//import javafx.scene.control.TextArea;

import javafx.scene.control.TextField;
import javafx.stage.Stage;



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
	
	boolean passGood = false;
	
	static String userWindowLabel;
	
	static String userTeam;
	
	golfMain show = new golfMain();
	public void initialize() {

		errorDisplay.setVisible(false);

		btnSubmit.setOnAction(e -> {
			submit();
			
			if (passGood)
				golfMain.closeWindow(e);
			
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
				//System.out.println("Password accepted");
				if(mysqlAccess.getType(user).equals("Player")){
					System.out.println("Player");
					passGood = true;
					userWindowLabel = mysqlAccess.getName(user);
					userTeam = mysqlAccess.getTeam(user);
					show.showPlayer();
					
					errorDisplay.setVisible(false);
				} else if (mysqlAccess.getType(user).equals("Coach")) {
					System.out.println("Coach");
					passGood = true;
					userWindowLabel = mysqlAccess.getName(user);
					userTeam = mysqlAccess.getTeam(user);
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
			System.out.println("Username and pass not recognized");
			

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