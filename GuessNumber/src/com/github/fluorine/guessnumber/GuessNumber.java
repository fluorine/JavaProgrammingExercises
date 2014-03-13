package com.github.fluorine.guessnumber;

import java.util.Random;

import javarepl.REPL;

/**
 * Guess-A-Number game, with levels!
 * 
 * @author fluorine@github.com
 * 
 */
public class GuessNumber {
	public static void main(String[] args) {
		while (true) {
			int level = REPL.getInt("Choose a level (10 to 1000): ");

			if (level < 10 || level > 1000) {
				System.out.println("  Provided level is out or range.\n");
			} else {
				playRound(level);
				System.out.println("  Play Again?");
			}
		}
	}

	public static void playRound(int level) {
		int secretNumber = (new Random()).nextInt(level) + 1;
		int count = 0;

		while (true) {
			int number = REPL.getInt("Guess a number: ");

			count++;
			if (secretNumber > number) {
				System.out.println("   Secret number is greater.\n");
			} else if (secretNumber < number) {
				System.out.println("   Secret number is less.\n");
			} else {
				System.out.println("   You won after " + count + " trials!\n");
				return;
			}
		}
	}
}
