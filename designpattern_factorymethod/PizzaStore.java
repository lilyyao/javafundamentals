package designpattern_factorymethod;

import programidiom_simplefactory.Pizza;

/**
 * Factory Method is a framework
 *
 * It has 2 parallel class hierarchies: The 'Creator' classes and the 'Product' classes.
 *
 * The key: Let the subclasses decide what objects to create.
 *
 */

/**
 * The creator class is abstract.
 * It defines an abstract factory method that the subclasses implement to produce products.
 * It contains other code depends on an abstract product.
 *
 * ABSTRACT is not mandanted -
 * When there is no subclass of the creator, the method can provide default concrete product.
 */


// it is ABSTRACT for creation method
public abstract class PizzaStore {
   public Pizza orderPizza(String type) {
      Pizza pizza;

      // a method of the store, not the factory object
      pizza = createPizza(type);

      pizza.prepare();
      pizza.bake();
      pizza.cut();
      pizza.box();

      return pizza;   }

   /**
    *
    * a method acts like a factory. It is ABSTRACT in the superclass.
    *
    * @param type  parameterized to select among several variations
    * @return  it returns the product created
    */
   //
   //
   // @return

   protected abstract Pizza createPizza(String type);

}
