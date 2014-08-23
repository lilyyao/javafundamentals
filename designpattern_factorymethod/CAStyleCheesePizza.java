package designpattern_factorymethod;

import programidiom_simplefactory.Pizza;

//All products must implement the same interface.
//So the classes which use the products can refer to the interface, not the concrete class.
public class CAStyleCheesePizza extends Pizza {
   public CAStyleCheesePizza() {
      name = "California Style Cheese Pizza";
      dough = "Thin like cisceros";
      sauce = "Little good sauce";

      toppings.add("Parmaron cheese");
   }
}
