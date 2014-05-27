package designpattern_abstractfactory;

public class PrinterFriendlyRectangle implements DisplayFriendlyShape {
   private int xPos, yPos;

   public PrinterFriendlyRectangle(int x, int y) {
      xPos = x;
      yPos = y;
      System.out.println(this.getClass().getSimpleName() + " constructing..");
   }

   @Override
   public void draw() {
      System.out.println(this.getClass().getSimpleName() + " drawing..");
      // draw implementation
   }

}