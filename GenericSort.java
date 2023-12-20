//alan vo 
//occc fall 2023 
//advanced java 
//generic insertion sort 
//had help with the insertion sort algorithm from this helpful video: https://www.youtube.com/watch?v=8mJ-OhcfpYg

//C:\Users\bvo10\OneDrive\Desktop\20Int.txt
//C:\Users\bvo10\OneDrive\Desktop\20String.txt
//C:\Users\bvo10\OneDrive\Desktop\20Double.txt
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GenericSort{
	public static void main(String[] args) {

		String fileName1; // for ints
		String fileName2; // for strings 
		String fileName3; // for characters

		System.out.println("Welcome to Generic Sort!");
		Scanner s = new Scanner (System.in);
		System.out.print("Please enter a file name with 20 integers: ");
		fileName1 = s.nextLine();
		System.out.print("Please enter a file name with 20 strings: ");
		fileName2 = s.nextLine();
		System.out.print("Please enter a file name with 20 doubles: ");
		fileName3 = s.nextLine();
		System.out.println();

		// Create an Integer array using file 
		try {
			Integer [] intArray = new Integer [20]; //create new int array that can hold 20 elements
			Scanner f = new Scanner (new File(fileName1));
			while (f.hasNext()){
				for (int i = 0; i < 20; i++) {
					Integer number = Integer.valueOf(f.nextInt());
					intArray[i] = number; //populate array with numbers
				}
			}

			System.out.print("Unsorted integers: ");
			printList(intArray); //display unsorted 20 numbers 
			System.out.print("Sorted integers: ");
			sort(intArray); //sort integers
			printList(intArray); //display sorted 20 numbers
			System.out.println();

			//finished with Integers now onto Strings
			String [] stringArray = new String [20];
			Scanner f2 = new Scanner (new File (fileName2));
			while (f2.hasNext()) {
				for (int i = 0 ; i < 20 ; i++) {
					String string = f2.next();
					stringArray[i] = string;
				}
			}

			System.out.print("Unsorted strings: ");
			printList(stringArray); //display unsorted 20 strings 
			System.out.print("Sorted strings: ");
			sort(stringArray); //sort integers
			printList(stringArray); //display sorted 20 strings
			System.out.println();

			//finally onto doubles
			Double [] doubleArray = new Double [20];
			Scanner f3 = new Scanner (new File (fileName3));
			while (f3.hasNext()) {
				for (int i = 0; i < 20 ; i++) {
					Double number = f3.nextDouble();
					doubleArray [i]= number;
				}
			}

			System.out.print("Unsorted doubles: ");
			printList(doubleArray); //display unsorted 20 strings 
			System.out.print("Sorted doubles: ");
			sort(doubleArray); //sort integers
			printList(doubleArray); //display sorted 20 strings



		}
		catch (FileNotFoundException e) {
			System.out.println("Files not found!");
			System.out.println(e.toString());
			System.exit(0);
		}
		s.close();
	}


	/** Sort an array of comparable objects using insertion sort*/
	public static <E extends Comparable<E>> void sort(E[] list) {
		E temp;

		//begin with index 1 
		for (int i = 1; i < list.length; i++) {
			temp = list[i];
			int j = i - 1; //keeps track of the variable being compared to temp on the left

			/* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
			while (j >= 0 && temp.compareTo(list[j]) < 0) {
				list[j + 1] = list[j]; //shift an element to the right
				j = j - 1;
			}
			list[j + 1] = temp;
		}
	}



	/** Print an array of objects */
	public static void printList(Object[] list) {
		for (int i = 0; i < list.length; i++) 
			System.out.print(list[i] + "   ");
		System.out.println();
	}
}
