package programidiom_simplefactory;

import java.util.ArrayList;
import java.util.List;

//Product class
public abstract class Pizza {
   public String name;
   public String dough;
   public String sauce;
   public List<String> toppings = new ArrayList<>();

   public void prepare() {
      System.out.println("Preparing " + name);
      System.out.println("Tossing dough...");
      System.out.println("Adding sauce...");
      System.out.println("Adding toppings: ");
      for (int i = 0; i < toppings.size(); i++) {
         System.out.println("  " + toppings.get(i));
      }
   }

   public void bake() {
      System.out.println("Bake for 25 minutes");
   }

   public void cut() {
      System.out.println("Cut into diagonal slices");
   }

   public void box() {
      System.out.println("Put into branded box");
   }

   public String getName() {
      return name;
   }

}
