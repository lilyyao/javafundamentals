package jdbcMysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbQuery {

	private String queryStr;
	
	private DbConnect dbConnect;
	private Connection connection;

	private String defaultTable = "contact";
	private String defaultQuery = "SELECT * FROM " + defaultTable;
	
	public DbQuery() {}
	
	public DbQuery(String inStr) {

		dbConnect = new DbConnect();
		connection = dbConnect.getConnection();
		
		this.queryStr = inStr;

		if (this.queryStr == null) {
			this.queryStr = defaultQuery;
		}
	}

	public ResultSet exeQuery() {

		try {

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(queryStr);
					
			if (defaultQuery.equals(queryStr)) {
				// This assumes the table structure and data type is known and
				// fixed.
				System.out.println("ID \tfName \tlName \temail \t\tphoneNo");
				while (resultSet.next()) {
					System.out.println(resultSet.getInt("id") + "\t"
							+ resultSet.getString("firstName") + "\t"
							+ resultSet.getString("lastName") + "\t"
							+ resultSet.getString("email") + "\t"
							+ resultSet.getString("phoneNo"));
				}
				
			} else {
				// This reads a table regardless of its structure and data type.
				System.out.println("\n\n****Dynamic Read a table - get its count and each column****");
				printResultSet(resultSet);
			} 
			
			return resultSet;

		} catch (SQLException sqle) {
			System.out.println("sql: Failed");
			sqle.printStackTrace();
			System.exit(-1);
			return null;
		} finally {
			dbConnect.closeConnection();
		}
	}

	public void printResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
			resultSet.beforeFirst();
			int numOfColumns = resultSet.getMetaData().getColumnCount();
			while (resultSet.next()) {
				for (int i = 1; i <= numOfColumns; i++) {
					System.out.print(resultSet.getObject(i) + "\t");
				}
				System.out.print("\n");
			}
			} catch (SQLException sqle) {
				System.out.println("sql: Failed");
				sqle.printStackTrace();
				System.exit(-1);
			} 
			
		}
	}
	
	public static void main(String[] args) {
			
		DbQuery dbQuery = new DbQuery(null);
		dbQuery.exeQuery();
		
	}
	
}
