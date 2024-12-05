package oops;


class Parent1 { 
    void fun() { System.out.println("Parent1"); } 
} 
  
// Parent Class2 
class Parent2 { 
    void fun() { System.out.println("Parent2"); } 
} 
  
class MultipleInheritance extends Parent1, Parent2 { 
    // main function 
    public static void main(String[] args) 
    { 
    	MultipleInheritance t = new MultipleInheritance(); 
        t.fun(); 
    } 
}