package concurrent_phaser_managerworker;

import java.util.concurrent.Phaser;

/**
 * workers work independently
 * each complete their part
 */
public class Worker extends Thread {
   int numOfStory = 5;
   Phaser story;

   // worker register themselves to the Phaser object
   Worker(Phaser story, String name) {
      this.story = story;
      this.setName(name);
      this.story.register();
      start();
   }

   public void run() {
      for (int i = 1; i <= numOfStory; i++) {
         System.out.println("\t" + getName() + " doing working for story#" + i);
         if (i == numOfStory) {
            //work completed
            story.arriveAndDeregister();
         } else {
            story.arriveAndAwaitAdvance();
         }
         try {
            Thread.sleep(1000); // simulate the time for doing the work
         } catch (InterruptedException ie) {
            // ignore the exception
            ie.printStackTrace();
         }
      }
   }
}
