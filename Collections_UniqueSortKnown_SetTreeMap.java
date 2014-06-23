import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;

public class Collections_UniqueSortKnown_SetTreeMap {
   public static void main(String[] args) {
      String tongueTwister = "I feel, a feel, a special feel, a special feel I feel, " +
            "if you feel the feel I feel, I feel the feel you feel, ahem.";

      Set<String> words = new HashSet<>();
      Set<Character> chars = new TreeSet<>();
      Map<String, String> misspeltWords = new HashMap<>();
      misspeltWords.put("ahem", "aham");

      // split the sentence into words by non-word characters,
      // and putting them in the set to DEDUP.
      for(String word: tongueTwister.split("\\W+")) {
         // use the map to do spell check
         if(misspeltWords.containsKey(word)) {
            System.out.println("The correct spelling for " + word
                  + " is: " + misspeltWords.get(word) );
         }
         words.add(word);

         //convert the word into characters
         for(char c: word.toCharArray())
            chars.add(c);

      }

      System.out.println("The original tongueTwister is: " + tongueTwister);
      System.out.println("The unique words in the phrase are: " + words);
      System.out.println("The alphabets in the phrase are: " + chars);




   }
}
