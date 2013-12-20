package com.github.fluorine.calculatepi;

import java.math.BigDecimal;

/**
 * Implementation of the Leibniz's formula to calculate PI.
 * 
 * @author fluorine@github.com
 * 
 */
public class CalculatePI {
	final static int precision = 1000000;

	public static void main(String[] args) {
		System.out
				.println("Calculating PI using Leibniz's formula\n(with a precision of "
						+ precision + " iterations)");
		System.out.printf("  %80.78f", calculatePI(precision));
	}

	public static BigDecimal calculatePI(int precision) {
		BigDecimal PIquarter = new BigDecimal(0);
		for (int k = 1; k < precision; k++) {
			PIquarter = PIquarter.add(new BigDecimal(Math.pow(-1.0, k + 1.0)
					/ (2.0 * k - 1.0)));
		}

		return PIquarter.multiply(new BigDecimal(4));
	}
}
