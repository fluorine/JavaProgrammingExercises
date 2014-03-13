package com.github.fluorine.firstguiapp;

import javax.swing.JFrame;
import javax.swing.JButton;

/**
 * A simple graphical application (GUI).
 * 
 * @author fluorine@github.com
 * 
 */
public class FirstAppWithGUI {
	public final static int HEIGHT = 300;
	public final static int WIDTH = 300;

	public static void main(String[] args) {
		// Create window
		JFrame w = new JFrame("A simple Window.");
		w.setSize(WIDTH, HEIGHT);
		w.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// Create button
		JButton btnExit = new JButton("Quit");
		btnExit.addActionListener(new ExitListener());
		btnExit.setToolTipText("Clic to exit.");

		// Add button and display window
		w.add(btnExit);
		w.setVisible(true);
	}

}
