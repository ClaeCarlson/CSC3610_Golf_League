package golfLeague;

import java.io.IOException;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class golfMain extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private AnchorPane login;
	private AnchorPane admin;
	private BorderPane createUser2;
	private BorderPane coach;
	private AnchorPane player;
	public String userName = "";
	public String pass = "";
	public String type = "";

	@Override
	public void start(Stage primaryStage) throws IOException {

		this.primaryStage = primaryStage;
		// title
		this.primaryStage.setTitle("Login");
		// load both fxml files
		initializeRootLayout();
		showLogin();
	}

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

	public void showLogin() {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(golfMain.class.getResource("Login.fxml"));

		try {
			login = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Set login into the center of root layout.
		rootLayout.setCenter(login);
	}

	public void showAdmin() {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(golfMain.class.getResource("Admin.fxml"));

		try {
			admin = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Stage newStage = new Stage();
		newStage.setTitle("Admin");
		BorderPane adminRoot = new BorderPane();
		Scene scene = new Scene(adminRoot, 700, 500);
		newStage.setScene(scene);
		newStage.show();
		adminRoot.setCenter(admin);

		// make methods for each of the pages to open

	}

	public void showLeaguePage() {

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

	public void showCoach() {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(golfMain.class.getResource("coach.fxml"));

		try {

			coach = (BorderPane) loader.load();

		} catch (IOException e) {

			e.printStackTrace();

		}

		Stage newStage = new Stage();

		newStage.setTitle("Edit Player");

		Scene scene = new Scene(coach, 600, 400);

		newStage.setScene(scene);

		newStage.show();

	}

	public void showPlayer() throws ClassNotFoundException, SQLException, IOException {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(golfMain.class.getResource("Player.fxml"));

		Parent player = loader.load();
		
		Player_Controller controller = loader.getController();	

		Stage newStage = new Stage();

		newStage.setTitle("Player");

		Scene scene = new Scene(player, 400, 450);

		newStage.setScene(scene);

		newStage.show();

		controller.populateTable();
	
		
	}

	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		launch(args);

	}

}