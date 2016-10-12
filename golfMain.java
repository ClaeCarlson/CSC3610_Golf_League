package golfLeague;

import java.io.IOException;

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

		// Set tickets into the center of root layout.
		rootLayout.setCenter(login);
	}

	public void showPlayer() {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(golfMain.class.getResource("Admin.fxml"));

		try {
			admin = (AnchorPane) loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		rootLayout.setCenter(login);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
