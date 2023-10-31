//alan vo 
//occc fall 2023
//advanced java
//mouse motion demo

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseMotionJPanel extends JPanel implements MouseMotionListener, MouseListener{
	
	
	JLabel x_coord, y_coord;
	JButton leftButton, middleButton, rightButton;
	
	Color c;
	
	
	public MouseMotionJPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		x_coord = new JLabel ("X: ");
		y_coord = new JLabel ("Y: ");
		
		northPanel.add(x_coord);
		northPanel.add(y_coord);
		
		leftButton = new JButton("Left");
		middleButton = new JButton("Middle");
		rightButton = new JButton ("Right");
		
		c = leftButton.getBackground();//grab copy of current color to set them back to after mouse released

		southPanel.add(leftButton);
		southPanel.add(middleButton);
		southPanel.add(rightButton);
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		
		
		//listen to events
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		//leftButton.addMouseMotionListener(this); 
		//middleButton.addMouseMotionListener(this);
		//rightButton.addMouseMotionListener(this);
		//gives coordinates within component but not behind it so comment out 
		
		leftButton.addMouseListener(this);
		middleButton.addMouseListener(this);
		rightButton.addMouseListener(this);
		
		

		
		
	}
	
	//Mouse Listener methods
	public void mouseClicked(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == leftButton) {
			leftButton.setBackground(Color.RED);
		}
		if (e.getSource() == middleButton) {
			middleButton.setBackground(Color.RED);
		}
		if (e.getSource() == rightButton){
			rightButton.setBackground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent e) {
		Object theButton = e.getSource();
		if (theButton == leftButton) {
			leftButton.setBackground(c);
		}
		if (theButton == middleButton) {
			middleButton.setBackground(c);
		}
		if (theButton == rightButton) {
			rightButton.setBackground(c);
		}
		
	}
	public void mousePressed (MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftButton.setBackground(Color.RED);
		}
		if (e.getButton() == MouseEvent.BUTTON2) {
			middleButton.setBackground(Color.RED);
		}
		if (e.getButton() ==MouseEvent.BUTTON3) {
			rightButton.setBackground(Color.RED);
		}
	}
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftButton.setBackground(c);
		}
		if (e.getButton() == MouseEvent.BUTTON2) {
			middleButton.setBackground(c);
		}
		if (e.getButton() ==MouseEvent.BUTTON3) {
			rightButton.setBackground(c);
		}
	}
	
	
	
	
	
	
	// MouseMotionListener methods
	
	//empty but concrete method
	public void mouseDragged (MouseEvent e) {}
	public void mouseMoved (MouseEvent e) {
		x_coord.setText("X: " + e.getX());
		y_coord.setText("Y: " + e.getY());
	}
}
