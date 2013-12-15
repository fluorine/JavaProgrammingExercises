package com.github.fluorine.sortedlinkedlist;

import com.github.fluorine.repl.*;

/**
 * This program ask user for some integer values to create a sorted linked list.
 * 
 * This program requires the JavaREPL utility class.
 * 
 * @author fluorine@github.com
 */
public class SortedLinkedList {
	public static void main(String[] args) {
		// Get data from the user
		Integer[] numbers = REPL
				.getIntArray("Write some integers, separated by space,\n"
						+ "   to generate a sorted linked list");

		// Add given numbers into sorted linked list
		SortedLinkedNode root = new SortedLinkedNode(numbers[0]);
		int i = 1;

		do {
			root = root.add(numbers[i++]);
		} while (i < numbers.length);

		// Display linked list
		System.out.println("\n   Sorted Linked List:\n   " + root.toString());

	}
}
