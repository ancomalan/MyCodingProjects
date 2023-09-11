//alan vo 
//occc fall 2023 
//advanced java 
//sieve of erathosthenes 
//I received help from Devon on how to "cross out" every multiple 
import java.util.Scanner; 
public class SieveOfErathosthenes {

	public static void main(String[] args) {
		System.out.println("Welcome to the Sieve of Eratosthenes Program!");
		int start = 0; //variable to store starting value 
		int stop = 0; //variable to store stopping value

		//command prompt 
		if (args.length == 2) {
			start = Integer.parseInt(args[0]);
			stop = Integer.parseInt(args[1]); 
		}
		//if no command line parameters, prompt user 
		else {
			Scanner input = new Scanner (System.in); //create scanner object
			System.out.print("Please enter a starting value (greater than 1): "); //prompt user for starting value greater than 1 
			start = input.nextInt();
			if (start <= 1) {
				System.out.println("Invalid starting point!");
				System.exit(0);
			}
			System.out.print("Please enter a stopping value: ");
			stop = input.nextInt();
			input.close();
		}

		//Use the stop value to create an array of type boolean and set every value to true.
		int sizeOfArray = stop; //size of array
		int numOfPrimes = 0; //running total variable to check for total number of primes 
		boolean [] array = new boolean [sizeOfArray];
		//for loop to set all array elements to true
		for (int i = 1; i <= stop - 1; i++) {
			array[i] = true;
		}

		//implement Sieve algorithm
		//got help from Devon on lines 44 - 52. He got help from https://www.geeksforgeeks.org/sieve-of-eratosthenes/
		for (int k = 2; k * k <= (stop - 1); k++) {
			if(array[k] == true) {

				//cancel multiples
				for (int i = k * k; i <= stop-1; i += k) {
					array[i] = false;
				}
			}
		}

		//check new array and print out number of primes (true elements)
		for (int p = start; p <= stop -1 ; p++) {
			if (array[p] == true) {
				numOfPrimes++;
			}
		}
		System.out.println(numOfPrimes + " primes from " + start + " to " + stop);
	}
}
