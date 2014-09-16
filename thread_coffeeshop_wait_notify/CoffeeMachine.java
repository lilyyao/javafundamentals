package thread_coffeeshop_wait_notify;

public class CoffeeMachine extends Thread {
   static String coffeeMade = null;
   static final Object lock = new Object();    // lock can be an object
   private static int coffeeNumber = 1;
   void makeCoffee() {
      synchronized (CoffeeMachine.lock) {

         //done making, waiting for the coffee to be picked up
         if (coffeeMade != null) {
            try {
               System.out.println("Coffee machine: waiting for waiter's request");
               CoffeeMachine.lock.wait();
            }
            catch (InterruptedException ie) {
               ie.printStackTrace();
            }
         }

         //making coffee
         coffeeMade = "Coffee No. " + coffeeNumber ++;
         System.out.println("Coffee machine: Made " + coffeeMade);
         //coffee is ready, notify the waiter to pick it up
         CoffeeMachine.lock.notifyAll();
         System.out.println("Coffee machine: Notifying waiter to pick the coffee");
      }
   }

   public void run() {
      while(true) {
         makeCoffee();
         try {
            System.out.println("Coffee machineL Making another coffee now");
            // simulate the time taken to make a coffee by calling sleep method
            Thread.sleep(10000);
         }
         catch (InterruptedException ie) {
            // OK to ignore
            ie.printStackTrace();
         }
      }
   }
}
