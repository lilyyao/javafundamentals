package designpattern_factorymethod;

import programidiom_simplefactory.Pizza;

public class NYStylePepperoniPizza extends Pizza {
      public NYStylePepperoniPizza() {
         name = "New York Style Pepperoni Pizza";
         dough = "Thin like cisceros";
         sauce = "Little good sauce";

         toppings.add("Parmaron cheese");
      }
   }
