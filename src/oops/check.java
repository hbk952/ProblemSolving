package oops;
import oops_parent.*;

public class check{ //for outer class- only public,default(no keyword required),abstract and final are permitted
	
	public static void main(String[] args) {
		ChildInheritProtectedMethodFromParent c = new ChildInheritProtectedMethodFromParent();
		c.inheriting();

	}

}

class ChildInheritProtectedMethodFromParent extends ParentWithProtectedMethod {//here we cannot use public modifier because file name is not checkchild.
	//implementing example of protected - check1 calss is in different package and has method with protected access modifier.
	//check inherits check1(class check become subclass of check1) and thus can access method with protected modifier.
	protected void inheriting() {//thus protected has scope of subclass outside package
		ChildInheritProtectedMethodFromParent c = new ChildInheritProtectedMethodFromParent();
		c.display();
	}
}




//Access modifier		Scope
//Public				world
//Protected				inherited subclasses of different package
//default				package
//private				class