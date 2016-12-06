/*package golfLeague;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class practice extends Application {
	@FXML
	TreeTableView<Player> treeView = new TreeTableView<>();

	@FXML
	TreeTableColumn<Player, String> name = new TreeTableColumn<>();
	
	@FXML
	TreeTableColumn<Player, String> handicap = new TreeTableColumn<>();
	
	@FXML
	TreeTableColumn<Player, String> rank = new TreeTableColumn<>();
	
	@FXML
	TreeTableColumn<Player, String> team = new TreeTableColumn<>();
	
	JDBC_Connector mysqlAccess = new JDBC_Connector();
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public void start(Stage stage) throws ClassNotFoundException, SQLException {
        stage.setTitle("Player");
        final Scene scene = new Scene(new Group(), 400, 400);
        Group sceneRoot = (Group)scene.getRoot();  
      
        ResultSet ult = mysqlAccess.dataSet("*");
        
        List<Player> players = new ArrayList<>();
        
        while(ult.next()){
        	players.add(
        			new Player(ult.getString(3), ult.getString(4),ult.getString(6), ult.getString(7), ult.getString(8), ult.getString(9)));
        }
        
       
        
		 TreeItem<Player> root = new TreeItem<>();
	
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
        sceneRoot.getChildren().add(treeView);
        stage.setScene(scene);
        stage.show();
    }     
}*/