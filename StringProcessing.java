import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessing {

   public static void main (String [] args) {

      // String search
      String str = "abc has b in it.";

      System.out.println("Character b first occurs at index: " + str.indexOf('b') );

      System.out.println("substring 'has' first occurs at index: " + str.indexOf("has") );

      int countB = 0;
      int fromIndex = 0;

      while(str.indexOf('b', fromIndex) > -1) {
         fromIndex = str.indexOf('b', fromIndex);
         countB ++;
         fromIndex ++;
      }
      System.out.println("'b' occurs " + countB + " times. ");

      if (str.startsWith("abc") && str.endsWith("it.") )  {
         System.out.println("test string: " + str);
         System.out.println("It starts with 'abc'");
         System.out.println("It ends with 'it.'");
      }

      String matchString = "has";
      int startIndex = str.indexOf(matchString);
      boolean foundMatch = str.regionMatches(true, startIndex, matchString, 0, matchString.length());
      if (foundMatch)  {
         System.out.println("found the match.");
      } else
         System.out.println("No match found?!, something is wrong..");


      // String parsing

      // right way to convert from an integer to String
      String str1 = String.valueOf(10);
      // right way to convert from String to int
      int i = Integer.parseInt("10");
      // numberFormatException will be thrown for the following
      //float f = Float.parseFloat("not parsable to float");


      //split() method
      String st = "Never say never";
      String[] words = st.split(" ");
      for (String word : words) {
         System.out.println(word);
      }


      //regex
      String s = "somebody somewhere zip:12345, phone:1234567890, email: a@b.com";
      // \\b for word boundary
      Pattern pattern = Pattern.compile("\\b\\d{5}\\b");
      Matcher matcher = pattern.matcher(s);
      while (matcher.find()) {
         System.out.println("5-digit zipcode: " + matcher.group());
      }

      pattern = Pattern.compile("\\w+@\\w+\\.com");
      matcher = pattern.matcher(s);
      while (matcher.find()) {
         System.out.println("email: " + matcher.group());
      }

      // replace
      pattern = Pattern.compile("(\\D)(\\d{3})(\\d{7})(\\D)");
      matcher = pattern.matcher(s);
      //$1 back refer to the first group
      String newStr =  matcher.replaceAll("$1$2-$3$4");
      System.out.println("inserted a dash after the third digit of the phone: " + newStr);


      // String formatting
      int radius = 5;
      double area = Math.PI * radius * radius;
      System.out.println("Circle area using default formatting with println: " + area);
      System.out.printf("Circle area using format specifier with printf: %.2f", area);

   }

}
