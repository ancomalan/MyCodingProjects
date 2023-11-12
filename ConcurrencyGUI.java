//alan vo 
//occc fall 2023
//advanced java 
//producer consumer gui
import java.util.concurrent.Semaphore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/* From the GUI the user sets the number of producers, the number of consumers, the average value produced, and 
 * the average value consumed, then clicks "start" to get the ball rolling. The GUI will then display the 
 * current state of the shared resource (an integer) as  producers and consumers do their work. You can show 
 * the various console messages in text panes as well.
 */
public class ConcurrencyGUI extends JPanel implements ActionListener{

	static int theBuffer; //current state of the shared resource
	static Semaphore s = new Semaphore(1);
	JButton start; //button to activate the program
	static JTextArea currentState; //text area to display current state of the shared resource
	static JTextArea workMessages; //text area to print messages of what producer and consumer are doing

	//create 4 textfields for the user to input what they want 
	static JTextField numProducers; 
	static JTextField numConsumers;
	static JTextField avgValueProduced; 
	static JTextField avgValueConsumed;

	//4 integer values that user inputted
	static int numberProducers;
	static int numberConsumers; 
	static int averageValueProduced;
	static int averageValueConsumed;

	public ConcurrencyGUI() {
		this.setLayout(new BorderLayout());
		JPanel titlePanel = new JPanel();
		JPanel currentResourcePanel = new JPanel(); //for displaying the current state of the shared resource (an integer)
		JPanel userPanel = new JPanel(); //for the user to select how much producers and consumers, etc..
		JPanel workPanel =  new JPanel(); // to display producers and consumers doing their work
		Font appFontLarge = new Font("Arial", Font.BOLD, 40);
		Font appFontSmall = new Font("Arial", Font.PLAIN, 18);

		// title of GUI
		JLabel titleLabel = new JLabel("Producer-Consumer GUI!");
		titleLabel.setFont(appFontLarge);
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		titlePanel.add(titleLabel); //add title label to title panel


		//panel for displaying the current state of resource (an integer)
		currentResourcePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel currentResourceLabel = new JLabel ("Current State of Resource: ");
		currentResourceLabel.setFont(appFontSmall);
		currentState = new JTextArea (1,1); //for the integer number
		currentState.append(String.valueOf(theBuffer)); //display initial value of buffer (0)
		currentResourcePanel.add(currentResourceLabel);
		currentResourcePanel.add(currentState);
		titlePanel.add(currentResourcePanel); //add current resource section to title panel


		//allow user to select what options they want
		//producers
		userPanel.setLayout(new FlowLayout (FlowLayout.CENTER));
		JLabel numProducersLabel = new JLabel("#Producers:");
		numProducers = new JTextField();
		numProducers.setPreferredSize(new Dimension(20, 20));
		userPanel.add(numProducersLabel);
		userPanel.add(numProducers);

		//consumers 
		JLabel numConsumersLabel = new JLabel("#Consumers:");
		numConsumers = new JTextField();
		numConsumers.setPreferredSize(new Dimension(20, 20));
		userPanel.add(numConsumersLabel);
		userPanel.add(numConsumers);

		//average value produced 
		JLabel avgValueProducedLabel = new JLabel("Average Value Produced:");
		avgValueProduced = new JTextField();
		avgValueProduced.setPreferredSize(new Dimension(20, 20));
		userPanel.add(avgValueProducedLabel);
		userPanel.add(avgValueProduced);

		//average value consumed
		JLabel avgValueConsumedLabel = new JLabel("Average Value Consumed:");
		avgValueConsumed = new JTextField();
		avgValueConsumed.setPreferredSize(new Dimension(20, 20));
		userPanel.add(avgValueConsumedLabel);
		userPanel.add(avgValueConsumed);




		//display the console messages of producers and consumers in GUI program and the start button
		//put those on a JPanel that is managed by BorderLayout, and put the text area up North and the button down South. 
		workMessages = new JTextArea(20,50); //create text area to store console messages 
		workMessages.setFont(appFontSmall);
		workMessages.setText("Click the button to start the program!" + "\n");
		start = new JButton("START"); //create start button to run the program
		start.setFont(appFontSmall);


		JPanel upperWorkPanel = new JPanel(new GridLayout(1,1));
		upperWorkPanel.add(workMessages); //add text area
		JPanel lowerWorkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lowerWorkPanel.add(start); //add start button
		workPanel.setLayout(new BorderLayout());
		workPanel.add(upperWorkPanel, BorderLayout.NORTH);
		workPanel.add(lowerWorkPanel, BorderLayout.SOUTH);


		//Then we put our main panels into the BorderLayout
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(userPanel, BorderLayout.CENTER);
		this.add(workPanel, BorderLayout.SOUTH);

		start.addActionListener(this);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if user selects start button, run the program
		if (e.getSource() == start) {
			//get values from text fields to use in program
			numberProducers = Integer.parseInt(numProducers.getText());
			numberConsumers = Integer.parseInt(numConsumers.getText());
			averageValueProduced = Integer.parseInt(avgValueProduced.getText());
			averageValueConsumed = Integer.parseInt(avgValueConsumed.getText());


			Consumer [] c = new Consumer[numberConsumers];
			Producer [] p = new Producer[numberProducers];

			//initialize consumers with given user input
			for(int i = 0; i < c.length; i++){
				c[i] = new Consumer(i);
				c[i].start(); //start the thread
			}

			//initialize producers with given user input
			for (int i = 0; i < p.length; i++) {
				p[i] = new Producer(i);
				p[i].start(); //start the thread

			}
		}
	}

