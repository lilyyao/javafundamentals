package designpattern_factorymethod;

import programidiom_simplefactory.Pizza;

// concrete creator
public class CAPizzaStore extends PizzaStore {
   // The factory method is implemented in the subclass
      public Pizza createPizza(String type) {
         if (type.equals("cheese")) {
            return new CAStyleCheesePizza();
         } else if (type.equals("pepperoni")) {
            return new CAStylePepperoniPizza();
         } else return null;
      }
   }
