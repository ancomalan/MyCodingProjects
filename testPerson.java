//alan vo 
//occc fall 2023 
//advanced java
//testPerson program that exercises every behavior in Person, RegisteredPerson, and OCCCPerson classes
import java.util.Scanner;
public class testPerson{

	public static void main(String[] args) {
		//test parent class
		String firstName; 
		String lastName; 
		Scanner input = new Scanner (System.in);
		System.out.print("Please enter a first name: ");
		firstName = input.next();
		System.out.print("Please enter a last name: ");
		lastName = input.next();
		
		//test OCCCDate dob 
		int day, month, year = 0 ; 
		System.out.print("Please enter the day that you were born: ");
		day = input.nextInt();
		System.out.print("Please enter the month that you were born: ");
		month = input.nextInt();
		System.out.print("Please enter the year that you were born: ");
		year = input.nextInt();
		
		
		OCCCDate dob = new OCCCDate (day, month, year); //create new dob object 
		System.out.println();
		Person p1 = new Person (firstName, lastName, dob); //create a new person object with first and last name
		System.out.println("Date of birth is: " + p1.getDOB());
		System.out.println("Age: " + p1.getAge());//test age function
		Person p2 = new Person(p1);	//test copy constructor 
		System.out.println("Person 1 is: " + p1.toString()); //test toString method
		System.out.println("Person 1's first name is: " + p1.getFirstName()); //test getFirstName method
		System.out.println("Person 2 is: " + p2.toString()); //test toString method
		System.out.println("Person 2's last name is: " + p2.getLastName()); //test getLastName method

		//test setters
		Person p3 = new Person (firstName, lastName, dob);
		p3.setFirstName("ALAN");
		System.out.println("Person 3's first name is now: " + p3.getFirstName());
		p3.setLastName("VO");
		System.out.println("Person 3's last name is now: " + p3.getLastName());
		System.out.println("Person 3 is: " + p3.toString()); //test toString method

		//test equals method for p1 and p3
		if (p1.equals(p3)) {
			System.out.println("Person 1 and Person 3 are the same person!");
		}
		else {
			System.out.println("Person 1 and Person 3 are not the same person!");
		}

		//test eat, sleep, play, run methods
		p1.eat();
		p2.sleep();
		p3.play();
		p3.run();


		System.out.println();
		System.out.println();
		//now test registered person sub class
		String govID; 
		System.out.print("Please enter a government ID: ");
		govID = input.next();
		RegisteredPerson rp1 = new RegisteredPerson(firstName, lastName, dob, govID); //create new registered person with first name, last name, and government ID 
		System.out.println("Registered Person 1 is: " + rp1.toString());
		RegisteredPerson rp2 = new RegisteredPerson(p3, govID);//create new registered person with person object and government ID
		System.out.println("Registered Person 2 is : " + rp2.toString());
		RegisteredPerson rp3 = new RegisteredPerson(rp1); //create a registered person from another registered person (copy constructor test)
		System.out.println("Registered Person 3 is: " + rp3.toString());
		System.out.println("The government ID for Registered Person 1 is: " + rp1.getGovernmentID()); //test getter for govID 
		//test equals method for first name, last name, and gov id between 2 persons
		if (rp1.equals(rp2)) {
			System.out.println("Registered Person 1 and Registered Person 2 share the same name and government ID!");

		}
		else {
			System.out.println("Registered Person 1 and Registered Person 2 are not the same people!");
		}

		//test equals method for only first name and last name, ignoring government ID
		if (rp2.equals(p1)) {
			System.out.println("Registered Person 2 and person 1 share the same first and last name!");

		}
		else {
			System.out.println("Registered Person 2 and person 1 do not share the same first and last name!");
		}
		//test run method on registered person 
		rp2.run();


		System.out.println();
		System.out.println();
		//test OCCCPerson class
		String studentID; 
		System.out.print("Please enter a student ID: ");
		studentID = input.next();
		OCCCPerson op1 = new OCCCPerson(rp1, studentID); //create occcstudent object with registeredperson object and student id
		System.out.println("OCCC Person 1 is: " + op1.toString());
		OCCCPerson op2 = new OCCCPerson (op1);				//create another occcperson with a occcperson object 
		System.out.println("OCCC Person 2 is: " + op2.toString());
		System.out.println("The student ID for OCCC Person 2 is: " + op2.getStudentID()); //test getter for studentID

		//test equals method for first name, last name, gov id, and student id 
		if (op1.equals(op2)) {
			System.out.println("OCCC Person 1 and 2 share the same name, government ID, and student ID!");
		}
		else {
			System.out.println("OCCC Person 1 and 2 are not the same people!");
		}


		//test equals method for only RegisteredPerson fields, ignore stud ID
		if (op1.equals(rp2)) {
			System.out.println("OCCC Person 1 and Registered Person 2 share the same name and government ID!");

		}
		else {
			System.out.println("OCCC Person 1 and Registered Person 2 are not the same people!");
		}

		//test equals method to compare only name and DOB fields
		if (op1.equals(p3)) {
			System.out.println("OCCC Person 1 and Person 3 share the same first and last name!");
		}
		else {
			System.out.println("OCCC Person 1 and Person 3 do not share the same first and last name!");
		}
		//test sleeping method
		op1.sleep();
		
		
		
		input.close();
	}
}
