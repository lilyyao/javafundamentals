package designpattern_decorator;

// Mocha is a decorator
public class Mocha extends CondimentDecorator {

   // Instance variable to hold the beverage we are wrapping
   Beverage beverage;

   // Set the object being wrapped
   public Mocha(Beverage beverage) {
      this.beverage = beverage;
   }

   // decorating the description
   public String getDescription() {
      return beverage.getDescription() + ", Mocha";
   }

   // delegate the call to the object being decorated
   public double cost() {
      return .20 + beverage.cost();
   }

}
