package thread_racecondition;

public class UseCounter implements Runnable {
   public void increment() {
      synchronized (this)
      {                         //critical section
         Counter.count++;               //write
         System.out.println(Counter.count + " ");  //read
      }
   }

   public void run() {
      increment();
      increment();
      increment();
   }

}
