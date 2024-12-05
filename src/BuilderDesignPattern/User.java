package BuilderDesignPattern;

public class User {
	private final String userID;
	private final String userName;
	private final String emailID;
	
	
	private User(UserBuilder builder) {
		this.userID = builder.userID;
		this.userName = builder.userName;
		this.emailID = builder.emailID;
	}


	public String getUserID() {
		return userID;
	}
	public String getUserName() {
		return userName;
	}
	public String getEmailID() {
		return emailID;
	}
	
	static class UserBuilder{
		private String userID;
		private String userName;
		private String emailID;
		
		public UserBuilder() {
			
		}
		
		//method chaining - return this reference so that we can call again method of the same class
		public UserBuilder setUserID(String userID) {
			this.userID = userID;
			return this;
		}
		public UserBuilder setUserName(String userName) {
			this.userName = userName;
			return this;
		}
		public UserBuilder setEmailID(String emailID) {
			this.emailID = emailID;
			return this;
		}
		public User build() {
			User user = new User(this);
			return user;
		}
		
	}

}
