package com.github.fluorine.sorting;

public class QuickSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
	public QuickSort(T[] original) {
		super(original);
	}

	private int order;

	@Override
	protected String getName() {
		return "Quick Sort";
	}

	@Override
	public void inPlaceSort(T[] array, int order) {
		this.order = order;
		sort(array, 0, array.length);
	}

	private void sort(T[] array, int start, int limit) {
		if (limit - start <= 1)
			return;

		T pivot = array[start];
		int i = start + 1;
		int j = limit - 1;

		while (true) {
			while (i < limit && pivot.compareTo(array[i]) == order) {
				i++;
				delay(order);
			}

			while (j > start && pivot.compareTo(array[j]) != order) {
				j--;
				delay(order);
			}

			if (i >= j)
				break;

			swapItems(array, i, j);
		}

		swapItems(array, j, start);

		// Recursive calls
		sort(array, start, j);
		sort(array, j + 1, limit);
	}
}
