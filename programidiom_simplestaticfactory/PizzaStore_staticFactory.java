package programidiom_simplestaticfactory;

import programidiom_simplefactory.Pizza;

public class PizzaStore_staticFactory {

      public Pizza OrderPizza(String type) {
         Pizza pizza;

         pizza = SimpleStaticPizzaFactory.createPizza(type);

         pizza.prepare();
         pizza.bake();
         pizza.cut();
         pizza.box();

         return pizza;
      }
   }
