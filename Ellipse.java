//alan vo 
//occc fall 2023
//advanced java 
//ellipse child class of shape 
public class Ellipse extends Shape {

	protected double radius1;
	protected double radius2;


	//ellipse constructor 
	public Ellipse(double x, double y, double r1, double r2) {
		super.x = x; 
		super.y = y;
		this.radius1 = r1; 
		this.radius2 = r2;
	}

	//had help implenmenting formulas for area and perimeter from: https://www.geeksforgeeks.org/how-to-find-the-perimeter-and-area-of-ellipse/
	public double getArea() {
		return Math.PI * (radius1 * radius2);
	}
	public double getPerimeter() {
		return 2.0 * Math.PI * Math.sqrt(((radius1* radius1) + (radius2 * radius2)) / 2.0);  
	}
	//For now the drawing methods will simply write text to the console. Make it fairly detailed: for instance, it should specify the
	//upper-left coordinates and the various parameters that make up the shape and specify the color
	//and such.
	public void drawShape() {
		System.out.println("For the ellipse with radius 1 equal to " + radius1 + ", and radius 2 equal to " + radius2 + 
				", the area is " + getArea() + ", and the perimeter is " + getPerimeter() + ".");
		System.out.print("The upper left coordinates of this ellipse is (" + x + ", " + y + ") " + "and the color is: " + super.getColor() + ". ");
		if (super.getFill() == false) {
			System.out.println("The ellipse is not filled.");
		}
		else {
			System.out.println("The ellipse is filled.");
		}
	}
}
