package jdbcMysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCreate {

	private DbConnect dbConnect;
	private Connection connection;
	private Statement statement;
	private DbQuery dbQuery;
	private ResultSet resultSet;

	public DbCreate() {
		dbConnect = new DbConnect();
		connection = dbConnect.getConnection();
		dbQuery = new DbQuery();
	}
	
	public void useDatabase(String database) {
		
    	String str = "use " + database;	

		try (Statement statement = connection.createStatement() ){		
			statement.executeUpdate(str);
		} catch (SQLException sqle) {
			System.out.println("sql: Failed " + str);
            	sqle.printStackTrace();
		} 	
		
		System.out.println ("use database " + database + " successful.");
	}
	
	public void exeCreate(String tableName) {
		String str = null;
		try (Statement statement = connection.createStatement() ){		
			str = "CREATE TABLE " + tableName +
					"(id int not null auto_increment, firstName varchar(30) Not null, " +
					"lastName varChar(30), email varchar(30), phoneNo varchar(13)," +
					"primary key (id) );";
			
			statement.executeUpdate(str);
		} catch (SQLException sqle) {
			System.out.println("sql: Failed " + str);
			String tableExist = "Table '" + tableName + "' already exists";
            if (tableExist.equals(sqle.getMessage())) {
    			System.out.println(tableExist + ". Drop first");
            	exeDrop(tableName);
            } else {
    			System.out.println("not execute drop table" + tableName);
    			System.out.println(tableExist);
    			System.out.println("message: " + sqle.getMessage());
            	sqle.printStackTrace();
            	System.exit(-1);
            }
		} 		
	}
	
	public void exeDrop(String tableName) {
		
    	String str = "DROP TABLE " + tableName;	

		try (Statement statement = connection.createStatement() ){		
			statement.executeUpdate(str);
		} catch (SQLException sqle) {
			System.out.println("sql: Failed " + str);
            	sqle.printStackTrace();
		} 				
	}
		
	public static void main(String[] args) {
		String database = "addressbook";
		String table = "contact";
		
		DbCreate dbCreate = new DbCreate();
		dbCreate.useDatabase(database);
		dbCreate.exeCreate(table);
	}

}
