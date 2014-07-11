package designpattern_strategy;

public class ModelDuck extends Duck {
   public ModelDuck() {
    flyBehavior = new FlyNoWay();
   }

   public void display() {
      System.out.println("\nI am a model duck");
   }
}
