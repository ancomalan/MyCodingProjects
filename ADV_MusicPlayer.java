//alan vo 
//occc fall 2023
//advanced java 
//music player jpanel
//I received help from this informative video on how to use audio in java: https://www.youtube.com/watch?v=Q6yl-7ayn1w
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.filechooser.*;


public class ADV_MusicPlayer extends JPanel implements ActionListener {

	JTextField filePathID; //for the wav file
	JButton playButton;
	JButton pauseButton;
	JButton chooseButton;
	JButton loopButton;
	private boolean isPaused;
	private boolean isLooping = false;
	JFileChooser fileChooser; //allows us to pick a wav file
	Clip clip; //this plays the music


	public ADV_MusicPlayer() 
	{

		this.setLayout(new BorderLayout());
		JPanel titlePanel = new JPanel();
		JPanel centerPanel = new JPanel();
		Font appFontLarge = new Font("Arial", Font.BOLD, 30);
		Font appFontSmall = new Font("Arial", Font.PLAIN, 18);

		// title
		JLabel titleLabel = new JLabel("WAV MUSIC PLAYER!");
		titleLabel.setFont(appFontLarge);
		titlePanel.add(titleLabel);

		this.add(titlePanel, BorderLayout.NORTH);


		filePathID = new JTextField(20);
		playButton = new JButton("Play");
		pauseButton = new JButton("Pause");
		chooseButton = new JButton("Choose File");
		loopButton = new JButton("Loop");
		isPaused = false; //default is that we are not paused
		isLooping = false; //default is that we are not looping

		playButton.addActionListener(this);
		pauseButton.addActionListener(this);
		chooseButton.addActionListener(this);
		loopButton.addActionListener(this);

		//add to jPanel
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		centerPanel.add(filePathID);
		centerPanel.add(chooseButton);
		centerPanel.add(playButton);
		centerPanel.add(pauseButton);
		centerPanel.add(loopButton);


		//add center panel to borderlayout panel
		this.add(centerPanel, BorderLayout.CENTER);
		fileChooser = new JFileChooser("."); //set default file path of file chooser to java project
		fileChooser.setFileFilter(new FileNameExtensionFilter("WAV Files", "wav")); //file filter allows us only to see wav files


		setSize(500, 100);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == playButton){
			playMusic(); //if play button is clicked, call playMusic function
		} 
		else if (e.getSource() == pauseButton){
			pauseMusic();
		} 
		else if (e.getSource() == chooseButton){
			chooseFile();
		} 
		else if (e.getSource() == loopButton){
			toggleLoop();
		}
	}

	//function to play music
	private void playMusic() {
		//if currently playing music, stop playing music when play button is pressed
		if (clip != null && clip.isRunning()) 
		{
			clip.stop();
		}

		try 
		{
			File file = new File(filePathID.getText()); //get text in file path field
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);

			//give music to clip object (like putting a disc into cd player)
			clip = AudioSystem.getClip();
			clip.open(audioIn);

			if (isLooping) 
			{
				clip.loop(Clip.LOOP_CONTINUOUSLY); //acount for looping
			}

			clip.start(); // equal to pressing play on music player

		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	//function to pause and resume music
	private void pauseMusic() 
	{
		if (clip != null && clip.isRunning()) 
		{
			clip.stop();
			isPaused = true;
			pauseButton.setText("Resume");
		} 
		else if (clip != null && isPaused) 
		{
			clip.start();

			if(isLooping)
			{
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}

			isPaused = false;
			pauseButton.setText("Pause");
		}
	}

	//function to choose file
	private void chooseFile() 
	{
		fileChooser.setCurrentDirectory(new File(".")); //set default directory to where java project is
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) 
		{
			File selectedFile = fileChooser.getSelectedFile();
			filePathID.setText(selectedFile.getAbsolutePath());
		}
	}

	//function to account looping music
	private void toggleLoop() 
	{
		isLooping = !isLooping;
		if (isLooping) 
		{
			loopButton.setText("Stop Loop");

			if(clip.isRunning())
			{
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			} 
		}
		else 
		{
			loopButton.setText("Loop");

			if(clip.isRunning())
			{
				clip.loop(0); //tells the program to play clip to play music until it stops
			}
		}
	}
}

