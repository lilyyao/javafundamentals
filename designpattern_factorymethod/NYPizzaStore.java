package designpattern_factorymethod;

import programidiom_simplefactory.Pizza;

// concrete creator
public class NYPizzaStore extends PizzaStore {
   // The factory method is implemented in the subclass
   public Pizza createPizza(String type) {
      if (type.equals("cheese")) {
         return new NYStyleCheesePizza();
      } else if (type.equals("pepperoni")) {
         return new NYStylePepperoniPizza();
      } else return null;
   }
}
