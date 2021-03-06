package Collections;

import java.util.HashSet;
import java.util.Set;

public class CircleHashCode {
   private int xPos, yPos, radius;

   public CircleHashCode(int x, int y, int r) {
      xPos = x;
      yPos = y;
      radius = r;
   }

   public boolean equals(Object arg) {
      if (arg == null ) return false;

      if (this == arg) return true;

      if (arg instanceof CircleHashCode) {
         CircleHashCode that = (CircleHashCode) arg;
         if ( ( this.xPos == that.xPos) && (this.yPos == that.yPos) &&
               (this.radius == that.radius)) {
            return true;
         }
      }

      return false;
   }

   public int hashCode() {
      // use bit-manipulation operator such as ^ to generate close to unique hash codes
      // using magic prime numbers 7, 11, and 53 here

      return (7*xPos) ^ (11 * yPos) ^ (53 * radius);
   }

}

class TestCircle {
   public static void main(String[] args) {
      Set<CircleHashCode> circleSet = new HashSet<>();
      circleSet.add(new CircleHashCode(10,20,5));

      //contains() using hashCode()
      // - if no such method, return false
      // - if has such method, return true
      System.out.println(circleSet.contains(new CircleHashCode(10,20,5)));
   }
}
