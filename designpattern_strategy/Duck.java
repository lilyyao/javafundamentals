package designpattern_strategy;

// From <<Head First Design Patterns>>
public abstract class Duck {

   // something will do that behavior
   IFlyBehavior flyBehavior;

   // delegate that 'BEHAVIOR' to the object referenced
   public void doFly() {
      flyBehavior.fly();
   }

   public abstract void display();

   public void setFlyBehavior(IFlyBehavior fb) {
      flyBehavior = fb;
   }

   public void swim() {
      System.out.println("All ducks can swim!");
   }
}
