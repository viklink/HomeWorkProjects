package collections;

import java.util.Arrays;

public class DefaultMyList implements MyList {

	private Object[] data;
	private int size;
	private static final int DEFAULT_CAPACITY = 6;

	public DefaultMyList() {
		data = new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	@Override
	public void add(Object e) {
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
	public boolean containsAll(MyList c) {
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

}
