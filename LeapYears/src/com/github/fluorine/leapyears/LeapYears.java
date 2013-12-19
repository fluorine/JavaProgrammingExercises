package com.github.fluorine.leapyears;

import java.util.Calendar;

/**
 * This simple application displays the next 20 leap years, from current year of
 * the system.
 * 
 * @author fluorine@github.com
 * 
 */
public class LeapYears {
	final static int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	final static int maxNextLeapYears = 20;

	public static void main(String[] args) {
		System.out.print("Next " + maxNextLeapYears + " leap years, from "
				+ currentYear + ":\n  ");

		int countLeapYears = 0;
		for (int i = currentYear; countLeapYears < maxNextLeapYears; i++) {
			if (isLeapYear(i)) {
				System.out.print(i + "  ");
				countLeapYears++;
			}
		}
	}

	/**
	 * Check is given year is leap.
	 * 
	 * @param year
	 * @return True if leap year, False otherwise.
	 */
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0)
				|| (year % 100 == 0 && year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}
}
