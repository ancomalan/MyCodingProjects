/**
 * Name: Alan Vo 
 * Date: 02/20/23
 * File: MonsterTruck.java
 * Description: This program is a subclass of the MotorVehicle superclass
 */
public class MonsterTruck extends MotorVehicle {

	//private data members 
	private int numberOfWins; 
	private int numberOfLosses;
	private String specialManuever; 


	//default constructor 
	public MonsterTruck() {

	}

	//constructor that takes all data fields from the superclass as well
	public MonsterTruck(int numberOfWins, int numberOfLosses, String specialManuever, int truckYearBuilt, String truckName, String truckBodyType, String truckPowerPlant ) {
		super(truckYearBuilt, truckName, truckBodyType, truckPowerPlant); // initialize inherited data fields from superclass by calling superclass constructor
		this.numberOfWins = numberOfWins; 
		this.numberOfLosses = numberOfLosses; 
		this.specialManuever = specialManuever; 
	}


	//getters and setters
	public int getNumberOfWins() {
		return numberOfWins;
	}
	public void setNumberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}
	public int getNumberOfLosses() {
		return numberOfLosses;
	}
	public void setNumberOfLosses(int numberOfLosses) {
		this.numberOfLosses = numberOfLosses;
	}
	public String getSpecialManuever() {
		return specialManuever;
	}
	public void setSpecialManuever(String specialManuever) {
		this.specialManuever = specialManuever;
	}


	//modified toString() method that prints out the details from this subclass and the superclass by calling the superclass's toString() method
	@Override
	public String toString() {
		return super.toString() + "\n# Wins: " + numberOfWins + "\n# Losses: " + numberOfLosses + "\nSpecial Trick: " + specialManuever;
	}

	
	//winning percentage calculation method
	public void calcWinningPercentage(int numberOfWins, int numberOfLosses) {
		int totalGames = numberOfWins + numberOfLosses; 
		double WinningPercentage = (numberOfWins / (double)totalGames);
		WinningPercentage = (WinningPercentage * 100.0);
		System.out.printf("Win Percentage: %.2f", WinningPercentage);
		System.out.print("%");
	}

}
