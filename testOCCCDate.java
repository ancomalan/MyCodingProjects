//alan vo 
//occc fall 2023 
//advanced java 
//occc date tester
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class testOCCCDate {
	public static void main (String[] args) {
		int dayOfMonth = 0, monthOfYear = 0, year = 0;
		if (args.length == 3) {
			dayOfMonth = Integer.parseInt(args[0]);
			monthOfYear = Integer.parseInt(args[1]);
			year = Integer.parseInt(args[2]);
		}
		else {
			Scanner s = new Scanner (System.in);
			System.out.print("Please enter day (1-31): ");
			dayOfMonth = s.nextInt();
			System.out.print("Please enter month (1-12): " );
			monthOfYear = s.nextInt();
			System.out.print("Please enter year (XXXX): ");
			year = s.nextInt();
			System.out.println();
			s.close();
		}

		//create the gregorian calendar object 
		GregorianCalendar calendar = new GregorianCalendar (year, monthOfYear-1, dayOfMonth);

		//now turn gregorian calendar data back into OCCCDate terms 
		int theDay = calendar.get(Calendar.DAY_OF_MONTH);
		int theMonth = calendar.get(Calendar.MONTH) + 1;
		int theYear = calendar.get(Calendar.YEAR);
		int theDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		System.out.println("The date in US format (mm/dd/yyyy) for the values inputted is: " + OCCCDate.getDayName(theDayOfWeek) + ", " + theMonth + "/" + theDay + "/" 
				+ theYear);
		//test February 30, 2020 (should display as March 1, 2020)
		OCCCDate run1 = new OCCCDate (calendar);
		run1.setDateFormat(OCCCDate.FORMAT_US);
		run1.setStyleFormat(OCCCDate.STYLE_NAMES);
		run1.setDayName(OCCCDate.HIDE_DAY_NAME);
		System.out.println("February 30, 2020 is actually: " + run1.toString() + "!");

		GregorianCalendar calendar2 = new GregorianCalendar (2021, 0, 365);
		//test January 365, 2021 (should display as December 31)
		OCCCDate run2 = new OCCCDate (calendar2);
		run2.setDateFormat(OCCCDate.FORMAT_US);
		run2.setStyleFormat(OCCCDate.STYLE_NAMES);
		run2.setDayName(OCCCDate.HIDE_DAY_NAME);
		System.out.println("January 365, 2021 is actually: " + run2.toString() + "!");



		//test constructor with day, month, and year parameters
		OCCCDate myDate = new OCCCDate (10, 5, 2021);
		System.out.println("The date in US format (mm/dd/yyyy) for the constructor with day, month, and year parameters is: " + 
				OCCCDate.getDayName(myDate.getDayOfWeek()) + ", " + myDate.getMonthNumber() + "/" + myDate.getDayOfMonth() + "/" + myDate.getYear());
		System.out.println("The day of month is for this constructor is: " + myDate.getDayOfMonth()) ;//test dayOfMonth getter


		//test copy constructor
		OCCCDate copyTest = new OCCCDate (myDate);
		System.out.println("The date in US format for the copy constructor (mm/dd/yyyy) is: " + OCCCDate.getDayName(copyTest.getDayOfWeek()) + ", " 
				+ copyTest.getMonthNumber() + "/" + copyTest.getDayOfMonth() + "/" + copyTest.getYear());

		//test gregorian calendar constructor
		OCCCDate gregTest = new OCCCDate(calendar);
		System.out.println("The date in US format for the gregorian calendar constructor (mm/dd/yyyy) is: " + OCCCDate.getDayName(gregTest.getDayOfWeek()) 
		+ ", " + gregTest.getMonthNumber()+ "/" + gregTest.getDayOfMonth() + "/" + gregTest.getYear());



		OCCCDate newDate = new OCCCDate(); 	//test default constructor 

		System.out.println("The date (today's date) in US format for the default constructor (mm/dd/yyyy) is: " + OCCCDate.getDayName(newDate.getDayOfWeek()) + ", " + 
				newDate.getMonthNumber()+ "/" + newDate.getDayOfMonth() + "/" + newDate.getYear());
		System.out.println("The month number (1-12) for the default constructor is: " + newDate.getMonthNumber());//test getMonthNumber method
		System.out.println("The name of the month for the default constructor is: " + OCCCDate.getMonthName(newDate.getMonthNumber()));//test getMonthName function 
		System.out.println("The year for the default constructor is: " + newDate.getYear());//test getYear function 
		System.out.println();

		//test all 4 US formats for the date
		System.out.println("Today's Date in US formats: ");
		newDate.setDateFormat(OCCCDate.FORMAT_US);
		newDate.setStyleFormat(OCCCDate.STYLE_NUMBERS);
		newDate.setDayName(OCCCDate.SHOW_DAY_NAME);
		System.out.println(newDate.toString()); //print day name and (mm/dd/yyyy) 

		newDate.setDateFormat(OCCCDate.FORMAT_US);
		newDate.setStyleFormat(OCCCDate.STYLE_NAMES);
		newDate.setDayName(OCCCDate.SHOW_DAY_NAME);
		System.out.println(newDate.toString());  //print day name and (monthName dd, yyyy)

		newDate.setDateFormat(OCCCDate.FORMAT_US);
		newDate.setStyleFormat(OCCCDate.STYLE_NUMBERS);
		newDate.setDayName(OCCCDate.HIDE_DAY_NAME);
		System.out.println(newDate.toString()); //print out in (mm/dd/yyyy) format with day name hidden

		newDate.setDateFormat(OCCCDate.FORMAT_US);
		newDate.setStyleFormat(OCCCDate.STYLE_NAMES);
		newDate.setDayName(OCCCDate.HIDE_DAY_NAME);
		System.out.println(newDate.toString()); //print out default US date with day name hidden and in (monthName, dd, yyyy) format 
		System.out.println();

		//test all 4 euro formats for the date
		System.out.println("Today's Date in Euro formats: ");
		newDate.setDateFormat(OCCCDate.FORMAT_EURO);
		newDate.setStyleFormat(OCCCDate.STYLE_NUMBERS);
		newDate.setDayName(OCCCDate.SHOW_DAY_NAME);
		System.out.println(newDate.toString()); //print day name and (dd/mm/yyyy)


		newDate.setDateFormat(OCCCDate.FORMAT_EURO);
		newDate.setStyleFormat(OCCCDate.STYLE_NAMES);
		newDate.setDayName(OCCCDate.SHOW_DAY_NAME);
		System.out.println(newDate.toString()); //print day name and (dd monthName yyyy)


		newDate.setDateFormat(OCCCDate.FORMAT_EURO);
		newDate.setStyleFormat(OCCCDate.STYLE_NUMBERS);
		newDate.setDayName(OCCCDate.HIDE_DAY_NAME);
		System.out.println(newDate.toString()); //print (dd/mm/yyyy) without day name 


		newDate.setDateFormat(OCCCDate.FORMAT_EURO);
		newDate.setStyleFormat(OCCCDate.STYLE_NAMES);
		newDate.setDayName(OCCCDate.HIDE_DAY_NAME);
		System.out.println(newDate.toString()); //print (dd monthName yyyy) without day name
		System.out.println();

		//test getDifferenceInYears function 
		System.out.println("The difference in years between " + run1.toString() + " and now is: "+ run1.getDifferenceInYears() + " year(s)!");

		//test difference in years between 2 OCCCDate objects
		System.out.println("The difference in years between " + myDate.toString() + " and " + run1.toString() + " is: " + myDate.getDifferenceInYears(run1) + " year(s)!");

		//test boolean equals function 
		myDate.setDayName(OCCCDate.HIDE_DAY_NAME);
		copyTest.setDateFormat(OCCCDate.FORMAT_US);
		copyTest.setStyleFormat(OCCCDate.STYLE_NAMES);
		copyTest.setDayName(OCCCDate.HIDE_DAY_NAME);
		if (myDate.equals(copyTest)) {
			System.out.println(myDate.toString() + " is equal to " + copyTest.toString());
		}
		else {
			System.out.println(myDate.toString() + " is NOT equal to " + copyTest.toString());
		}

		if (run1.equals(copyTest)) {
			System.out.println(run1.toString() + " is equal to " + copyTest.toString());
		}
		else {
			System.out.println(run1.toString() + " is NOT equal to " + copyTest.toString());
		}
	}
}
/*all below from the java api
//print out a bunch of interesting things
System.out.println("ERA: " + calendar.get(Calendar.ERA));
System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
System.out.println("DATE: " + calendar.get(Calendar.DATE));
System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
System.out.println("DAY_OF_WEEK_IN_MONTH: "
		+ calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)); */