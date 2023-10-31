//alan vo 
//occc fall 2023 
//advanced java 
//2d objects jpanel

import java.awt.*;
import javax.swing.*;

public class ADV_MyHouse extends JPanel{



 
 public ADV_MyHouse(){

this.setPreferredSize(new Dimension(600,600));
 }
 

 public void paint(Graphics g) {
  
  Graphics2D g2D = (Graphics2D) g;
  
  g2D.setPaint(Color.cyan);
  g2D.fillRect(0, 0, 600, 600);
  //title
  g2D.setPaint(Color.white);
  g2D.setFont(new Font("Ink Free",Font.BOLD,50));
  g2D.drawString("This is my house!", 100, 50);  
  
 //roof 
  int [] xPoints = {150, 300, 450};
  int [] yPoints = {200, 100, 200};

  g2D.setPaint(Color.DARK_GRAY);
  g2D.fillPolygon(xPoints, yPoints, 3);
  
  //house rectangle
  g2D.setPaint(Color.LIGHT_GRAY);
  g2D.fillRect(150, 200, 300, 200);
  
  //grass
  g2D.setPaint(Color.green);
  g2D.fillRect(0, 400, 600, 200);
  
  
  //door 
  g2D.setPaint(Color.WHITE);
  g2D.fillRect(275, 300, 50, 100);
  //door knob
  g2D.setPaint(Color.black);
  g2D.fillOval(305, 350, 10, 10);
  
  //sun
  g2D.setPaint(Color.yellow);
  g2D.fillOval(0, 0, 100, 100);
  g2D.setPaint(Color.orange);
  g2D.fillOval(5, 5, 90, 90);

  }
 
 
 
 
 
  
 
}