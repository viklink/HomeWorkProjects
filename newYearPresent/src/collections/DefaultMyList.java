package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultMyList<E> implements MyList <E>, ListIterable {

	private Object[] data;
	private int size;
	private static final int DEFAULT_CAPACITY = 6;

	public <E> DefaultMyList(E e) {
		data = new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	@Override
	public <E> void add(E e) {
		if (size == data.length) {
			int newSize = data.length * 2;
			data = Arrays.copyOf(data, newSize);
		}
		data[size++] = e;
	}

	@Override
	public void clear() {
		for (int i = 0; i < data.length; i++) {
			data[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index != -1) {
			remove(index);
			return true;
		} else {
			return false;
		}
	}

	private int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (data[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(data[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(Object o) {
		boolean isObj = false;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == o) {
				isObj = true;
			} else {
				isObj = false;
			}
		}
		return isObj;
	}

	@Override
	public <E> boolean containsAll(MyList<E> c) {
		boolean isAll = false;

		for (int i = 0; i < data.length; i++) {
			if (c != null) {
				if (c.contains(data[i])) {
					isAll = true;
				} else {
					isAll = false;
					break;
				}
			}
		}
		return isAll;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < data.length; i++) {
			sb.append("[" + data[i].toString() + "]");
			if (i != data.length - 1) {
				sb.append(",");
			}
			sb.append("}");
		}
		return sb.toString();
	}

	@Override
	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	private class IteratorImpl implements Iterator<Object> {

		private int arrayIndex = 0;
		private boolean isNext = false;
		private boolean isRemoved = false;

		public boolean hasNext() { // returns true if the iteration has more elements
			return arrayIndex < data.length;
		}

		public Object next() { // returns the next element in the iteration
			
			if (arrayIndex >= data.length) {
				throw new NoSuchElementException("Iterated beyond the end of array");
			}
			isNext = true;
			return data[arrayIndex++];
		}

		public void remove() { // removes from the underlying collection the last element returned by this
								// iterator
			data[arrayIndex] = new IteratorImpl().next();
			if (!isNext || isRemoved) {
				throw new IllegalStateException();
			}
			for (int i = arrayIndex; i < data.length - 1; i++) {
				data[i] = data[i + 1];
			}
			isRemoved = true;
			size--;
		}
	}

	@Override
	public ListIterator listIterator() {
		return new ListIteratorImpl();
	}

	private class ListIteratorImpl extends IteratorImpl implements ListIterator {

		private int arrayIndex = 0;
		private boolean isNext = false;
		private boolean isPrevious = false;
		private boolean isSet = false;
		private boolean isRemoved = false;

		public Object next() {
			
			if (arrayIndex >= data.length) {
				throw new NoSuchElementException("Iterated beyond the end of array");
			}
			isNext = true;
			return data[arrayIndex++];
		}

		@Override
		public boolean hasPrevious() {
			return arrayIndex >= 0;
		}

		@Override
		public Object previous() {
			if (arrayIndex < 0) {
				throw new NoSuchElementException("Iterated beyond the beginning of array");
			}
			isPrevious = true;
			return data[arrayIndex--];
		}

		@Override
		public void set(Object e) {
			if (!isNext || !isPrevious || isSet) {
				throw new IllegalStateException();
			}
			isSet = true;
			data[arrayIndex] = e;
		}

		@Override
		public void remove() {
			data[arrayIndex] = new ListIteratorImpl().previous();
			if (!isNext || !isPrevious || isRemoved) {
				throw new IllegalStateException();
			}
			for (int i = arrayIndex; i < data.length - 1; i++) {
				data[i] = data[i + 1];
			}
			isRemoved = true;
			size--;
		}

	}

}
