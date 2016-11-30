package golfLeague;


import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class CreateUser2Controller {

	@FXML
	Button btnClear = new Button();

	@FXML
	Button btnSubmit = new Button();

	@FXML
	TextField txtUser = new TextField();

	@FXML
	TextField txtPass = new TextField();

	@FXML
	TextField txtFName = new TextField();

	@FXML
	TextField txtLName = new TextField();

	@FXML
	TextField txtHandicap = new TextField();

	@FXML
	TextField txtScore = new TextField();

	@FXML
	TextField txtTeam = new TextField();

	@FXML
	RadioButton typePlayer = new RadioButton();

	@FXML
	RadioButton typeCoach = new RadioButton();

	@FXML
	Label lblError;

	JDBC_Connector mysqlAccess = new JDBC_Connector();
	
	ToggleGroup type = new ToggleGroup();
	
	
	public void initialize() {

		btnClear.setOnAction(e -> {
			clear();
		});

		btnSubmit.setOnAction(e -> {

			try {
				// validate data - make sure fields aren't empty

				if (txtUser.getText() != null && txtPass.getText() != null && txtFName.getText() != null
						&& txtLName.getText() != null && txtHandicap.getText() != null && txtScore.getText() != null
						&& txtTeam.getText() != null
						&& ((RadioButton) type.getSelectedToggle()).getText() != null) {
					// use InsertPersonAll method to create a tuple in the
					// person table of the db
					mysqlAccess.insertPersonAll(txtUser.getText(), txtPass.getText(), txtFName.getText(),
							txtLName.getText(), ((RadioButton) type.getSelectedToggle()).getText(),
							txtHandicap.getText(), txtScore.getText(), "N", txtTeam.getText());

					// close the window when creation is successful
					final Node source = (Node) e.getSource();
					final Stage stage = (Stage) source.getScene().getWindow();
					stage.close();

				} else
					lblError.setVisible(true);
					System.out.println("Else");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				lblError.setVisible(true);
				System.out.println("SQL");
				e1.printStackTrace();
			} catch (NullPointerException e1) {
				System.out.println("NUll");
				e1.printStackTrace();
				lblError.setVisible(true);
			}

		});

	}

	public void setData() {

		

		typePlayer.setToggleGroup(type);
		typeCoach.setToggleGroup(type);

		lblError.setVisible(false);

	}

	public void clear() {
		txtUser.clear();
		txtPass.clear();
		txtFName.clear();
		txtLName.clear();
		txtHandicap.clear();
		txtScore.clear();
		txtTeam.clear();
		lblError.setVisible(false);
	}

	// public void submit(){
	// try {
	// // validate data - make sure fields aren't empty
	//
	// if (txtUser.getText() != null && txtPass.getText() != null &&
	// txtFName.getText() != null
	// && txtLName.getText() != null && txtHandicap.getText() != null &&
	// txtScore.getText() != null
	// && txtTeam.getText() != null
	// && ((RadioButton) radioGrp.getSelectedToggle()).getText() != null) {
	// // use InsertPersonAll method to create a tuple in the person table of
	// the db
	// mysqlAccess.insertPersonAll(txtUser.getText(), txtPass.getText(),
	// txtFName.getText(), txtLName.getText(),
	// ((RadioButton) radioGrp.getSelectedToggle()).getText(),
	// txtHandicap.getText(),
	// txtScore.getText(), null, txtTeam.getText());
	//
	// // close the window when creation is successful
	// final Node source = (Node) e.getSource();
	// final Stage stage = (Stage) source.getScene().getWindow();
	// stage.close();
	//
	// } else
	// lblError.setVisible(true);
	// } catch (ClassNotFoundException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// } catch (SQLException e1) {
	// // TODO Auto-generated catch block
	// lblError.setVisible(true);
	// e1.printStackTrace();
	// } catch (NullPointerException e1) {
	// lblError.setVisible(true);
	// }
	// }

}