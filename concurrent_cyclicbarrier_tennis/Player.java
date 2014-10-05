package concurrent_cyclicbarrier_tennis;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Player extends Thread {
   CyclicBarrier waitPoint;

   public Player (CyclicBarrier barrier, String name) {
      this.setName(name);
      waitPoint = barrier;
      this.start();
   }

   public void run() {
      System.out.println("Player " + getName() + " is ready");
      try {
         waitPoint.await(); // wait for all players to arrive
      } catch (BrokenBarrierException | InterruptedException e) {
         System.out.println("exception occurred while waiting .." + e);
      }
   }
}
