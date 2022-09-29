package Downloader;

import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.*;

class mp3downloader extends JFrame implements ActionListener {
	static JTextField link;

	static JTextField outputfile;

	static JFrame frame;
	
	static JButton downloadbutton;

	static JLabel message;

	
	public static void main(String[] args) {
		frame = new JFrame("Music Downloader");

		message = new JLabel("");

		downloadbutton = new JButton("Start Downloading");

		mp3downloader downloader = new mp3downloader();

		downloadbutton.addActionListener(downloader);

		link = new JTextField("Enter Link Here", 16);
		outputfile = new JTextField("Name your downloaded song", 16);

		JPanel p = new JPanel();

		p.add(link);
		p.add(outputfile);
		p.add(downloadbutton);
		p.add(message);

		frame.add(p);

		frame.setSize(300, 300);

		frame.show();
	}

	// if the button is pressed
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Start Downloading")) {

			message.setText("downloaded");
			try {
				downloadprocess.Downloadlink(link.getText(), outputfile.getText());
			} catch (MalformedURLException e1) {
				System.out.println("Please Enter a link");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			link.setText("  ");
			outputfile.setText(" ");
		}
	}
}