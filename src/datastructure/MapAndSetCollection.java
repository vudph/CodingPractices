package datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapAndSetCollection {

	public static void main(String[] args) {
		Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("D", 1);
		linkedHashMap.put("A", 2);
		linkedHashMap.put("B", 3);
		linkedHashMap.put("E", 4);
		System.out.println("LinkedHashMap iteration, in order...");
		Iterator<String> iter0 = linkedHashMap.keySet().iterator();
		while (iter0.hasNext()) {
			String key = iter0.next();
			System.out.println(key + ": " + linkedHashMap.get(key));
		}
		
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("D", 1);
		hashMap.put("A", 2);
		hashMap.put("B", 3);
		hashMap.put("E", 4);
		System.out.println("HashMap iteration, not in order...");
		Iterator<String> iter1 = hashMap.keySet().iterator();
		while (iter1.hasNext()) {
			String key = iter1.next();
			System.out.println(key + ": " + hashMap.get(key));
		}
		
		Map<String, Integer> treeMap = new HashMap<>();
		treeMap.put("D", 1);
		treeMap.put("A", 2);
		treeMap.put("B", 3);
		treeMap.put("E", 4);
		System.out.println("HashMap iteration, in order & sorted...");
		Iterator<String> iter2 = treeMap.keySet().iterator();
		while (iter2.hasNext()) {
			String key = iter2.next();
			System.out.println(key + ": " + treeMap.get(key));
		}
		
		Set<String> hashSet = new HashSet<>();
		hashSet.add("D");
		hashSet.add("A");
		hashSet.add("B");
		hashSet.add("E");
		System.out.println("Hashset traverse...");
		Iterator<String> iter3 = hashSet.iterator();
		while(iter3.hasNext()) {
			System.out.println(iter3.next());
		}
		
		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("D");
		linkedHashSet.add("A");
		linkedHashSet.add("B");
		linkedHashSet.add("E");
		System.out.println("LinkedHashSet traverse...");
		Iterator<String> iter4 = linkedHashSet.iterator();
		while(iter4.hasNext()) {
			System.out.println(iter4.next());
		}
		
		Set<String> treeSet = new TreeSet<>();
		treeSet.add("D");
		treeSet.add("A");
		treeSet.add("B");
		treeSet.add("E");
		System.out.println("TreeSet traverse...");
		Iterator<String> iter5 = treeSet.iterator();
		while(iter5.hasNext()) {
			System.out.println(iter5.next());
		}
	}

}
