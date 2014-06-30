package Collections;

import java.util.Deque;
import java.util.ArrayDeque;

public class DequeDemo {
   private Deque<String> q = new ArrayDeque<>();

   void addInQueue(String customer) {
      q.addLast(customer);
   }

   void removeFront() {
      q.removeFirst();
   }

   void removeBack() {
      q.removeLast();
   }

   void printQueue() {
      System.out.println("Queue contains: " + q);
   }
}


class DequeTest {
   public static void main (String [] args) {
      DequeDemo dequeDemo = new DequeDemo();
      dequeDemo.addInQueue("Alice");
      dequeDemo.addInQueue("Bob");
      dequeDemo.addInQueue("Clair");
      dequeDemo.addInQueue("David");

      dequeDemo.printQueue();

      dequeDemo.removeFront();
      dequeDemo.removeBack();

      dequeDemo.printQueue();
   }
}