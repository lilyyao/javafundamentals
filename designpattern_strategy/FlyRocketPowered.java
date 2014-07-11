package designpattern_strategy;

public class FlyRocketPowered implements IFlyBehavior {
   public void fly() {
      System.out.println("I'm flying by a rocket!");
   }
}
