package jdbcMysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	
	private Connection connection;
	
	
	private String url = "jdbc:mysql://localhost:3306/";
	private String database = "addressBook";
	private String userName = "root";
	private String password = "mysql123";

	public Connection getConnection() {
		//DriverManager to get connection
		try {
			connection = DriverManager.getConnection(
					url + database, userName, password);
			
			System.out.println("Database connection: Successful");
			return connection;
		} catch (Exception e) {
			System.out.println("Database connection: Failed");
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeConnection() {
		try {
			if (connection != null ) {
				connection.close();
				System.out.println("Close Database connection: Successful");
			}
		} catch (Exception e) {
			System.out.println("Closing Database connection Failed");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DbConnect testConnect = new DbConnect();
		testConnect.getConnection();
		testConnect.closeConnection();
		
	}
}
