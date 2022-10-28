package com.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap();
		map.put(1, 5);
		map.put(3, 2);
		map.put(2, 1);
		map.put(5, 3);
		map.put(4, 4);
		
		System.out.println("Sorting based on Value");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(x -> System.out.println(x.getKey() + "-" + x.getValue()));
	
		System.out.println("Sorting based on key");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(x -> System.out.println(x.getKey() + "-" + x.getValue()));
	
		map = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		map.entrySet().forEach(x -> System.out.println(x.getKey() + "-" + x.getValue()));
	}
}
