//alan vo 
//occc fall 2023
//advanced java
//generic gui app

import javax.swing.*;
import java.awt.*;

public class GenericGUIApp extends JFrame{
	public static final int WIDTH = 600;
	public static final int HEIGHT = 800;
	
	
	public static void main(String [] args) {
		GenericGUIApp g = new GenericGUIApp();
	}
	
	public GenericGUIApp() {
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("GenericGUIApp!!!");
		setLayout(new GridLayout(1,1));
		
		JPanel jp = new CarSalesJPanel();
		add(jp);
		setResizable(false);
		setVisible(true);
		
		
		
		
		
	}
}
	
	

