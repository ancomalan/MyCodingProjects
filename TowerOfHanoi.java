//alan vo 
//occc fall 2023
//advanced java 
//tower of hanoi

import java.util.Scanner;
public class TowerOfHanoi {
	//I had help on writing this function from: https://www.vogella.com/tutorials/JavaAlgorithmsTowersOfHanoi/article.html
	//I also watched this video to understand how the recursion worked: https://www.youtube.com/watch?v=q6RicK1FCUs&t=499s
	public static void TOH (int number_of_disks, int start, int end) {
		//base case
		if (number_of_disks == 1){
			System.out.println("Move the disk from spindle " + start + " to spindle " + end);
			return;
		}
		//general case
		if (number_of_disks > 1) {
		int undesignatedSpindle = 6 - start - end; //pole which is neither start or end 
		TOH(number_of_disks-1, start, undesignatedSpindle); //move n-1 disks from start spindle to undesignated spindle
		System.out.println("Move the disk from spindle " + start + " to spindle " + end);
		TOH(number_of_disks-1, undesignatedSpindle, end); //move n-1 disks from undesignated spindle to end spindle
		}
	}


	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Welcome to the Tower Of Hanoi Program!");
		//Prompt the user for the number of disks, and accept that value. Validate the user input; make them repeat if invalid 
		//check command line first 
		int number_of_disks = 0; 
		int start = 0; 
		int stop = 0; 
		if (args.length == 3) {
			number_of_disks = Integer.parseInt(args[0]);
			//validate number of disks
			if (number_of_disks <= 0) {
				System.out.print("Error! Please enter a positive integer for the amount of disks. ");
				System.exit(0);

			}
			start = Integer.parseInt(args[1]);
			//validate starting spindle 
			if (start != 1 && start != 2 && start != 3) {
				System.out.println("Error! The starting spindle must be 1, 2, or 3!");
				System.exit(0);
			}
			stop = Integer.parseInt(args[2]);
			if ((stop != 1 && stop != 2 && stop != 3) || stop == start ) {
				System.out.println("Error! The final spindle must be 1, 2, or 3, and must not equal the starting spindle!");
				System.exit(0);
			}
		}
		else {
			System.out.print("Please enter the amount of disks: ");
			number_of_disks = input.nextInt();
			//validate number of disks
			while (number_of_disks <= 0) {
				System.out.print("Error! Please enter a positive integer for the amount of disks: ");
				number_of_disks = input.nextInt();
			}

			System.out.print("Please enter starting spindle (1, 2, or 3) : ");
			start = input.nextInt();
			//validate starting spindle 
			while (start != 1 && start != 2 && start != 3) {
				System.out.println("Error! The starting spindle must be 1, 2, or 3!");
				System.out.print("Please enter starting spindle (1, 2, or 3) : ");
				start = input.nextInt();
			}
			System.out.print("Please enter which spindle you would like to end up at (1, 2 , or 3): ");
			stop = input.nextInt();
			//validate end spindle
			while ((stop != 1 && stop != 2 && stop != 3) || stop == start ) {
				System.out.println("Error! The final spindle must be 1, 2, or 3, and must not equal the starting spindle!");
				System.out.print("Please enter which spindle you would like to end up at (1, 2 , or 3): ");
				stop = input.nextInt();
			}
			System.out.println();
			
		}
		TOH(number_of_disks, start, stop); //Invoke the recursive TOH function with the now-validated input parameters
		input.close();
	}
}
