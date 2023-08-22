//alan vo 
//occc fall 2023
//advanced java
//magic 8ball program

import java.util.Scanner; //to read input from the keyboard
public class Magic8Ball {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //create scanner object to read input from user
		String question; //to store user's question
		int count = 0; //to store the number of questions answered
		String[] answers = {"Don't count on it!", "Very doubtful", "My reply is no", "Ask again later", "Better not tell you now", "Cannot predict now",
				"Signs point to yes", "Most likely", "Without a doubt", "It is certain"}; // create an array that stores all the possible answers from 8Ball
		
		System.out.print("Please enter a question for the Magic 8 Ball to answer (enter an empty string if you would like to exit): "); // prompt user for question
		question = input.nextLine(); //accept question

		//create a while loop that keeps accepting questions from the user as long as there is no empty string 
		while (!question.isEmpty()) {
			System.out.println(answers[(int)(Math.random() * 10)]); //print out a random answer from answers array by generating random array index from 0-9 
			count++; //increment everytime a question is asked
			System.out.print("Please enter a question for the Magic 8 Ball to answer (enter an empty string if you would like to exit): ");
			question = input.nextLine();
		}
		
		System.out.println("Number of questions answered: " + count); //After program exits, state how many questions were answered
	
	}
}
