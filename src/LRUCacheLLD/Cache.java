package LRUCacheLLD;

public class Cache<Key, Value> {
	private final EvictionPolicy<Key> evictionPolicy;
	private final Storage<Key, Value> storage;
	public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
		super();
		this.evictionPolicy = evictionPolicy;
		this.storage = storage;
	}
	
	public void put(Key key, Value value) {
		try {
			this.storage.add(key,value);
			this.evictionPolicy.keyAccessed(key);
		}catch(StorageFullException exception) {
			System.out.println("Storage got full, will try to evict: ");
			Key keyToRemove = evictionPolicy.evictKey();
			if(keyToRemove == null) {
				throw new RuntimeException("Unexpected state. Storage is full and no key to evict");
			}
			this.storage.remove(keyToRemove); //now storage has 1 space vacant
			put(key, value); //storing the key
		}
	}
	
	public Value get(Key key) {
		try {
			Value value = this.storage.get(key);
			this.evictionPolicy.keyAccessed(key);
		}catch(NotFoundException notfoundexception) {
			System.out.println("Tried to access non-existing key");
			return null;
		}
	}

}
