package thread_racecondition;

/**
 * Thread share memory, and they can concurrently modify data.
 *
 * Data Race = Race Condition = Race Hazard
 */
public class DataRace {
   public static void main(String[] args) {
      UseCounter c = new UseCounter();
      Thread t1 = new Thread(c);
      Thread t2 = new Thread(c);
      Thread t3 = new Thread(c);
      Thread t4 = new Thread(c);

      t1.start();
      t2.start();
      t3.start();
      t4.start();
   }
}
