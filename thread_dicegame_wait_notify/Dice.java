package thread_dicegame_wait_notify;

import java.util.Random;

public class Dice {
   // to remember whose turn it is to roll the dice
   private static String turn = null;
   synchronized public static String getTurn() { return turn;}
   synchronized public static void setTurn(String player) { turn = player;}

   // which player starts the game
   public static void setWhoStarts(String name) { turn = name;}

   // private to prevent instantiating the class with only static members
   private Dice() {}

   // when we roll the dice, it should give a random result
   private static Random random = new Random();
   // random.nextInt(6) gives values from 0 to 5, so add 1 to result
   public static int roll() {return random.nextInt(6)+1;}

}
