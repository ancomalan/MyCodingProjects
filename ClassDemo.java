import java.util.Scanner;
public class ClassDemo {

	public static void main(String[] args) {
	String name; // strings are objects made from classes and that is why it has to be uppercase
	Scanner input = new Scanner (System.in);
	System.out.print("Please enter your name: ");
	name = input.nextLine(); 
	System.out.println("Hello, " + name + "!");
	System.out.println("There are " + name.length() + " letters in your name.");
	}

}
