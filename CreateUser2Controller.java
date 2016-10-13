package golfLeague;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateUser2Controller extends golfMain{
	
	@FXML
	Button btnClear = new Button();
	@FXML
	Button btnSubmit = new Button();
	
	@FXML
	TextArea txtUser = new TextArea();
	@FXML
	TextArea txtPass = new TextArea();
	@FXML
	TextArea txtType = new TextArea();
	
	@FXML
	TextField txtFName = new TextField();
	@FXML
	TextField txtLName = new TextField();
	@FXML
	TextField txtHandicap = new TextField();
	@FXML
	TextField txtScore = new TextField();
	
	@FXML
	Label lblError;
		
	
	public void initialize() {
		
		lblError.setVisible(false);
		
		txtUser.appendText(userName);
		txtPass.appendText(pass);
		txtType.appendText(type);
		
		btnClear.setOnAction(e -> {
			txtFName.clear();
			txtLName.clear();
			txtHandicap.clear();
			txtScore.clear();
			lblError.setVisible(false);
		});
		
		btnSubmit.setOnAction(e -> {
			hashMap.put(userName,
					new Person(userName, pass, txtFName.getText(), txtLName.getText(),
							type, txtHandicap.getText(), txtScore.getText()));
		});
		
		
	}

}
