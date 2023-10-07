//alan vo 
//occc fall 2023 
//advanced java 
//testShape program
import java.awt.Color;
public class testShape {
	public static void main(String[] args) {
		//create new ellipse
		Ellipse ellipse1 = new Ellipse (1, 2, 10, 12);
		ellipse1.drawShape();
		System.out.println();

		//create new rectangle 
		Rectangle rectangle1 = new Rectangle (3, 5, 3, 8);
		rectangle1.setColor(Color.BLUE);
		rectangle1.setFill(Shape.SHAPE_SET_FILL); //test fill shape, should print out that rectangle is filled
		rectangle1.drawShape();
		System.out.println();

		//create new circle 
		Circle circle1 = new Circle (5, 7, 6);
		circle1.setFill(Shape.SHAPE_SET_FILL);
		circle1.drawShape();
		System.out.println();
		circle1.setColor(Color.PINK);
		circle1.setFill(Shape.SHAPE_SET_OUTLINE); 
		circle1.setX(10); //test setter for x
		circle1.setY(12); //test setter for y
		circle1.drawShape();
		System.out.println();

		//create new square
		Square square1 = new Square (120, 332, 50);
		square1.setColor(Color.GREEN);
		square1.setFill(Shape.SHAPE_SET_FILL);
		square1.drawShape();
		System.out.println();
		
		//create new triangle 
		EquilateralTriangle triangle1 = new EquilateralTriangle (0, 0, 9, 10);
		triangle1.setFill(Shape.SHAPE_SET_FILL);
		triangle1.setColor(Color.YELLOW);
		triangle1.drawShape();
	}
}
