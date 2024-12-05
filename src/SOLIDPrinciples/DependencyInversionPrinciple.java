package SOLIDPrinciples;
//Class should depend on interfaces rather than concrete classes.
//create Interface object references and then constructor injection.
interface Keyboard{
	
}
interface Mouse{
	
}

class MacBook{
	private final Keyboard keyboard; //Interface object references
	private final Mouse mouse;
    public MacBook(Keyboard keyboard,Mouse mouse) { //constructor injection
    	this.keyboard=keyboard;
    	this.mouse=mouse;
    }
}

public class DependencyInversionPrinciple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
