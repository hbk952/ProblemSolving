package oops;

import java.util.HashMap;
import java.util.Map;

public class ImmutableClass {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1", "first");
		map.put("2", "second");
		Student s = new Student("ABC", 101, map);
		System.out.println("Hashcode of s is "+ s.hashCode());
		System.out.println(s.getName()+" "+s.getRegNo()+" "+s.getMetadata());
		
		map.put("3", "third");// Remains unchanged due to deep copy in constructor
		System.out.println(s.getMetadata());
		Student s1 = new Student("ABC", 101, map);
		System.out.println("Hashcode of s1 is "+ s1.hashCode());
		System.out.println(s1.getName()+" "+s1.getRegNo()+" "+s1.getMetadata());
	}
}

final class Student {
    // private final data members
    private final String name;
    private final int regNo;
    private final Map<String, String> metadata;
    //Parameterized Constructor of immutable class
    public Student(String name, int regNo,Map<String, String> metadata)
    {
        this.name = name;
        this.regNo = regNo;
        // Creating Map object with reference to HashMap
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry :
             metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.metadata = tempMap;
    }
    public String getName() { return name; }
    public int getRegNo() { return regNo; }
    
    public Map<String, String> getMetadata() // User defined type to get meta data.Creating Map with HashMap reference
    {
        Map<String, String> tempMap = new HashMap<>();
 
        for (Map.Entry<String, String> entry :
             this.metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}