package designpattern_decorator;

public class HouseBlend extends Beverage {
   public HouseBlend() {
      description = "House Blend Coffee";
   }

   // this is the pure cost of the coffe itself
   public double cost() {
      return 1.0;
   }
}
