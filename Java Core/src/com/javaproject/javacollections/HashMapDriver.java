package com.javaproject.javacollections;

import java.util.HashMap;
import java.util.Set;

public class HashMapDriver {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "Kartik");
		map.put(2, "Arya");
		map.put(3, "Artrimis");
		System.out.println(map);
		System.out.println(map.get(2));
		Set<Integer> s = map.keySet();
		for(Object key:s){
			System.out.println(map.get(key));
		}
	}
}
