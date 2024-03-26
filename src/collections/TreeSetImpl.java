package collections;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.TreeSet;

//A NavigableSet implementation based on a TreeMap. 
//The elements are ordered using their Comparable natural ordering or by a Comparator.
//This implementation provides guaranteed log(n) time cost for the basic operations add, remove and contains.

//The ordering maintained by a set must be "consistent with equals"(see Comparator/Comparator code ref.) because the Set interface is defined in
//terms of the equals operation but a TreeSet performs all element comparisons using its compareTo/compare method.
//so two elements that are deemed equal by this method are, from the standpoint of the set, equal.

//This implementation is not synchronized.If multiple threads access a tree set concurrently,it must be synchronized externally
//by synchronizing on some object that naturally encapsulates the set. If no such object exists,the set should be "wrapped" using
//SortedSet s = Collections.synchronizedSortedSet(new TreeSet(...)); 
//This is best done at creation time, to prevent accidental unsynchronized access to the set.

public class TreeSetImpl<E> extends AbstractSet<E>
implements NavigableSet<E>, Cloneable, java.io.Serializable {

	private transient NavigableMap<E,Object> m; //The backing map
	private static final Object PRESENT = new Object(); //Dummy value to associate with an Object in the backing Map
	
	//Constructs a set backed by the specified navigable map
	TreeSetImpl(NavigableMap<E,Object> m) {
        this.m = m;
    }
	
	//Constructs a new, empty tree set, sorted according to the natural ordering of its elements.
	//All elements inserted into the set must implement the Comparable interface and all such elements
	//must be mutually comparable e1.compareTo(e2) - same data type else ClassCastException thrown.
	public TreeSetImpl() {
        this(new TreeMap<>());
    }
	
	//Constructs a new, empty tree set, sorted according to the specified comparator.
	//All elements inserted into the set must be mutually comparable by the specified comparator
	//comparator.compare(e1,e2) must not throw a ClassCastException for any elements
	public TreeSetImpl(Comparator<? super E> comparator) {
        this(new TreeMap<>(comparator));
    }
	
	//Constructs a new tree set containing the elements in the specified collection, 
	//sorted according to the natural ordering of its elements.
	public TreeSetImpl(Collection<? extends E> c) {
        this();
        addAll(c);
    }
	
	//Constructs a new tree set containing the same elements and using the same ordering as the specified sorted set.
	public TreeSetImpl(SortedSet<E> s) {
        this(s.comparator());
        addAll(s);
    }
	
	
	@Override
	public Comparator<? super E> comparator() {
		return m.comparator();
	}

	@Override
	public E first() {
		 return m.firstKey();
	}

	@Override
	public E last() {
		return m.lastKey();
	}

	@Override
	public E lower(E e) {
		return m.lowerKey(e);
	}

	@Override
	public E floor(E e) {
		return m.floorKey(e);
	}

	@Override
	public E ceiling(E e) {
		return m.ceilingKey(e);
	}

	@Override
	public E higher(E e) {
		return m.higherKey(e);
	}

	@Override
	public E pollFirst() {
		Map.Entry<E,?> e = m.pollFirstEntry();
        return (e == null) ? null : e.getKey();
	}

	@Override
	public E pollLast() {
		Map.Entry<E,?> e = m.pollLastEntry();
        return (e == null) ? null : e.getKey();
	}

	@Override
	public NavigableSet<E> descendingSet() {
		return new TreeSet<>(m.descendingMap());
	}

	@Override
	public Iterator<E> descendingIterator() {
		return m.descendingKeySet().iterator();
	}

	@Override
	public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
		return new TreeSet<>(m.subMap(fromElement, fromInclusive,toElement,   toInclusive));
	}

	@Override
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		return new TreeSet<>(m.headMap(toElement, inclusive));
	}

	@Override
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		return new TreeSet<>(m.tailMap(fromElement, inclusive));
	}

	@Override
	public SortedSet<E> subSet(E fromElement, E toElement) {
		 return subSet(fromElement, true, toElement, false);
	}

	@Override
	public SortedSet<E> headSet(E toElement) {
		return headSet(toElement, false);
	}

	@Override
	public SortedSet<E> tailSet(E fromElement) {
		return tailSet(fromElement, true);
	}

	//Returns an iterator over the elements in this set in ascending order
	@Override
	public Iterator<E> iterator() {
		return m.navigableKeySet().iterator();
	}

	@Override
	public int size() {
		return m.size();
	}
	
	public Spliterator<E> spliterator() {
        return TreeMap.keySpliteratorFor(m);
    }

}
