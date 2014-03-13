package com.github.fluorine.multiplicationtable;

/**
 * This simple application displays a 12 x 12 multiplication table.
 * 
 * @author fluorine@github.com
 * 
 */
public class MultiplicationTable {
	public static void main(String[] args) {
		displayTable(12);
	}

	/**
	 * An implementation of a recursive algorithm to display a multiplication
	 * table.
	 * 
	 * @param limit
	 *            Number of columns / rows
	 */
	public static void displayTable(int limit) {
		displayTable(limit, 1, 1);
	}

	private static void displayTable(int limit, int x, int y) {
		if (x > limit) {
			if (y == limit) {
				return;
			} else {
				System.out.println();
				displayTable(limit, 1, y + 1);
			}
		} else {
			System.out.print((x * y) + "\t");
			displayTable(limit, x + 1, y);
		}
	}

}
