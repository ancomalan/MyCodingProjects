//alan vo 
//occc fall 2023 
//advanced java 
//car sales jpanel

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CarSalesJPanel extends JPanel implements ActionListener{

	JTextArea buildText;
	JButton buildButton;
	JComboBox<String> makeMenu;
	JComboBox<String> modelMenu;
	String [] makeList;
	String [][] modelList;
	JCheckBox option_stereo, option_eject, option_selfdrive; //JCheckBox allows us to provide several options; choose any number you like. 
	JRadioButton color_red, color_black, color_silver;
	JRadioButton trans_manual, trans_automatic;
	ButtonGroup colorGroup; //A ButtonGroup (no J) enforces the “one and only one” behavior.
	ButtonGroup transGroup;

	public CarSalesJPanel(){

		this.setLayout(new BorderLayout());

		JPanel titlePanel = new JPanel();
		JPanel carPanel = new JPanel();
		JPanel optionsPanel = new JPanel();
		JPanel colorPanel = new JPanel();
		JPanel transPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel buildPanel = new JPanel();

		Font appFontLarge = new Font("Arial", Font.PLAIN, 50);
		Font appFontSmall = new Font("Arial", Font.PLAIN, 18);


		// title
		JLabel titleLabel = new JLabel("MY NEW CAR!!!");
		titleLabel.setFont(appFontLarge);
		titlePanel.add(titleLabel);


		// make and model selection
		makeList = new String [] {"Ford", "Toyota", "Mazda", "Chevrolet"};
		modelList = new String [4][];
		modelList[0] = new String [] {"Escape", "F-150", "Explorer", "Expedition", "Fusion"};
		modelList[1] = new String [] {"Prius", "Corolla", "Tundra"};
		modelList[2] = new String [] {"626", "121", "Miata"};
		modelList[3] = new String [] {"Corvette", "Camaro", "Silverado", "Equinox", "Malibu"};

		//Now we populate the two menus with the String arrays
		makeMenu = new JComboBox<String>(makeList);
		modelMenu = new JComboBox<String>(modelList[0]);

		makeMenu.setFont(appFontSmall);
		modelMenu.setFont(appFontSmall);

		carPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		carPanel.add(makeMenu);
		carPanel.add(modelMenu);

		// options
		option_stereo = new JCheckBox("Premium Stereo");
		option_eject = new JCheckBox ("Passenger Ejection Seat");
		option_selfdrive = new JCheckBox ("AI Drive Control");

		option_stereo.setFont(appFontSmall);
		option_eject.setFont(appFontSmall);
		option_selfdrive.setFont(appFontSmall);

		optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		optionsPanel.add(option_stereo);
		optionsPanel.add(option_eject);
		optionsPanel.add(option_selfdrive);

		//color 
		colorGroup = new ButtonGroup(); //put them in a ButtonGroup to enforce the “one choice” rule
		color_red = new JRadioButton ("Sooner Red");
		color_black = new JRadioButton("Midnight Black");
		color_silver = new JRadioButton("Metallic Silver");

		color_red.setFont(appFontSmall);
		color_black.setFont(appFontSmall);
		color_silver.setFont(appFontSmall);

		colorGroup.add(color_red);
		colorGroup.add(color_black);
		colorGroup.add(color_silver);

		//put in their jpanel
		colorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		colorPanel.add(color_red);
		colorPanel.add(color_black);
		colorPanel.add(color_silver);


		//transmission
		transGroup = new ButtonGroup();
		trans_manual = new JRadioButton("Six Speed Manual");
		trans_automatic = new JRadioButton("Continuously Variable Automatic");

		trans_manual.setFont(appFontSmall);
		trans_automatic.setFont(appFontSmall);

		transGroup.add(trans_manual);
		transGroup.add(trans_automatic);

		transPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		transPanel.add(trans_manual);
		transPanel.add(trans_automatic);

		//build my car
		//We’ll put those on a JPanel that is managed by BorderLayout, and put the text area up North and the button down South. 
		buildText = new JTextArea(12, 60);
		buildText.setFont(appFontSmall);
		buildText.setText("Click the button to build your new car!");
		buildButton = new JButton("Build My Car!");
		buildButton.setFont(appFontSmall);

		/*To populate the North and South of our BorderLayout we’ll make two JPanels and
    call them “upper” and “lower.” The upper panel will use a 1 x 1 GridLayout (so our
    TextArea will fill the entire region) and the lower panel will use the usual
    FlowLayout and thus we will have a normal-looking JButton there. */
		JPanel upperBuild = new JPanel(new GridLayout(1,1));
		upperBuild.add(buildText);
		JPanel lowerBuild = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lowerBuild.add(buildButton);
		buildPanel.setLayout(new BorderLayout());
		buildPanel.add(upperBuild, BorderLayout.NORTH);
		buildPanel.add(lowerBuild, BorderLayout.SOUTH);


		// put it all together;We put all of the JPanels we just created, plus more to carry JLabels to identify everything, into
		//a JPanel that we create with an 7 x 1 GridLayout.

		centerPanel.setLayout(new GridLayout(7,1));
		centerPanel.add(carPanel);
		JLabel optionsLabel = new JLabel("OPTIONS");
		optionsLabel.setFont(appFontSmall);
		JPanel optionsLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		optionsLabelPanel.add(optionsLabel);
		centerPanel.add(optionsLabelPanel);
		centerPanel.add(optionsPanel);
		JLabel colorLabel = new JLabel("COLORS");
		colorLabel.setFont(appFontSmall);
		JPanel colorLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		colorLabelPanel.add(colorLabel);
		centerPanel.add(colorLabelPanel);
		centerPanel.add(colorPanel);
		JLabel transLabel = new JLabel("TRANSMISSION");
		transLabel.setFont(appFontSmall);
		JPanel transLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		transLabelPanel.add(transLabel);
		centerPanel.add(transLabelPanel);
		centerPanel.add(transPanel);

		color_red.setSelected(true);
		trans_manual.setSelected(true);

		//Then we put our three main panels into the BorderLayout
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(buildPanel, BorderLayout.SOUTH);

		//add ActionListener handlers to every component on which our user might click. 
		makeMenu.addActionListener(this);
		modelMenu.addActionListener(this);
		option_stereo.addActionListener(this);
		option_eject.addActionListener(this);
		option_selfdrive.addActionListener(this);
		color_red.addActionListener(this);
		color_black.addActionListener(this);
		color_silver.addActionListener(this);
		trans_manual.addActionListener(this);
		trans_automatic.addActionListener(this);
		buildButton.addActionListener(this);


	}

	public void actionPerformed(ActionEvent e) {

		//empty and repopulate
		/*The very first thing we’ll do is clear that build text area by replacing it with
		 * the opening text. Note that in cleaner code this text would be stored as a 
		 * const final String up in the global variable area. */
		buildText.setText("Click the button to build your new car!");

		//We remove the old model list, and add in the current one.
		//Here we make use of the new “enhanced” for loop.
		if (e.getSource() == makeMenu) {
			int i = makeMenu.getSelectedIndex();
			modelMenu.removeAllItems();
			for (String s: modelList[i]) {
				modelMenu.addItem(s);
			}
		}

		if (e.getSource() == buildButton) {
			buildText.setText("");
			buildText.append("Make: " + String.valueOf(makeMenu.getSelectedItem())+ "\n");
			buildText.append("Model: " + String.valueOf(modelMenu.getSelectedItem()) + "\n");


			//options 
			if ( option_stereo.isSelected() ||
					option_selfdrive.isSelected() || option_eject.isSelected() ){
				buildText.append("OPTIONS: \n");
				if ( option_stereo.isSelected() ){
					buildText.append("Premium Stereo \n");
				}
				if ( option_eject.isSelected() ){
					buildText.append("Passenger Ejection Seat \n");
				}
				if ( option_selfdrive.isSelected() ){
					buildText.append("AI Drive Control \n");
				}
			}

			//colors 
			if (color_red.isSelected() || color_black.isSelected() || color_silver.isSelected()) {
				buildText.append("COLOR: ");
				if(color_red.isSelected()) {
					buildText.append("Sooner Red \n");
				}
				if(color_black.isSelected()) {
					buildText.append("Midnight Black \n");
				}
				if (color_silver.isSelected()) {
					buildText.append("Metallic Silver \n");
				}
			}

			//transmission
			if (trans_manual.isSelected() || trans_automatic.isSelected()) {
				buildText.append("TRANSMISSON: ");
				if (trans_manual.isSelected()) {
					buildText.append("Six Speed Manual \n");
				}
				if (trans_automatic.isSelected()) {
					buildText.append("Continuously Variable Automatic"); 
				}
			}
		}
	}


}