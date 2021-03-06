
package golfLeague;

import java.io.IOException;
import java.util.HashMap;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public void insertPersonAll(String uname, String pword, String fname, String lname, String type, String handicap, String score, String rank, String team ) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		
		java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/golf_league", "travon",
				"tra");
		
		
		String insertString = "insert into person (userName, password, fname,lname, type, handicap, score, rank, team) "
				+ "values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(insertString);
		
		statement.setString(1, uname);
		statement.setString(2, pword);
		statement.setString(3, fname);
		statement.setString(4, lname);
		statement.setString(5, type);
		statement.setString(6, handicap);
		statement.setString(7, score);
		statement.setString(8, rank);
		statement.setString(9, team);
		
		statement.executeUpdate();
		
	
		connection.close();
	}

	public void update(String up, String set, String where) throws SQLException, ClassNotFoundException{
		
		Class.forName("com.mysql.jdbc.Driver");
		
			java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/golf_league", "travon",
				"tra");
			
			String update = "update ? set ? where ?";
						
			PreparedStatement statement = connection.prepareStatement(update);
			
			statement.setString(1, up);
			statement.setString(2,  set);
			statement.setString(3, where);
			
			statement.executeUpdate();
	}

	public String data(String field, String where) throws SQLException, ClassNotFoundException{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/golf_league", "travon",
			"tra");
		
		String select = "select "+ field + " from person where " + where;
					
		Statement state = connection.createStatement();
		
		ResultSet ult = state.executeQuery(select);
		
		ult.next();
		return ult.getString(1);
		
		
		
	}
	public static void main(String[] args) {
		Map<String, Person> hashMap = new HashMap<>();
		launch(args);
	}
}
