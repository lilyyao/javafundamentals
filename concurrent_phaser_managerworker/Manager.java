package concurrent_phaser_managerworker;

import java.util.concurrent.Phaser;

/**
 * master thread to overlook workers are doing their part of the work
 *
 * SYNC BEFORE START to the work
 */
public class Manager {
   public static void main(String[] args) throws InterruptedException {
      // Phaser is the synchronizer to make task items one-by-one,
      // and deliver it before moving to the next item
      int numOfStory = 5;
      int numOfWorker = 3;

      // number of thread to arrive to advance to the next stage
      // default is 0
      Phaser story = new Phaser(1);
      System.out.println("Starting to work");

      // workers to work on the story
      for (int i = 1; i<= numOfWorker; i++) {
         new Worker(story, "worker" + i);
      }

      for (int i = 1; i <= numOfStory; i++) {
         // prepare
         // arrive at the phaser and waits until other threads arrive
         story.arriveAndAwaitAdvance();
         System.out.println("Deliver story# " + i);
      }

      // work completed for this story, so deregister
      story.arriveAndDeregister();
      System.out.println("story completed.");
   }
}
