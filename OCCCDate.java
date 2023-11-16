//alan vo 
//occc fall 2023 
//advanced java 
//occc date class
import java.util.GregorianCalendar;
import java.io.Serializable;
import java.util.Calendar;

public class OCCCDate implements Serializable{
	//private data members
	private int dayOfMonth; //1..31
	private int dayOfWeek; //for day name 
	private int monthOfYear; //1..12
	private int year; //e.g 2020
	private GregorianCalendar gc; //a private helper object
	private boolean dateFormat = FORMAT_US; 	//default is FORMAT_US
	private boolean dateStyle = STYLE_NUMBERS; //default is STYLE_NUMBERS
	private boolean dateDayName = SHOW_DAY_NAME; //default is SHOW_DAY_NAME

	//boolean constants
	public static final boolean FORMAT_US = true;//default
	public static final boolean FORMAT_EURO = false;
	public static final boolean STYLE_NUMBERS = true; //default
	public static final boolean STYLE_NAMES = false;
	public static final boolean SHOW_DAY_NAME = true; //default
	public static final boolean HIDE_DAY_NAME = false;


	//constructors
	//default constructor, uses current date and time
	public OCCCDate() {
		//This constructor will create a GregorianCalendar object and use that to set the day, month, and year fields.
		gc = new GregorianCalendar (); //use private gregorian calendar helper object 
		this.dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		this.monthOfYear = gc.get(Calendar.MONTH) + 1; //add 1 because gregorian calendar months are 0-11 and we are in terms of OCCCDate now
		this.year = gc.get(Calendar.YEAR);
		this.dayOfWeek = gc.get(Calendar.DAY_OF_WEEK);
	}

	//OCCCDate constructor with parameters: (int day, int month, int year)
	public OCCCDate(int day, int month, int year) {
		try {
			this.dayOfMonth = day; 
			this.monthOfYear = month;
			this.year = year;
			gc = new GregorianCalendar (this.year, this.monthOfYear - 1, this.dayOfMonth);
			this.dayOfWeek= gc.get(Calendar.DAY_OF_WEEK);

			if (!isValidOCCCDate (day, month, year)) {
				throw new InvalidOCCCDateException();
			}
		}
		catch(InvalidOCCCDateException e) {
			System.out.println(e.toString());
			System.out.print("Gregorian Calendar Date: ");
			this.dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
			this.monthOfYear = gc.get(Calendar.MONTH) + 1; //add 1 to the month because we are now in OCCCDate terms
			this.year = gc.get(Calendar.YEAR);
			this.dayOfWeek = gc.get(Calendar.DAY_OF_WEEK);
		}
	}

	//constructor using gregorian calendar object
	public OCCCDate(GregorianCalendar gc) {
		this.dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		this.monthOfYear = gc.get(Calendar.MONTH) + 1; //add 1 to the month because we are now in OCCCDate terms
		this.year = gc.get(Calendar.YEAR);
		this.dayOfWeek = gc.get(Calendar.DAY_OF_WEEK);

	}

	//copy constructor
	public OCCCDate(OCCCDate d) {
		this.dayOfMonth = d.dayOfMonth;
		this.monthOfYear = d.monthOfYear;
		this.year = d.year;
		gc = new GregorianCalendar (this.year, this.monthOfYear - 1, this.dayOfMonth);
		this.dayOfWeek = gc.get(Calendar.DAY_OF_WEEK);

	}

	//function to check for valid occcdate 
	public boolean isValidOCCCDate (int day, int month, int year){
		boolean flag = true;
		//get dates from date object 
		this.dayOfMonth = day; 
		this.monthOfYear = month;
		this.year = year;
		gc = new GregorianCalendar (this.year, this.monthOfYear - 1, this.dayOfMonth);
		if (this.monthOfYear != (gc.get(Calendar.MONTH)+ 1) || this.dayOfMonth != gc.get(Calendar.DAY_OF_MONTH) 
				|| this.year != gc.get(Calendar.YEAR)) {
			flag = false; //set the flag to false if gregorian calendar and occc date do not match
		}
		return flag;
	}


	//function to get day of month 
	public int getDayOfMonth() {
		return dayOfMonth;
	}

	//function to get day of week for day name
	public int getDayOfWeek() {
		return dayOfWeek;
	}

	//function to return the name of day
	public static String getDayName(int d) {
		switch (d) {
		case 1: return "Sunday";
		case 2: return "Monday";
		case 3: return "Tuesday";
		case 4: return "Wednesday";
		case 5: return "Thursday";
		case 6: return "Friday";
		case 7: return "Saturday";
		default: return "UNKNOWN DAY";
		}
	}

	//function to get month number (1-12)
	public int getMonthNumber() {
		return monthOfYear;
	}

	//function to return name of months: january, february, march, etc
	public static String getMonthName(int m) {
		switch (m) {
		case 1: return "January";
		case 2: return "February";
		case 3: return "March"; 
		case 4: return "April";
		case 5: return "May";
		case 6: return "June"; 
		case 7: return "July"; 
		case 8: return "August";
		case 9: return "September";
		case 10: return "October";
		case 11: return "November";
		case 12: return "December";
		default: return "UNKNOWN MONTH";
		}
	}

	//function to return year (e.g. 2023 for example)
	public int getYear() {
		return year;
	}


