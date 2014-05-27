package designpattern_abstractfactory;

public class Test {
   public static void main (String[] args) {
      Canvas canvas = new Canvas();
      canvas.addNewShape(ShapeType.CIRCLE, FriendType.DISPLAY);
      canvas.addNewShape(ShapeType.RECTANGLE, FriendType.PRINTER);
      canvas.redraw();
   }
}
