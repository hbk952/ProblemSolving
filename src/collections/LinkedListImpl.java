package collections;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.LinkedList.ListItr;
import java.util.LinkedList.Node;
import java.util.function.Consumer;

//Doubly-linked list implementation of the List and Deque interfaces.
//This implementation is not synchronized (same as in arrayList) 
//If multiple threads access a linked list concurrently and at least one of the threads modifies the list structurally, 
//it must be synchronized externally by synchronizing on some object that naturally encapsulates the list.
//If no such object exists, the list should be "wrapped" using a method at creation time to prevent accidental 
//unsynchronized access to the list e.g List list = Collections.synchronizedList(new LinkedList(...));
//The iterators returned by this class's iterator and listIterator methods are fail-fast. i.e
//if the list is structurally modified at any time after the iterator is created, in any way except through
//the Iterator's own {@code remove} or {@code add} methods, the iterator will throw a ConcurrentModificationException.
//Fail-fast iterators throw {@code ConcurrentModificationException} on a best-effort basis. Therefore, 
//it would be wrong to write a program that depended on this exception for its correctness:
//the fail-fast behavior of iterators should be used only to detect bugs.
public class LinkedListImpl <E>
extends AbstractSequentialList<E>
implements List<E>, Deque<E>, Cloneable, java.io.Serializable{
	
	transient int size = 0;
    transient Node<E> first; //Pointer to first node.
    transient Node<E> last; //Pointer to last node.
    
    public LinkedListImpl() { //No arg constructor
    	
    }
    
    public LinkedListImpl(Collection<? extends E> c) {
        this();
        addAll(c);
    }
    
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
	
    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f); //constructor : (Node<E> prev, E element, Node<E> next)
        first = newNode; //now pointer "first" pointing newNode - newNode become first node
        if (f == null) //if the earlier first node was null then newNode is only node we have thus "last" pointer will also reference same making it doubly linked list.
            last = newNode;
        else
            f.prev = newNode; //else previous of f will point the node - doubly linked list
        size++;
        modCount++;
    }
    
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode; //pointer "last" will reference the last node making the newNode as last
        if (l == null)
            first = newNode;
        else
            l.next = newNode; //forming doubly linked list
        size++;
        modCount++;
    }
    
   private E unlinkFirst(Node<E> f) { //Unlinks non-null first node f
       final E element = f.item;
       final Node<E> next = f.next;
       f.item = null;
       f.next = null; // help GC by referencing the pointer and element to NULL
       first = next; //pointing the second node as first
       if (next == null)
           last = null;
       else
           next.prev = null;
       size--;
       modCount++;
       return element;
   }

   private E unlinkLast(Node<E> l) { //Unlinks non-null last node l.
       // assert l == last && l != null;
       final E element = l.item;
       final Node<E> prev = l.prev;
       l.item = null;
       l.prev = null; // help GC
       last = prev;
       if (prev == null)
           first = null;
       else
           prev.next = null;
       size--;
       modCount++;
       return element;
   }
	
   E unlink(Node<E> x) { //Unlinks non-null node x.
       // assert x != null;
       final E element = x.item;
       final Node<E> next = x.next;
       final Node<E> prev = x.prev;

       if (prev == null) {
           first = next;
       } else {
           prev.next = next;
           x.prev = null;
       }

       if (next == null) {
           last = prev;
       } else {
           next.prev = prev;
           x.next = null;
       }

       x.item = null;
       size--;
       modCount++;
       return element;
   }
   	
   public boolean add(E e) { //Appends the specified element to the end of this list
       linkLast(e);
       return true;
   }
   
	@Override
	public void addFirst(E e) {
		linkFirst(e);
	}

	@Override
	public void addLast(E e) {
		linkLast(e);	
	}
	
	public boolean addAll(Collection<? extends E> c) { //Appends all of the elements in the specified collection to the end of list.
        return addAll(size, c);
    } 
	//Inserts all of the elements in the specified collection into this list, starting at the specified position.
	//Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices).
	public boolean addAll(int index, Collection<? extends E> c) {
        checkPositionIndex(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        Node<E> pred, succ;
        if (index == size) { //if appending the collection in last
            succ = null;
            pred = last;
        } else { //if appending the collection at specific designation.
            succ = node(index);
            pred = succ.prev;
        }

        for (Object o : a) {
            @SuppressWarnings("unchecked") E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }

        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }

        size += numNew;
        modCount++;
        return true;
    }
	public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

	@Override
	public E removeFirst() {
		final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
	}

	@Override
	public E removeLast() {
		final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
	}
	
	public E get(int index) { //Returns the element at the specified position in this list.
        checkElementIndex(index);
        return node(index).item;
    }
	
	@Override
	public E getFirst() {
		final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
	}

	@Override
	public E getLast() {
		final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
	}

	//Removes the first occurrence of the specified element from this list.Removes the element with the lowest index.
	public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
	
	//Returns the (non-null) Node at the specified element index.
	Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
	//Search operations
	
	public int indexOf(Object o) { //returns the lowest index - Objects.equals(o, get(i))
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }
	
	public int lastIndexOf(Object o) { //returns the highest index or last index
        int index = size;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (o.equals(x.item))
                    return index;
            }
        }
        return -1;
    }

	//Queue operations
	
	@Override
	public E peek() { //Retrieves, but does not remove, the head (first element) of this list
		final Node<E> f = first;
        return (f == null) ? null : f.item;
	}
	
	@Override
	public E element() { //Retrieves, but does not remove, the head (first element) of this list
		return getFirst();
	}
	
	@Override
	public E poll() { //Retrieves and removes the head (first element) of this list
		 final Node<E> f = first;
	     return (f == null) ? null : unlinkFirst(f);
	}
	
	@Override
	public E remove() { //Retrieves and removes the head (first element) of this list
        return removeFirst();
    }
	
	@Override
	public boolean offer(E e) { //Adds the specified element as the tail (last element) of this list
        return add(e);
    }
	
	// Deque operations
	
	@Override
	public boolean offerFirst(E e) { //Inserts the specified element at the front of this list
        addFirst(e);
        return true;
    }
	@Override
	public boolean offerLast(E e) {
        addLast(e);
        return true;
    }
	
	@Override
	public E peekFirst() { //Retrieves, but does not remove, the first element of this list
        final Node<E> f = first;
        return (f == null) ? null : f.item;
     }
	
	@Override
	public E peekLast() { //Retrieves, but does not remove, the last element of this list
        final Node<E> l = last;
        return (l == null) ? null : l.item;
    }
	@Override
	public E pollFirst() { //Retrieves and removes the first element of this list or NULL if empty list
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }
	@Override
	public E pollLast() { //Retrieves and removes the last element of this list or NULL if empty list
        final Node<E> l = last;
        return (l == null) ? null : unlinkLast(l);
    }
	@Override
	public void push(E e) { //Pushes an element onto the stack represented by this list inserts the element at the front of this list
        addFirst(e);
    }
	@Override
	public E pop() {
        return removeFirst();
    }
	@Override
	public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }
	@Override
	public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
	
	@Override
	public ListIterator<E> listIterator(int index) { //@throws IndexOutOfBoundsException
        checkPositionIndex(index);
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListItr(int index) {
            // assert isPositionIndex(index);
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            checkForComodification();
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public E previous() {
            checkForComodification();
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.item;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
            checkForComodification();
            if (lastReturned == null)
                throw new IllegalStateException();

            Node<E> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
            expectedModCount++;
        }

        public void set(E e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            checkForComodification();
            lastReturned.item = e;
        }

        public void add(E e) {
            checkForComodification();
            lastReturned = null;
            if (next == null)
                linkLast(e);
            else
                linkBefore(e, next);
            nextIndex++;
            expectedModCount++;
        }

        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            while (modCount == expectedModCount && nextIndex < size) {
                action.accept(next.item);
                lastReturned = next;
                next = next.next;
                nextIndex++;
            }
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
    
    @SuppressWarnings("unchecked")
    private LinkedList<E> superClone() {
        try {
            return (LinkedList<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    public Object clone() { //Returns a shallow copy of LinkedList.
        LinkedList<E> clone = superClone();

        // Put clone into "virgin" state
        clone.first = clone.last = null;
        clone.size = 0;
        clone.modCount = 0;

        // Initialize clone with our elements
        for (Node<E> x = first; x != null; x = x.next)
            clone.add(x.item);

        return clone;
    }


}
