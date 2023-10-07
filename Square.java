//alan vo 
//occc fall 2023 
//advanced java 
//square child class of rectangle class
public class Square extends Rectangle {
	//The only code in the child classes are constructors;
	//everything else is inherited from their respective parents
	public Square(double x, double y, double width) {
		super(x, y, width, width);
	}
}
