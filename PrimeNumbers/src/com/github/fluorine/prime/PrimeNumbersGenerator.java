package com.github.fluorine.prime;

/**
 * This little application prints all numbers between 1 and 1000.
 * 
 * @author fluorine@github.com
 * 
 */
public class PrimeNumbersGenerator {
	public static void main(String[] args) {
		final int MAX = 1000;

		int k = 0;
		for (int i = 2; i < MAX; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
				k++;
			}
		}

		// Display total
		System.out.print("\n\n[Total prime numbers found between 1 and " + MAX
				+ ": " + k + "]");
	}

	/**
	 * A recursive algorithm to find prime numbers.
	 * 
	 * @param n
	 *            The number to evaluate as prime or not prime
	 * @return true if prime, false otherwise.
	 */
	public static boolean isPrime(int n) {
		return isPrime(n, 2);
	}

	private static boolean isPrime(int n, int i) {
		if (i >= n) {
			return true;
		} else if (n % i == 0) {
			return false;
		} else {
			return isPrime(n, i + 1);
		}
	}
}
