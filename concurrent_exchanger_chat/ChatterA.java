package concurrent_exchanger_chat;

import java.util.concurrent.Exchanger;

public class ChatterA extends Thread {
   private Exchanger<String> chat;

   public ChatterA(Exchanger<String> said) {
      chat = said;
   }

   public void run() {
      String reply = null;

      try {
         // start the conversation with B
         reply = chat.exchange("hello B!");
         // print the response received from B
         System.out.println("B replied: " + reply);

         // exchange another set of talk
         reply = chat.exchange("now what?");
         System.out.println("B replied: " + reply);

         // exchange only happens when both send and receive happens
         // this is the last sentence that spoken
         // close the chat
         // ignore the "dummy" reply
         reply = chat.exchange("bye bye");
      } catch (InterruptedException ie) {
         System.out.println("Got interrupted during my chat");
      }
   }
}
