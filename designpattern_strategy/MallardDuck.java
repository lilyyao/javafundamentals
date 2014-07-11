package designpattern_strategy;

public class MallardDuck extends Duck {
   public MallardDuck() {
      flyBehavior = new FlyWithWings();
   }

   public void display() {
      System.out.println("\nI'm a Mallard duck");
   }
}
