package designpattern_factorymethod;

import programidiom_simplefactory.Pizza;

public class NYStyleCheesePizza extends Pizza {
      public NYStyleCheesePizza() {
         name = "New York Style Cheese Pizza";
         dough = "General Thin";
         sauce = "Marinara sauce";

         toppings.add("Grated Reggiano cheese");
      }

   // optional override
   public void cut() {
      System.out.println("Cutting into square slices");
   }
   }
