//alan vo 
//occc fall 2023
//advanced java 
//equilateral triangle subclass of abstract shape parent class
public class EquilateralTriangle extends Shape{
	protected double base; 
	protected double height;

	//triangle constructor
	public EquilateralTriangle(double x, double y, double base, double height) {
		super.x = x; 
		super.y = y;
		this.base = base; 
		this.height = height;
	}

	//implement abstract methods
	public double getArea() {
		return 0.5 * (base * height);
	}
	public double getPerimeter() {
		return base * 3;
	}
	public void drawShape() {
		System.out.println("For the equilateral triangle with base " + base + ", and height " + height + 
				", the area is " + getArea() + ", and the perimeter is " + getPerimeter() + ".");
		System.out.print("The upper left coordinates of this equilateral triangle is (" + x + ", " + y + ") " + "and the color is: " + super.getColor() + ". ");
		if (super.getFill() == false) {
			System.out.println("The equilateral triangle is not filled.");
		}
		else {
			System.out.println("The equilateral triangle is filled.");
		}
	}
}
