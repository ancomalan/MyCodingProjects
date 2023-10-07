//alan vo 
//occc fall 2023
//advanced java 
//circle child class of ellipse class
public class Circle extends Ellipse {
	//The only code in the child classes are constructors;
	//everything else is inherited from their respective parents
	public Circle(double x, double y, double r) {
		super (x, y, r, r);
	}
}
