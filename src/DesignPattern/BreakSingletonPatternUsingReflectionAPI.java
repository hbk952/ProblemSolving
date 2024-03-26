package DesignPattern;

import java.lang.reflect.Constructor;



public class BreakSingletonPatternUsingReflectionAPI {

	public static void main(String[] args) throws Exception{
		SingletonBreak x = SingletonBreak.getInstance();
		SingletonBreak y = SingletonBreak.getInstance();
		//break singleton pattern using reflection API - dynamically access and modify class & interface 
        //Constructor class variable for reflection API - breaking singleton pattern
        Constructor<SingletonBreak> constructor = SingletonBreak.class.getDeclaredConstructor();
        constructor.setAccessible(true);//making the constructor of singleton class public.
        SingletonBreak z = constructor.newInstance();//creating object. Declare exception also
        
        System.out.println("Hashcode of x is "+ x.hashCode());
        System.out.println("Hashcode of y is "+ y.hashCode());
        System.out.println("Hashcode of z is "+ z.hashCode());
        
        //for solution 2 - creating ENUM object - no constructor in ENUM - no constructor modified to public.
        SingletonInstance a = SingletonInstance.INSTANCE;
        SingletonInstance b = SingletonInstance.INSTANCE;
        System.out.println("Hashcode of a is "+ a.hashCode());
        System.out.println("Hashcode of b is "+ b.hashCode());
        
        Constructor<SingletonInstance> constructorEnum = SingletonInstance.class.getDeclaredConstructor();
        constructorEnum.setAccessible(true);//making the constructor of singleton class public.
        SingletonInstance c = constructorEnum.newInstance();//creating object. Declare exception also
        System.out.println("Hashcode of c is "+ c.hashCode());
        //in the output, object for a and b (same created but not for c because ENUM not have costructor
	}

}

class SingletonBreak{
	
	private static SingletonBreak single_instance = null;//Static variable reference of single_instance of type Singleton
	private SingletonBreak() //private constructor
	{
		//Solution 1: to protect from reflection API - If object is present already, throw exception from inside constructor
        /*
        if(single_instance != null) {
        	throw new RuntimeException("you are trying to break singleton pattern");
        }
        */
	    	
	}
		
	    
	public static SingletonBreak getInstance()
	{
	    if (single_instance == null)
	    {
	        synchronized (SingletonBreak.class) { //synchronised block
	        		 if (single_instance == null) {
	        			 single_instance = new SingletonBreak();
	        		 }
			}
	    }
	 
	    return single_instance;
	}
	
	//Solution to protect singleton break from reflection API - Either Object not created or return same object.
    // sol 1: If object is present already, throw exception from inside constructor.
    //sol 2: use enum - make Singleton enum instead of class as shown below.
	    
}
//Solution 2
enum SingletonInstance{
	INSTANCE
}

