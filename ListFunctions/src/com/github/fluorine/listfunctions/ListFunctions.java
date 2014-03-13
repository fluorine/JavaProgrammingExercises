package com.github.fluorine.listfunctions;

import com.github.fluorine.funclist.FuncList;
import javarepl.REPL;

/**
 * Some functional programming with lists.
 * 
 * @author fluorine@github.com
 * 
 */
public class ListFunctions {
	public static void main(String[] args) {
		// Print instructions
		System.out
				.println("This command-line application gets a list of integers");
		System.out.println("from user to generate a list and operate on it.\n");

		// Get list on integers from user, using REPL
		Integer[] values = REPL
				.getIntArray("Write some integers (delimited by space): ");

		// Populate linked list and display it
		FuncList<Integer> list = null;

		for (int i = 0; i < values.length; i++) {
			list = new FuncList<Integer>(values[i], list);
		}

		System.out.print("\n  List:     " + list.toString());
		System.out.println("  Reversed: " + reverse(list));

		// Odd or Even positions
		System.out.print("   Odd items: " + oddItems(list));
		System.out.println("  Even items: " + evenItems(list));

		// Some operations
		System.out.println("  Maximum value in list: " + max(list));
		System.out.println("  Minimum value in list: " + min(list) + "\n");
	}

	public static <T extends Comparable<T>> T max(FuncList<T> list) {
		if (list.tail == null) {
			return list.head;
		} else {
			T tailMax = max(list.tail);
			if (list.head.compareTo(tailMax) == 1) {
				return list.head;
			} else {
				return tailMax;
			}
		}
	}

	public static <T extends Comparable<T>> T min(FuncList<T> list) {
		if (list.tail == null) {
			return list.head;
		} else {
			T tailMin = min(list.tail);
			if (list.head.compareTo(tailMin) == -1) {
				return list.head;
			} else {
				return tailMin;
			}
		}
	}

	public static <T> FuncList<T> reverse(FuncList<T> list) {
		return reverse(list, null);
	}

	private static <T> FuncList<T> reverse(FuncList<T> list, FuncList<T> rev) {
		if (list.tail == null) {
			return new FuncList<T>(list.head, rev);
		} else {
			return reverse(list.tail, new FuncList<T>(list.head, rev));
		}
	}

	public static <T> FuncList<T> oddItems(FuncList<T> list) {
		return reverse(pickPositions(list, true));
	}

	public static <T> FuncList<T> evenItems(FuncList<T> list) {
		return reverse(pickPositions(list, false));
	}

	private static <T> FuncList<T> pickPositions(FuncList<T> list, boolean able) {
		if (able) {
			if (list == null) {
				return null;
			} else {
				return new FuncList<T>(list.head, pickPositions(list.tail,
						false));
			}
		} else {
			if (list == null) {
				return null;
			} else {
				return pickPositions(list.tail, true);
			}
		}
	}
}
