package com.github.fluorine.greetings;

import java.util.Scanner;

/**
 * Using name from user to show greetings.
 * 
 * @author fluorine@github.com
 */
public class Greetings {
	public static void main(String[] args) {
		// Prompt
		System.out.print("Write your name: ");
		
		// Getting name from user, through console
		Scanner keyword = new Scanner(System.in);
		String name = keyword.nextLine();
		
		// Displaying greetings
		System.out.println("\n  Hello, " + name + "!");
	}

}
