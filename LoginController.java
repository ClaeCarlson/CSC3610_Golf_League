package golfLeague;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LoginController extends golfMain {

	String user;
	String pass;

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
			user = txtUser.getText();
			pass = txtPass.getText();

			if (user.equals("admin") && pass.equals("admin")) {
				showAdmin();
				errorDisplay.setVisible(false);
			}

			else
				errorDisplay.setVisible(true);

		});

		btnClear.setOnAction(e -> {
			txtUser.clear();
			txtPass.clear();
			errorDisplay.setVisible(false);
		});

		btnNewUser.setOnAction(e -> {
			showCreateUser();
		});
	}
	/*
	 * use a map with username being key - value is the person object - compares
	 * the password datafield to login and checks what kind of person
	 */

}
