package golfLeague;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.xml.stream.events.StartDocument;

import javafx.application.Application;
import javafx.beans.binding.IntegerExpression;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Player_Controller extends golfMain {

	@FXML
	static
	TreeTableView<Player> treeView = new TreeTableView<>();

	@FXML
	static
	TreeTableColumn<Player, String> name = new TreeTableColumn<>();
	
	@FXML
	static
	TreeTableColumn<Player, String> handicap = new TreeTableColumn<>();
	
	@FXML
	static
	TreeTableColumn<Player, String> rank = new TreeTableColumn<>();
	
	@FXML
	static
	TreeTableColumn<Player, String> team = new TreeTableColumn<>();

	@FXML
	Button start = new Button();

	@FXML
	AnchorPane scene;

	@SuppressWarnings("unchecked")
	public static void populateTable() throws ClassNotFoundException, SQLException {
		
		 ResultSet ult = golfMain.dataSet("*");
	        
	        List<Player> players = new ArrayList<>();
	        
	        while(ult.next()){
	        	players.add(
	        			new Player(ult.getString(3), ult.getString(4),ult.getString(6), ult.getString(7), ult.getString(8), ult.getString(9)));
	        }
	        
	       
	        
			final TreeItem<Player> root = new TreeItem<>();
		
			root.setExpanded(true);
			
			players.stream().forEach((player) -> {
				root.getChildren().add(new TreeItem<>(player));
			});
			
			rank = new TreeTableColumn<>("Rank");
			rank.setPrefWidth(100);
			rank.setCellValueFactory(
					(TreeTableColumn.CellDataFeatures<Player, String> p) ->
					new ReadOnlyStringWrapper(p.getValue().getValue().getRank())
					);
			
			name = new TreeTableColumn<>("Name");
			name.setPrefWidth(100);
			name.setCellValueFactory(
					(TreeTableColumn.CellDataFeatures<Player, String> p) ->
					new ReadOnlyStringWrapper(p.getValue().getValue().getfName() 
							+ p.getValue().getValue().getlName())
					);
			
			team = new TreeTableColumn<>("Team");
			team.setPrefWidth(100);
			team.setCellValueFactory(
					(TreeTableColumn.CellDataFeatures<Player, String> p) ->
					new ReadOnlyStringWrapper(p.getValue().getValue().getTeam())
					);
			
			handicap = new TreeTableColumn<>("Handicap");
			handicap.setPrefWidth(100);
			handicap.setCellValueFactory(
					(TreeTableColumn.CellDataFeatures<Player, String> p) ->
					new ReadOnlyStringWrapper(p.getValue().getValue().getHandicap())
					);
			
			treeView = new TreeTableView<>(root);
			treeView.getColumns().setAll(rank, name, team, handicap);
	        treeView.setPrefWidth(400);
	        treeView.setShowRoot(false); 
	
		
	}
		
}
