package programidiom_simplefactory;

public class PizzaStore {
   //In simple factory, the factory is another object composed within
   SimplePizzaFactory factory;

   public PizzaStore(SimplePizzaFactory factory) {
      this.factory = factory;
   }

   public Pizza OrderPizza(String type) {
      Pizza pizza;

      pizza = factory.createPizza(type);

      pizza.prepare();
      pizza.bake();
      pizza.cut();
      pizza.box();

      return pizza;
   }
}
