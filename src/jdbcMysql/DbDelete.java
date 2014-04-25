package jdbcMysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDelete {

		private DbConnect dbConnect;
		private Connection connection;
		private Statement statement;
		private DbQuery dbQuery;
		private ResultSet resultSet;

		private String tableName;

		public DbDelete(String table) {
			this.tableName = table;

			dbConnect = new DbConnect();
			connection = dbConnect.getConnection();
			
			try {
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
			} catch (SQLException sqle) {
				System.out.println("sql: Failed");
				sqle.printStackTrace();
				System.exit(-1);
			} 

			dbQuery = new DbQuery();
		}

		public void exeDelete(String filterColumnName, String filterValue) {

			try {
				ResultSet resultSet = statement.executeQuery("SELECT * FROM "
						+ tableName + " WHERE " + filterColumnName + "= \""
						+ filterValue + "\"");
				System.out.println("\nBEFORE DELETE:");
				dbQuery.printResultSet(resultSet);

				// NOW delete
				resultSet.beforeFirst();
				while ( resultSet.next() ) {
					resultSet.deleteRow();
				}
				resultSet.close();
				
				System.out.println("\nAFTER DELETE:");
				ResultSet resultSet2 = statement.executeQuery("SELECT * FROM " + tableName);
				dbQuery.printResultSet(resultSet2);

			} catch (SQLException sqle) {
				System.out.println("sql: Failed");
				sqle.printStackTrace();
				System.exit(-1);
			} finally {
				dbConnect.closeConnection();
			}
		}
		
		public static void main(String[] args) {
			String table = "contact";
			DbDelete dbDelete = new DbDelete(table);
			dbDelete.exeDelete("firstName", "Jasmine");
		}
	}

