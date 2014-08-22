package designpattern_decorator;

public abstract class Beverage {
   String description = "Unknown Beverage - abstract";

   public String getDescription() {
      return description;
   }

   public abstract double cost();
}
