package FactoryMethod;

public class EmployeeFactory {
	//for Factory method only
	public static Employee getEmployee(String empType) {
		if(empType.trim().equalsIgnoreCase("ANDROID DEVELOPER")) {
			return new AndroidDeveloper();
		}
		else if(empType.trim().equalsIgnoreCase("WEB DEVELOPER")) {
			return new WebDeveloper();
		}
		else {
			return null;
		}
	}
	
	//for Abstract factory method design pattern.
	//Here factory layer don't know whose class object it is going to create
	public static Employee getEmployee(EmployeeAbstractFactory factory) {
		return factory.createEmployee();
	}

}
