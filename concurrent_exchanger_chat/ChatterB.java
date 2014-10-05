package concurrent_exchanger_chat;

import java.util.concurrent.Exchanger;

public class ChatterB extends Thread {
   private Exchanger<String> chat;

   public ChatterB(Exchanger<String> said) {
      chat = said;
   }

   public void run() {
      String reply = null;

      try {
         // start the conversation with B
         reply = chat.exchange("Hello A!");
         // print the response received from B
         System.out.println("A replied: " + reply);

         // exchange another set of talk
         reply = chat.exchange("play");
         System.out.println("A replied: " + reply);

         // exchange only happens when both send and receive happens
         // to get the bye, need to send a 'dummy' string
         reply = chat.exchange("");
         System.out.println("A replied: " + reply);
      } catch (InterruptedException ie) {
         System.out.println("Got interrupted during my chat");
      }
   }
}