	//function to setDateFormat (US or EURO Style)
	public void setDateFormat(boolean dateFormat) {
		this.dateFormat = dateFormat;
	}

	//function to set style format (name for the month or just number)
	public void setStyleFormat(boolean styleFormat) {
		this.dateStyle = styleFormat;
	}

	//function to show or hide name of day 
	public void setDayName (boolean nameFormat) {
		this.dateDayName = nameFormat;
	}

	//function to get difference in years between this OCCCDate and now
	public int getDifferenceInYears() {
		//get the year of the current time by using the private gregorian calendar object
		gc = new GregorianCalendar();
		return gc.get(Calendar.YEAR) - this.year;
	}

	//function to get difference in years between between this date and d
	public int getDifferenceInYears(OCCCDate d) {
		return Math.abs(d.year - this.year);
	}

	public boolean equals(OCCCDate dob) {
		// compare only day, month, and year
		boolean result = false;
		if (dob.dayOfMonth == this.dayOfMonth && dob.monthOfYear == this.monthOfYear && dob.year == this.year) {
			result = true;
		}
		return result;
	}



	//@Override
	public String toString() {

		//string variables to add zeros to days and months less than 10 (for number style formats: dd and mm) 
		String correctDayFormat = ""; 
		String correctMonthFormat = ""; 

		//US format mm/dd/yyyy or monthName dd, yyyy
		//print day name and (mm/dd/yyyy) 
		if(dateFormat && dateStyle && dateDayName){
			if (dayOfMonth < 10) {
				correctDayFormat = "0" + String.valueOf(this.dayOfMonth);
			}
			else {
				correctDayFormat = String.valueOf(dayOfMonth);
			}
			if (monthOfYear < 10) {
				correctMonthFormat = "0" + String.valueOf(this.monthOfYear);
			}
			else {
				correctMonthFormat = String.valueOf(monthOfYear);
			}
			String result = OCCCDate.getDayName(dayOfWeek) + ", "+ correctMonthFormat + "/" + correctDayFormat + "/" + this.year;
			return result;
		}
		//print day name and (monthName dd, yyyy)
		else if (dateFormat && !dateStyle && dateDayName){ 
			String result = OCCCDate.getDayName(dayOfWeek) + ", " +
					OCCCDate.getMonthName(this.monthOfYear) + " " + this.dayOfMonth + ", " + this.year;
			return result;
		}
		//print out default US date with day name hidden and in (mm/dd/yyyy) format
		else if (dateFormat && dateStyle && !dateDayName) {
			if (dayOfMonth < 10) {
				correctDayFormat = "0" + String.valueOf(this.dayOfMonth);
			}
			else {
				correctDayFormat = String.valueOf(dayOfMonth);
			}
			if (monthOfYear < 10) {
				correctMonthFormat = "0" + String.valueOf(this.monthOfYear);
			}
			else {
				correctMonthFormat = String.valueOf(monthOfYear);
			}
			String result = correctMonthFormat + "/" + correctDayFormat + "/" + this.year;
			return result;
		}
		//print out default US date with day name hidden and in (monthName, dd, yyyy) format 
		else if (dateFormat && !dateStyle && !dateDayName){ 
			String result = OCCCDate.getMonthName(this.monthOfYear) + " " + this.dayOfMonth + ", " + this.year;
			return result;
		} 


		//Euro format dd/mm/yyyy or dd monthName yyyy
		//print day name and (dd/mm/yyyy)
		else if(!dateFormat && dateStyle && dateDayName){
			if (dayOfMonth < 10) {
				correctDayFormat = "0" + String.valueOf(this.dayOfMonth);
			}
			else {
				correctDayFormat = String.valueOf(dayOfMonth);
			}
			if (monthOfYear < 10) {
				correctMonthFormat = "0" + String.valueOf(this.monthOfYear);
			}
			else {
				correctMonthFormat = String.valueOf(monthOfYear);
			}
			String result = OCCCDate.getDayName(dayOfWeek) + ", " + correctDayFormat + "/" + correctMonthFormat + "/" + this.year;
			return result;
		}
		//print day name and (dd monthName yyyy)
		else if (!dateFormat && !dateStyle && dateDayName){
			String result = OCCCDate.getDayName(dayOfWeek) + ", " + this.dayOfMonth + " " + OCCCDate.getMonthName(this.monthOfYear) + " " + this.year;
			return result;
		}
		//print (dd/mm/yyyy) without day name 
		else if (!dateFormat && dateStyle && !dateDayName) {
			if (dayOfMonth < 10) {
				correctDayFormat = "0" + String.valueOf(this.dayOfMonth);
			}
			else {
				correctDayFormat = String.valueOf(dayOfMonth);
			}
			if (monthOfYear < 10) {
				correctMonthFormat = "0" + String.valueOf(this.monthOfYear);
			}
			else {
				correctMonthFormat = String.valueOf(monthOfYear);
			}
			String result = correctDayFormat + "/" + correctMonthFormat + "/" + this.year;
			return result;
		}
		//print (dd monthName yyyy) without day name
		else if (!dateFormat && !dateStyle && !dateDayName) {
			String result = this.dayOfMonth + " " + OCCCDate.getMonthName(this.monthOfYear) + " " + this.year;
			return result;
		}
		else {
			return "INVALID DATE";
		}
	}
}