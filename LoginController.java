package golfLeague;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LoginController extends golfMain{
	
	String user;
	String pass;

	@FXML
	Button btnSubmit = new Button();
	@FXML
	Button btnClear = new Button();
	
	@FXML
	TextField txtUser;
	@FXML
	TextField txtPass;
	
	public void initialize() {
		btnSubmit.setOnAction(e -> {
			user = txtUser.getText();
			pass = txtPass.getText();
			
			if (user.equals("Player") && pass.equals("player"))
				showPlayer();
		});
		
		btnClear.setOnAction(e -> {
			txtUser.clear();
			txtPass.clear();
		});
	}

	
}
