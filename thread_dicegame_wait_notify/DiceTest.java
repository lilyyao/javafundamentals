package thread_dicegame_wait_notify;

public class DiceTest {

   public static void main (String [] args) {
      Player player1 = new Player(Gamers.JANE);
      Player player2 = new Player(Gamers.JOE);

      // set who to start the game
      Dice.setWhoStarts(Gamers.JOE);

      player1.start();
      player2.start();
   }
}
