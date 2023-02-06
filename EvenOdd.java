import java.util.Scanner; 
public class EvenOdd {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int userInput = 0 ; 
		
		System.out.println("Enter Even Number: ");
		userInput = input.nextInt();
		
		while (userInput % 2 == 0) {
			System.out.println("Enter even number: ");
			userInput = input.nextInt();
		}
		
	//	do {
	//	System.out.println("Enter even number: ");
	//	userInput = input.nextInt();
	//	} while (userInput % 2 == 0);

		
		System.out.println("Goodbye!");

	 }
}
