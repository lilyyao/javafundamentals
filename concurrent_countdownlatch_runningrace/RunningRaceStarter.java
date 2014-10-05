package concurrent_countdownlatch_runningrace;

import java.util.concurrent.CountDownLatch;

/**
 * this class simulates the start of a running race by counting down from 5.
 * It holds 3 runner threads to be ready to start in the start line of the race.
 * Once the count down reaches zero, all the three runners start running..
 */
public class RunningRaceStarter {
   public static void main(String[] args) throws InterruptedException {
      // count from 5 to 0 then start the race
      CountDownLatch counter = new CountDownLatch(5);

      // instantiate three runner threads
      new Runner(counter, "Jane");
      new Runner(counter, "John");
      new Runner(counter, "Jason");

      System.out.println("Starting the countdown");
      long countVal = counter.getCount();
      while (countVal > 0) {
         Thread.sleep(1000);  // 1000 milliseconds = 1 second
         System.out.println(countVal);

         if (countVal == 1) {
            // next one will be zero; so say "start"
            Thread.sleep(1000);
            System.out.println("Start");
         }
         //count down by 1
         counter.countDown();
         countVal = counter.getCount();
      }
   }
}
