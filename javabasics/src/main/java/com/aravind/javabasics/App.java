package com.aravind.javabasics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.aravind.javabasics.day01_oops.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Date start = new Date();
		System.out.println("Start ! " + start);

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

		Date end = new Date();
		Long totalTime = end.getTime() - start.getTime();
		System.out.println("Total time :" + totalTime);
		System.out.println("End ! " + end);
	}
}
