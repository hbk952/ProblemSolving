package collections;

package collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

//Hash table and linked list implementation of the {@code Set} interface with predictable iteration order.
//This implementation maintains a doubly-linked list running through all of its entries.
//This linked list defines the iteration and insertion ordering.
//insertion order is not affected if an element is re-inserted into the set.
//An element e is reinserted into a set s ,if s.add(e) is invoked when s.contains(e)} would return true immediately prior to the invocation.

//Like HashSet, it provides constant-time performance for the basic operations add, contains and remove,
//assuming the hash function disperses elements properly among the buckets.
//Performance is slightly below that of HashSet due to the added expense of maintaining the linked list
//with one exception Iteration over a LinkedHashSet requires time proportional to the size of the set regardless of its capacity

//A linked hash set has two parameters that affect its performance: initial capacity & load factor.
//the penalty for choosing an excessively high value for initial capacity is less severe for this class
//than for HashSet as iteration times for this class are unaffected by capacity.

//This implementation is not synchronized
public class LinkedHashSetImpl<E> extends HashSetImpl<E>
implements Set<E>, Cloneable, java.io.Serializable{
	
	@java.io.Serial
    private static final long serialVersionUID = -2851667679971038690L;
	
	public LinkedHashSetImpl(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
    }
	
	//the default load factor (0.75)
	public LinkedHashSetImpl(int initialCapacity) {
        super(initialCapacity, .75f, true);
    }
	
	//Constructs a new, empty linked hash set with the default initial capacity (16) and load factor (0.75)
	public LinkedHashSetImpl() {
        super(16, .75f, true);
    }
	
	public LinkedHashSetImpl(Collection<? extends E> c) {
        super(Math.max(2*c.size(), 11), .75f, true);
        addAll(c);
    }
}

