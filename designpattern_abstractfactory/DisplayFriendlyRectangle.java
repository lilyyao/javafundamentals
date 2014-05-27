package designpattern_abstractfactory;

public class DisplayFriendlyRectangle implements DisplayFriendlyShape {
   private int length, height;

   public DisplayFriendlyRectangle(int l, int h) {
      length = l;
      height = h;
      System.out.println(this.getClass().getSimpleName() + " constructing..");
   }

   public void draw() {
      System.out.println(this.getClass().getSimpleName() + " drawing..");
      // draw implementation
   }
}
