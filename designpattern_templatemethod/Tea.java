package designpattern_templatemethod;

public class Tea extends CaffeineBeverageWithHook {
   public void brew() {
      System.out.println("Steeping the tea");
   }
   public void addCondiments() {
      System.out.println("Adding Lemon");
   }
}
