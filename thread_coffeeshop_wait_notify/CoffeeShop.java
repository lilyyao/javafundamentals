package thread_coffeeshop_wait_notify;

/**
 * 2 thread: 1 for the CoffeeMachine 1 for the Waiter
 *
 * They interact with each other through wait/notify
 * Until Ctl-C to terminate the application
 */
public class CoffeeShop {

   public static void main(String[] args) {
      CoffeeMachine coffeeMachine = new CoffeeMachine();
      Waiter waiter = new Waiter();

      coffeeMachine.start();
      waiter.start();
   }

}
