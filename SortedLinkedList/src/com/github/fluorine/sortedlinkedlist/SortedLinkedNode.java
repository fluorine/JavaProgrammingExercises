package com.github.fluorine.sortedlinkedlist;

/**
 * A persistent data structure to store integer values as items in a sorted
 * linked list.
 * 
 * @author fluorine@github.com
 * 
 */
public class SortedLinkedNode {
	int value;
	SortedLinkedNode next;

	// Constructors

	/**
	 * Constructor to create starting node for a persistent linked list.
	 * 
	 * @param value
	 */
	public SortedLinkedNode(int value) {
		this(value, null);
	}

	/**
	 * An internal constructor to add new items into the list.
	 */
	private SortedLinkedNode(int value, SortedLinkedNode next) {
		this.value = value;
		this.next = next;
	}

	// Methods

	public SortedLinkedNode add(int value) {
		if (value < this.value) {
			return new SortedLinkedNode(value, this);
		} else {
			if (next == null) {
				return new SortedLinkedNode(this.value, new SortedLinkedNode(
						value));
			} else {
				return new SortedLinkedNode(this.value, next.add(value));
			}
		}
	}

	@Override
	public String toString() {
		if (next == null) {
			return value + "\n";
		} else {
			return value + " -> " + next.toString();
		}
	}
}
