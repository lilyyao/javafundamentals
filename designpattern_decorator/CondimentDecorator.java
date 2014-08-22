package designpattern_decorator;

// This class needs to be interchangeable with a Beverage,
// so it extends the Beverage class.
public abstract class CondimentDecorator extends Beverage {

   //this method is implemented in Beverage
   //now demands reimplmentation
   public abstract String getDescription();
}
