package designpattern_decorator;

//Whip is a decorator
public class Whip extends CondimentDecorator {

   // Instance variable to hold the beverage we are wrapping
   Beverage beverage;

   // Set the object being wrapped
   public Whip(Beverage beverage) {
      this.beverage = beverage;
   }

   // decorating the description
   public String getDescription() {
      return beverage.getDescription() + ", Whip";
   }

   // delegate the call to the object being decorated
   public double cost() {
      return .05 + beverage.cost();
   }

}