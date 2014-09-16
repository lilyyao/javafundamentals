package thread;

public class ThreadCountDownWithJoin extends Thread {
   String[] timeStr = { "one", "two", "three"};

   public void run() {
      for (int i = 2; i>=0; i--) {
         try {
            System.out.println(timeStr[i]);
            Thread.sleep(1000);
         } catch (InterruptedException ie) {
            ie.printStackTrace();
         }

      }
   }

   public static void main(String[] args) {
      ThreadCountDownWithJoin timer = new ThreadCountDownWithJoin();
      System.out.println("Starting count down..");
      timer.start();
      try {
         timer.join();       // the main method will wait
      }
      catch (InterruptedException ie) {
         ie.printStackTrace();
      }

      System.out.println("Boom!!");
   }
}
