package com.github.fluorine.sorting;

public class MergeSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
	private int order;
	private T[] array;

	public MergeSort(T[] original) {
		super(original);
	}

	@Override
	protected String getName() {
		return "Merge Sort";
	}

	@Override
	public void inPlaceSort(T[] array, int order) {
		this.array = array;
		this.order = order;
		sort(0, array.length);
	}

	private void sort(int start, int limit) {
		if (limit - start <= 1)
			return;

		int middle = start + ((limit - start) / 2);

		// Recursive calls
		sort(start, middle);
		sort(middle, limit);
		merge(start, middle, limit);
	}

	@SuppressWarnings("unchecked")
	private void merge(int start, int middle, int limit) {
		if (start == middle || middle == limit)
			return;

		// Temporal array to save new array of merged items

		Object[] temp = new Object[limit - start];
		int i = 0;

		// Indices to track slices

		int left = start;
		int right = middle;

		// Merge

		while (left < middle && right < limit) {
			if (array[left].compareTo(array[right]) == order) {
				temp[i++] = array[right++];
			} else {
				temp[i++] = array[left++];
			}
			delay(order);
		}

		while (left < middle) {
			temp[i++] = array[left++];
			delay(order);
		}

		while (right < limit) {
			temp[i++] = array[right++];
		}

		// Overwrite original array

		int k;
		for (i = 0, k = start; k < limit; k++, i++) {
			array[k] = (T) temp[i];
		}
	}
}
