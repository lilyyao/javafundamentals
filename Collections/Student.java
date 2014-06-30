package Collections;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.*;

public class Student implements Comparable<Student> {
   String id;
   String name;
   Double gpa;

   public Student(String studentId, String studentName, double studentGpa) {
      id = studentId;
      name = studentName;
      gpa = studentGpa;
   }

   public String toString() {
      return "\n" + id + " \t " + name + "   \t    " + gpa;
   }

   // Natural ordering
   public int compareTo(Student that) {
      //Using String's compareTo()
      return this.id.compareTo(that.id);
   }

}

class ComparatorTest {
   public static void main (String[] args) {
      Student [] students = { new Student("cs01", "Alice", 3.1),
            new Student("cs21", "Bob", 3.7),
            new Student("cs11", "Clair", 3.5),
            new Student("cs08", "David", 3.8) };

      System.out.println("Before sorting");
      System.out.println(Arrays.toString(students));

      // Note this is for the array
      Arrays.sort(students);

      System.out.println("\n\nAfter sorting by Comparable");
      System.out.println(Arrays.toString(students));

      // Note this is for the array + the comparator
      Arrays.sort(students, new GpaComparator());

      System.out.println("\n\nAfter sorting by Comparator");
      System.out.println(Arrays.toString(students));
   }
}

// Note no change to Student class
// Custom ordering
class GpaComparator implements Comparator<Student> {
   public int compare(Student s1, Student s2) {
      // Using the compareTo() from the raw type
      return (s1.gpa.compareTo(s2.gpa));
   }
}