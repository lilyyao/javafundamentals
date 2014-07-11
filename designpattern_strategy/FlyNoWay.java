package designpattern_strategy;

public class FlyNoWay implements IFlyBehavior {
   public void fly () {
      System.out.println("can't fly without wings");
   }

}
