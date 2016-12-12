package golfLeague;

import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class golfMain extends Application {

	private Stage primaryStage;
	private static AnchorPane login;
	private BorderPane coach;
	
	public String userName = "";
	public String pass = "";
	public String type = "";

	@Override
	public void start(Stage primaryStage) throws IOException {

		this.primaryStage = primaryStage;
		// title
		this.primaryStage.setTitle("Login");
		// load both fxml files
		//initializeRootLayout();
		showLogin();
	}
/*
	private void initializeRootLayout() {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(golfMain.class.getResource("RootLayout.fxml"));
		try {
			rootLayout = (BorderPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// set borderpane in scene and stage
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
*/
	public static void showLogin() {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(golfMain.class.getResource("Login.fxml"));

		try {
			login = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Set login into the center of root layout.
		//rootLayout.setCenter(login);
		
		// test using anchorpane instead
		Stage newStage = new Stage();

		newStage.setTitle("Login");

		Scene scene = new Scene(login, 600, 400);

		newStage.setScene(scene);

		newStage.show();
	}


	public void showAdmin() throws IOException {
		
	  FXMLLoader loader = new FXMLLoader();
	  loader.setLocation(golfMain.class.getResource("../golfLeague/Administration.fxml"));
	  Parent admin = loader.load();
	  Administration_Controller controller = loader.getController();
	  
	  Stage newStage = new Stage();
	  newStage.setTitle("Admin");
	  
	  Scene scene = new Scene(admin, 600, 400);
	  newStage.setScene(scene);
	  newStage.show();
	  
	  controller.setData();
	  controller.retrieveSchedule();
	  
	 }


	public void showCreateUser2() throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(golfMain.class.getResource("CreateUser2.fxml"));
		Parent createUser2 = loader.load();
		CreateUser2Controller controller = loader.getController();
		Stage newStage = new Stage();
		newStage.setTitle("Create Account");
		Scene scene = new Scene(createUser2, 400, 450);
		newStage.setScene(scene);
		newStage.show();
		controller.setData();
	}

	public void showCoach() throws ClassNotFoundException, SQLException {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(golfMain.class.getResource("coach.fxml"));

		try {

			coach = (BorderPane) loader.load();

		} catch (IOException e) {

			e.printStackTrace();

		}

		Stage newStage = new Stage();

		newStage.setTitle("Coach");
		
		CoachController controller = loader.getController();
		

		Scene scene = new Scene(coach, 600, 400);

		newStage.setScene(scene);

		newStage.show();
		
		controller.populateTable();

	}

	public void showPlayer() throws ClassNotFoundException, SQLException, IOException {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(golfMain.class.getResource("Player.fxml"));

		Parent player = loader.load();
		
		Player_Controller controller = loader.getController();	

		Stage newStage = new Stage();

		newStage.setTitle("Player");

		Scene scene = new Scene(player, 600, 400);

		newStage.setScene(scene);

		newStage.show();

		controller.populateTable();
	
		
	}
	
	public static void showFullRoster() throws ClassNotFoundException, SQLException, IOException {
		
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(golfMain.class.getResource("FullRoster.fxml"));

		Parent fullRoster = loader.load();
		
		FullRoster controller = loader.getController();	

		Stage newStage = new Stage();

		newStage.setTitle("Full Roster");

		Scene scene = new Scene(fullRoster, 600, 400);

		newStage.setScene(scene);

		newStage.show();

		controller.fullRoster();
	}
	
	public static void showRestorePerson() throws ClassNotFoundException, SQLException, IOException {
		
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(golfMain.class.getResource("RestorePerson.fxml"));

		Parent restore = loader.load();
		
		restorePerson controller = loader.getController();	

		Stage newStage = new Stage();

		newStage.setTitle("Restore");

		Scene scene = new Scene(restore, 600, 400);

		newStage.setScene(scene);

		newStage.show();

		controller.deletedTable();
	}
	
	public static void closeWindow(ActionEvent e) {
		final Node source = (Node) e.getSource();

		final Stage stage = (Stage) source.getScene().getWindow();

		stage.close();
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		JDBC_Connector show = new JDBC_Connector();
		show.retrieveRank();
		launch(args);

	}

}