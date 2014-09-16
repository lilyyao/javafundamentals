package thread_coffeeshop_wait_notify;

public class Waiter extends Thread {
   public void getCoffee() {
      synchronized (CoffeeMachine.lock) {

         // no coffee yet
         if (CoffeeMachine.coffeeMade == null) {
            try {
               //wait until coffee machine notifies that coffee is ready
               System.out.println("Waiter: will get coffee when coffee machine notifies done");
               CoffeeMachine.lock.wait();
            }
            catch (InterruptedException ie) {
               // OK to ignore
               ie.printStackTrace();
            }
         }

         //delivering coffee
         System.out.println("Waiter: Delivering " + CoffeeMachine.coffeeMade);
         CoffeeMachine.coffeeMade = null;  // clear the variable, no more coffee

         //ask(notify) the coffee machine to prepare the next coffee
         CoffeeMachine.lock.notifyAll();
         System.out.println("Waiter: Notifying coffee machine to make another one");
      }
   }

   public void run() {
      //keep going until the user presses ctl-C and terminates the program
      while(true) {
         getCoffee();
      }
   }

}
