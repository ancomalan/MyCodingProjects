//alan vo 
//occc fall 2023
//advanced java 
//sorting 
//C:\Users\bvo10\OneDrive\Desktop\sortingTest1.txt
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class Sorting {
	public static void main(String[] args) {
		String fileName = ""; 
		String outputFileName = ""; //for writing results to
		Scanner s = new Scanner (System.in); 
		ArrayList<String> list = new ArrayList<>(); //create string array list to use later for checking if all occurrences of a word begin with uppercase letter

		/*If the program is run with one command-line parameter, use that parameter to create the output file name 
		by stripping away the file extension and replacing it with .out. */
		if (args.length == 1) {
			fileName = args[0];
			outputFileName = fileName.substring(0,fileName.indexOf('.'))+".out";
		}

		/*If the program is run with two input parameters, accept the second parameter as the name of an output file and write all results to that file. */
		else if (args.length == 2) {
			fileName = args[0];
			outputFileName = args[1];
		}
		//If the program is run without a command-line parameter, prompt the user for the input filename and display the results to the console.
		else {
			System.out.print("Please enter a file name: ");
			fileName = s.nextLine();
			outputFileName = fileName.substring(0,fileName.indexOf('.'))+".out";
		}




		try {
			Scanner f = new Scanner (new File (fileName));
			String key = ""; // to store each word extracted from file
			Map<String, Integer> map = new TreeMap<>(); // Create a TreeMap to hold words as key and count as value

			while (f.hasNext()) {
				key = f.next(); //get the next token (word)
				key = key.replaceAll("[^a-zA-Z0-9]", ""); //strip out punctuation, special characters, and spaces 	
				list.add(key);//add to array list the original cased words to use in function later
				key = key.toLowerCase();


				if (key.length() > 0) {
					if (!map.containsKey(key)) {
						map.put(key, 1);
					}
					else {
						int value = map.get(key);//get the value for the key
						value++;
						map.put(key, value);	
					}
				}
			}


			//display contents of tree map to console
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				String originalKey = entry.getKey();
				int value = entry.getValue();

				if (value == 1) {
					if (allWordsStartWithUppercase (list, originalKey)) {  
						String result = originalKey.substring(0, 1).toUpperCase() + originalKey.substring(1); //change word to start with uppercase letter
						System.out.println(result);

					}
					else {
						System.out.println(originalKey);

					}

				}
				else {
					if (allWordsStartWithUppercase (list, originalKey)) {
						String result = originalKey.substring(0, 1).toUpperCase() + originalKey.substring(1); //change word to start with uppercase letter
						System.out.println(result + " (" + value + ")");

					}
					else {
						System.out.println(originalKey + " (" + value + ")");
					}

				}
			}


			//print to output file 
			PrintWriter output = new PrintWriter(outputFileName);  //create print writer object to write to file
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				String originalKey = entry.getKey();
				int value = entry.getValue();

				if (value == 1) {
					if (allWordsStartWithUppercase (list, originalKey)) {  
						String result = originalKey.substring(0, 1).toUpperCase() + originalKey.substring(1); 
						output.println(result);

					}
					else {
						output.println(originalKey);

					}

				}
				else {
					if (allWordsStartWithUppercase (list, originalKey)) {
						String result = originalKey.substring(0, 1).toUpperCase() + originalKey.substring(1);  
						output.println(result + " (" + value + ")");

					}
					else {
						output.println(originalKey + " (" + value + ")");
					}

				}
			}

			output.close();//close the file 
			s.close();

		}
		catch (FileNotFoundException e){
			System.out.println("File " + outputFileName + " was not found!");
			System.out.println(e.toString());
			System.exit(0);
		}
	}

	//function to check for whether all occurences of a word begin with a uppercase letter or not 
	public static boolean allWordsStartWithUppercase(ArrayList <String> list, String key){
		boolean flag = false; 
		//loop through the array list 
		for (int i = 0 ; i < list.size(); i++){
			if (list.get(i).equalsIgnoreCase(key)) {
				if (Character.isUpperCase(list.get(i).charAt(0))) {
					flag = true;
				}
				else {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
}

