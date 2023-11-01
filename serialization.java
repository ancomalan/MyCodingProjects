//alan vo 
//occc fall 2023 
//advanced java
//serialization
//C:\Users\bvo10\OneDrive\Desktop\8people.txt
import java.util.*;
import java.io.*;
import java.util.Scanner;
public class serialization {
	public static void main (String [] args) {

		System.out.println("Welcome to Serialization!");
		Scanner input = new Scanner (System.in);

		//Create five objects in the Person hierarchy (at least one of each type)
		Person [] p = new Person[5];  // Make an array (for simplicity) of Person

		OCCCDate date1 = new OCCCDate (22, 2, 1974);
		p[0] = new Person("George", "Washington", date1);

		OCCCDate date2 = new OCCCDate (12, 2, 1809);
		p[1] = new Person("Abraham", "Lincoln", date2);

		OCCCDate date3 = new OCCCDate (8, 12, 2003);
		Person p2 = new Person("Alan" , "Vo", date3);
		RegisteredPerson rp1 = new RegisteredPerson(p2, "0306"); //create registered Person object from person object and string gov ID
		p[2] = rp1;  

		//create OCCCPerson object from registered person 
		OCCCDate date4 = new OCCCDate (1, 1, 1999);
		Person p3 = new Person("Jung", "Yu", date4);
		RegisteredPerson rp2 = new RegisteredPerson(p3, "4922");
		OCCCPerson op1 = new OCCCPerson (rp2, "123456789");
		p[3] = op1;

		//create another OCCCPerson object 
		OCCCDate date5 = new OCCCDate (21, 3, 2000);
		Person p5 = new Person ("Seol", "Hong", date5);
		RegisteredPerson rp3 = new RegisteredPerson(p5, "8826");
		OCCCPerson op2 = new OCCCPerson (rp3, "099339402");
		p[4] = op2;

		//save these 5 objects to a file 
		// Now dump them to a file and read them back in (save)

		System.out.print("Please enter file name to save first 5 people in: ");
		String fileName = input.nextLine();

		System.out.println("Dumping objects to " + fileName + "...");

		try{
			FileOutputStream   fout = new FileOutputStream(fileName);
			ObjectOutputStream oout = new ObjectOutputStream(fout);

			for(int i = 0; i < p.length; ++i){
				oout.writeObject(p[i]);
			}
		}
		catch(IOException e){
			System.out.println("OH NO BAD THINGS HAPPEN");
			System.out.println(e.toString());
		}

		Person [] fivePeople = new Person[5];
		try{
			FileInputStream   fin = new FileInputStream(fileName);
			ObjectInputStream oin = new ObjectInputStream(fin);
			Object o;
			for(int i = 0; i < p.length; ++i){
				o = oin.readObject();
				// here we have to figure out what kind of Person we have and write them to the array with the appropriate type cast.
				// for code like this always start at the bottom of the inheritance chain and work your way up

				if (o.getClass().equals(OCCCPerson.class)){
					fivePeople[i] = (OCCCPerson) o;
				}
				else if (o.getClass().equals(RegisteredPerson.class)) {
					fivePeople[i] = (RegisteredPerson) o;
				}
				else{
					fivePeople[i] = (Person) o;
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
		for (int i = 0; i < fivePeople.length; i++) {
			System.out.println(fivePeople[i].toString());
		}

		System.out.println();
		System.out.print("Please enter what you would like to do (LOAD/ADD): ");
		String option = input.nextLine(); //load or add




		/*Give the user a chance to load an existing file
		On load, list the elements in the file (just use the toString method */
		if (option.equalsIgnoreCase("LOAD")){
			System.out.print("Please enter the file name that you want to load: ");
			fileName = input.nextLine();
			Person [] loadArray = new Person[8];
			try{
				FileInputStream   fin = new FileInputStream(fileName);
				ObjectInputStream oin = new ObjectInputStream(fin);
				Object o;
				for(int i = 0; i < loadArray.length; ++i){
					o = oin.readObject();

					// here we have to figure out what kind of Person we have and write them to the array with the appropriate type cast.
					// for code like this always start at the bottom of the inheritance chain and work your way up

					if (o.getClass().equals(OCCCPerson.class)){
						loadArray[i] = (OCCCPerson) o;
					}
					else if (o.getClass().equals(RegisteredPerson.class)) {
						loadArray[i] = (RegisteredPerson) o;
					}
					else{
						loadArray[i] = (Person) o;
					}
				}
			}
			catch(Exception e){
				System.out.println("INPUT ERROR");
				System.out.println(e.toString());
			}

			//print out all objects read from file
			for(int i = 0; i < loadArray.length;++i){
				System.out.println(loadArray[i].toString());
			}
		}





		/*Give the user a chance to add new items to the file
				The user gets to choose what kind of Person to add
				The program should then prompt for the input data
				After every new item is added, list the current elements */
		if (option.equalsIgnoreCase("ADD")) {
			Person [] P = Arrays.copyOf(p,8); //new array of size 8 to store 3 new people that user adds
			String firstName, lastName, govID, studentID;
			int day, month, year; //for occcdate object
			String userChoice; // to determine what type of person user selects

			for (int i = 5; i < 8; i++) {
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
					P[i] = new Person (firstName, lastName, dob); //create person object from all info acquired by user
					System.out.println(P[i].toString());

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
					P[i] = new RegisteredPerson(person, govID);
					System.out.println(P[i].toString());
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
					P[i] = new OCCCPerson (registeredPerson2, studentID);
					System.out.println(P[i].toString());
				}

			}
			// Now dump them to a file and read them back in (save)
			System.out.println();
			System.out.println("Dumping objects to " + fileName + "...");

			try{
				FileOutputStream   fout = new FileOutputStream(fileName);
				ObjectOutputStream oout = new ObjectOutputStream(fout);

				for(int i = 0; i < P.length; ++i){
					oout.writeObject(P[i]);
				}
			}
			catch(IOException e){
				System.out.println("OH NO BAD THINGS HAPPEN");
				System.out.println(e.toString());
			}


			System.out.println("Now we read them back in...");
			System.out.println();

			Person []Q = new Person[8];


			try{
				FileInputStream   fin = new FileInputStream(fileName);
				ObjectInputStream oin = new ObjectInputStream(fin);
				Object o;
				for(int i = 0; i < Q.length; ++i){
					o = oin.readObject();
					// here we have to figure out what kind of Person we have and write them to the array with the appropriate type cast.
					// for code like this always start at the bottom of the inheritance chain and work your way up

					if (o.getClass().equals(OCCCPerson.class)){
						Q[i] = (OCCCPerson) o;
					}
					else if (o.getClass().equals(RegisteredPerson.class)) {
						Q[i] = (RegisteredPerson) o;
					}
					else{
						Q[i] = (Person) o;
					}
				}
			}
			catch(Exception e){
				System.out.println("INPUT ERROR");
				System.out.println(e.toString());
			}

			//open the saved file and show that there are now 8 people
			for(int i = 0; i < Q.length; ++i){
				System.out.println(Q[i].toString());
			}
		}
	}
}






