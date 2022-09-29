package Downloader;

import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.*;

class tester extends JFrame implements ActionListener {
	// JTextField
	static JTextField link;

	static JTextField outputfile;

	// JFrame
	static JFrame frame;

	// JButton
	static JButton downloadbutton;

	// label to display text
	static JLabel message;

	// main class
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// create a new frame to store text field and button
		frame = new JFrame("Music Downloader");

		// create a label to display text
		message = new JLabel("");

		// create a new button
		downloadbutton = new JButton("Start Downloading");

		// create a object of the text class
		tester test = new tester();

		// addActionListener to button
		downloadbutton.addActionListener(test);

		// create a object of JTextField with 16 columns
		link = new JTextField("Enter Link Here", 16);
		outputfile = new JTextField("Name your downloaded song", 16);

		// create a panel to add buttons and textfield
		JPanel p = new JPanel();

		p.add(link);
		p.add(outputfile);
		p.add(downloadbutton);
		p.add(message);

		// add panel to frame
		frame.add(p);

		// set the size of frame
		frame.setSize(300, 300);

		frame.show();
	}

	// if the button is pressed
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Start Downloading")) {
			// set the text of the label to the text of the field
			message.setText("downloaded");
			try {
				downloadprocess.Downloadlink(link.getText(), outputfile.getText());
			} catch (IllegalArgumentException e1) {
				System.out.println("Please Enter a link");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			link.setText("  ");
			outputfile.setText(" ");
		}
	}
}