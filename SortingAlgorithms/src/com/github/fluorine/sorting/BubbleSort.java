package com.github.fluorine.sorting;

public class BubbleSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

	public BubbleSort(T[] original) {
		super(original);
	}

	@Override
	protected String getName() {
		return "Bubble Sort";
	}

	@Override
	public void inPlaceSort(T[] array, int order) {
		for (int i = array.length - 1; i > 1; i--) {
			for (int k = 0; k < i; k++) {
				if (array[k].compareTo(array[k + 1]) == order) {
					swapItems(array, k, k + 1);
					delay(order);
				}
			}
		}
	}
}
