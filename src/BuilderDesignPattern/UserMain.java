package BuilderDesignPattern;

public class UserMain {

	public static void main(String[] args) {
		User user = new User.UserBuilder()	//object created
				.setEmailID("Harish@gmail.com").setUserID("Hbk").setUserName("Harish") //properties set
				.build(); //object finally built

	}

}
