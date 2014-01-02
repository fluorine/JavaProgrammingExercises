package com.github.fluorine.listfunctions;

import javarepl.REPL;
import com.github.fluorine.funclist.FuncList;
import com.github.fluorine.listfunctions.Function;

/**
 * More functional programming with lists.
 * <ul>
 * <li>A function to find an item in linked list.</li>
 * <li>Using interfaces and anonymous classes to 'send" functions as parameters
 * of other functions.</li>
 * </ul>
 * 
 * @author fluorine@github.com
 * 
 */
public class ListFunctions2 {
	public static void main(String[] args) {
		// Get values for linked list
		System.out.println("  Write a list of integers to create");
		Integer[] numbers = REPL.getIntArray("of integers: ");

		// Generate linked list and display it
		FuncList<Integer> root = new FuncList<Integer>(numbers[0]);
		for (int i = 1; i < numbers.length; i++) {
			root = new FuncList<Integer>(numbers[i], root);
		}

		System.out.println();
		System.out.println("   " + root.toString());

		// Find an item
		int target = REPL.getInt("Insert a value to find in list: ");
		if (find(target, root)) {
			System.out
					.println("   Value " + target + " was found in the list.");
		} else {
			System.out.println("   Value " + target
					+ " was NOT found in the list.");
		}

		// Produce squares from list
		FuncList<Integer> squares = map(root, new Function<Integer>() {
			// Function to be "send" into another function (map).
			@Override
			public Integer apply(Integer value) {
				return value * value;
			}
		});

		// Display list of squares
		System.out
				.println("\n  List of squares produced from the provided list:\n   "
						+ squares.toString());

	}

	/**
	 * A recursive function to find an item in a linked list.
	 * 
	 * @param <T>
	 *            A comparable value.
	 * @param value
	 *            Value to find.
	 * @param list
	 *            List to search in.
	 * @return True if value was found in list, False otherwise.
	 */
	public static <T extends Comparable<T>> boolean find(T value,
			FuncList<T> list) {
		if (list == null) {
			return false;
		} else {
			if (list.head.compareTo(value) == 0) {
				return true;
			} else {
				return find(value, list.tail);
			}
		}
	}

	/**
	 * This recursive function apply processes every item of the provided list.
	 * It applies a provided function on every item.
	 * 
	 * @param <T>
	 * @param list
	 *            List to process.
	 * @param fn
	 *            Function to process each item.
	 * @return List of processed items.
	 */
	public static <T> FuncList<T> map(FuncList<T> list, Function<T> fn) {
		return map(list, null, fn);
	}

	private static <T> FuncList<T> map(FuncList<T> list,
			FuncList<T> processedList, Function<T> fn) {
		if (list == null) {
			return processedList;
		} else {
			T product = fn.apply(list.head);
			return map(list.tail, new FuncList<T>(product, processedList), fn);
		}
	}
}
