package jdbcMysql;

public class DbCRUD {

	public static void main(String[] args) {
		DbConnect testConnect = new DbConnect();
		testConnect.getConnection();
		
		//CREATE
		String database = "addressbook";
		String table = "contact";
		DbCreate dbCreate = new DbCreate();
		dbCreate.useDatabase(database);
		dbCreate.exeCreate(table);
		
		//INSERT
		testConnect.getConnection(); //bug??
		DbInsert dbInsert = new DbInsert(table);
		dbInsert.exeInsert("firstName", "Jasmine");
		dbInsert.exeInsert("firstName", "Lily");
		dbInsert.exeInsert("firstName", "A");
		
		//UPDATE
		DbUpdate dbUpdate = new DbUpdate();
		dbUpdate.exeUpdate(table, "firstName", "Lily", "phoneNo", "8888");
		
		//DELETE
		DbDelete dbDelete = new DbDelete(table);
		dbDelete.exeDelete("firstName", "A");	
		
		testConnect.closeConnection();
		
	}
	
}
