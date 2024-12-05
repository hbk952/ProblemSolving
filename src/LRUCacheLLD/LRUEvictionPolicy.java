package LRUCacheLLD;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{
	private DoublyLinkedList<Key> dll; //key in the last node will the most frequent accessed.
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

	@Override
	public void keyAccessed(Key key) {
		if (mapper.containsKey(key)) { //if map has key, detach the node and append it to last
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        } else { //append the new key to last
            DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key, newNode);
        }
		
	}

	@Override
	public Key evictKey() {
		DoublyLinkedListNode<Key> first = dll.getFirstNode();
        if(first == null) {
            return null;
        }
        dll.detachNode(first);
        return first.getElement();
	}

}
