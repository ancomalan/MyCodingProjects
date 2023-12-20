//alan vo 
//occc fall 2023 
//advanced java 
//person GUI final project 
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class personGUI extends JFrame implements ActionListener{

	static ArrayList<Person> p = new ArrayList<Person>(); // static ArrayList to store all people objects as they get created and deleted
	static JTextArea currentPeople; //text area to display current list of people on the GUI

	//file menu items 
	JMenuItem fileMenu_new;
	JMenuItem fileMenu_open; //load 
	JMenuItem fileMenu_save;
	JMenuItem fileMenu_saveAs;
	JMenuItem fileMenu_exit;

	JButton newPersonButton; //button to create new person  
	JButton deletePersonButton; //button to delete person

	//create textfields to store user input for creating people 
	static JTextField firstName; 
	static JTextField lastName; 
	static JTextField dayOfBirth; 
	static JTextField monthOfBirth; 
	static JTextField yearOfBirth;
	static JTextField govID; 
	static JTextField studentID;

	//data used to create people objects
	static String firstName2;
	static String lastName2;
	static int dayOfBirth2;
	static int monthOfBirth2; 
	static int yearOfBirth2;
	static String govID2; 
	static String studentID2; 

	static JFileChooser fileChooser; //filechooser used in the open and save dialogs
	static File file; //used to get file path for saving and loading 

	Font appFontLarge = new Font("Arial", Font.BOLD, 40);
	Font appFontSmall = new Font("Arial", Font.PLAIN, 18);

	public static void main (String [] args){
		personGUI gui = new personGUI();

	}
	public personGUI(){
		super("Person GUI!");
		setSize(900, 900);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //handle window closing by ourselves
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				exitMenuDemo();
			}
		});


		JMenuBar bar = new JMenuBar(); //create menu bar
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		fileMenu_new = new JMenuItem ("New");
		fileMenu_new.addActionListener(this);


		fileMenu_open = new JMenuItem("Open...");
		fileMenu_open.addActionListener(this);
		fileMenu_open.setMnemonic(KeyEvent.VK_O);

		fileMenu_save = new JMenuItem("Save");
		fileMenu_save.addActionListener(this);
		fileMenu_save.setMnemonic(KeyEvent.VK_V);

		fileMenu_saveAs = new JMenuItem ("Save as...");
		fileMenu_saveAs.addActionListener(this);


		fileMenu_exit = new JMenuItem("Exit");
		fileMenu_exit.addActionListener(this);
		fileMenu_exit.setMnemonic(KeyEvent.VK_X);


		//add file menu option tabs to the file menu
		fileMenu.add(fileMenu_new);
		fileMenu.add(fileMenu_open);
		fileMenu.add(fileMenu_save);
		fileMenu.add(fileMenu_saveAs);
		fileMenu.addSeparator();
		fileMenu.add(fileMenu_exit);
		bar.add(fileMenu);
		setJMenuBar(bar);
		setVisible(true);


		//help menu 
		JMenu helpMenu = new JMenu("Contact Help");
		JMenuItem contact = new JMenuItem("Phone: 405-250-1610");
		JMenuItem email = new JMenuItem ("Email: bvo101968@gmail.com");
		helpMenu.add(contact);
		helpMenu.add(email);
		helpMenu.setMnemonic(KeyEvent.VK_H);
		bar.add(Box.createHorizontalGlue());
		bar.add(helpMenu);

		this.setLayout(new BorderLayout());
		JPanel fieldPanel = new JPanel(); //panel for inputting first name, last name, dob, gov id, and student id (data)
		JPanel titlePanel = new JPanel(); //for title of list of people 
		JPanel addOrDeletePanel = new JPanel(); //for displaying the current list of people and allow user to delete or create new persn
		fieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		addOrDeletePanel.setLayout(new BorderLayout());

		//allow user to create people by inputting data into textfields
		//first name
		fieldPanel.setLayout(new FlowLayout (FlowLayout.CENTER));
		JLabel firstNameLabel = new JLabel("First Name:");
		firstName =  new JTextField();
		firstName.setPreferredSize(new Dimension(50, 20));
		fieldPanel.add(firstNameLabel);
		fieldPanel.add(firstName);

		//last name
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastName =  new JTextField();
		lastName.setPreferredSize(new Dimension(50, 20));
		fieldPanel.add(lastNameLabel);
		fieldPanel.add(lastName);

		//month of birth 
		JLabel monthLabel = new JLabel("Birth Month:");
		monthOfBirth =  new JTextField();
		monthOfBirth.setPreferredSize(new Dimension(50, 20));
		fieldPanel.add(monthLabel);
		fieldPanel.add(monthOfBirth);

		//day of birth
		JLabel dayLabel = new JLabel("Birth Day: ");
		dayOfBirth =  new JTextField();
		dayOfBirth.setPreferredSize(new Dimension(50, 20));
		fieldPanel.add(dayLabel);
		fieldPanel.add(dayOfBirth);

		//year of birth
		JLabel yearLabel = new JLabel("Birth Year:");
		yearOfBirth =  new JTextField();
		yearOfBirth.setPreferredSize(new Dimension(50, 20));
		fieldPanel.add(yearLabel);
		fieldPanel.add(yearOfBirth);

		//gov id 
		JLabel govLabel = new JLabel("GOV ID:");
		govID =  new JTextField();
		govID.setPreferredSize(new Dimension(50, 20));
		fieldPanel.add(govLabel);
		fieldPanel.add(govID);


		//student id 
		JLabel studentLabel = new JLabel("Student ID:");
		studentID =  new JTextField();
		studentID.setPreferredSize(new Dimension(50, 20));
		fieldPanel.add(studentLabel);
		fieldPanel.add(studentID);


		//title for current list of people
		JLabel listLabel = new JLabel("Current List of People: ");
		listLabel.setFont(appFontLarge);
		titlePanel.add(listLabel); //add title label to title panel


		currentPeople = new JTextArea (30, 30);
		currentPeople.setFont(appFontSmall);
		newPersonButton = new JButton("CREATE PERSON"); 
		deletePersonButton = new JButton("DELETE PERSON");
		newPersonButton.setFont(appFontSmall);
		deletePersonButton.setFont(appFontSmall);

		JPanel upperWorkPanel = new JPanel(new GridLayout(1,1));
		upperWorkPanel.add(currentPeople); //add text area
		JPanel lowerWorkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lowerWorkPanel.add(newPersonButton); //add create new person button 
		lowerWorkPanel.add(deletePersonButton); //add delete person button 
		addOrDeletePanel.add(upperWorkPanel, BorderLayout.NORTH);
		addOrDeletePanel.add(lowerWorkPanel, BorderLayout.SOUTH);


		this.add(fieldPanel, BorderLayout.NORTH);
		this.add(titlePanel, BorderLayout.CENTER);
		this.add(addOrDeletePanel, BorderLayout.SOUTH);

		//add action listeners to jbuttons
		newPersonButton.addActionListener(this);
		deletePersonButton.addActionListener(this);
	} // end of constructor



	public void actionPerformed(ActionEvent e){
		if ( e.getSource() == fileMenu_new ){
			fileMenu_save.setEnabled(false);
			fileMenu_saveAs.setEnabled(false);

		}

		//if user adds person 
		if (e.getSource() == newPersonButton) {

			fileMenu_save.setEnabled(true); //after creating the person and clicking the button, allow the user to save or save as
			fileMenu_saveAs.setEnabled(true);

			//get all data 
			firstName2 = firstName.getText();
			lastName2 = lastName.getText();
			dayOfBirth2 = Integer.parseInt(dayOfBirth.getText());
			monthOfBirth2 = Integer.parseInt(monthOfBirth.getText());
			yearOfBirth2 = Integer.parseInt(yearOfBirth.getText());
			govID2 = govID.getText(); 
			studentID2 = studentID.getText(); 


			//add to array list and display to screen
			//if everything except student id and gov id, it is a regular person
			if (govID2 == "" && studentID2 == "") {
				OCCCDate dob =  new OCCCDate(dayOfBirth2, monthOfBirth2, yearOfBirth2);
				Person person = new Person (firstName2, lastName2, dob);
				p.add(person); //create person object from all info acquired by user
				currentPeople.append(person.toString() + "\n");//display person on gui

			}
			//if everything except student id, then it is a registered person
			else if (studentID2 == "") {
				OCCCDate dob =  new OCCCDate(dayOfBirth2, monthOfBirth2, yearOfBirth2);
				Person person = new Person (firstName2, lastName2, dob); //create person object from all info acquired by user
				RegisteredPerson registered = new RegisteredPerson(person, govID2); //create registered person
				p.add(registered); //add registered person to array list 
				currentPeople.append(registered.toString() + "\n");
			}
			//otherwise, it is a student if all data is inputted
			else {
				OCCCDate dob =  new OCCCDate(dayOfBirth2, monthOfBirth2, yearOfBirth2);
				Person person = new Person (firstName2, lastName2, dob); //create person object from all info acquired by user
				RegisteredPerson registeredPerson2 = new RegisteredPerson(person, govID2);
				OCCCPerson occc = new OCCCPerson (registeredPerson2, studentID2);
				p.add(occc); //add occc student to array list 
				currentPeople.append(occc.toString() + "\n"); 
			}

			//clear the java text fields 
			firstName.setText(""); 
			lastName.setText(""); 
			dayOfBirth.setText("");
			monthOfBirth.setText("");
			yearOfBirth.setText("");
			govID.setText("");
			studentID.setText("");



		}

		//if user deletes a person
		if (e.getSource() == deletePersonButton) {
			//get all data 
			firstName2 = firstName.getText();
			lastName2 = lastName.getText();
			dayOfBirth2 = Integer.parseInt(dayOfBirth.getText());
			monthOfBirth2 = Integer.parseInt(monthOfBirth.getText());
			yearOfBirth2 = Integer.parseInt(yearOfBirth.getText());
			govID2 = govID.getText(); 
			studentID2 = studentID.getText(); 


			//remove from array list and show that is deleted on screen
			//if everything except student id and gov id, it is a regular person
			if (govID2 == "" && studentID2 == "") {
				OCCCDate dob =  new OCCCDate(dayOfBirth2, monthOfBirth2, yearOfBirth2);
				Person person = new Person (firstName2, lastName2, dob);

				//loop through array list to delete the person that user wants to delete
				for (int i = 0 ; i < p.size(); i++) {
					if (person.equals(p.get(i))) {
						currentPeople.append(p.get(i).toString() + " HAS BEEN DELETED " + "\n");//display person has been deleted on gu
						p.remove(i); //remove from array list 
						break;
					}
				}

			}
			//if everything except student id, then it is a registered person
			else if (studentID2 == null) {
				OCCCDate dob =  new OCCCDate(dayOfBirth2, monthOfBirth2, yearOfBirth2);
				Person person = new Person (firstName2, lastName2, dob); //create person object from all info acquired by user
				RegisteredPerson registered = new RegisteredPerson(person, govID2); //create registered person

				//loop through array list to delete the person that user wants to delete
				for (int i = 0 ; i < p.size(); i++) {
					if (registered.equals(p.get(i))) {
						currentPeople.append(p.get(i).toString() + " HAS BEEN DELETED " + "\n");//display person has been deleted on gu
						p.remove(i); //remove from array list 
						break;
					}
				}
			}
			//otherwise, it is a student if all data is inputted
			else {
				OCCCDate dob =  new OCCCDate(dayOfBirth2, monthOfBirth2, yearOfBirth2);
				Person person = new Person (firstName2, lastName2, dob); //create person object from all info acquired by user
				RegisteredPerson registeredPerson2 = new RegisteredPerson(person, govID2);
				OCCCPerson occc = new OCCCPerson (registeredPerson2, studentID2);
				//loop through array list to delete the person that user wants to delete
				for (int i = 0 ; i < p.size(); i++) {
					if (occc.equals(p.get(i))) {
						currentPeople.append(p.get(i).toString() + " HAS BEEN DELETED " + "\n");//display person has been deleted on gu
						p.remove(i); //remove from array list 
						break;
					}
				}
			}
			//clear the java text fields 
			firstName.setText(""); 
			lastName.setText(""); 
			dayOfBirth.setText("");
			monthOfBirth.setText("");
			yearOfBirth.setText("");
			govID.setText("");
			studentID.setText("");
		}

		//if user loads a file
		if ( e.getSource() == fileMenu_open ){
			fileChooser = new JFileChooser();
			int response = fileChooser.showOpenDialog(null); //select file to open
			if (response == JFileChooser.APPROVE_OPTION) {				
				file = new File(fileChooser.getSelectedFile().getAbsolutePath()); //get the path for file that is chosen 
				//read from file to display on text area
				try{
					FileInputStream   fin = new FileInputStream(file);
					ObjectInputStream oin = new ObjectInputStream(fin);
					Object o;
					for(int i = 0; i < p.size(); ++i){
						o = oin.readObject();

						// here we have to figure out what kind of Person we have and write them to the arrayList with the appropriate type cast.
						// for code like this always start at the bottom of the inheritance chain and work your way up

						if (o.getClass().equals(OCCCPerson.class)){
							p.set(i, (OCCCPerson)o);
						}
						else if (o.getClass().equals(RegisteredPerson.class)) {
							p.set(i, (RegisteredPerson)o);
						}
						else{
							p.set(i, (Person)o);
						}
					}
				}
				catch(Exception e2){
					System.out.println(e2.toString());
				}
				currentPeople.append("\n");
				//display people in array list to text area
				for (int i = 0 ; i < p.size(); i++) {
					currentPeople.append(p.get(i).toString() + "\n");
				}
			}
		}


		if ( e.getSource() == fileMenu_save ){
			currentPeople.setText("");
			file = new File(fileChooser.getSelectedFile().getAbsolutePath());
			//save to the file
			try{
				FileOutputStream   fout = new FileOutputStream(file);
				ObjectOutputStream oout = new ObjectOutputStream(fout);

				for(int i = 0; i < p.size(); ++i){
					oout.writeObject(p.get(i)); 
				}
			}
			catch(IOException e2){
				System.out.println(e2.toString());
			}


		}
		if ( e.getSource() == fileMenu_saveAs ){
			currentPeople.setText("");
			fileChooser = new JFileChooser();
			int response = fileChooser.showSaveDialog(null); //selects file to save
			if (response == JFileChooser.APPROVE_OPTION) {
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				//save to the file
				try{
					FileOutputStream   fout = new FileOutputStream(file);
					ObjectOutputStream oout = new ObjectOutputStream(fout);

					for(int i = 0; i < p.size(); ++i){
						oout.writeObject(p.get(i)); 
					}
				}
				catch(IOException e2){
					System.out.println(e2.toString());
				}

			}
		}
		if ( e.getSource() == fileMenu_exit ){
			exitMenuDemo();
		}
	}

	public void exitMenuDemo(){
		System.out.println("EXIT FUNCTION CALLED...");
		dispose();
		System.exit(0);
	}
}
