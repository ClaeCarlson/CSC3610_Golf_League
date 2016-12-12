package golfLeague;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;



public class restorePerson {
	
	@FXML
	TreeTableView<Person> treeView;

	@FXML
	TreeTableColumn<Person, String> name ;

	@FXML
	TreeTableColumn<Person, String> handicap ;

	@FXML
	TreeTableColumn<Person, String> rank ;

	@FXML
	TreeTableColumn<Person, String> score ;
	
	@FXML
	TreeTableColumn<Person, String> team;
	
	@FXML
	Button restore;
	
	String selectedUser = "";
	
	
	JDBC_Connector mysqlAccess = new JDBC_Connector();
	
	public void initialize() {
		restore.setOnAction(e -> {
			try {
				mysqlAccess.restorePerson(selectedUser);
				deletedTable();
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			// this is throwing nullpointerexception
	
			selectedUser = newValue.getValue().toString();
		});
	}
	
	@SuppressWarnings("unchecked")
	public void deletedTable() throws ClassNotFoundException, SQLException{
		
		String where = "";
		
		ResultSet ult = mysqlAccess.dataSet("*", where, "deletedpeople");
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

		rank.setPrefWidth(90);
		rank.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Person, String> p) ->
				new ReadOnlyStringWrapper(p.getValue().getValue().getRank())
		);

		name.setPrefWidth(130);
		name.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Person, String> p) ->
				new ReadOnlyStringWrapper(p.getValue().getValue().getfName()
						+ " " + p.getValue().getValue().getlName())
		);

		score.setPrefWidth(90);
		score.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Person, String> p) ->
				new ReadOnlyStringWrapper(p.getValue().getValue().getScore())
		);

		handicap.setPrefWidth(90);
		handicap.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Person, String> p) ->
				new ReadOnlyStringWrapper(p.getValue().getValue().getHandicap())
		);
		
		team.setPrefWidth(150);
		team.setCellValueFactory((TreeTableColumn.CellDataFeatures<Person, String> p) ->
				new ReadOnlyStringWrapper(p.getValue().getValue().getTeam())
		);

		treeView.setRoot(root);
		treeView.getColumns().setAll(name, handicap, team, score, rank);
		treeView.setPrefWidth(570);
		treeView.setShowRoot(false);

		
	}
}