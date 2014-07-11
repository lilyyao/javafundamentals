package designpattern_strategy;

public class DuckTest {
   public static void main(String[] args) {
      Duck mallard = new MallardDuck();
      mallard.display();
      mallard.doFly();

      Duck model = new ModelDuck();
      model.display();
      model.doFly();
      model.swim();

      model.setFlyBehavior(new FlyRocketPowered());
      model.display();
      model.doFly();
   }
}
