//alan vo 
//occc fall 2023
//advanced java 
//occcdate with exceptions test program
import java.util.Scanner;
public class OCCCDateExceptions {
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);
		String menu = "Y";
		int day; 
		int month; 
		int year; 

		while (menu.equalsIgnoreCase("Y")) {
			//prompt user for data to validate occcdate
			System.out.print("Please enter a day: ");
			day = input.nextInt();
			System.out.print("Please enter a month number (1-12): ");
			month = input.nextInt();
			System.out.print("Please enter a year: ");
			year = input.nextInt();

			//create a occcdate object
			OCCCDate date = new OCCCDate(day, month, year);
			date.setDateFormat(OCCCDate.FORMAT_US);
			date.setStyleFormat(OCCCDate.STYLE_NAMES);
			date.setDayName(OCCCDate.HIDE_DAY_NAME);
			System.out.print(date.toString());
			System.out.println();
			System.out.print("Would you like to add another date? (Y or N): ");
			menu = input.next();
		}
		input.close();
	}
}
