/**
 * Name: Alan Vo 
 * Date: 02/25/23
 * File: CargoPlane.java
 * Description: This program consists of the CargoPlane class's private data members, constructors, getters/setters, and methods
 */
//only implement methods from AirVehicle interface
public class CargoPlane implements AirVehicle {
	//private data members 
	private int numberOfEngines;
	private int numberOfCrewMembers;
	private String nameOfPlane;
	private String manufacturer;


	//default constructor 
	public CargoPlane() {

	}

	//constructor that takes all data members as arguments
	public CargoPlane(int numberOfEngines, int numberOfCrewMembers, String nameOfPlane, String manufacturer) {
		this.numberOfEngines = numberOfEngines;
		this.numberOfCrewMembers = numberOfCrewMembers; 
		this.nameOfPlane = nameOfPlane; 
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

	public String getNameOfPlane() {
		return nameOfPlane;
	}

	public void setNameOfPlane(String nameOfPlane) {
		this.nameOfPlane = nameOfPlane;
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
		return "CargoPlane [numberOfEngines=" + numberOfEngines + ", numberOfCrewMembers=" + numberOfCrewMembers
				+ ", nameOfPlane=" + nameOfPlane + ", manufacturer=" + manufacturer + "]";
	}


	//implement methods from AirVehicle interface 
	public void avTakeoff() {
		System.out.print(nameOfPlane + " has started the takeoff roll.");
	}
	public void avFly() {
		System.out.print(nameOfPlane + " has taken off and is now flying." + "\nFlying");
	}
	public void avLand() {
		System.out.println(nameOfPlane + " has successfully landed.");
	}


}
