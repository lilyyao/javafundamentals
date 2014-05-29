package designpattern_dao;

// different data source
public class DAOFactory {
   public static CircleDAO getCircleDAO(String sourceType) {
      // can be RDBMS. XML db, other system/repo
      switch (sourceType) {
      case "RDBMS":
            return new RDBMSDAO();
      }

      return null;
   }

}
