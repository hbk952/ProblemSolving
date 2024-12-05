package oops;

public class ParentInheritance {
	int parentNumber=10;
	protected String parentName;
	private String parentAddress;
	static String className;
	final String name;//using constructor- initialize nit required. Else need to initialize.
	protected ParentInheritance(int p,String n, String a,String name){
		this.parentNumber =p;
		this.parentName=n;
		this.parentAddress=a;
		this.name=name;
	}
	void parentInheritanceClassVariable() {
		System.out.println("parentNumber: "+parentNumber+" ,parentName: "+parentName+" ,parentAddress: "+parentAddress);
	}
	final void parentInheritanceClassVariable(String x) {
		System.out.println("parentNumber: "+parentNumber+" ,parentName: "+parentName+" ,parentAddress: "+parentAddress);
	}
	static void initializeClassName(String s) {
		className="ParentInheritance";
		System.out.println("className: "+className);
	}
	private void privateMethod() {
		System.out.println("This is privateMethod");
	}
	
	void onlyParent() {
		System.out.println("This is present only in parent");
	}
}
