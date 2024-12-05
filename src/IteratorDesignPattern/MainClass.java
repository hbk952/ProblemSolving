package IteratorDesignPattern;

public class MainClass {

	public static void main(String[] args) {
		UserManagement userMgmt = new UserManagement();
		userMgmt.addUser(new User("Harish","Hbk"));
		userMgmt.addUser(new User("Ravi","Rb"));
		userMgmt.addUser(new User("Rahul","Rh"));
		
		MyIterator itr = userMgmt.getIterator();
		while(itr.hasNext()){
			User user = (User) itr.next();
			System.out.println(user.getName());
		}

	}

}
