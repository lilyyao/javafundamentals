package designpattern_factorymethod;

import programidiom_simplefactory.Pizza;

public class CAStylePepperoniPizza extends Pizza {
      public CAStylePepperoniPizza() {
         name = "California Style Pepperoni Pizza";
         dough = "Thin like cisceros";
         sauce = "Little good sauce";

         toppings.add("Parmaron cheese");
      }
   }
