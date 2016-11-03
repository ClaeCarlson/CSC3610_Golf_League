package golfLeague;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateUserController extends golfMain{

	@FXML
	TextField txtUser = new TextField();
	@FXML
	TextField txtPass = new TextField();
	@FXML
	TextField txtPass2 = new TextField();

	@FXML
	ComboBox<String> cmboType = new ComboBox<String>();

	@FXML
	Button btnClear = new Button();
	@FXML
	Button btnSubmit = new Button();

	@FXML
	Label lblFields = new Label();
	@FXML
	Label lblPass = new Label();

	public void intialize() {
		cmboType.getItems().add("Player");
		cmboType.getItems().add("Coach");

		lblFields.setVisible(false);
		lblPass.setVisible(false);

		btnClear.setOnAction(e -> {
			txtUser.clear();
			txtPass.clear();
			txtPass2.clear();
		});

		btnSubmit.setOnAction(e -> {
			lblPass.setVisible(false);
			lblFields.setVisible(false);
			if (txtUser.getText() != null && txtPass.getText() != null && txtPass2.getText() != null
					&& cmboType.getSelectionModel().getSelectedItem() != null) {
				if (txtPass.getText().equals(txtPass2.getText())) {
					showCreateUser2();
				} else
					lblPass.setVisible(true);

			} else
				lblFields.setVisible(true);

		});
	}
}
