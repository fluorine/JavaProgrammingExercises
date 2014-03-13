package com.github.fluorine.sorting;

/**
 * This class allow the implementation and evaluation of sorting algorithms.
 * 
 * @author fluorine@github.com
 * 
 * @param <T>
 *            A Comparable<T> type.
 */
public abstract class SortingAlgorithm<T extends Comparable<T>> {
	private int stepsCounter = 0;

	/**
	 * Name of the algorithm.
	 */
	public final String name;

	/**
	 * Original (likely unsorted) array.
	 */
	public final T[] original;

	/**
	 * Ascending sorted array.
	 */
	public final T[] ascendingSorted;

	/**
	 * Descending sorted array.
	 */
	public final T[] descendingSorted;

	/**
	 * Steps counter for algorithm.
	 */
	public final long steps;

	// Constructors
	public SortingAlgorithm(T[] original) {
		// Filling some fields
		this.original = original;
		name = getName();

		// Cloning arrays to sort them in place
		T[] ascendingArray = original.clone();
		T[] descendingArray = original.clone();

		// Sorting
		inPlaceSort(ascendingArray, 1);
		inPlaceSort(descendingArray, -1);
		steps = stepsCounter;

		// Filling other fields
		ascendingSorted = ascendingArray;
		descendingSorted = descendingArray;
	}

	/**
	 * Implementation that rearranges sorts the Comparable items of an array.
	 * 
	 * @param array
	 *            A mutable array.
	 * @param order
	 *            1 for ascending and -1 for descending sorting.
	 */
	public abstract void inPlaceSort(T[] array, int order);

	/**
	 * Implementation that rearranges sorts the Comparable items of an array in
	 * ascending order.
	 * 
	 * @param array
	 *            Mutable array.
	 */
	public void inPlaceSort(T[] array) {
		inPlaceSort(array, 1);
	}

	/**
	 * @return Name of the algorithm.
	 */
	protected abstract String getName();

	@Override
	public String toString() {
		return name + ": " + steps + " steps";
	}

	/**
	 * Delay time to measure performance.
	 */
	protected void delay(int order) {
		if (order == 1)
			stepsCounter++;
	}

	/**
	 * A method to exchange positions of two items in array.
	 * 
	 * @param <T>
	 * @param array
	 * @param x
	 * @param y
	 */
	public static <T> void swapItems(T[] array, int x, int y) {
		T temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	/**
	 * Entry point to test classes derived from this class.
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Random numbers

		// final Integer[] array = new Integer[] { 19, 28, 98, 90, 99, 3, 62,
		// 47,
		// 41, 46, 45, 60, 71, 79, 53, 20, 74, 97, 35, 16, 67, 88, 42, 80,
		// 39, 68, 96, 21, 52, 51, 91, 31, 13, 30, 54, 12, 57, 63, 73, 77,
		// 78, 83, 25, 4, 76, 94, 66, 2, 55, 93, 70, 65, 18, 72, 11, 15,
		// 48, 5, 7, 8, 22, 61, 85, 33, 38, 6, 81, 34, 69, 10, 64, 56, 43,
		// 49, 36, 32, 26, 86, 89, 0, 37, 44, 82, 17, 100, 14, 87, 40, 75,
		// 59, 84, 92, 24, 29, 9, 23, 1, 50, 58, 27, 95 };

		final Integer[] array = new Integer[] { 18, 2, 13, 1, 17, 9, 8, 10, 25,
				3, 6, 16, 23, 4, 20, 12, 24, 15, 7, 5, 21, 14, 22, 11, 19 };

		// final Integer[] array = new Integer[] { 1, 2, 3, 7, 4, 5, 6, 7 };

		// final Integer[] array = new Integer[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
		// };

		// Settings
		Integer[] a = array;
		SortingAlgorithm<?>[] algorithms = { new SelectionSort<Integer>(a),
				new BubbleSort<Integer>(a), new InsertionSort(a),
				new QuickSort(a), new MergeSort(a), new StoogeSort(a) };

		for (SortingAlgorithm i : algorithms) {
			printSortingAlgorithm(i);
		}
	}

	private static <T extends Comparable<T>> void printSortingAlgorithm(
			SortingAlgorithm<T> s) {
		System.out.println(s.toString());
		System.out.println("  Original:\t" + arrayToString(s.original));
		System.out.println("  Ascending:\t" + arrayToString(s.ascendingSorted));
		System.out.println("  Descending:\t"
				+ arrayToString(s.descendingSorted));
		System.out.println();
	}

	public static <T> String arrayToString(T[] array) {
		StringBuffer sb = new StringBuffer();
		for (T i : array) {
			sb.append(" " + i.toString());
		}
		return sb.toString();
	}
}
