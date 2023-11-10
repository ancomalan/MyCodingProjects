//alan vo 
//occc fall 2023
//advanced java 
//serialization
//C:\Users\bvo10\OneDrive\Desktop\Test.txt
import java.util.*;
import java.io.*;

public class testSerialization{
	public static void main(String [] args){

		
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


		// Now dump them to a file and read them back in

		System.out.print("Please enter file name to dump objects to: ");
		Scanner s = new Scanner(System.in);
		String fileName = s.next();

		System.out.println("Dumping objects to " + fileName + "...");
		System.out.println();

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

		
		//read objects from file back in to program
		System.out.println("Now we read them back in...");

		Person [] q = new Person[5]; //create new array

		try{
			FileInputStream   fin = new FileInputStream(fileName);
			ObjectInputStream oin = new ObjectInputStream(fin);
			Object o;
			for(int i = 0; i < q.length; ++i){
				o = oin.readObject();

				// here we have to figure out what kind of Person we have and write them to the array with the appropriate type cast.
				// for code like this always start at the bottom of the inheritance chain and work your way up

				if (o.getClass().equals(OCCCPerson.class)){
					q[i] = (OCCCPerson) o;
				}
				else if (o.getClass().equals(RegisteredPerson.class)) {
					q[i] = (RegisteredPerson) o;
				}
				else {
					q[i] = (Person) o;
				}
			}
		}
		catch(Exception e){
			System.out.println("INPUT ERROR");
			System.out.println(e.toString());
		}

		//display new array contents
		for(int i = 0; i < q.length; ++i){
			System.out.println(q[i].toString());
		}
		
		
		// Create a new, larger array for new people to be added. Copy over the content of the original array. Insert the new element at the end.
		Person [] P = Arrays.copyOf(p, p.length+3);
		
		
		//add 3 new people 
		OCCCDate dob = new OCCCDate (5, 6, 2006);
		Person person = new Person ("Jason", "Vo", dob);
		P[5] = person;
		
		Person person2 = new Person ("Jim", "Halpert", dob);
		RegisteredPerson registeredP = new RegisteredPerson(person2, "122222");
		P[6] = registeredP;
		
		Person person3 = new Person ("Pam", "Weasley", dob);
		RegisteredPerson registeredP2 = new RegisteredPerson(person3, "0992223");
		OCCCPerson occcPerson = new OCCCPerson (registeredP2, "23123812093812");
		P[7] = occcPerson; 
		
	
		// Now dump them to a file and read them back in

				System.out.print("Please enter file name to dump new people in: ");
				Scanner s2 = new Scanner(System.in);
				String fileName2 = s2.next();

				System.out.println("Dumping objects to " + fileName2 + "...");

				try{
					FileOutputStream   fout = new FileOutputStream(fileName2);
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

				Person []Q = new Person[8];
		

				try{
					FileInputStream   fin = new FileInputStream(fileName);
					ObjectInputStream oin = new ObjectInputStream(fin);
					Object o;
					for(int i = 0; i < Q.length; ++i){
						o = oin.readObject();
						System.out.println(o.getClass());

						// here we have to figure out what kind of Person we have and write them to the array with the appropriate type cast.
						// for code like this always start at the bottom of the inheritance chain and work your way up

						if (o.getClass().equals(OCCCPerson.class)){
							System.out.println("Got me an OCCC Person");
							Q[i] = (OCCCPerson) o;
						}
						else if (o.getClass().equals(RegisteredPerson.class)) {
							System.out.println("got me a Registered Person");
							Q[i] = (RegisteredPerson) o;
						}
						else{
							System.out.println("This is a Person");
							Q[i] = (Person) o;
						}
					}
				}
				catch(Exception e){
					System.out.println("INPUT ERROR");
					System.out.println(e.toString());
				}

				//open the saved file and show that there are 5 people
				for(int i = 0; i < Q.length; ++i){
					System.out.println(Q[i].toString());
				}
		//then load the text file to see changes: should be 8 people
	}
}


