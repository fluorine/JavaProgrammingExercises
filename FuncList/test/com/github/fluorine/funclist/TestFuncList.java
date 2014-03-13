package com.github.fluorine.funclist;

import junit.framework.TestCase;
import com.github.fluorine.funclist.FuncList;

public class TestFuncList extends TestCase {

	FuncList<Integer> list;

	protected void setUp() throws Exception {
		list = new FuncList<Integer>(3);
		list = new FuncList<Integer>(2, list);
		list = new FuncList<Integer>(1, list);
	}

	public void testAppend() {
		list = new FuncList<Integer>(7);
		list = list.append(6, 5, 4, 3, 2, 1);
		Integer[] match = { 1, 2, 3, 4, 5, 6, 7 };

		int k = 0;
		for (int i : list) {
			assertTrue(match[k++] == i);
		}

		assertEquals(7, k);
	}

	public void testHead() {
		assertEquals(new Integer(1), list.head);
	}

	public void testCount() {
		assertEquals(3, list.count());
	}

	public void testIterator() {
		Integer[] match = new Integer[] { 1, 2, 3 };
		int k = 0;

		for (Integer i : list) {
			assertEquals(match[k++], i);
		}
	}

	public void testToString() {
		assertEquals("1 -> 2 -> 3\n", list.toString());
	}

}
