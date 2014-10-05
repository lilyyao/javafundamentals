package concurrent_semaphore_atm;

import java.util.concurrent.Semaphore;

/**
 * This class simulates a situation where an ATM room has only 2 ATM machines
 * and there are 5 people waiting to access the machine.
 *
 * Only 1 person can access an ATM machine at a given time, others wait for their turn.
 */
public class ATMTest {
   public static void main (String[] args) {
      Semaphore machines = new Semaphore(2);

      //list of people waiting to access the machine
      new Person(machines, "Alice");
      new Person(machines, "Bob");
      new Person(machines, "Cal");
      new Person(machines, "Dylon");
      new Person(machines, "Emma");

      System.out.println("ATM done");

   }
}
