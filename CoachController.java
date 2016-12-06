package golfLeague;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

public class CoachController {

	@FXML
	Button logout = new Button();
	@FXML
	Button updateScore = new Button();
	@FXML
	Button deletePlayer = new Button();
	@FXML
	Button printRoster = new Button();
	
	@FXML
	TextField txtScore = new TextField();
	
	@FXML
	TreeTableView<Person> treeView;

	@FXML
	TreeTableColumn<Person, String> name ;

	@FXML
	TreeTableColumn<Person, String> handicap ;

	@FXML
	TreeTableColumn<Person, String> score ;

	@FXML
	TreeTableColumn<Person, String> team ;
	
	@FXML
	Label lblName = new Label("");
	@FXML
	Label success;
	
	String selectedUser = "";
	
	JDBC_Connector mysqlAccess = new JDBC_Connector();
	
	@SuppressWarnings("unchecked")
	public void populateTable() throws ClassNotFoundException, SQLException {
		mysqlAccess.retrieveRank();
		
		lblName.setText("Coach " + LoginController.userWindowLabel);
		
		String where = "team = '" + LoginController.userTeam + "'";
		
		ResultSet ult = mysqlAccess.dataSet("*", where);
		List<Person> players = new ArrayList<>();

		while (ult.next()) {
			players.add(
					new Person(ult.getString(1), ult.getString(3), ult.getString(4), ult.getString(6), ult.getString(7), ult.getString(8),
							ult.getString(9)));
		}

		TreeItem<Person> root = new TreeItem<>();

		root.setExpanded(true);
		players.stream().forEach((player) -> {
			root.getChildren().add(new TreeItem<>(player));
		});

		score.setPrefWidth(100);
		score.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Person, String> p) ->
				new ReadOnlyStringWrapper(p.getValue().getValue().getScore())
		);

		name.setPrefWidth(100);
		name.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Person, String> p) ->
				new ReadOnlyStringWrapper(p.getValue().getValue().getfName()
						+ " " + p.getValue().getValue().getlName())
		);

		team.setPrefWidth(100);
		team.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Person, String> p) ->
				new ReadOnlyStringWrapper(p.getValue().getValue().getTeam())
		);

		handicap.setPrefWidth(100);
		handicap.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Person, String> p) ->
				new ReadOnlyStringWrapper(p.getValue().getValue().getHandicap())
		);

		treeView.setRoot(root);
		treeView.getColumns().setAll(score, name, team, handicap);
		treeView.setPrefWidth(400);
		treeView.setShowRoot(false);

	}
	public void initialize() {
		
		success.setVisible(false);
		
		updateScore.setOnAction(e -> {
			try {
				String score = txtScore.getText();
				if (selectedUser != "") {
					mysqlAccess.update(score, selectedUser);
					success.setVisible(true);
					populateTable();
				}
				else
					System.out.println("No user selected");
			} catch (ClassNotFoundException e1) {
				
				//e1.printStackTrace();
			} catch (SQLException e1) {
				System.out.println("SQL EXCEPTION");
				//e1.printStackTrace();
			} catch (NullPointerException e1) {
				//System.out.println("");
			}
			
		});

		logout.setOnAction(e -> {
			
			
			golfMain.closeWindow(e);

			golfMain.showLogin();

		});
		
		deletePlayer.setOnAction(e->{
			try {
				if (selectedUser != "") {
					mysqlAccess.deletePerson(selectedUser);
					success.setVisible(true);
					populateTable();
				}
				else
					System.out.println("No user selected");
			} catch (SQLException | ClassNotFoundException e1) {
				
			}
		});
		
		printRoster.setOnAction(e->{
			
		});
		
		treeView.getSelectionModel()
        .selectedItemProperty()
        .addListener((observable, oldValue, newValue) ->
        	// this is throwing nullpointerexception
        	selectedUser = newValue.getValue().toString());

	}
}
