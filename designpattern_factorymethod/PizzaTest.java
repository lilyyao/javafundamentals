package designpattern_factorymethod;

import programidiom_simplefactory.Pizza;

public class PizzaTest {

   public static void main(String[] args) {
      PizzaStore nyStore = new NYPizzaStore();
      PizzaStore caStore = new CAPizzaStore();

      Pizza pizza = nyStore.orderPizza("pepperoni");
      System.out.println("Nathan ordered a " + pizza.getName() + "\n");

      Pizza pizza1 = caStore.orderPizza("cheese");
      System.out.println("Jasmine ordered a " + pizza1.getName() + "\n");

   }
}
