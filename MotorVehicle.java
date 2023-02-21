/**
 * Name: Alan Vo 
 * Date: 02/20/23
 * File: MotorVehicle.java
 * Description: This program is the superclass of the MonsterTruck subclass 
 */
public class MotorVehicle {

	//declare private data members 
	private int truckYearBuilt;
	private String truckName;
	private String truckBodyType;
	private String truckPowerPlant;


	//default constructor 
	public MotorVehicle() {

	}

	//constructor that takes all data members as arguments 
	public MotorVehicle(int truckYearBuilt, String truckName, String truckBodyType, String truckPowerPlant) {
		this.truckYearBuilt = truckYearBuilt; 
		this.truckName = truckName;
		this.truckBodyType = truckBodyType;
		this.truckPowerPlant = truckPowerPlant;
	}


	//getters and setters 
	public int getTruckYearBuilt() {
		return truckYearBuilt;
	}
	public void setTruckYearBuilt(int truckYearBuilt) {
		this.truckYearBuilt = truckYearBuilt;
	}
	public String getTruckName() {
		return truckName;
	}
	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}
	public String getTruckBodyType() {
		return truckBodyType;
	}
	public void setTruckBodyType(String truckBodyType) {
		this.truckBodyType = truckBodyType;
	}
	public String getTruckPowerPlant() {
		return truckPowerPlant;
	}
	public void setTruckPowerPlant(String truckPowerPlant) {
		this.truckPowerPlant = truckPowerPlant;

	}


	//toString() method that prints out details of motor vehicle object
	@Override
	public String toString() {
		return "Name: " + truckName + "\nBody type: " + truckBodyType + "\nPower Plant: " + truckPowerPlant + "\nYear: " + truckYearBuilt;
	}

}