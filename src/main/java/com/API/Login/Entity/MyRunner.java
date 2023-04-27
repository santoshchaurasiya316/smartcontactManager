package com.API.Login.Entity;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class MyRunner implements CommandLineRunner{
	
	private Employee employee;
	
	ArrayList<Employee> empDetail=new ArrayList<>();
	
	@Override
	public void run(String... args) throws Exception {
		
		empDetail.add(new Employee(101, "santosh", "Active", 5000));
		empDetail.add(new Employee(102, "Raghib", "Inactive", 15000));
		empDetail.add(new Employee(103, "Salman", "Active", 12000));
		empDetail.add(new Employee(101, "Abhishek", "Active", 51000));
		
//		Set<Employee> hashSet=new HashSet<>();
//		empDetail.stream().forEach(System.out::println);
		
		//GroupBy same Id
//		Map<Integer, List<Employee>> groupOfEmp = empDetail.stream().collect(Collectors.groupingBy(e->e.getEmpId()));
		
		//Max salary based on Id
//		Map<Object, Object> collect = empDetail.stream().collect(Collectors.groupingBy(e->e.getEmpId(),Collectors.collectingAndThen(
//				Collectors.maxBy(Comparator.comparing(e->e.getEmpSalary())) , Optional::get)));
//				System.out.println(collect);
		
		//Max salary
//		Optional<Employee> max = empDetail.stream().max(Comparator.comparing(Employee :: getEmpSalary));
//		System.out.println(max);
		
//		empDetail.stream().sorted(Comparator.comparing(Employee::getEmpSalary)).forEach(e->{
//			System.out.println(e);
//		});
	
//		Stream<Employee> val = empDetail.stream().filter(t -> t.getEmpStatus().equals("Active"));
//		val.sequential().forEach(e->{
//			System.out.println(e);
//		});
		
//    ArrayList<Employee> collect = empDetail.stream()
//        .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingInt(Employee::getEmpId))),ArrayList::new));
		
		//removing duplicates from the empDetail list using removeIf()
//		HashSet seen = new HashSet<>();
//		empDetail.removeIf(e -> !seen.add(e.getEmpId()));
//	    empDetail.forEach(p-> System.out.println(p));
	    
//	 TreeSet<Employee> collect = empDetail.stream()
//	                   .collect(Collectors.toCollection(()-> new TreeSet<>(Comparator.comparingInt(Employee::getEmpId))));
    
//		System.out.println(collect);
		
//	List<Employee> secondHighest = empDetail.stream().sorted(Comparator.comparing(Employee::getEmpSalary).reversed()).collect(Collectors.toList());
//	System.out.println(secondHighest.get(1));
		             //OR
//	Optional<Employee> secondHighest = empDetail.stream().sorted(Comparator.comparing(Employee::getEmpSalary).reversed()).skip(1).findFirst();
//      System.out.println(secondHighest);
		
//-----------------------------------------------------------------------------------------------------------------------
		

        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);
          
        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
          
        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);
  
        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
     
        //-----------get even numbers----------------------
       listOfListofInts.stream().flatMap(e-> e.stream()).filter(e->e%2==0).forEach(p->{
    	   System.out.println(p);
        });
	}
	
}
