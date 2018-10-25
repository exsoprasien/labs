package com.labs.main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<String>();

		list.add("test4");
		list.add("pest2");
		list.add("fest3");
		list.add("Test1");

		list.stream().filter(x -> x.toUpperCase().contains("TES")).map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
				.forEach(System.out::println);
		;
	}

}