	public static class Producer extends Thread{
		int i;
		public Producer(int i){
			super();
			this.i = i;
		}

		public void run(){
			while(true){
				mySleep();
				workMessages.append("Producer " + i + ": attempting to acquire" + "\n");
				try{
					s.acquire();
					workMessages.append("Producer " + i + ": resource acquired!" + "\n");
					mySleep();
					workMessages.append("Producer " + i + ": theBuffer (pre)  is " + theBuffer + "\n");
					currentState.setText("");
					currentState.append(String.valueOf(theBuffer));
					theBuffer += (int) (Math.random()* averageValueProduced); //producer generates random thing based on what user inputs
					workMessages.append("Producer " + i + ": theBuffer (post) is " + theBuffer + "\n");
					currentState.setText("");
					currentState.append(String.valueOf(theBuffer));
					workMessages.append("Producer " + i + ": resource released" + "\n");
					s.release();
				}
				catch(InterruptedException e){}
			}   
		}
	}

	private static class Consumer extends Thread{
		int i;
		public Consumer(int i){
			super();
			this.i = i;
		}

		public void run(){
			while(true){
				mySleep();
				workMessages.append("Consumer " + i + ": attempting to acquire" + "\n" );
				try{
					s.acquire();
					workMessages.append("Consumer " + i + ": resource acquired!" + "\n" );
					mySleep();
					workMessages.append("Consumer " + i + ": theBuffer is " + theBuffer + "\n");
					currentState.setText("");
					currentState.append(String.valueOf(theBuffer));
					int need = (int) (1 + Math.random()* averageValueConsumed); //generate random need based on what user inputted from gui
					workMessages.append("Consumer " + i + ": my need is " + need + "\n");
					if (theBuffer >= need){ 
						theBuffer -= need;
						workMessages.append("Consumer " + i + ": got what I needed!" + "\n");
						workMessages.append("Consumer " + i + ": theBuffer is now " + theBuffer + "\n");
						currentState.setText("");
						currentState.append(String.valueOf(theBuffer));
					}
					else{
						workMessages.append("Consumer " + i + ": resource unavailable" + "\n");
					}
					workMessages.append("Consumer " + i + ": resource released" + "\n");
					s.release();
				}
				catch(InterruptedException e){}
			}
		}
	}
	public static void mySleep(){
		// this function puts the thread "to sleep" for a while,
		// to simulate time spent processing 

		try{
			Thread.sleep((int)(Math.random()*1000));
		}
		catch(InterruptedException e){
			// do nothing
		}
	} // close sleep method
} 