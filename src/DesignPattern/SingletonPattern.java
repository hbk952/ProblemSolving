package DesignPattern;



public class SingletonPattern {

	public static void main(String[] args) {
		Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        Singleton z = Singleton.getInstance();
        
        System.out.println("Hashcode of x is "+ x.hashCode());
        System.out.println("Hashcode of y is "+ y.hashCode());
        System.out.println("Hashcode of z is "+ z.hashCode());
        if (x == y && y == z) {
        	System.out.println("Three objects point to the same memory location on the heap i.e, to the same object");
        }
        else {
            System.out.println("Three objects DO NOT point to the same memory location on the heap");
        }   
	}

}

class Singleton{
	
//for early initialisation - created object when class loaded.
//    private static Singleton single_instance = new Singleton();
//    public static Singleton getInstance()
//    {
//        return single_instance;
//    }
	
//Lazy initialisation - object created when needed i.e when getInstance method called.
	
	private static Singleton single_instance = null;//Static variable reference of single_instance of type Singleton
	private Singleton() //private constructor
    {
    	
    }
	
    public static Singleton getInstance()// Static method to create instance of Singleton class
    {
        if (single_instance == null)//if the instance is already initialised, will not be initialised again.
            single_instance = new Singleton();
 
        return single_instance;
    }
    
    /*This lazy initialization will create issue in case of multiple threads.
      multiple threads will access the getInstance() at the same time , creating multiple objects of singleton class.
      introducing thread safety: make getInstance method synchronised - one thread can access at a time
      e.g public synchrosnized static Singleton getInstance()
      more optimised solution - use synchronised block to synchronised the lines of object creation only.
    e.g
    public static Singleton getInstance()
    {
        if (single_instance == null)
        {
        	synchronized (Singleton.class) { //synchronised block
        		 if (single_instance == null) {
        			 single_instance = new Singleton();
        		 }
			}
        }
 
        return single_instance;
    }
    */

}
