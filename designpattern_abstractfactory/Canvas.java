package designpattern_abstractfactory;

import java.util.ArrayList;
import java.util.Iterator;

public class Canvas {
   private ArrayList<Shape> shapelist = new ArrayList<>();

   public void addNewShape(ShapeType shp, FriendType friend) {
      ShapeFactory sf = null;

      switch(friend) {
         case DISPLAY:
            sf = new DisplayFriendlyFactory();
            break;
         case PRINTER:
            sf = new PrinterFriendlyFactory();

      }

      if (sf != null) {
        Shape shape = sf.getShape(shp);
        shapelist.add(shape);
      } else {
         System.out.println("not a supported friend type for " + friend );
      }

   }

   public void redraw() {
      Iterator<Shape> itr = shapelist.iterator();
      while (itr.hasNext()) {
         Shape shape = itr.next();
         shape.draw();
      }
   }


}
