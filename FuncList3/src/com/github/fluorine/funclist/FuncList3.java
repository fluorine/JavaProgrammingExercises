package com.github.fluorine.funclist;

import java.math.BigInteger;

import javarepl.REPL;
import com.github.fluorine.funclist.FuncList;

/**
 * More functional programming for sorting, appending and merging lists.
 * 
 * @author fluorine@github.com
 * 
 */
public class FuncList3 {
	public static void main(String[] args) {
		// Get values
		System.out.println("Insert two list of integers, separated by space.");
		Integer[] aa = REPL.getIntArray("List A: ");
		Integer[] bb = REPL.getIntArray("List B: ");

		// Produce lists
		FuncList<Integer> a = ArrayToList(aa);
		FuncList<Integer> b = ArrayToList(bb);

		// Sort lists
		a = sortList(a);
		b = sortList(b);

		// Display sorted lists
		System.out.println();
		System.out.println("  Sorted list A:\n    " + a.toString());
		System.out.println("  Sorted list B:\n    " + b.toString());

		// Create new list appending A and B and
		// then display it.
		FuncList<Integer> ab = appendLists(a, b);
		System.out.println("  Appended list:\n   " + ab.toString());

		// Create a new list merging A and B
		// into a new sorted list. Then display it.
		FuncList<Integer> merged = mergeLists(a, b);
		System.out.println("  Merged list:\n   " + merged.toString());

		// Produce a list of Fibonacci numbers
		System.out.println("  List of fibonacci numbers:\n    ");
		FuncList<BigInteger> fibo = produceFibonacci();
		for (BigInteger i : fibo) {
			System.out.print(i + " ");
		}
	}

	/**
	 * This function produces a linked list from an array.
	 * 
	 * @param <T>
	 *            Type of items in array in list.
	 * @param a
	 *            Input array
	 * @return Linked list of items in array
	 */
	public static <T> FuncList<T> ArrayToList(T[] a) {
		if (a == null || a.length == 0)
			return null;

		FuncList<T> list = new FuncList<T>(a[0]);
		for (int i = 1; i < a.length; i++) {
			list = new FuncList<T>(a[i], list);
		}

		return list;
	}

	/**
	 * A function to sort a linked list using insertion sort.
	 * 
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<T>> FuncList<T> sortList(
			FuncList<T> list) {
		return sortList(list, null);
	}

	private static <T extends Comparable<T>> FuncList<T> sortList(
			FuncList<T> list, FuncList<T> sorted) {
		if (list == null) {
			return sorted;
		} else {
			return sortList(list.tail, insertItem(list.head, sorted));
		}
	}

	/**
	 * Insert item into ascending linked list.
	 * 
	 * @param <T>
	 *            Comparable<T> type
	 * @param item
	 *            Item to insert into sorted list.
	 * @param list
	 *            Sorted list
	 * @return New sorted list with new item inside.
	 */
	public static <T extends Comparable<T>> FuncList<T> insertItem(T item,
			FuncList<T> list) {
		if (list == null) {
			return new FuncList<T>(item);
		} else if (item.compareTo(list.head) == -1) {
			return new FuncList<T>(item, list);
		} else {
			if (list.tail == null) {
				return new FuncList<T>(list.head, new FuncList<T>(item));
			} else {
				return new FuncList<T>(list.head, insertItem(item, list.tail));
			}
		}
	}

	/**
	 * This function appends two lists to produce a new one.
	 * 
	 * @param <T>
	 * @param a
	 * @param b
	 * @return The new list
	 */
	public static <T> FuncList<T> appendLists(FuncList<T> a, FuncList<T> b) {
		if (a == null) {
			return b;
		} else {
			return new FuncList<T>(a.head, appendLists(a.tail, b));
		}
	}

	/**
	 * This recursive function merges two sorted lists into a new sorted list.
	 * 
	 * @param <T>
	 * @param a
	 * @param b
	 * @return New sorted list from merging two lists.
	 */
	public static <T extends Comparable<T>> FuncList<T> mergeLists(
			FuncList<T> a, FuncList<T> b) {
		if (a == null) {
			return b;
		} else if (b == null) {
			return a;
		} else {
			if (a.head.compareTo(b.head) == -1) {
				return new FuncList<T>(a.head, mergeLists(a.tail, b));
			} else {
				return new FuncList<T>(b.head, mergeLists(b.tail, a));
			}
		}
	}

	/**
	 * @return List of Fibonacci numbers.
	 */
	public static FuncList<BigInteger> produceFibonacci() {
		return new FuncList<BigInteger>(new BigInteger("1"),
				new FuncList<BigInteger>(new BigInteger("1"), produceFibonacci(
						new BigInteger("1"), new BigInteger("1"), 3)));
	}

	public static FuncList<BigInteger> produceFibonacci(BigInteger a,
			BigInteger b, int count) {
		if (count >= 100) {
			return new FuncList<BigInteger>(a.add(b));
		} else {
			BigInteger total = a.add(b);
			return new FuncList<BigInteger>(total, produceFibonacci(b, total,
					count + 1));
		}
	}
}
