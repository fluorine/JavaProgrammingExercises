package com.github.fluorine.sorting;

public class InsertionSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
	public InsertionSort(T[] original) {
		super(original);
	}

	@Override
	protected String getName() {
		return "Insertion Sort";
	}

	@Override
	public void inPlaceSort(T[] array, int order) {
		for (int a = 1; a < array.length; a++) {
			T item = array[a];

			int i;
			for (i = a; i > 0 && item.compareTo(array[i - 1]) != order; i--) {
				array[i] = array[i - 1];
				delay();
			}

			array[i] = item;
		}
	}

}
