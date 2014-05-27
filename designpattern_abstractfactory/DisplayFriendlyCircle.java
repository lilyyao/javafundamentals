package designpattern_abstractfactory;

public class DisplayFriendlyCircle implements DisplayFriendlyShape {
   private int xPos, yPos;
   private int radius;

   public DisplayFriendlyCircle(int x, int y, int r) {
      xPos = x;
      yPos = y;
      radius = r;
      System.out.println(this.getClass().getSimpleName() + " constructing..");
   }

   @Override
   public void draw() {
      System.out.println(this.getClass().getSimpleName() + " drawing..");
      // draw implementation
   }

}
