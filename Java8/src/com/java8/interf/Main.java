package com.java8.interf;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interface1 addition = ( a,  b) -> a + b;
		Interface1 soustraction = (int a, int b) -> a - b;

		Main main = new Main();
		System.out.println(main.calculate(addition, 5, 4));
		System.out.println(main.calculate(soustraction, 5, 4));
		
		Random random = new Random();
		//random.doubles().limit(10).forEach(System.out::println);
		
		//MAP
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		System.out.println(squaresList);
		
		
		//filter
		List<String>strings = Arrays.asList("abc", "", "", "efg", "abcd","", "jkl");
		//get count of empty string
		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println(count);
		
		List<String>strings2 = Arrays.asList("one",  "two");
		
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = strings2::add;
		
		
		strings2.forEach(c1.andThen(c2));
		
		
//		List numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//		IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
//		System.out.println("Highest number in List : " + stats.getMax());
//		System.out.println("Lowest number in List : " + stats.getMin());
//		System.out.println("Sum of all numbers : " + stats.getSum());
//		System.out.println("Average of all numbers : " + stats.getAverage());
	}

	public int calculate(Interface1 interface1, int a, int b) {
		System.out.println("test_branchyounes");
		System.out.println("branch");
		return interface1.function1(a, b);
	}

}
