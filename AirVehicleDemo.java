/**
 * Name: Alan Vo 
 * Date: 02/25/23
 * File: AirVehicleDemo.java
 * Description: This program creates a fighter jet object and a cargo plane object (using the FighterJet and CargoPlane class), 
   then simulates them taking off, flying, and landing (using the AirVehicle and SoundBarrier interfaces)
 */
import java.util.Scanner; //to read input from keyboard
public class AirVehicleDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //create scanner object to read input from user
		String userInput; //used in while loop to store user input from keyboard


		//create a fighter jet and cargo plane object by using the constructors with all arguments
		FighterJet fighterJet = new FighterJet(2,1,"F-22","Lockheed Martin");
		CargoPlane cargoPlane = new CargoPlane(4,3,"C-17","Boeing");


		//fighter jet simulation 
		System.out.println("###################");
		System.out.println("# FighterJet Info #");
		System.out.println(fighterJet.toString());//print out details of fighterJet object 
		System.out.println();
		System.out.print("Ready for takeoff? (y/n): "); //prompt user if they are ready for takeoff
		userInput = input.nextLine();

		//while loop that continues to prompt user for takeoff until they input "y"
		while (!userInput.equals("y")) {
			System.out.println("Pilot will be prompted again in 5 seconds.");
			System.out.println("Please ensure takeoff preparations are complete.");
			wait(5000); //wait 5000 milliseconds because it is equal to 5 seconds
			System.out.print("Ready for takeoff? (y/n): ");
			userInput = input.nextLine();
		}

		//simulate a fighter jet's fast takeoff
		fighterJet.avTakeoff(); 
		for (int i = 0 ; i < 3 ; i++) {
			wait(500); //simulate fast takeoff with less wait time
			System.out.print("...");
		}
		System.out.println();

		//simulate fighter jet flying quickly
		fighterJet.avFly();
		for (int i = 0; i < 4 ; i++) {
			wait(500);
			System.out.print("...");
		}
		System.out.println();

		//simulate fighter jet breaking the sound barrier
		fighterJet.breakSoundBarrier();

		//land the fighter jet 
		fighterJet.avLand();
		System.out.println();


		//cargo plane simulation 
		System.out.println("###################");
		System.out.println("# CargoPlane Info #");
		System.out.println(cargoPlane.toString()); //display details of cargoPlane object
		System.out.println();
		System.out.print("Ready for takeoff? (y/n): "); //prompt user if they are ready for takeoff
		userInput = input.nextLine();

		//another while loop that continues to prompt user for takeoff until they enter "y"
		while (!userInput.equals("y")) {
			System.out.println("Pilot will be prompted again in 5 seconds.");
			System.out.println("Please ensure takeoff preparations are complete.");
			wait(5000);
			System.out.print("Ready for takeoff? (y/n): ");
			userInput = input.nextLine();
		}

		//simulate cargo plane's slow takeoff
		cargoPlane.avTakeoff();
		for (int i = 0 ; i < 3 ; i++) {
			wait(2000);//cargo plane is slower than fighter jet so simulated with more wait time 
			System.out.print("...");
		}
		System.out.println();

		//simulate cargo plane flying
		cargoPlane.avFly();
		for (int i = 0; i < 5 ; i++) {
			wait(2000);
			System.out.print("...");
		}
		System.out.println();

		//simulate cargo plane landing 
		cargoPlane.avLand();

		//close the scanner object 
		input.close();

	}


	// I received help from stack overflow on this static function that delays a certain amount of milliseconds
	// source: https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
	public static void wait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		}
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}
