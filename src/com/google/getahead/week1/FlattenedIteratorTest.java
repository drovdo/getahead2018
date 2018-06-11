package com.google.getahead.week1;

import java.util.*;

public class FlattenedIteratorTest {

	private static <T> void test(List<Iterator<T>> list, Iterator<T> expected) {
		Iterator<T> iterator = new FlattenedIterator<>(list);
		while(iterator.hasNext() && expected.hasNext()) {
			T exp = expected.next();
			T real = iterator.next();
			if(!exp.equals(real)) {
				throw new RuntimeException("Validation failed, expected " + exp + " but got " + real);
			}
		}

		if(iterator.hasNext() != expected.hasNext()) {
			throw new RuntimeException("Validation failed, iterator lengths do not match");
		}
	}

	public static void main(String[] args) {
		List<Iterator<Integer>> list1 = new LinkedList<>();
		list1.add(Arrays.asList(1, 2, 3).iterator());
		list1.add(Arrays.asList(4, 5, 6).iterator());
		list1.add(Arrays.asList(7, 8, 9).iterator());
		test(list1, Arrays.asList(1, 4, 7, 2, 5, 8, 3, 6, 9).listIterator());

		List<Iterator<Integer>> list2 = new LinkedList<>();
		list2.add(Arrays.asList(1, 2, 3).iterator());
		list2.add(Arrays.asList(4, 5).iterator());
		list2.add(Arrays.asList(6, 7, 8).iterator());
		test(list2, Arrays.asList(1, 4, 6, 2, 5, 7, 3, 8).listIterator());

		List<Iterator<Integer>> list3 = new LinkedList<>();
		list3.add(Arrays.asList(1, 2, 3).iterator());
		list3.add(((List<Integer>)Collections.EMPTY_LIST).iterator());
		list3.add(Arrays.asList(6, 7).iterator());
		test(list3, Arrays.asList(1, 6, 2, 7, 3).listIterator());
	}
}
