package golfLeague;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class golfMain extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private AnchorPane login;
	private AnchorPane admin;
	private BorderPane createUser;
	private BorderPane createUser2;
	
	public String userName = "";
	public String pass = "";
	public String type = "";
	public Map<String, Person> hashMap;
	

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

	private void showLogin() {

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
	
	public void showCreateUser() {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(golfMain.class.getResource("CreateUser.fxml"));

		try {
			createUser = (BorderPane) loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		Stage newStage = new Stage();
		newStage.setTitle("Create New User");
		

		Scene scene = new Scene(createUser, 400, 400);
		newStage.setScene(scene);
		
		newStage.show();
		
		
	}
	
	public void showCreateUser2 (String user, String pass, String type) {
		
		userName = user;
		pass = pass;
		type = type;
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(golfMain.class.getResource("CreateUser2.fxml"));

		try {
			createUser2 = (BorderPane) loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		Stage newStage = new Stage();
		newStage.setTitle("Create Account");
		

		Scene scene = new Scene(createUser2, 400, 400);
		newStage.setScene(scene);
		
		newStage.show();
		
		
	}

	public static void main(String[] args) {
		Map<String, Person> hashMap = new HashMap<>();
		launch(args);
	}
}
