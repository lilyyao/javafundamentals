package designpattern_dao;

// persistence spec
public interface CircleDAO {
   public void insertCircle(CircleTransfer circle);
   public CircleTransfer findCircle(int id);
   public void deleteCircle(int id);
}
