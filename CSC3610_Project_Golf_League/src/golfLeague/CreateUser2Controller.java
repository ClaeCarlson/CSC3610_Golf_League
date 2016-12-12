package golfLeague;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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

	String userData;

	public void initialize() {

		btnClear.setOnAction(e -> {
			clear();
		});

		btnSubmit.setOnAction(e -> {

			submit(e);

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

	public void submit(ActionEvent e) {
		try {
			// validate data - make sure fields aren't empty

			if (txtUser.getText() != null && txtPass.getText() != null && txtFName.getText() != null
					&& txtLName.getText() != null && txtHandicap.getText() != null && txtScore.getText() != null
					&& txtTeam.getText() != null && ((RadioButton) type.getSelectedToggle()).getText() != null) {
				// use InsertPersonAll method to create a tuple in the
				// person table of the db
				alertBox();

				// close the window when creation is successful
				golfMain.closeWindow(e);

			} else {
				lblError.setVisible(true);
				System.out.println("Else");
			}
		} catch (NullPointerException e1) {
			System.out.println("Empty boxes!");
			lblError.setVisible(true);
		}
	}

	public void alertBox(){
		   Alert alert = new Alert(AlertType.CONFIRMATION);
		   alert.setTitle("Create new user");
		   //alert.setHeaderText("User Created:");
		   alert.setContentText("User Name: " + txtUser.getText()  + "\nPassword: " + txtPass.getText() 
		    + "\nName: " + txtFName.getText() + " " + txtLName.getText() + "\nHandicap: " 
		    + txtHandicap.getText() + "\nScore: " + txtScore.getText() + "\nTeam: " 
		    + txtTeam.getText() + "\nType: " + ((RadioButton) type.getSelectedToggle()).getText());
		   alert.showAndWait().ifPresent(rs -> {
		       if (rs == ButtonType.OK) {
		           System.out.println("Pressed OK.");
		           try {
		     mysqlAccess.insertPersonAll(txtUser.getText(), txtPass.getText(), txtFName.getText(),
		        txtLName.getText(), ((RadioButton) type.getSelectedToggle()).getText(),
		        txtHandicap.getText(), txtScore.getText(), null, txtTeam.getText());
		    } catch (ClassNotFoundException e) {
		     // TODO Auto-generated catch block
		     e.printStackTrace();
		    } catch (SQLException e) {
		     // TODO Auto-generated catch block
		     e.printStackTrace();
		    }
		           
		       }
		       else if (rs == ButtonType.CANCEL) {
		    	   System.out.println("Canceled creation");
		       }
		   });
		  }
		}
