package golf;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class Player_Controller extends golfMain{

	@FXML
	TreeTableView treeView = new TreeTableView();

	@FXML
	TreeTableColumn name = new TreeTableColumn();
	
	
	public void initialize(){
		
		
		Player player1 = new Player("Travon", "Royal", 73, 76, 1);
		
		TreeItem<String> player = new TreeItem<>(player1.getfName());
		
		TreeTableColumn<String, String> name = new TreeTableColumn<>("Player");
		
		name.setCellValueFactory((javafx.scene.control.TreeTableColumn.CellDataFeatures<String, String> p) -> 
			new ReadOnlyStringWrapper(p.getValue().getValue()));
		
		TreeTableView<String> treeView = new TreeTableView<>(player);
		
		treeView.getColumns().add(name);
		
		
	}
}
