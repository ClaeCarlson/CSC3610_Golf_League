package golfLeague;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LoginController extends golfMain {

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

	public void initialize() {
		errorDisplay.setVisible(false);

		btnSubmit.setOnAction(e -> {
			String user = txtUser.getText();
			String pass = txtPass.getText();

			try {
				// validate that the username entered has the correct corresponding password
				if(pass.equals(data(" password " , " userName = '"+ user + "'"  ))){
					if(data(" type ", " userName = '" + user + "'" ).equals("Player")){
						showPlayer();
						errorDisplay.setVisible(false);
					}else if (data(" type "," userName = '" + user + "'").equals("Admin")){
						showAdmin();
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
				e1.printStackTrace();
			}

		});

		btnClear.setOnAction(e -> {
			txtUser.clear();
			txtPass.clear();
			errorDisplay.setVisible(false);
		});

		btnNewUser.setOnAction(e -> {
			showCreateUser2();
		});
		
	}

}
