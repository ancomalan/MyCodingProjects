import java.util.Scanner; 
public class AdditionTwo {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int number1; 
		int number2;
		System.out.println("Enter int 1: "); 
		number1 = input.nextInt(); 
		System.out.println("Enter int 2: ");
		number2 = input.nextInt();
		int sum = number1 + number2;
		System.out.println(); 
		System.out.println(number1 + " + " + number2 + " = " + sum);
		
		input.close(); // close scanner

	}
}

