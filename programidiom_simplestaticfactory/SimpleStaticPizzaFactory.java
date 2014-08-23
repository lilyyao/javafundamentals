package programidiom_simplestaticfactory;

import programidiom_simplefactory.CheesePizza;
import programidiom_simplefactory.PepperoniPizza;
import programidiom_simplefactory.Pizza;

public class SimpleStaticPizzaFactory {

   // the create method is static
   // so will not need the factory object
   public static Pizza createPizza(String type) {
      Pizza pizza = null;

      if (type.equals("cheese")) {
         pizza = new CheesePizza();
      } else if (type.equals("pepperoni")) {
         pizza = new PepperoniPizza();
      }

      return pizza;

   }
}
