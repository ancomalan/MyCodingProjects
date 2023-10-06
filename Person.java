//alan vo 
//occc fall 2023
//advanced java 
//parent class

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {

	//private data members
	private String firstName; 
	private String lastName; 
	private OCCCDate dob; //add state variable dob (date of birth) as a private OCCCDate.

	//constructors
	public Person (String firstName, String lastName) {
		this.firstName = firstName; 
		this.lastName = lastName;
	}

	//constructor with OCCCDate 
	public Person (String firstName, String lastName, OCCCDate dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = new OCCCDate(dob);
		this.dob.setDayName(OCCCDate.HIDE_DAY_NAME);
	}
	//copy constructor
	public Person (Person p) {
		this.firstName = p.firstName;
		this.lastName = p.lastName;
		this.dob = p.dob;
	}

	//getters
	public String getFirstName() {
		return new String (firstName);
	}
	public String getLastName() {
		return new String (lastName);
	}


	//setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName; 
	}

	public OCCCDate getDOB() {
		return dob;
	}
	
	// returns age in years, truncated not rounded
	public int getAge() {
		//get the year of the current time by using the gregorian calendar object
		GregorianCalendar currentTime = new GregorianCalendar();
		int age = currentTime.get(Calendar.YEAR)- dob.getYear();
		//check if birthday has passed yet within the year, otherwise decrement age by 1
		//had some inspiration from https://www.javatpoint.com/java-calculate-age
		if ((dob.getMonthNumber() > currentTime.get(Calendar.MONTH) + 1) || (dob.getMonthNumber() == currentTime.get(Calendar.MONTH) + 1 && 
				dob.getDayOfMonth() > currentTime.get(Calendar.DAY_OF_MONTH))) {
			age-=1;
		}
		return age; 
	}
	
	
	
	//toString method; format lastName, firstName (birthdate)
	@Override 
	public String toString() {
		return lastName + ", " + firstName + "(" + dob + ")";
	}

	//person equals method
	public boolean equals(Person p) {
		return firstName.equalsIgnoreCase(p.firstName) && lastName.equalsIgnoreCase(p.lastName);
	

	}

	//eat, sleep, play, and run methods
	public void eat() {
		System.out.println(getClass().getName() + " " + toString() + " is eating!");
	}
	public void sleep() {
		System.out.println(getClass().getName() + " " + toString() + " is sleeping!");
	}
	public void play() {
		System.out.println(getClass().getName() + " " + toString() + " is playing!");
	}
	public void run() {
		System.out.println(getClass().getName() + " " + toString() + " is running!");
	}


}
