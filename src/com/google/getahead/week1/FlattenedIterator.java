package com.google.getahead.week1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 Given a list of iterators, implement a FlattenedIterator class which incrementally iterates over the integers from all the iterators in an interleaved fashion.

 An iterator implements the next() and hasNext() interface. You're free to use them, and you will implement them on the FlattenedIterator class.

 Test Cases
 For iterator set [1,2,3], [4,5] and [6,7,8], the FlattenedIterator should yield an iterator over [1,4,6,2,5,7,3,8].
 Iterators [1,2,3], [] and [6,7], yield iterator [1,6,2,7,3].
 * @param <T>
 */

public class FlattenedIterator<T> implements Iterator<T> {

	private List<Iterator<T>> iterators;
	private Iterator<Iterator<T>> iteratorIterator;

	public FlattenedIterator(List<Iterator<T>> iterators) {
		this.iterators = new LinkedList<>(iterators);
		this.iteratorIterator = this.iterators.listIterator();
		while(iteratorIterator.hasNext()) {
			if(!iteratorIterator.next().hasNext()) {
				iteratorIterator.remove();
			}
		}
		this.iteratorIterator = this.iterators.listIterator();
	}

	@Override
	public boolean hasNext() {
		return iteratorIterator.hasNext();
	}

	@Override
	public T next() {
		if(!this.hasNext()) {
			return null;
		}

		Iterator<T> currentIterator = iteratorIterator.next();
		T returnValue = currentIterator.next();

		if(!currentIterator.hasNext()) {
			iteratorIterator.remove();
		}

		if(!iteratorIterator.hasNext()) {
			iteratorIterator = iterators.listIterator();
		}

		return returnValue;

	}
}
