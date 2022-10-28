package com.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingList {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>();
		li.add(40);
		li.add(12);
		li.add(31);
		li.add(2);
		li.add(9);
		
		System.out.println("List Before Sorting");
		li.forEach(x -> System.out.println(x));
		
		System.out.println("After Sorting Ascending Order");
		li.stream().sorted().forEach(System.out::println);
		
		System.out.println("After Sorting Descending Order");
		li.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
}
