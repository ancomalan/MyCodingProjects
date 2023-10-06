//alan vo 
//occc fall 2023
//advanced java
//subclass of registeredPerson class
public class OCCCPerson extends RegisteredPerson{
	//private data members
	private String studentID; 
	
	//constructors
	public OCCCPerson (RegisteredPerson p, String studentID) {
		super(p);
		this.studentID = studentID;
	}
	
	public OCCCPerson (OCCCPerson p) {
		super(p);
		this.studentID = p.studentID;
	}
	
	//getters
	public String getStudentID () {
		return new String (studentID);
	}

	//equals method comparing first name, last name, gov id, and student id 
	public boolean equals(OCCCPerson p) {
		return super.getFirstName().equalsIgnoreCase(p.getFirstName()) && super.getLastName().equalsIgnoreCase(p.getLastName()) && 
				super.getGovernmentID().equalsIgnoreCase(p.getGovernmentID()) && studentID.equalsIgnoreCase(p.studentID);
	}
	//compare only RegisteredPerson fields, ignore student ID
	public boolean equals(RegisteredPerson p) {
		return super.getFirstName().equalsIgnoreCase(p.getFirstName()) && super.getLastName().equalsIgnoreCase(p.getLastName())
				&& super.getGovernmentID().equalsIgnoreCase(p.getGovernmentID());
	
}
	// compare only name and DOB fields
	public boolean equals(Person p) {
		return super.getFirstName().equalsIgnoreCase(p.getFirstName()) && super.getLastName().equalsIgnoreCase(p.getLastName());
	}
	// adds {studentID} to end of string
	//toString method
	public String toString() {
		return super.toString() + " {" + studentID + "}";

	}

}

