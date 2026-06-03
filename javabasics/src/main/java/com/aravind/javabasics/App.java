package com.aravind.javabasics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.aravind.javabasics.day01_oops.Department;
import com.aravind.javabasics.day01_oops.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Date start = new Date();
		System.out.println("Start ! " + start);
		sessionprinter(1);
		Session1();
		sessionprinter(2);
		session2();
		Date end = new Date();
		Long totalTime = end.getTime() - start.getTime();
		System.out.println("Total time :" + totalTime);
		System.out.println("End ! " + end);

	}

	public static void sessionprinter(int Session) {

		if (Session > 1) {
			System.out.println("Session" + (Session - 1) + " Ends");
			System.out.println();
		}

		System.out.println("Session " + Session + " Starts ");

	}

	public static void Session1() {
		List<Employee> emps = new ArrayList<>();

		Employee e1 = new Employee((long) 1, "Aravind", 0);
		emps.add(e1);
		Employee e2 = new Employee((long) 2, "Meena", 100);
		emps.add(e2);
		Employee e3 = new Employee((long) 3, "Jothi", 90);
		emps.add(e3);
		Employee e4 = new Employee((long) 4, "Amuthan", 81);
		emps.add(e4);
		Employee e5 = new Employee((long) 5, "Manisha", 81);
		emps.add(e5);

		double totalSalary = emps.stream().mapToDouble(Employee::getSalary).sum();

		List<Employee> sortedEmployees = emps.stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
				.toList();

		Employee highestSalaryEmployee = emps.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);

		sortedEmployees.forEach(em -> {
			System.out.println(em);
		});

		System.out.println("Highest Salary :" + sortedEmployees.get(0));
		System.out.println("Highest Salary using comparator : " + highestSalaryEmployee);
		System.out.println("Total Sum of the Salary: " + totalSalary);

		List<Employee> greaterthan80 = sortedEmployees.stream().filter(n -> n.getSalary() >= 80).toList();

		greaterthan80.forEach(n -> {
			System.out.println(n);
		});

		System.out.println("Count of EMployees : " + emps.size());

	}

	public static void session2() {
		Department it = new Department(1L, "IT");
		Department hr = new Department(2L, "HR");
		Department finance = new Department(3L, "Finance");

		Employee e1 = new Employee(1L, "Aravind", 0, it);
		Employee e2 = new Employee(2L, "Meena", 100, it);
		Employee e3 = new Employee(3L, "Jothi", 90, hr);
		Employee e4 = new Employee(4L, "Amuthan", 81, finance);
		Employee e5 = new Employee(5L, "Manisha", 81, it);

		List<Employee> emps = new ArrayList<>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		emps.add(e4);
		emps.add(e5);

		Map<Department, List<Employee>> finmap = emps.stream().collect(Collectors.groupingBy(Employee::getDept));

		finmap.forEach((dept, employees) -> {

			System.out.println("Department : " + dept.getName());

			employees.forEach(emp -> System.out.println("   " + emp.getName()));

		});
		Map<Department, Long> finmap2 = emps.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));

		finmap2.forEach((dept, cnt) -> {

			System.out.println("Department : " + dept.getName() + " Count :" + cnt);

		});
		Map<Department, Double> avgSalary = emps.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
		
		avgSalary.forEach((dept, cnt) -> {

			System.out.println("Department : " + dept.getName() + " Average Salary :" + cnt);

		});
		
		
		
	}
}
