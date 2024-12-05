package collections;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.var;

import jdk.internal.util.ArraysSupport;

/*
*<p><strong>Note that this implementation is not synchronized.</strong>
* If multiple threads access an {@code ArrayList} instance concurrently,
* and at least one of the threads modifies the list structurally, it
* <i>must</i> be synchronized externally.  (A structural modification is
* any operation that adds or deletes one or more elements, or explicitly
* resizes the backing array; merely setting the value of an element is not
* a structural modification.)  This is typically accomplished by
* synchronizing on some object that naturally encapsulates the list.
*/

/*
 * <p id="fail-fast">
 * The iterators returned by this class's {@link #iterator() iterator} and
 * {@link #listIterator(int) listIterator} methods are <em>fail-fast</em>:
 * if the list is structurally modified at any time after the iterator is created
 * in any way except through the iterator's own remove or add methods, the iterator will throw a
 * ConcurrentModificationException.Thus, iterator fails quickly and cleanly rather than risking arbitrary,
 * non-deterministic behavior at an undetermined time in the future.
 * The fail-fast behavior of iterators should be used only to detect bugs
 */

public class ArrayListImplementation<E> extends AbstractList<E> implements List<E>,RandomAccess,Cloneable,
java.io.Serializable  {
	private int size;
	//Internally an ArrayList uses an Object[] Array which is an array of objects
	transient Object[] elementData; // non-private to simplify nested class access
	private static final int DEFAULT_CAPACITY = 10;//Default initial capacity.
	private static final Object[] EMPTY_ELEMENTDATA = {};//Shared empty array instance used for empty instances.
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {}; //when new ArrayList(); - initialised with initial = default capacity =10
	//the List is initialized with a default capacity of 10. Array List with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA 
	//will be expanded to DEFAULT_CAPACITY when the first element is inserted into the Array list
	//constructors
	//1.Constructs an empty Arraylist with an initial capacity of ten.
	public ArrayListImplementation() {
	     this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}
	//2. ArrayList(int capacity) Ex: ArrayList arr = new ArrayList(7);
	public ArrayListImplementation(int initialCapacity) {
	       if (initialCapacity > 0) {
	           this.elementData = new Object[initialCapacity];  
	           
	       } else if (initialCapacity == 0) {
	       
	           this.elementData = EMPTY_ELEMENTDATA;
	       } else {
	       
	           throw new IllegalArgumentException("Illegal Capacity: "+  initialCapacity);
	       }
	}
	//3.ArrayList(Collection<? extends E> c ) Ex: ArrayList<String> arrayList = new ArrayList<String>(new LinkedList());
	//If the size of passed collection is greater than zero then Arrays.copyOf() method is used to copy the collection to the array. 
	//NullPointerException is thrown if the collection that passed into the constructor is null.
	public ArrayListImplementation(Collection<? extends E> c) {
        Object[] a = c.toArray();
        if ((size = a.length) != 0) {
            if (c.getClass() == ArrayList.class) {
                elementData = a;
            } else {
                elementData = Arrays.copyOf(a, size, Object[].class);
            }
        } else {
            // replace with empty array.
            elementData = EMPTY_ELEMENTDATA;
        }
    }
	public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }
	
	//Returns a shallow copy of this ArrayList instance. Elements themselves are not copied.
	public Object clone() {
        try {
            ArrayList<?> v = (ArrayList<?>) super.clone();
            v.elementData = Arrays.copyOf(elementData, size);
            v.modCount = 0;
            return v;
        } catch (CloneNotSupportedException e) {
            //this shouldn't happen, since we are Cloneable.
            throw new InternalError(e);
        }
    }
	//Appends the specified element to the end of this list.
	 public boolean add(E e) {
	        modCount++;
	        add(e, elementData, size);
	        return true;
	 }
	 
	 private void add(E e, Object[] elementData, int s) {
	        if (s == elementData.length)
	            elementData = grow();
	        elementData[s] = e;
	        size = s + 1;
	    }

	
	//How the size of ArrayList grows dynamically?  [add() method]
	//the add(Object ) method object is passed and the size is increased. 
	public boolean add(E e) {
	       ensureCapacityInternal(size + 1);  // Size Increments
	       elementData[size++] = e;
	       return true;
	} 
	
	//Internal capacity of the array is ensured by the ensureCapacityInternal() method
	private void ensureCapacityInternal(int minCapacity) {
		//if array initialized with default capacity - after adding element if size<default, it will be default 
		//else the the size will be incremented.
	       if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) { 
	           minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
	       }
	       //if you are mentioning capacity explicity during initialisation and the adding objects
	       ensureExplicitCapacity(minCapacity);
	}
	//ensureExplicitCapacity method determines what is the current size of elements and what is the maximum size of the array
	private void ensureExplicitCapacity(int minCapacity) {
	       modCount++;
	       
	       // overflow-conscious code
	       if (minCapacity - elementData.length > 0)
	           grow(minCapacity);
	}
	
	//Increases the capacity to ensure that it can hold at least the number of elements specified by the minimum capacity argument
	private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private Object[] grow() {
        return grow(size + 1);
    }
    
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        modCount++;
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                         elementData, index + 1,
                         s - index);
        elementData[index] = element;
        size = s + 1;
    }
	//Appends all of the elements of collection to the end of this list, in the order that they are returned by the collection's Iterator
	public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        modCount++;
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);
        System.arraycopy(a, 0, elementData, s, numNew);
        size = s + numNew;
        return true;
    }
	
	//Inserts all of the elements in the specified collection into this list, starting at the specified position
    //Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices)
	public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);

        Object[] a = c.toArray();
        modCount++;
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);

        int numMoved = s - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index,
                             elementData, index + numNew,
                             numMoved);
        System.arraycopy(a, 0, elementData, index, numNew);
        size = s + numNew;
        return true;
    }
	
	
	//if the (mincapacity – arraylength) is greater than 0(>0) then the Array size will grow by calling the grow()
	//The new capacity is calculated which is 50% more than the old capacity
	//It uses Arrays.copyOf which gives the array increased to the new length.
	// Removes the element at the specified position in this list.
	// Shifts any subsequent elements to the left (subtracts one from their indices)- O(n) operation.
	//System.arrayCopy method is used for this purpose. 
	//Here index+1 is the initial position and index is the final position.
	//Since the element at the position index is removed so elements starting from index+1(initial position) are copied to the destination starting from the index(final position). 
	public E remove(int index) {
		 Objects.checkIndex(index, size);
         final Object[] es = elementData; //referencing the arraylist to object array which is final so that after removing the element reference will not change.
         @SuppressWarnings("unchecked") 
         E oldValue = (E) es[index]; //oldvalue is the the removed element - work as return parameter
         fastRemove(es, index);
         return oldValue;
	}
	
    //Private remove method that skips bounds checking
    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize; //initial value will be 0
      //removing element size will be decreased by 1
        if ((newSize = size - 1) > i) //if removing the elements between the initial and final index of array - need to shift element to left by 1
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null; //dereferencing the element removed
    }
    
    //Removes the first occurrence of the specified element from this list if it is present.
    public boolean remove(Object o) {
        final Object[] es = elementData; //reference the arraylist with final object array.
        final int size = this.size;
        int i = 0;
        found: {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }
    
    //Removes from this list all of its elements that are contained in the collection
    public boolean removeAll(Collection<?> c) {
        return batchRemove(c, false, 0, size);
    }
    
    //removes from this list all of its elements that are not contained in the specified collection.
    public boolean retainAll(Collection<?> c) {
        return batchRemove(c, true, 0, size);
    }

    boolean batchRemove(Collection<?> c, boolean complement,final int from, final int end) {
		Objects.requireNonNull(c);
		final Object[] es = elementData;
		int r;
		// Optimize for initial run of survivors
		for (r = from;; r++) {
		if (r == end) //if collection doesn't contains elements - return false
		    return false;
		if (c.contains(es[r]) != complement) //if collection contains elements then break
		    break;
		}
		int w = r++;
		try {
		for (Object e; r < end; r++)
		    if (c.contains(e = es[r]) == complement)
		        es[w++] = e;
		} catch (Throwable ex) {
		// Preserve behavioral compatibility with AbstractCollection,even if c.contains() throws.
		System.arraycopy(es, r, es, w, end - r);
		w += end - r;
		throw ex;
		} finally {
		modCount += end - w;
		shiftTailOverGap(es, w, end);
		}
		return true;
    }
    
    //Erases the gap from lo to hi, by sliding down following elements. */
    private void shiftTailOverGap(Object[] es, int lo, int hi) {
        System.arraycopy(es, hi, es, lo, size - hi);
        for (int to = size, i = (size -= hi - lo); i < to; i++)
            es[i] = null;
    }
    
    //Removes from this list all of the elements whose index is between. 
    // And Shifts any succeeding elements to the left (reduces their index) which shortens the list by {@code (toIndex - fromIndex)} elements.
    protected void removeRange(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(fromIndex, toIndex));
        }
        modCount++;
        shiftTailOverGap(elementData, fromIndex, toIndex);
    }

    
    
    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }
	//implemented method from AbstractList
	@Override
	public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }
	
	public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof List)) {
            return false;
        }

        final int expectedModCount = modCount;
        // ArrayList can be subclassed and given arbitrary behavior, but we can
        // still deal with the common case where o is ArrayList precisely
        boolean equal = (o.getClass() == ArrayList.class)
            ? equalsArrayList((ArrayList<?>) o)
            : equalsRange((List<?>) o, 0, size);

        checkForComodification(expectedModCount);
        return equal;
    }
	private void checkForComodification(final int expectedModCount) {
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
	
	boolean equalsRange(List<?> other, int from, int to) {
        final Object[] es = elementData;
        if (to > es.length) {
            throw new ConcurrentModificationException();
        }
        var oit = other.iterator();
        for (; from < to; from++) {
            if (!oit.hasNext() || !Objects.equals(es[from], oit.next())) {
                return false;
            }
        }
        return !oit.hasNext();
    }
	
	public int hashCode() {
        int expectedModCount = modCount;
        int hash = hashCodeRange(0, size);
        checkForComodification(expectedModCount);
        return hash;
    }

    int hashCodeRange(int from, int to) {
        final Object[] es = elementData;
        if (to > es.length) {
            throw new ConcurrentModificationException();
        }
        int hashCode = 1;
        for (int i = from; i < to; i++) {
            Object e = es[i];
            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        }
        return hashCode;
    }

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	//Internally an ArrayList uses an Object[] Array which is an array of objects.
	
}
