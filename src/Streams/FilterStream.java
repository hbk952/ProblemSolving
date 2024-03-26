package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterStream {

	public static void main(String[] args) {
		List<Employee> maleEmp = new ArrayList();
		maleEmp.add(new Employee(1,"Harish",27,50000));
		maleEmp.add(new Employee(2,"Abhi",26,10000));
		maleEmp.add(new Employee(3,"Amit",22,10000));
		maleEmp.add(new Employee(4,"Sanchit",24,40000));
		
		List<Employee> FemaleEmp = new ArrayList();
		FemaleEmp.add(new Employee(5,"Harshita",26,50000));
		FemaleEmp.add(new Employee(6,"Abhilasha",25,10000));
		FemaleEmp.add(new Employee(7,"Amita",21,10000));
		FemaleEmp.add(new Employee(8,"Sanchita",23,40000));
		
		//Filtering the employee whose name starts with A
		List<Employee> Maleresult = maleEmp.stream().filter(e->e.getName().startsWith("A")).collect(Collectors.toList());
		
		List<Employee> Femaleresult = FemaleEmp.stream().filter(e->e.getName().startsWith("A")).collect(Collectors.toList());
		
		//merging both list sorted by age
		List<Employee> filteredEmp = Stream.concat(Maleresult.stream(), Femaleresult.stream())
									.sorted(Comparator.comparingInt(Employee::getAge))
									.collect(Collectors.toList());
		
		
		List<String> empName = filteredEmp.stream().map(e->e.getName().toUpperCase()).collect(Collectors.toList());
		Iterator<String> itr = empName.listIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		filteredEmp.forEach(e->System.out.println(e.getName()));
		empName.forEach(System.out::println);
		
	}

}

class Employee{
	int empId;
	String name;
	int age;
	int salary;
	public Employee(int empId, String name, int age, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
