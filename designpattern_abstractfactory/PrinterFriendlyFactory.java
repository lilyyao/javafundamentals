package designpattern_abstractfactory;

public class PrinterFriendlyFactory implements ShapeFactory{

   @Override
   public Shape getShape(ShapeType t) {
      switch(t) {
         case CIRCLE:
            return new PrinterFriendlyCircle(10,10,20);
         case RECTANGLE:
            return new PrinterFriendlyRectangle(10,20);
      }
      return null;
   }
}
