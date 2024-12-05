package oops;

public class ChildInheritance extends ParentInheritance {
	int parentNumber=20;
	//implicit define the constructor becuase the parent method has the constructor.
	ChildInheritance(int p, String n, String a,String name) {
		super(p, n, a,name);
	}
	@Override
	void parentInheritanceClassVariable() { //use @Override or not, will call this overrided method in child
		super.parentInheritanceClassVariable();
		System.out.println("in child method");
	}
	
	public static void main(String[] args) {
		ParentInheritance pc = new ChildInheritance(1,"x","y","Harish");
		pc.onlyParent();
//		ChildInheritance cp = new ParentInheritance(1,"x","y","Harish"); //compile error - cannot convert from parent to child
//		cp.onlyChild();
//		c.parentInheritanceClassVariable("x");
//		ParentInheritance.initializeClassName("parent static");
//		ChildInheritance.initializeClassName("child static");
	}
	
	static void initializeClassName(String s) {
		System.out.println("className inside child: "+s);
	}
	void display() {
		System.out.println("Parent accessing child method");
	}
	void onlyChild() {
		System.out.println("This is present only in parent");
	}

}
