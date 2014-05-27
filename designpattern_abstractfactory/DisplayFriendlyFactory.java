package designpattern_abstractfactory;

public class DisplayFriendlyFactory implements ShapeFactory{

   @Override
   public Shape getShape(ShapeType t) {
      switch(t) {
      case CIRCLE:
         return new DisplayFriendlyCircle(10,10,20);
      case RECTANGLE:
         return new DisplayFriendlyRectangle(10,20);
      }
      return null;
   }
}
