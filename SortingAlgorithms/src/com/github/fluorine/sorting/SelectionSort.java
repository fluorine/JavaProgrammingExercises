package com.github.fluorine.sorting;

public class SelectionSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

	public SelectionSort(T[] array) {
		super(array);
	}

	@Override
	protected String getName() {
		return "Selection Sort";
	}

	@Override
	public void inPlaceSort(T[] array, int order) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int k = i + 1; k < array.length; k++) {
				if (array[i].compareTo(array[k]) == order) {
					SortingAlgorithm.swapItems(array, i, k);
					delay(order);
				}
			}
		}
	}
}
