package oops;

public class UpcastingDowncasting {

	public static void main(String[] args) {
		Parent p = new child();
		p.name = "harish";
		//p.color = "black"; -complile time error-color field not in parent
		p.m1();
		p.nature();
		System.out.println(p.x);
		
		child c = (child)p;
		c.m1();
		c.nature();
		System.out.println(c.x);//x from child class
		System.out.println(c.name);//name field present in parent only
	}

}

class Parent{
	int x=10;
	String name;
	void nature() {
		System.out.println("parent");
	}
	static void m1() {
		System.out.println("parent m1");
	}
}

class child extends Parent{
	int x=20;
	String color;
	void nature() {
		System.out.println("child");
	}
	static void m1() {
		System.out.println("child m1");
	}
}
