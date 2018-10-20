package com.labs.collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.labs.model.Person;

public class Main {

	public static void main(String[] args) {

		// Predicate
		List<String> list = Arrays.asList("one", "two", "three", "four", "twoff", "twop", "yesop");

		Predicate<String> p = (s) -> s.startsWith("two");
		Predicate<String> p2 = (s) -> s.endsWith("op");
		// list.forEach(System.out::println);
		// list.stream().filter(p.or(p2)).forEach(System.out::println);

		// Comparator
		List<Integer> list2 = Arrays.asList(33, 55, 11, 9, 124, 4322);
		Comparator<Integer> comp = (c1, c2) -> Integer.compare(c1, c2);
		System.out.println(list2.stream().max(comp).get());
		
		

		Stream<String> lines = readFile("D:\\WORKSPACES\\LABS\\Java8\\src\\person.txt");
		List<Person> personList = new ArrayList<Person>();
		// Function<String, List<Person> > = s -> s.

		Stream<Person> res = lines.map(line -> {
			String[] personLine = line.split(" ");
			Person person = new Person(personLine[0], Integer.valueOf(personLine[1]));
			personList.add(person);
			return person;
		});

		Person opt = res.filter(person -> person.getAge() > 20).min(Comparator.comparing(Person::getAge)).get();
		System.out.println("----" + opt.getAge());

		Path path = Paths.get("d:", "PERSO");
		try (Stream<Path> lineList = Files.list(path)) {
			lineList.forEach(System.out::println);
		} catch (IOException e) {

		}

	}

	public static Stream<String> readFile(String fileName) {
		BufferedReader br = null;
		FileReader fr = null;

		try {

			// br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			return br.lines();

		} catch (IOException e) {
			e.printStackTrace();
		}
		// finally {
		//
		// try {
		//
		// if (br != null)
		// br.close();
		//
		// if (fr != null)
		// fr.close();
		//
		// } catch (IOException ex) {
		//
		// ex.printStackTrace();
		//
		// }
		// }
		return null;
	}
}
