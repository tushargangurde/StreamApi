import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<>();
		Optional<Employee> emp;

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));

		emp = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1)
				.findFirst();
		System.out.println("Second highest salary:" + emp.get());

		emp = employeeList.stream().min(Comparator.comparingDouble(Employee::getSalary));
		System.out.println("Min salary:" + emp.get());
		System.out.println("-------------------------------------------------------------");

		emp = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
		System.out.println("Max salary:" + emp.get());
		System.out.println("-------------------------------------------------------------");

		Map<String, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("Group By Department:" + map);
		System.out.println("-------------------------------------------------------------");

		Map<String, Long> output = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		System.out.println("Department counting");
		output.forEach((k, v) -> {
			System.out.println(k + "-" + v);
		});
		System.out.println("-------------------------------------------------------------");

		double average = employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
		System.out.println("Average salary:" + average);
		System.out.println("-------------------------------------------------------------");

		Map<String, Double> outputList = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println("Average age by Gender:" + outputList);
		System.out.println("-------------------------------------------------------------");

		employeeList.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
		System.out.println("Sorted based on Name & Salary");
		employeeList.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------");

		System.out.println("Find dulicate numbers from list");
		List<Integer> numbers = Arrays.asList(new Integer[] { 1, 2, 1, 3, 4, 4, 3 });
		numbers.stream().filter(e -> Collections.frequency(numbers, e) > 1).collect(Collectors.toSet())
				.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------");

		outputList = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
		System.out.println("Sum of salary of all departments");
		outputList.forEach((k, v) -> {
			System.out.println(k + "-" + v);
		});
		System.out.println("-------------------------------------------------------------");
	}

}
