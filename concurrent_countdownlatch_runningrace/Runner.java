package concurrent_countdownlatch_runningrace;

import java.util.concurrent.CountDownLatch;

public class Runner extends Thread {
   private CountDownLatch timer;

   public Runner(CountDownLatch cdl, String name) {
      timer = cdl;
      this.setName(name);
      System.out.println(this.getName() + " ready and waiting for the count down to start");
      start();
   }

   public void run() {
      try {
         // wait for the timer to count down to 0
         timer.await();
      } catch (InterruptedException ie) {
         System.out.println("interrupted -- can't start running the race");
      }
      System.out.println(this.getName() + " start running now ..");
   }
}
