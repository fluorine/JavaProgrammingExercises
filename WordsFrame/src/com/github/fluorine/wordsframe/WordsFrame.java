package com.github.fluorine.wordsframe;

import javarepl.REPL;

/**
 * This application get some string tokens from user and displays them in a text
 * frame.
 * 
 * @author fluorine@github.com
 * 
 */
public class WordsFrame {
	public static void main(String[] args) {
		String[] tokens = REPL
				.getTokens("Write some words, separated my space: ");
		displayFrame(tokens);
	}

	public static final String indent = "   ";

	public static void displayFrame(String[] words) {
		int max = maxLength(words);
		String line = indent + repeatString("*", max + 4);

		System.out.println("\n" + line);
		for (String word : words) {
			System.out.println(indent + "* " + word
					+ repeatString(" ", max - word.length()) + " *");
		}
		System.out.println(line);
	}

	private static String repeatString(String c, int times) {
		StringBuilder line = new StringBuilder();

		for (int i = 0; i < times; i++)
			line.append(c);

		return line.toString();
	}

	private static int maxLength(String[] tokens) {
		int max = 0;

		for (String i : tokens) {
			if (i.length() > max)
				max = i.length();
		}

		return max;
	}
}
