package SOLIDPrinciples;
//Interface should be such, that client should not implement unnecessary functions they do not need.
interface ResturantEmployee{
	void washDishes();
	void serveCustomers();
	void cookFood();
}

class Waiter implements ResturantEmployee{
	@Override
	public void washDishes() {
		// not the job of waiter
	}
	@Override
	public void serveCustomers() {
		
	}
	@Override
	public void cookFood() {
		//not the job of waiter	
	}
}

//So in the above examples , we have to define the work for waiter who is not liable to do those in reality.
//Solution: Segment the interface accoridng to the requirement e.g:
interface WaiterInterface{
	void serveCustomers();
	void takeOrder();
}

interface chef{
	void cookFood();
	void decideMenu();
}

public class InterfaceSegmentedClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
