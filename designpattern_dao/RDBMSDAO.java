package designpattern_dao;

// persistence mechanism
public class RDBMSDAO implements CircleDAO {
   @Override
   public void insertCircle(CircleTransfer circle) {
      // insert implementation
      System.out.println("insertCircle implementation");
   }

   @Override
   public CircleTransfer findCircle(int id) {
      // find implementation
      System.out.println("findCircle implementation");
      return null;
   }

   @Override
   public void deleteCircle(int id) {
      // delete implementation
      System.out.println("deleteCircle implementation");
   }


}
