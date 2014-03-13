package com.github.fluorine.productsum;

import javarepl.REPL;

/**
 * A program that asks the user for a number n and gives him the possibility to
 * choose between computing the sum and computing the product of 1,…,n.
 * 
 * These and other problems were statet ar from:
 * http://adriann.github.io/programming_problems.html
 * 
 * @author fluorine@github.com
 * 
 */
public class ProductSum {
	public static void main(String[] args) {
		// Instructions
		System.out.println("This program can produce the sum or the product\n"
				+ "of the series of numbers from 1 to given n.");

		// Ask for a number
		int n;
		while (true) {
			n = REPL.getInt("n: ");

			if (n < 1) {
				System.out.println("  The number should not be less than 1.");
			} else {
				break;
			}
		}

		// Ask for option
		String option;
		while (true) {
			option = REPL.getString("Produce the sum (s) or product (p)? ")
					.trim().toLowerCase();

			if (option.equals("s") || option.equals("p")) {
				break;
			} else {
				System.out.println("  Invalid option. Try again.");
			}
		}

		// Calculate sum or product
		if (option.equals("p")) {
			int product = 1;
			for (int i = 1; i <= n; i++) {
				product *= i;
			}

			System.out.println("  The product of all numbers from 1 to " + n
					+ " is " + product);
		} else {
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				sum += i;
			}

			System.out.println("  The sum of all numbers from 1 to " + n
					+ " is " + sum);
		}
	}
}
