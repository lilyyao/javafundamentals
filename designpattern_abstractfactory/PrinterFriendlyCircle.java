package designpattern_abstractfactory;

public class PrinterFriendlyCircle implements DisplayFriendlyShape {
   private int xPos, yPos;
   private int radius;

   public PrinterFriendlyCircle(int x, int y, int r) {
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
