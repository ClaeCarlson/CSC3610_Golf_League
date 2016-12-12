package golfLeague;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Connector {

	static private Connection connect = null;
	private static PreparedStatement prestm = null;
	private static ResultSet resultSet = null;
	
	public JDBC_Connector() {

		try{
			Class.forName("com.mysql.jdbc.Driver");
			// change password here to fit your mysql login
			connect = DriverManager.getConnection("jdbc:mysql://localhost/golf_league", "root","redred");
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

	public void update(String score, String user) throws SQLException, ClassNotFoundException {

		
		String update = "update person set score = ? where userName = ?";

		prestm = connect.prepareStatement(update);

		prestm.setString(1, score);
		prestm.setString(2, user);

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
	
	// added 12/4 for player labels
	public String getName(String user) throws SQLException{
		
		prestm = connect.prepareStatement("select fname, lname from person where userName = '" + user + "'");
		resultSet = prestm.executeQuery();
		resultSet.next();
		
		String fullName = resultSet.getString(1) + " " + resultSet.getString(2);
		
		System.out.println(fullName);
		return fullName;
		
	}
	
	// added 12/5 for populating table with relevant info
	public String getTeam(String user) throws SQLException {
		prestm = connect.prepareStatement("select team from person where userName = '" + user + "'");
		resultSet = prestm.executeQuery();
		resultSet.next();
		
		String team = resultSet.getString(1);
		
		System.out.println(team);
		
		return team;
	}

	// changing dataSet from ResultSet dataSet(String field) to include where
	public ResultSet dataSet(String field, String where, String table) throws SQLException, ClassNotFoundException {
		prestm = connect.prepareStatement("select " + field + " from " + table + " " + where);
		resultSet = prestm.executeQuery(); 
		
		return resultSet;

	}

	public void retrieveRank() throws SQLException,ClassNotFoundException {
		
		prestm = connect.prepareStatement("select userName, score from person order by score+0 desc");
		
		resultSet = prestm.executeQuery();
		
		int i = 1;
		
		while (resultSet.next()) {
			// only do if string isn't ""
			if (!resultSet.getString(2).equals("")) {
				storeRank(i, resultSet.getString(1));
				i++;
			}
		}
	}
	
	public void storeRank(int i, String name) throws SQLException {
		prestm = connect.prepareStatement("update person set rank = ? where userName = ?");
		prestm.setInt(1, i);
		prestm.setString(2, name);
		prestm.executeUpdate();
	}
	
	public void deletePerson(String user) throws SQLException {
		prestm = connect.prepareStatement("delete from person where userName = ?");
		prestm.setString(1, user);
		prestm.executeUpdate();
		System.out.println("User deleted");
	}
	
	public void restorePerson(String user) throws SQLException {
		prestm = connect.prepareStatement("delete from deletedpeople where userName = ?");
		prestm.setString(1, user);
		prestm.executeUpdate();
		System.out.println("User restored");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
