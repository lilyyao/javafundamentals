import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IteratorPalindrome {
   public static void main (String[] args) {
      List<String> myList = new ArrayList<>();
      myList.add("C");
      myList.add("C++");
      myList.add("java");

      for (String language : myList) {
         System.out.println(language);
      }

      // Using Iterator
      for (Iterator<String> myIter = myList.iterator(); myIter.hasNext();) {
         String language = myIter.next();
         System.out.println("Iterator can do the same: " + language);
      }

      List<Integer> nums = new ArrayList<>();
      for (int i = 1; i < 10; i++) {
         nums.add(i);
      }
         System.out.println("\nOriginal list " + nums);

         Iterator<Integer> numsIter = nums.iterator();
         while (numsIter.hasNext()) {
            numsIter.next();
            numsIter.remove();
         }
         System.out.println("*** List after removing all elements " + nums);

      String palStr = "abcba";
      List<Character> palindrome = new LinkedList<>();
      for (char ch : palStr.toCharArray()) {
         palindrome.add(ch);
      }
      System.out.println("\n\nInput string is: " + palStr);

      // Using ListIterator
      ListIterator<Character> iterator = palindrome.listIterator();
      ListIterator<Character> revIterator = palindrome.listIterator(palindrome.size());

      boolean result = true;
      while (revIterator.hasPrevious() && iterator.hasNext()) {
         if(iterator.next() != revIterator.previous()) {
            result = false;
            break;
         }
      }

      if (result) {
         System.out.println("The given string is a palindrome");
      } else {
         System.out.println("The given string is NOT a palindrome");
      }


   }


}
