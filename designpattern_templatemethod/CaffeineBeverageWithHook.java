package designpattern_templatemethod;

public abstract class CaffeineBeverageWithHook {
      final void prepareRecipe() {
         boilWater();
         brew();
         pourInCup();
         if (customerWantsCondiments() ) {
            addCondiments();
         }
      }

   abstract void brew();

   abstract void addCondiments();

   void boilWater() {
      System.out.println("Boiling water");
   }

   void pourInCup() {
      System.out.println("Pouring into cup");
   }

   // This is a hook because the subclass can override this method but doesn't have to.
   // mostly empty default implementation
   boolean customerWantsCondiments() {
      return true;
   }

}
