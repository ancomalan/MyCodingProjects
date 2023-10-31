//alan vo 
//occc fall 2023 
//advanced java 
//jacket sales jpanel

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ADV_JacketSales extends JPanel implements ActionListener {
	JTextArea buildText;
	JButton buildButton;
	JComboBox<String> brandMenu; //brand of jacket 
	JComboBox<String> jacketTypeMenu; //type of jacket
	String [] brandList;
	String [][] jacketTypeList;
	JCheckBox option_waterproof, option_bulletproof, option_stabproof; //options for additiional features 
	JRadioButton color_navy, color_black, color_beige, color_red, color_green; //options for colors
	ButtonGroup colorGroup; //A ButtonGroup (no J) enforces the “one and only one” behavior.
	

	public ADV_JacketSales(){
		this.setLayout(new BorderLayout());

		JPanel titlePanel = new JPanel();
		JPanel jacketPanel = new JPanel();
		JPanel optionsPanel = new JPanel();
		JPanel colorPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel buildPanel = new JPanel();

		Font appFontLarge = new Font("Arial", Font.BOLD, 30);
		Font appFontSmall = new Font("Arial", Font.PLAIN, 18);


		// title
		JLabel titleLabel = new JLabel("BUILD A JACKET!");
		titleLabel.setFont(appFontLarge);
		titlePanel.add(titleLabel);


		// make and model selection
		brandList = new String [] {"Burberry", "Gucci", "Nike"};
		jacketTypeList = new String [3][];
		jacketTypeList[0] = new String [] {"Trench Coat", "Tailered Coat", "Puffer Jacket", "Leather Jacket"};
		jacketTypeList[1] = new String [] {"Down Jacket", "Zip Jacket", "Bomber Jacket"};
		jacketTypeList[2] = new String [] {"Hoodie", "Windbreaker Jacket"};

		//Now we populate the two menus with the String arrays
		brandMenu = new JComboBox<String>(brandList);
		jacketTypeMenu = new JComboBox<String>(jacketTypeList[0]);

		brandMenu.setFont(appFontSmall);
		jacketTypeMenu.setFont(appFontSmall);

		jacketPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		jacketPanel.add(brandMenu);
		jacketPanel.add(jacketTypeMenu);

		// lining options
		option_waterproof = new JCheckBox("Waterproof");
		option_bulletproof = new JCheckBox ("Bulletproof");
		option_stabproof = new JCheckBox ("Stabproof");

		option_waterproof.setFont(appFontSmall);
		option_bulletproof.setFont(appFontSmall);
		option_stabproof.setFont(appFontSmall);

		optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		optionsPanel.add(option_waterproof);
		optionsPanel.add(option_bulletproof);
		optionsPanel.add(option_stabproof);

		//color options
		colorGroup = new ButtonGroup(); //put them in a ButtonGroup to enforce the “one choice” rule
		color_navy = new JRadioButton ("Navy");
		color_black = new JRadioButton("Black");
		color_beige = new JRadioButton("Beige");
		color_red = new JRadioButton("Red");
		color_green = new JRadioButton("Forest Green");

		color_navy.setFont(appFontSmall);
		color_black.setFont(appFontSmall);
		color_beige.setFont(appFontSmall);
		color_red.setFont(appFontSmall);
		color_green.setFont(appFontSmall);

		colorGroup.add(color_navy);
		colorGroup.add(color_black);
		colorGroup.add(color_beige);
		colorGroup.add(color_red);
		colorGroup.add(color_green);
		
		//put in their jpanel
		colorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		colorPanel.add(color_navy);
		colorPanel.add(color_black);
		colorPanel.add(color_beige);
		colorPanel.add(color_red);
		colorPanel.add(color_green);



		//build jacket!
		//We’ll put those on a JPanel that is managed by BorderLayout, and put the text area up North and the button down South. 
		buildText = new JTextArea(6,50);
		buildText.setFont(appFontSmall);
		buildText.setText("Click the button to build your new jacket!");
		buildButton = new JButton("Build My Jacket!");
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
		centerPanel.add(jacketPanel);
		JLabel optionsLabel = new JLabel("ADDITIONAL FEATURES");
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

		color_navy.setSelected(true);
		

		//Then we put our three main panels into the BorderLayout
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(buildPanel, BorderLayout.SOUTH);

		//add ActionListener handlers to every component on which our user might click. 
		brandMenu.addActionListener(this);
		jacketTypeMenu.addActionListener(this);
		option_waterproof.addActionListener(this);
		option_bulletproof.addActionListener(this);
		option_stabproof.addActionListener(this);
		color_navy.addActionListener(this);
		color_black.addActionListener(this);
		color_beige.addActionListener(this);
		color_red.addActionListener(this);
		color_green.addActionListener(this);
		buildButton.addActionListener(this);


	}

	public void actionPerformed(ActionEvent e) {

		//empty and repopulate
		/*The very first thing we’ll do is clear that build text area by replacing it with
		 * the opening text. Note that in cleaner code this text would be stored as a 
		 * const final String up in the global variable area. */
		buildText.setText("Click the button to build your new jacket!");

		//We remove the old model list, and add in the current one.
		//Here we make use of the new “enhanced” for loop.
		if (e.getSource() == brandMenu) {
			int i = brandMenu.getSelectedIndex();
			jacketTypeMenu.removeAllItems();
			for (String s: jacketTypeList[i]) {
				jacketTypeMenu.addItem(s);
			}
		}

		if (e.getSource() == buildButton) {
			buildText.setText("");
			buildText.append("BRAND: " + String.valueOf(brandMenu.getSelectedItem())+ "\n");
			buildText.append("TYPE: " + String.valueOf(jacketTypeMenu.getSelectedItem()) + "\n");


			//options 
			if ( option_waterproof.isSelected() ||
					option_stabproof.isSelected() || option_bulletproof.isSelected() ){
				buildText.append("ADDITIONAL FEATURES: \n");
				if ( option_waterproof.isSelected() ){
					buildText.append("Waterproof \n");
				}
				if ( option_bulletproof.isSelected() ){
					buildText.append("Bulletproof \n");
				}
				if ( option_stabproof.isSelected() ){
					buildText.append("Stabproof \n");
				}
			}

			//colors 
			if (color_navy.isSelected() || color_black.isSelected() || color_beige.isSelected() || color_red.isSelected() || color_green.isSelected()) {
				buildText.append("COLOR: ");
				if(color_navy.isSelected()) {
					buildText.append("Navy \n");
				}
				if(color_black.isSelected()) {
					buildText.append("Black \n");
				}
				if (color_beige.isSelected()) {
					buildText.append("Beige \n");
				}
				if (color_red.isSelected()) {
					buildText.append("Red \n");
				}
				if (color_green.isSelected()) {
					buildText.append("Forest Green \n");
				}
			}
		}
	}
}
