package collections;

public interface MyList<E> extends Iterable<Object> {
	
	<E> void add(E e);
	void clear();
	boolean remove(Object o); 
	Object[] toArray(); 
	int size(); 
	boolean contains(Object o); 
	<E>boolean containsAll(MyList<E> c);

}
