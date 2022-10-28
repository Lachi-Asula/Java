package com.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortingMap {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(11, "lachi");
		map.put(33, "siva");
		map.put(55, "leela");
		map.put(22, "gopi");
		map.put(44, "padma");
		
		System.out.println("Original List");
		System.out.println(map);
		for(Map.Entry<Integer, String> m : map.entrySet()) {
			System.out.println(m.getKey() + "-" + m.getValue());
		}
		
		Set<Entry<Integer, String>> s = map.entrySet();
		List<Entry<Integer, String>> list = new ArrayList(s);
		
		System.out.println("Sorting Based on Value");
		list.sort(Entry.comparingByValue());
		list.forEach(System.out::println);
		//list.stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
		System.out.println("Sorting Based on Key");
		//list.sort(Entry.comparingByKey());
		//list.forEach(System.out::println);
		list.stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
//		Collections.sort(list, (x,y) -> x.getValue().compareTo(y.getValue()));
//		list.forEach(x -> System.out.println(x));
	}
}
