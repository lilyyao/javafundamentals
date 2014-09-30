package thread_dicegame_wait_notify;

public class Player extends Thread {
   private String currentPlayer = null;
   private String otherPlayer = null;

   public Player(String thisPlayer) {
      currentPlayer = thisPlayer;
      // there are 2 players in total
      otherPlayer = thisPlayer.equals(Gamers.JOE) ? Gamers.JANE : Gamers.JOE;
   }

   public void run() {
      // each player rolls the dice 5 times in the game
      for (int i = 0; i<6; i++) {
         // acquire the lock first
         synchronized (Dice.class) {
            // if it is not the current player's turn, then wait for the notification
            while (!Dice.getTurn().equals(currentPlayer)) {
               try {
                  Dice.class.wait(1000);
                  System.out.println(currentPlayer + " is waiting for " + otherPlayer + "..\n");
               } catch (InterruptedException ie) {
                  ie.printStackTrace();
               }
            }

            // it's current player's turn, so throw the dice to play
            System.out.println(Dice.getTurn() + " throws and gets " + Dice.roll());
            // set the turn to otherPlayer, and notify the other player
            Dice.setTurn(otherPlayer);
            Dice.class.notifyAll();
         }
      }
   }
}
