package collections;

//great care must be exercised if mutable objects are used as map keys.
//The behavior of a map is not specified if the value of an object(key) is changed in a manner that affects
//equals comparisons.
//Equals and hashCode methods are no longer well defined on such a map. Thus it is not permissible
//for a map to contain itself as a key.  While it is permissible for a map to contain itself as a value.
//Some implementations prohibit null keys and values, and some have restrictions on the types of their keys.
//Attempting an operation on an ineligible key or value whose completion would not result in the insertion 
//of an ineligible element into the map may throw an exception or it may succeed, at the option of the implementation
//Such exceptions are marked as "optional" in the specification for this interface.

//Hashmap is Hash table based implementation of the Map interface provides all of the optional map operations
//and permits null values and the null key.
//The HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls.

//This implementation provides constant-time performance for the basic operations get and put assuming the hash
//function disperses the elements properly among the buckets.

//Iteration over collection views requires time proportional to the "capacity" of the HashMap (the number of buckets)
//plus size the number of key-value mappings.

//HashMap has two parameters that affect its performance initial capacity and load factor.
//Load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased.
//When the number of entries in the hash table exceeds the product of the load factor and the current capacity,
//the hash table is rehashed so that the hash table has approximately twice the number of buckets.
public class HashMapImpl {

}
