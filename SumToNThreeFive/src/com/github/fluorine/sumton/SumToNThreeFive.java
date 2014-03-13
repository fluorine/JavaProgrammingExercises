package com.github.fluorine.sumton;

import java.util.Scanner;

/**
 * This program uses a REPL to ask the user for an integer grater than 0 to
 * display the sum of all numbers from 1 to n that are multiples of 3 or 5.
 * 
 * @author fluorine@github.com
 */
public class SumToNThreeFive {
	public static void main(String[] args) {
		// REPL
		while (true) {
			// Display instructions and REPL
			System.out
					.println(" Insert a n number greater than 0 to get the sum \n"
							+ " of all numbers divisible by 3 or 5, between 1 to n.");
			System.out.print("  > ");

			// Prompt and input
			Scanner keyword = new Scanner(System.in);
			int n = keyword.nextInt();

			// Validation and result
			if (n > 0) {
				System.out
						.println("\n  Sum of numbers divisible by 3 or 5, from 0 to "
								+ n + ":\n   " + sumToN(n) + "\n");
			} else {
				System.out.println();
			}
		}
	}

	/**
	 * This function returns the sum of all numbers from 1 to n.
	 */
	public static int sumToN(int n) {
		return sumToN(n, 0);
	}

	private static int sumToN(int n, int accum) {
		if (n == 0) {
			return accum;
		} else {
			if (n % 3 == 0 || n % 5 == 0) {
				return sumToN(n - 1, accum + n);
			} else {
				return sumToN(n - 1, accum);
			}
		}
	}
}
