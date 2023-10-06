//alan vo 
//occc fall 2023 
//advanced java 
//child class of person class
public class RegisteredPerson extends Person{
	//private data member
	private String govID;

	//constructors
	public RegisteredPerson(String firstName, String lastName, OCCCDate dob, String govID) {
		// use super (parent constructor) for child class in java
		super(firstName, lastName, dob);
		this.govID = govID; 
	}

	public RegisteredPerson (Person p, String govID) {
		super(p); //Call the parent constructor with the information you are given
		this.govID = govID;
	}

	public RegisteredPerson (RegisteredPerson p) {
		super(p);
		this.govID = p.govID;
	
	}


	//getter for government id
	public String getGovernmentID() {
		return new String(govID);
	}

	//equals method comparing first name, last name, and gov id between 2 persons
	public boolean equals(RegisteredPerson p) {
		
		return super.getFirstName().equalsIgnoreCase(p.getFirstName()) && super.getLastName().equalsIgnoreCase(p.getLastName()) && 
				govID.equalsIgnoreCase(p.govID);
	}
	
	// compare only Person fields, ignore government ID
	public boolean equals(Person p) {
		return super.getFirstName().equalsIgnoreCase(p.getFirstName()) && super.getLastName().equalsIgnoreCase(p.getLastName());
	}

	//toString Method
	@Override 
	public String toString() {
		return super.toString() + " [" + govID + "]";

	}


}
