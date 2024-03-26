package collections;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Spliterator;

//The hash code of a set is defined to be the sum of the hash codes of the elements in the set. 
//The hash code of a null element is defined to be zero.
//This ensures that s1.equals(s2) implies that s1.hashCode()==s2.hashCode() for any two sets.

//Hashset implements the Set interface, backed by a hash table - actually a Hashmap instance.
//This implementation is not synchronized
public class HashSetImpl<E> extends AbstractSet<E>
implements Set<E>, Cloneable, java.io.Serializable{
	
	@java.io.Serial
    static final long serialVersionUID = -5024744406713321676L;

	private static final Object PRESENT = null;

    private transient HashMap<E,Object> map; //thus hashset is hashmap implementation.
    //Hashset is a Hashmap with hashcode as keys and objects as values - thus cannot store duplicate values due to conflict in hashcodes.
    
    //Constructs a new, empty set; the backing HashMap instance with default initial capacity (16) and load factor (0.75)
    public HashSetImpl() {
        map = new HashMap<>();
    }
    
    //Constructs a new, empty set; the backing HashMap instance has initial capacity and default load factor (0.75)
    public HashSetImpl(int initialCapacity) {
        map = new HashMap<>(initialCapacity);
    }
    
    //Constructs a new, empty set; the backing HashMap instance has the specified initial capacity and the specified load factor.
    public HashSetImpl(int initialCapacity, float loadFactor) {
        map = new HashMap<>(initialCapacity, loadFactor);
    }
    
    //HashMap is created with default load factor (0.75) and an initial capacity sufficient to contain the elements in the specified collection.
    public HashSetImpl(Collection<? extends E> c) {
        map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
        addAll(c);
    }
    
    //This package private constructor is only used by LinkedHashSet.
    //Constructs a new, empty linked hash set constructor - only used by LinkedHashSet .
    //The backing LinkedHashMap with the specified initial capacity and the specified load factor. dummy can be ignored.
    public HashSetImpl(int initialCapacity, float loadFactor, boolean dummy) {
        map = new LinkedHashMap<>(initialCapacity, loadFactor);
    }
    
	@Override
	public Iterator<E> iterator() {
		return map.keySet().iterator();
	}

	@Override
	public int size() {
		return map.size();
	}
	
	public boolean isEmpty() {
        return map.isEmpty();
    }
	
	public boolean contains(Object o) {
        return map.containsKey(o);
    }
	
	//Adds the specified element to this set if it is not already present
	public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
	
	public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }
	
	public void clear() {
        map.clear();
    }
	
	//Returns a shallow copy of this HashSet} instance
	@SuppressWarnings("unchecked")
    public Object clone() {
        try {
            HashSet<E> newSet = (HashSet<E>) super.clone();
            newSet.map = (HashMap<E, Object>) map.clone();
            return newSet;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

	 public Spliterator<E> spliterator() {
	        return new HashMap().KeySpliterator<>(map, 0, -1, 0, 0);
	    }

	 @Override
	 public Object[] toArray() {
	        return map.keysToArray(new Object[map.size()]);
	    }

	 @Override
	 public <T> T[] toArray(T[] a) {
	        return map.keysToArray(map.prepareArray(a));
	    }
}
