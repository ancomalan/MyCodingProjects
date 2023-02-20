/**
 * Name: Alan Vo 
 * Date: 02/19/23
 * File: MonsterTruckRunner.java
 * Description: This program creates two monster truck objects, initializes their data variables, and displays their information to the user
 */
public class MonsterTruckRunner {

	public static void main(String[] args) {
		
		//create first monster truck object using the default constructor
		MonsterTruck truck1 = new MonsterTruck();
		
		//use setters to populate all data variables
		truck1.setTruckName("Max D");
		truck1.setTruckBodyType("silver");
		truck1.setTruckPowerPlant("gasoline");
		truck1.setTruckYearBuilt(2022);
		truck1.setNumberOfWins(10);
		truck1.setNumberOfLosses(2);
		truck1.setSpecialManuever("donut");


		//display information about first truck object using getter methods
		System.out.println("============================");
		System.out.println(truck1.getTruckName() + " INFO");
		System.out.println("============================");
		System.out.println();
		System.out.println("Name: " + truck1.getTruckName());
		System.out.println("Body type: " + truck1.getTruckBodyType());
		System.out.println("Power Plant: " + truck1.getTruckPowerPlant());
		System.out.println("Year: " + truck1.getTruckYearBuilt());
		System.out.println("# Wins: " + truck1.getNumberOfWins());
		System.out.println("# Losses: " + truck1.getNumberOfLosses());
		System.out.println("Special Trick: " + truck1.getSpecialManuever());
		truck1.calcWinningPercentage(truck1.getNumberOfWins(), truck1.getNumberOfLosses()); //call the win percentage method to display the winning percentage of truck object
		System.out.println(); 


		//create second monster truck object using the constructor with all arguments to initialize all data variables 
		MonsterTruck truck2 = new MonsterTruck(20, 10, "sidewinder", 2021, "Grave Digger", "black", "gasoline");
		
		//display information about second truck object 
		System.out.println();
		System.out.println("============================");
		System.out.println(truck2.getTruckName() + " INFO");
		System.out.println("============================");
		System.out.println();
		System.out.println(truck2.toString()); //call toString method to print object's information
		truck2.calcWinningPercentage(truck2.getNumberOfWins(), truck2.getNumberOfLosses());
	}

}
