package com.github.fluorine.sorting;

public class StoogeSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
	private T[] array;
	private int order;

	public StoogeSort(T[] original) {
		super(original);
	}

	@Override
	protected String getName() {
		return "Stooge Sort";
	}

	@Override
	public void inPlaceSort(T[] array, int order) {
		this.order = order;
		this.array = array;
		sort(0, array.length);
	}

	private void sort(int start, int limit) {
		int size = limit - start;
		if (size < 2)
			return;

		if (array[start].compareTo(array[limit - 1]) == order) {
			delay(order);
			swapItems(array, start, limit - 1);
		}

		if (size > 2) {
			int aThird = size / 3;
			sort(start, limit - aThird);
			sort(start + aThird, limit);
			sort(start, limit - aThird);
		}
	}
}
