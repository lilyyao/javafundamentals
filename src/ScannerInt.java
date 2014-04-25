import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ScannerInt {
	
	public static void main (String [] args) {
	
	String fileName = System.getProperty("user.dir") + File.separator + "a.txt";
	File file = new File(fileName); 
	ArrayList<Integer> intList = new ArrayList<>();
	
	try (Scanner scan = new Scanner(file) ) {
	
		while (scan.hasNextInt()) {
			intList.add(scan.nextInt());  
		} 
	}
		
	catch ( FileNotFoundException e) {
			e.printStackTrace();
	}
		
	for (Integer i: intList) {
		System.out.println(i);
	}
	
 }
}