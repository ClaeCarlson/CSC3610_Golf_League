package golfLeague;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;

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
	TreeTableColumn<Person, String> score ;


	@FXML
	Button fullRoster;
	@FXML
	Button logout;

	@FXML
	AnchorPane scene;
	
	@FXML
	Label lblName = new Label("");
	@FXML
	Label lblTeam = new Label("");

	JDBC_Connector mysqlAccess = new JDBC_Connector(); ;
	
	golfMain show = new golfMain();
	
	@SuppressWarnings("unchecked")
	public void populateTable() throws ClassNotFoundException, SQLException {
		
		
		lblName.setText("Welcome, " + LoginController.userWindowLabel);
		lblTeam.setText(LoginController.userTeam);
		
		String where = "where team = '" + LoginController.userTeam + "'";
		
		ResultSet ult = mysqlAccess.dataSet("*", where, "person");
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

		treeView.setRoot(root);
		treeView.getColumns().setAll(name, handicap, score, rank);
		treeView.setPrefWidth(402);
		treeView.setShowRoot(false);

	}
	// change to show score and show team as a label, not value in the table

	public void initialize() {

		logout.setOnAction(e -> {
			
			
			golfMain.closeWindow(e);

			golfMain.showLogin();

		});
		
		fullRoster.setOnAction(e -> {
			try {
				golfMain.showFullRoster();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

	}

}