package Fireflink_ninza_CRM.GenericUitility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {
	
	private static String URL = "";
	private static String USERNAME="";
	private static String PASSWORD = "";
	
	private Connection connection;
	
	public void openDatabaseConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	public void closeDatabaseConnection() throws SQLException {
		if(connection!=null) {
			connection.close();
		}
	}
	
	public ResultSet fetchDataFromDatabase(String query) throws SQLException {
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(query);
		
	}
	
	

}
