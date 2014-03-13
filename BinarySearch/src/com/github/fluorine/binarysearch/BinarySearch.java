package com.github.fluorine.binarysearch;

import java.util.Arrays;
import javarepl.REPL;

/**
 * This little application sorts an array of integers and then opens a little
 * REPL to search an item in it, using a recursive Binary Search algorithm .
 * 
 * @author fluorine@github.com
 * 
 */
public class BinarySearch {
	public static void main(String[] args) {
		// Getting some integers to populate an array
		Integer[] array = REPL
				.getIntArray("Write some integers (separated my space): ");

		// Sorting array and displaying it
		Arrays.sort(array);

		System.out.println();
		System.out.print("  Sorted array:\n    ");
		for (Integer i : array)
			System.out.print(" " + i);
		System.out.println("\n");

		// Opening REPL to use binary search and
		// find an item in the array
		while (true) {
			Integer number = REPL.getInt("Find a number in the array: ");
			int index = binarySearch(array, number);

			if (index == -1) {
				System.out.println("   Number was not found.");
			} else {
				System.out.println("   Number was found at position " + index
						+ " of array (starting from 0).");
			}

			System.out.println();
		}
	}

	static public int binarySearch(Integer[] array, Integer target) {
		return binarySearch(array, target, 0, array.length);
	}

	static public int binarySearch(Integer[] array, Integer target, int start,
			int limit) {
		if (limit <= start)
			return -1;

		int middle = start + ((limit - start) / 2);
		int comparation = target.compareTo(array[middle]);

		if (comparation < 0) {
			return binarySearch(array, target, start, middle);
		} else if (comparation > 0) {
			return binarySearch(array, target, middle + 1, limit);
		} else {
			return middle;
		}
	}
}
