//alan vo 
//occc fall 2023
//advanced java 
//rectangle child class of shape
public class Rectangle extends Shape {
	protected double width; 
	protected double height;

	public Rectangle(double x, double y, double width, double height) {
		super.x = x; 
		super.y = y; 
		this.width = width;
		this.height = height;
	}

	public double getArea() {
		return width * height;
	}
	public double getPerimeter() {
		return width + width + height + height;
	}
	public void drawShape() {
		System.out.println("For the rectangle with width " + width + ", and height " + height + 
				", the area is " + getArea() + ", and the perimeter is " + getPerimeter() + ".");
		System.out.print("The upper left coordinates of this rectangle is (" + x + ", " + y + ") " + "and the color is: " + super.getColor() + ". ");
		if (super.getFill() == false) {
			System.out.println("The rectangle is not filled.");
		}
		else {
			System.out.println("The rectangle is filled.");
		}
	}
}
