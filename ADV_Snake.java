//alan vo 
//occc fall 2023
//advanced java 
//snake game
//I learned a lot from: https://www.youtube.com/watch?v=bI6e6qjJ8JQ&t=1659s
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class ADV_Snake extends JPanel implements ActionListener{


	static final int SCREEN_WIDTH = 575;
	static final int SCREEN_HEIGHT = 550;
	static final int UNIT_SIZE = 25; //variable for how big the objects are in the snake game
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE); //variable for how many objects can fit on the screen
	static final int DELAY = 75; //controls how fast the snake is
	//create 2 arrays that hold all the coordinates for all the body parts of the snake, including the head
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int snakeBodyParts = 5;
	int applesEaten;
	int appleX; //x coordinate of random apple generated
	int appleY; //y coordinate of random apple generated
	char direction = 'R'; //have the snake go right when game starts
	boolean running = false;
	Timer timer;
	Random random;

	public ADV_Snake(){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.DARK_GRAY);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	public void startGame() {
		generateNewApple(); //create new apple 
		running = true;
		timer = new Timer(DELAY,this); //dictates how fast the game runs
		timer.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {

		if(running) {
			/*
				for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
					g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
					g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
				}
			 */
			//generate apple
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

			//draw head and body of snake
			for(int i = 0; i< snakeBodyParts;i++) {
				if(i == 0) { //dealing with head of snake
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
				else { //dealing with of body of snake
					g.setColor(new Color(45,180,0)); //create different color for body of snake
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}			
			}
			g.setColor(Color.red);
			g.setFont( new Font("Ink Free",Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
		}
		else {
			gameOver(g);
		}

	}
	//function to populate the game with apples
	public void generateNewApple(){
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}
	public void moveSnake(){
		for(int i = snakeBodyParts;i>0;i--) {
			x[i] = x[i-1]; //shift all coordinates over by 1 spot
			y[i] = y[i-1];
		}

		switch(direction) {
		case 'U': //up 
			y[0] = y[0] - UNIT_SIZE; //subtract y value because going up
			break;
		case 'D': //down 
			y[0] = y[0] + UNIT_SIZE; //add y value because going down
			break;
		case 'L': //left
			x[0] = x[0] - UNIT_SIZE; //subtract x value because going left
			break;
		case 'R': //right
			x[0] = x[0] + UNIT_SIZE; //add x value because going right
			break;
		}

	}
	public void checkApple() {
		//if coordinates of snake's head equals coordinates of apple
		if((x[0] == appleX) && (y[0] == appleY)) {
			snakeBodyParts++;
			applesEaten++; //score
			generateNewApple();
		}
	}
	public void checkCollisions() {
		//checks if head collides with body
		for(int i = snakeBodyParts;i>0;i--) {
			if((x[0] == x[i])&& (y[0] == y[i])) {
				running = false; //triggers game over method
			}
		}
		//check if head touches left border
		if(x[0] < 0) {
			running = false;
		}
		//check if head touches right border
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		//check if head touches top border
		if(y[0] < 0) {
			running = false;
		}
		//check if head touches bottom border
		if(y[0] > SCREEN_HEIGHT) {
			running = false;
		}

		if(!running) {
			timer.stop();
		}
	}
	public void gameOver(Graphics g) {
		//Score
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
		//Game Over text
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//if our game is running
		if(running) {
			moveSnake(); //move snake
			checkApple(); //
			checkCollisions();
		}
		repaint();
	}

	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') { //to prevent user from running into themselves
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
				}
				break;
			}
		}
	}
}
