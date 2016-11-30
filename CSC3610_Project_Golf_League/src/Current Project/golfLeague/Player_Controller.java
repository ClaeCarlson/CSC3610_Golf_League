package golfLeague;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import javafx.beans.property.ReadOnlyStringWrapper;

import javafx.fxml.FXML;

import javafx.scene.Node;

import javafx.scene.control.Button;

import javafx.scene.control.TreeItem;

import javafx.scene.control.TreeTableColumn;

import javafx.scene.control.TreeTableView;

import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class Player_Controller {

	@FXML
	TreeTableView<Person> treeView;

	@FXML
	TreeTableColumn<Person, String> name ;

	@FXML
	TreeTableColumn<Person, String> handicap ;

	@FXML
	TreeTableColumn<Person, String> rank ;

	@FXML
	TreeTableColumn<Person, String> team ;

	@FXML
	Button start;

	@FXML
	Button logout;

	@FXML
	AnchorPane scene;

	JDBC_Connector mysqlAccess = new JDBC_Connector(); ;
	
	golfMain show = new golfMain();
	
	@SuppressWarnings("unchecked")
	public void populateTable() throws ClassNotFoundException, SQLException {
		ResultSet ult = mysqlAccess.dataSet("*");
		List<Person> players = new ArrayList<>();

		while (ult.next()) {
			players.add(
					new Person(ult.getString(3), ult.getString(4), ult.getString(6), ult.getString(7), ult.getString(8),
							ult.getString(9)));
		}

		TreeItem<Person> root = new TreeItem<>();

		root.setExpanded(true);
		players.stream().forEach((player) -> {
			root.getChildren().add(new TreeItem<>(player));
		});

		rank.setPrefWidth(100);
		rank.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Person, String> p) ->
				new ReadOnlyStringWrapper(p.getValue().getValue().getRank())
		);

		name.setPrefWidth(100);
		name.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Person, String> p) ->
				new ReadOnlyStringWrapper(p.getValue().getValue().getfName()
						+ p.getValue().getValue().getlName())
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
		treeView.getColumns().setAll(rank, name, team, handicap);
		treeView.setPrefWidth(400);
		treeView.setShowRoot(false);

	}

	public void initialize() {

		logout.setOnAction(e -> {

			final Node source = (Node) e.getSource();

			final Stage stage = (Stage) source.getScene().getWindow();

			stage.close();

			show.showLogin();

		});

	}

}