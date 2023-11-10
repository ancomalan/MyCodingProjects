//alan vo 
//occc fall 2023 
//advanced java
//serialization
//C:\Users\bvo10\OneDrive\Desktop\8people.txt
import java.util.*;
import java.io.*;
import java.util.Scanner;
public class serialization2 {
	public static void main (String [] args) {

		System.out.println("Welcome to Serialization!");
		Scanner input = new Scanner (System.in);

		//Create five objects in the Person hierarchy (at least one of each type)
		ArrayList<Person> p = new ArrayList<Person>(); //create an array list of persons 

		OCCCDate date1 = new OCCCDate (22, 2, 1974);
		p.add(0, new Person("George", "Washington", date1)); //add first person to the array list

		OCCCDate date2 = new OCCCDate (12, 2, 1809);
		p.add(1, new Person("Abraham", "Lincoln", date2)); //add second person to the array list 

		OCCCDate date3 = new OCCCDate (8, 12, 2003);
		Person p2 = new Person("Alan" , "Vo", date3);
		RegisteredPerson rp1 = new RegisteredPerson(p2, "0306"); //create registered Person object from person object and string gov ID
		p.add(2, rp1); // add third person to the array list

		//create OCCCPerson object from registered person 
		OCCCDate date4 = new OCCCDate (1, 1, 1999);
		Person p3 = new Person("Jung", "Yu", date4);
		RegisteredPerson rp2 = new RegisteredPerson(p3, "4922");
		OCCCPerson op1 = new OCCCPerson (rp2, "123456789");
		p.add(3, op1); //add 4th person to the array list

		//create another OCCCPerson object 
		OCCCDate date5 = new OCCCDate (21, 3, 2000);
		Person p5 = new Person ("Seol", "Hong", date5);
		RegisteredPerson rp3 = new RegisteredPerson(p5, "8826");
		OCCCPerson op2 = new OCCCPerson (rp3, "099339402");
		p.add(4,op2); //add 5th person to the array list

		//save these 5 objects to a file 
		// Now dump them to a file and read them back in (save)

		System.out.print("Please enter file name to save first 5 people in: ");
		String fileName = input.nextLine();

		System.out.println("Dumping objects to " + fileName + "...");

		try{
			FileOutputStream   fout = new FileOutputStream(fileName);
			ObjectOutputStream oout = new ObjectOutputStream(fout);

			for(int i = 0; i < p.size(); ++i){
				oout.writeObject(p.get(i)); 
			}
		}
		catch(IOException e){
			System.out.println("OH NO BAD THINGS HAPPEN");
			System.out.println(e.toString());
		}

		try{
			FileInputStream   fin = new FileInputStream(fileName);
			ObjectInputStream oin = new ObjectInputStream(fin);
			Object o;
			for(int i = 0; i < p.size(); ++i){
				o = oin.readObject();

				// here we have to figure out what kind of Person we have and write them to the arrayList with the appropriate type cast.
				// for code like this always start at the bottom of the inheritance chain and work your way up

				if (o.getClass().equals(OCCCPerson.class)){
					p.set(i, (OCCCPerson)o);
				}
				else if (o.getClass().equals(RegisteredPerson.class)) {
					p.set(i, (RegisteredPerson)o);
				}
				else{
					p.set(i, (Person)o);
				}
			}
		}
		catch(Exception e){
			System.out.println("INPUT ERROR");
			System.out.println(e.toString());
		}
		System.out.println("Reading them back in from the saved file...");
		System.out.println();
		//display 5 people are loaded 
		for (int i = 0; i < p.size(); i++) {
			System.out.println(p.get(i).toString());
		}

		System.out.println();
		System.out.print("Please enter what you would like to do (LOAD/ADD): ");
		String option = input.nextLine(); //load or add



		/*Give the user a chance to load an existing file
		On load, list the elements in the file (just use the toString method */
		if (option.equalsIgnoreCase("LOAD")){
			//print out all objects read from file
			for(int i = 0; i < p.size();++i){
				System.out.println(p.get(i).toString());
			}
		}



		/*Give the user a chance to add new items to the file
				The user gets to choose what kind of Person to add
				The program should then prompt for the input data
				After every new item is added, list the current elements */

		if (option.equalsIgnoreCase("ADD")) {
			String firstName, lastName, govID, studentID;
			int day, month, year; //for occcdate object
			String userChoice; // to determine what type of person user selects
			String menu = "Y";

			while (menu.equalsIgnoreCase("Y")) {
				System.out.print("What type of person would you like to add? (PERSON/REGISTERED/OCCC)");
				userChoice = input.next();


				if (userChoice.equalsIgnoreCase("PERSON")) {
					System.out.print("Please enter first name: ");
					firstName = input.next();
					System.out.print("Please enter last name: ");
					lastName = input.next();
					System.out.print("Please enter day of birth: ");
					day = input.nextInt();
					System.out.print("Please enter month of birth:" );
					month = input.nextInt();
					System.out.print("Please enter year of birth: ");
					year = input.nextInt();				
					OCCCDate dob =  new OCCCDate(day, month, year);
					Person person = new Person (firstName, lastName, dob);
					p.add(person); //create person object from all info acquired by user)
					System.out.println(person.toString());
					System.out.print("Would you like to add more people? (Y or N)?");
					menu = input.next();

				}

				if (userChoice.equalsIgnoreCase("REGISTERED")) {
					System.out.print("Please enter first name: ");
					firstName = input.next();
					System.out.print("Please enter last name: ");
					lastName = input.next();
					System.out.print("Please enter day of birth: ");
					day = input.nextInt();
					System.out.print("Please enter month of birth:" );
					month = input.nextInt();
					System.out.print("Please enter year of birth: ");
					year = input.nextInt();			
					System.out.print("Please enter government ID: ");
					govID = input.next();
					OCCCDate dob =  new OCCCDate(day, month, year);
					Person person = new Person (firstName, lastName, dob); //create person object from all info acquired by user
					RegisteredPerson registered = new RegisteredPerson(person, govID);
					p.add(registered);
					System.out.println(registered.toString());
					System.out.print("Would you like to add more people? (Y or N)?");
					menu = input.next();
				}

				if (userChoice.equalsIgnoreCase("OCCC")) {
					System.out.print("Please enter first name: ");
					firstName = input.next();
					System.out.print("Please enter last name: ");
					lastName = input.next();
					System.out.print("Please enter day of birth: ");
					day = input.nextInt();
					System.out.print("Please enter month of birth:" );
					month = input.nextInt();
					System.out.print("Please enter year of birth: ");
					year = input.nextInt();			
					System.out.print("Please enter government ID: ");
					govID = input.next();
					System.out.print("Please enter student ID: ");
					studentID = input.next();
					OCCCDate dob =  new OCCCDate(day, month, year);
					Person person = new Person (firstName, lastName, dob); //create person object from all info acquired by user
					RegisteredPerson registeredPerson2 = new RegisteredPerson(person, govID);
					OCCCPerson occc = new OCCCPerson (registeredPerson2, studentID);
					p.add(occc);
					System.out.println(occc.toString());
					System.out.print("Would you like to add more people? (Y or N)?");
					menu = input.next();
				}

			}
			// Now dump them to a file and read them back in (save)
			System.out.println();
			System.out.println("Dumping objects to " + fileName + "...");

			try{
				FileOutputStream   fout = new FileOutputStream(fileName);
				ObjectOutputStream oout = new ObjectOutputStream(fout);

				for(int i = 0; i < p.size(); ++i){
					oout.writeObject(p.get(i));
				}
			}
			catch(IOException e){
				System.out.println("OH NO BAD THINGS HAPPEN");
				System.out.println(e.toString());
			}


			System.out.println("Now we read them back in...");
			System.out.println();



			try{
				FileInputStream   fin = new FileInputStream(fileName);
				ObjectInputStream oin = new ObjectInputStream(fin);
				Object o;
				for(int i = 0; i < p.size(); ++i){
					o = oin.readObject();
					// here we have to figure out what kind of Person we have and write them to the array with the appropriate type cast.
					// for code like this always start at the bottom of the inheritance chain and work your way up

					if (o.getClass().equals(OCCCPerson.class)){
						p.set(i, (OCCCPerson)o);
					}
					else if (o.getClass().equals(RegisteredPerson.class)) {
						p.set(i, (RegisteredPerson)o);
					}
					else{
						p.set(i, (Person)o);
					}
				}
			}
			catch(Exception e){
				System.out.println("INPUT ERROR");
				System.out.println(e.toString());
			}

			//open the saved file and show that there are now 8 people
			for(int i = 0; i < p.size(); ++i){
				System.out.println(p.get(i).toString());
			}
		}
	}
}
