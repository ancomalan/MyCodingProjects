/**
 * Name: Alan Vo 
 * Date: 02/25/23
 * File: FighterJet.java
 * Description: This program consists of the FighterJet class's private data members, constructors, getters/setters, and methods
 */
//implement methods from both interfaces
public class FighterJet implements AirVehicle, SoundBarrier{
	//private data members 
	private int numberOfEngines;
	private int numberOfCrewMembers;
	private String nameOfJet;
	private String manufacturer;


	//default constructor
	public FighterJet(){

	}

	//constructor that takes all data variables as arguments
	public FighterJet(int numberOfEngines, int numberOfCrewMembers, String nameOfJet, String manufacturer) {
		this.numberOfEngines = numberOfEngines;
		this.numberOfCrewMembers = numberOfCrewMembers; 
		this.nameOfJet = nameOfJet; 
		this.manufacturer = manufacturer;

	}


	//getters and setters
	public int getNumberOfEngines() {
		return numberOfEngines;
	}

	public void setNumberOfEngines(int numberOfEngines) {
		this.numberOfEngines = numberOfEngines;
	}

	public int getNumberOfCrewMembers() {
		return numberOfCrewMembers;
	}

	public void setNumberOfCrewMembers(int numberOfCrewMembers) {
		this.numberOfCrewMembers = numberOfCrewMembers;
	}

	public String getNameOfJet() {
		return nameOfJet;
	}

	public void setNameOfJet(String nameOfJet) {
		this.nameOfJet = nameOfJet;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	//toString() method
	@Override
	public String toString() {
		return "FighterJet [numberOfEngines=" + numberOfEngines + ", numberOfCrewMembers=" + numberOfCrewMembers
				+ ", nameOfJet=" + nameOfJet + ", manufacturer=" + manufacturer + "]";
	}


	//implement methods from both interfaces 
	public void avTakeoff() {
		System.out.print(nameOfJet + " has started the takeoff roll.");
	}
	public void avFly() {
		System.out.print(nameOfJet + " has taken off and is now flying." + "\nFlying");
	}
	public void avLand() {
		System.out.println(nameOfJet + " has successfully landed.");
	}

	public void breakSoundBarrier() {
		System.out.println(nameOfJet + " broke the sound barrier!");
	}


}
