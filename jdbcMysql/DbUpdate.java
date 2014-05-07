package jdbcMysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUpdate {

	private DbConnect dbConnect;
	private Connection connection;
	private Statement statement;
	private DbQuery dbQuery;
	private ResultSet resultSet;

	public DbUpdate() {
		dbConnect = new DbConnect();
		connection = dbConnect.getConnection();
		dbQuery = new DbQuery();
	}
		
	public void exeUpdate(String tableName, String filterColumnName, String filterValue,
			String setColumn, String setValue) {

		try {			
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);

			ResultSet resultSet = statement.executeQuery("SELECT * FROM "
					+ tableName + " WHERE " + filterColumnName + "= \""
					+ filterValue + "\"");
			System.out.println("\nBEFORE UPDATE:");
			dbQuery.printResultSet(resultSet);

			// Set of operations
			// a. - positioning
			resultSet.absolute(1);
			// b. - point change
			resultSet.updateString(setColumn, setValue);
			// c. - change takes effect
			resultSet.updateRow();

			System.out.println("\nAFTER UPDATE:");
			dbQuery.printResultSet(resultSet);

		} catch (SQLException sqle) {
			System.out.println("sql: Failed");
			sqle.printStackTrace();
			System.exit(-1);
		} finally {
			dbConnect.closeConnection();
		}
	}
	
	public static void main(String[] args) {
		String database = "addressbook";
		String table = "contact";
		
		DbUpdate dbUpdate = new DbUpdate();
		dbUpdate.exeUpdate(table, "firstName", "Lily", "phoneNo", "8888");
	}

}
