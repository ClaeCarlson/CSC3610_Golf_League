package golfLeague;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connector {

	static private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement prestm = null;
	private ResultSet resultSet = null;
	
	public JDBC_Connector() {
		// TODO Auto-generated constructor stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/golf_league", "root","1129");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertPersonAll(String uname, String pword, String fname, String lname, String type, String handicap,
			String score, String rank, String team) throws SQLException, ClassNotFoundException {

		prestm = connect.prepareStatement("insert into person (userName, password, fname,lname, type, handicap, score, rank, team) "
				+ "values (?,?,?,?,?,?,?,?,?)");

		prestm.setString(1, uname);
		prestm.setString(2, pword);
		prestm.setString(3, fname);
		prestm.setString(4, lname);
		prestm.setString(5, type);
		prestm.setString(6, handicap);
		prestm.setString(7, score);
		prestm.setString(8, rank);
		prestm.setString(9, team);

		prestm.executeUpdate();

	}

	public void update(String up, String set, String where) throws SQLException, ClassNotFoundException {

		
		String update = "update ? set ? where ?";

		prestm = connect.prepareStatement(update);

		prestm.setString(1, up);
		prestm.setString(2, set);
		prestm.setString(3, where);

		prestm.executeUpdate();

	}

	public String data(String field, String where) throws SQLException, ClassNotFoundException {
		prestm = connect.prepareStatement("select " + field + " from person where " + where + ";");
		resultSet = prestm.executeQuery();
		resultSet.next();

		return resultSet.getString(1);

	}
	
	public String getPassword( String name) throws SQLException{
	
		prestm = connect.prepareStatement("select password from person where userName = '" + name +"'");
		resultSet = prestm.executeQuery();
		resultSet.next();
		
		return resultSet.getString(1);
	}
	
	public String getType(String name) throws SQLException{
		
		prestm = connect.prepareStatement("select type from person where userName = '" + name + "'");
		resultSet = prestm.executeQuery();
		resultSet.next();
		
		return resultSet.getString(1);
	}

	public ResultSet dataSet(String field) throws SQLException, ClassNotFoundException {

		prestm = connect.prepareStatement("select " + field + " from person");
		resultSet = prestm.executeQuery();
		resultSet.next();

		return resultSet;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
