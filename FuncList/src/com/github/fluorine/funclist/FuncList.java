package com.github.fluorine.funclist;

import java.util.Iterator;

/**
 * A simple immutable linked list for functional programming.
 * 
 * @author fluorine@github.com
 * @version 0.1
 */
public class FuncList<T> implements Iterable<T> {
	/**
	 * Starting value of list.
	 */
	public final T head;

	/**
	 * Tail of current list, excluding head.
	 */
	public final FuncList<T> tail;

	// Constructors

	/**
	 * Creates new list with a new starting value (head), appending it to the
	 * tail list.
	 * 
	 * @param head
	 *            Value to append.
	 * @param tail
	 *            Rest of the new list
	 */
	public FuncList(T head, FuncList<T> tail) {
		this.head = head;
		this.tail = tail;
	}

	/**
	 * Create new linked list with a starting value.
	 * 
	 * @param head
	 *            Starting value
	 */
	public FuncList(T head) {
		this(head, null);
	}

	public FuncList<T> append(T... values) {
		FuncList<T> newlist = this;

		for (T i : values) {
			newlist = new FuncList<T>(i, newlist);
		}

		return newlist;
	}

	// Other methods

	/**
	 * @return Quantity of items in list.
	 */
	public int count() {
		if (tail == null) {
			return 1;
		} else {
			return 1 + tail.count();
		}
	}

	@Override
	public String toString() {
		if (tail == null) {
			return head.toString() + "\n";
		} else {
			return head.toString() + " -> " + tail.toString();
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				if (current == null) {
					return false;
				} else {
					return true;
				}
			}

			FuncList<T> current = instance();

			@Override
			public T next() {
				T value = current.head;
				current = current.tail;
				return value;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	// Get current instance, for iterator's anonymous instance
	private FuncList<T> instance() {
		return this;
	}
}
