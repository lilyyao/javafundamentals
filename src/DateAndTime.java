import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


// use pattern and formatter for date and time
// Sample output:
// the default format for the date is: Apr 29, 2014
// formatted today as: 04-29-14
// Date in pattern "d '('E')' MMM, YYYY" is 29 (Tue) Apr, 2014 
// Date in pattern "w'th week of' YYYY" is 18th week of 2014 
// Time in pattern "h:mm" is 10:40 
// Time in pattern "H:mm:ss:SS a, zzzz" is 10:40:29:915 AM, Pacific Daylight Time 

public class DateAndTime {
	
	public static void main (String[] args) {
		
		Date today = new Date();
		
		System.out.println("the default format for the date is: " + 
				DateFormat.getDateInstance().format(today));
		
		String datePattern = "MM-dd-yy";
		SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
		System.out.println("formatted today as: " + formatter.format(today));
		
		
		String[] datePatterns = {
				"d '('E')' MMM, YYYY", // E is name of the day (in week)
				"w'th week of' YYYY", // w is the week of the year
				
		};
		for(String dateFormat : datePatterns) {
			System.out.printf("Date in pattern \"%s\" is %s %n", dateFormat,
					new SimpleDateFormat(dateFormat).format(today));
		}
		
		
		String[] timeFormats = {
				"h:mm", // h is hour in am/pm(1-12), m is minute
				"H:mm:ss:SS a, zzzz" // H is hour in day(0-23), S is milliseconds a is am/pm, z is timezone
		};
		for(String timeFormat : timeFormats) {
			System.out.printf("Time in pattern \"%s\" is %s %n", timeFormat,
					new SimpleDateFormat(timeFormat).format(today));
		}
		
	}

}
