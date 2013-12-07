package com.github.fluorine.greetings;

import java.util.Scanner;

/**
 * Using name from user to show greetings
 * to Bob and Alice only.
 * 
 * @author fluorine@github.com
 */
public class Greetings {
	public static void main(String[] args) {
		// Prompt
		System.out.print("Write your name: ");
		
		// Getting name from user, through console,
		Scanner keyword = new Scanner(System.in);
		String name = keyword.nextLine().trim().toLowerCase();
		name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
		
		// Validating given name and displaying greetings
		if(name.compareTo("Bob") == 0 || name.compareTo("Alice") == 0) {
			System.out.println("\n  Hello, " + name + "!");
		} else {
			System.out.println("\n  You are not Bob or Alice.");
		}
	}

}