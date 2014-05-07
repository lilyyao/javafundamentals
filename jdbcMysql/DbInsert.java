package jdbcMysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInsert {

	private DbConnect dbConnect;
	private Connection connection;
	private Statement statement;
	private DbQuery dbQuery;
	private ResultSet resultSet;

	private String tableName;

	public DbInsert(String table) {
		this.tableName = table;

		dbConnect = new DbConnect();
		connection = dbConnect.getConnection();
		
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery("SELECT * FROM " + tableName);
		} catch (SQLException sqle) {
			System.out.println("sql: Failed");
			sqle.printStackTrace();
			System.exit(-1);
		} 

		dbQuery = new DbQuery();
	}

	public void exeInsert(String insertColumn, String insertValue) {

		try {
			System.out.println("\nBEFORE INSERT:");
			dbQuery.printResultSet(resultSet);

			// NOW insert
			// set the cursor to a new record and create a buffer to holder the column values 
			resultSet.moveToInsertRow(); 

			resultSet.updateString(insertColumn, insertValue);
			// takes effect in the DB
			resultSet.insertRow();

			System.out.println("\nAFTER INSERT:");
			dbQuery.printResultSet(resultSet);

		} catch (SQLException sqle) {
			System.out.println("sql: Failed");
			sqle.printStackTrace();
			System.exit(-1);
		} 
	}
	
	public static void main(String[] args) {
		String table = "contact";
		DbInsert dbInsert = new DbInsert(table);
		dbInsert.exeInsert("firstName", "Jasmine");
		dbInsert.exeInsert("firstName", "Lily");
		dbInsert.exeInsert("firstName", "A");
	}

}
