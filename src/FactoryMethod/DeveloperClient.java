package FactoryMethod;

public class DeveloperClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee = EmployeeFactory.getEmployee("ANDROID DEVELOPER");
		System.out.println(employee.Salary());
		
		//for Abstract Factory Method
		Employee e1 = EmployeeFactory.getEmployee(new AndroidDevFactory());
	}

}
