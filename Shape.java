//alan vo 
//occc fall 2023
//advanced java 
//shape parent abstract class
import java.awt.Color;
public abstract class Shape {
	//data members
	protected double x, y; //upper left corner of bounding box
	protected Color c;
	protected boolean fill; 
	public static boolean SHAPE_DEFAULT_FILL = false;
	public static Color SHAPE_DEFAULT_COLOR = Color.gray;
	public static boolean SHAPE_SET_FILL = true; // use with setFill
	public static boolean SHAPE_SET_OUTLINE = false; // use with setFill

	//constructor 
	protected Shape() {
		// sets Color and fill to default values
		this.c = SHAPE_DEFAULT_COLOR; //gray
		this.fill = SHAPE_DEFAULT_FILL; //false, not filled
	}

	//getter for color 
	public Color getColor() {
		return c;
	}
	//setter for color
	public void setColor(Color c) {
		this.c = c;
	}

	//getter for if shape is filled or not, default is not filled
	public boolean getFill() {
		return fill;
	}
	//setter for fill 
	public void setFill(boolean f) {
		this.fill = f;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	//abstract methods
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract void drawShape(); 
	//For now the drawing methods will simply write text to the console. 
	//Make it fairly detailed: for instance, it should specify the
	//upper-left coordinates and the various parameters that make up the shape and specify the color
	//and such.

}
