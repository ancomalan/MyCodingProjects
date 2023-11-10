//alan vo 
//occc fall 2023
//advanced java
//java fx bonus widget 
package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		Group root = new Group();
		Scene scene = new Scene(root, 600, 600, Color.LIGHTSKYBLUE);
		Stage stage = new Stage();

		Text text = new Text();
		text.setText("It is a beautiful day today!");
		text.setX(40);
		text.setY(40);
		text.setFont(Font.font("Verdana", 40));
		text.setFill(Color.MIDNIGHTBLUE);

		//grass
		Rectangle rectangle = new Rectangle();
		rectangle.setX(0);
		rectangle.setY(400);
		rectangle.setWidth(600);
		rectangle.setHeight(200);
		rectangle.setFill(Color.DARKGREEN);
		rectangle.setStrokeWidth(5);
		rectangle.setStroke(Color.DARKOLIVEGREEN);

		//house rectangle
		Rectangle rectangle2 = new Rectangle();
		rectangle2.setX(150);
		rectangle2.setY(200);
		rectangle2.setWidth(300);
		rectangle2.setHeight(200);
		rectangle2.setFill(Color.SANDYBROWN);
		rectangle2.setStrokeWidth(5);
		rectangle2.setStroke(Color.BLACK);

		//door
		Rectangle rectangle3 = new Rectangle();
		rectangle3.setX(275);
		rectangle3.setY(300);
		rectangle3.setWidth(50);
		rectangle3.setHeight(100);
		rectangle3.setFill(Color.CHOCOLATE);
		rectangle3.setStrokeWidth(5);
		rectangle3.setStroke(Color.BLACK);


		//roof of house
		Polygon triangle = new Polygon();
		triangle.getPoints().setAll(
				150.0,200.0,
				300.0,100.0,
				450.0,200.0
				);
		triangle.setFill(Color.SADDLEBROWN);
		triangle.setStrokeWidth(10);
		triangle.setStroke(Color.BLACK);

		//sun
		Circle circle = new Circle();
		circle.setCenterX(500);
		circle.setCenterY(100);
		circle.setRadius(50);
		circle.setFill(Color.ORANGE);

		//door knob
		Circle circle2 = new Circle();
		circle2.setCenterX(305);
		circle2.setCenterY(350);
		circle2.setRadius(5);
		circle2.setFill(Color.BEIGE);

		Image image = new Image("Window.png");
		ImageView imageView = new ImageView(image);
		imageView.setX(200);
		imageView.setY(280);

		ImageView imageView2 = new ImageView(image);
		imageView2.setX(350);
		imageView2.setY(280);


		root.getChildren().add(text);
		root.getChildren().add(rectangle);
		root.getChildren().add(rectangle2);
		root.getChildren().add(rectangle3);
		root.getChildren().add(triangle);
		root.getChildren().add(circle);
		root.getChildren().add(circle2);
		root.getChildren().add(imageView);
		root.getChildren().add(imageView2);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
