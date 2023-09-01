import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//C:\Users\bvo10\OneDrive\Desktop\AdvancedJava\PasswordChecker\intPrimes.txt
//reads file and checks for number of prime numbers
public class PrimeChecker {
	public static boolean isPrime(String p) {
		boolean result = true; // set the result to true first 
		int x = Integer.parseInt(p);
		if (x >= 2) {
			int stop = (int)Math.sqrt(x);

			for (int d = 2; d <= stop; d++) {  
				if (x % d == 0) { // if a number is divided by 2 and has no remainder it is an even number
					result = false;
					break;
				}
			}
		}
		else {
			result = false;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Prime Checker!"); 
		System.out.println(); 
		String fileName = "";
		int numPrimes = 0; //running total to see how many passwords are valid in the file
		if (args.length == 1){
			fileName = args[0];
		}
		else {
			System.out.print("Please enter file name with passwords: ");
			Scanner s = new Scanner (System.in);
			fileName = s.nextLine();
		}
		try{
			Scanner f = new Scanner (new File(fileName));
			while (f.hasNextLine()){
				String numbers = f.nextLine();
				if (isPrime(numbers)) {
					numPrimes++; //keep track of valid passwords
				}
				
				

				
			}
			System.out.println("There are " + numPrimes + " prime numbers in the file " + fileName);
		}
		catch (FileNotFoundException e){
			System.out.println("File " + fileName + " was not found!");
			System.out.println(e.toString());
			System.exit(0);
		}

		
		
		
		
		
		
		
		
		
		

	}

}
