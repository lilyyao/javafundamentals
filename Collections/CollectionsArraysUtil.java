package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsArraysUtil {
   public static void main (String[] args) {
      String [] strArr = { "21", "1", "111", "12", "123"};

      //String does lexicographic char-by-char comparison
      Arrays.sort(strArr);
      System.out.println("Array sorted as String: " +  Arrays.toString(strArr));
      // binarySearch takes a sorted array
      int idx = Arrays.binarySearch(strArr, "123");
      // index starts at 0
      System.out.println("The index from binary search returns: " + idx);


      int [] intArray = {21, 1, 111, 12, 123};
      // int does value comparison
      Arrays.sort(intArray);
      System.out.println("Array sorted as int: " + Arrays.toString(intArray));

      //convert from int array to integer array
      //Integer[] newArray = ArrayUtils.toObject(oldArray);
      Integer[] integerArray = new Integer[intArray.length];
      int i = 0;
      for (int value : intArray) {
         integerArray[i++] = Integer.valueOf(value);
      }

      //using the max() and min() of Collections
      List<Integer> nums = Arrays.asList(integerArray);
      int max = Collections.max(nums);
      int min = Collections.min(nums);
      System.out.println("For the given int array, max: " + max + " min: " + min);

      //can mod, can not add the List from asList()
      System.out.println("\nThe list from Arrays.asList: " + nums );
      nums.set(0,0);
      System.out.println("The list from Arrays.asList after mod: " + nums );


      //To add new element to the list converted from Arrays.asList()
      List<Integer> toGrowList = new ArrayList<Integer>(Arrays.asList(integerArray));
      toGrowList.add(100);
      System.out.println("The new List with added element is: \n" + toGrowList);
   }
}
