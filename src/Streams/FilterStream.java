package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
		
		//employee with 2nd highest salary
		//SQL 1: select * dense_rank over (order by salary desc) as rnk where rnk=2
		//SQL 2: select * from employee where salary=(select distinct(salary) from employee order by salary desc limit 1,1);
		List<Employee> second_highest_salary_emp = maleEmp.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed())
												   .skip(1).collect(Collectors.toList());
		System.out.println("second highest salary : "+second_highest_salary_emp.get(1).getSalary());	
		
		//Write a method that takes a list of Person objects and groups them by their age
		Map<Integer, List<Integer>> empSalaryAndAgeTrend = filteredEmp.stream().filter(e->e.getAge()>25).collect(Collectors.groupingBy(Employee::getSalary,Collectors.mapping(Employee::getEmpId, Collectors.toList())));
		for(Map.Entry me: empSalaryAndAgeTrend.entrySet()) {
			System.out.println(me.getKey() + ":" + me.getValue());
		}
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
