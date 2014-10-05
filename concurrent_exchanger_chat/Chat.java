package concurrent_exchanger_chat;

import java.util.concurrent.Exchanger;

/**
 * Exchanger helps coordinate(synchronize) exchanging messages between two threads.
 * Both the threads wait for each other and use the exchange() method to exchange message.
 */
public class Chat {
   public static void main(String[] args) {
      Exchanger<String> chat = new Exchanger<>();
      new ChatterA(chat).start();
      new ChatterB(chat).start();
   }
}
