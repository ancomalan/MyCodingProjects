//alan vo 
//occc fall 2023
//advanced java
//Invalid occc date exception

//extends exception is checked exception
public class InvalidOCCCDateException extends IllegalArgumentException {
	private final static String DEFAULT_MSG = "INVALID OCCC DATE EXCEPTION";
	private String msg; 
	
	public InvalidOCCCDateException() {
		super(DEFAULT_MSG);
		msg = DEFAULT_MSG;
	}
	
	public InvalidOCCCDateException(String msg) {
		super(msg);
		this.msg = msg;
	}
	public String getMessage() {
		return msg;
	}
	public String toString() {
		return this.getClass().getName() + ": " + msg;
	}

}
