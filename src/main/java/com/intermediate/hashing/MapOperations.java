package com.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapOperations {

	public HashMap keyValues(HashMap<Integer, Integer> input) {

		int tempList = input.get(1);
		System.out.println("Values:" + tempList);

		return input;
	}

	public ArrayList<Integer> printIntersection(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		Map<Integer, Integer> mapOne = new LinkedHashMap<Integer, Integer>();
		Map<Integer, Integer> mapTwo = new LinkedHashMap<Integer, Integer>();

		int N = A.size();
		int M = B.size();
		if (N >= 1 && N <= Math.pow(10, 5) && M >= 1 && M <= Math.pow(10, 5)) {

			for (Integer a : A) {
				if (mapOne.containsKey(a)) {
					int value = mapOne.get(a);
					mapOne.put(a, value + 1);
				} else {
					mapOne.put(a, 1);
				}
			}

			for (Integer b : B) {
				if (mapTwo.containsKey(b)) {
					int value = mapTwo.get(b);
					mapTwo.put(b, value + 1);
				} else {
					mapTwo.put(b, 1);
				}
			}

			for (Integer b : mapOne.keySet()) {
				if (mapTwo.containsKey(b)) {
					int value1 = mapOne.get(b);
					int value2 = mapTwo.get(b);
					int length = value1 > value2 ? value2 : value1;
					for (int i = 0; i < length; i++) {
						result.add(b);
					}
				}
			}

			/*
			 * for (int i = 0; i < M; i++) { if (A.contains(B.get(i))) result.add(B.get(i));
			 * A.remove(B.get(i)); }
			 */
		}
		return result;
	}

	public static void main(String[] args) {

		MapOperations mapOperations = new MapOperations();
		HashMap<Integer, Integer> keyValueList = new HashMap<Integer, Integer>();
		keyValueList.put(1, 2);
		// mapOperations.keyValues(keyValueList);

		List<Integer> lst = Arrays.asList(2, 10, 4, 10, 10, 10);
		// List<Integer> lst = Arrays.asList(2, 1, 4, 10);
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.addAll(lst);

		List<Integer> lst2 = Arrays.asList(3, 6, 2, 10, 10, 10, 10, 10, 10, 10, 10);
		// List<Integer> lst2 = Arrays.asList(3, 6, 2, 10, 10);
		ArrayList<Integer> abc2 = new ArrayList<Integer>();
		abc2.addAll(lst2);

		ArrayList<Integer> result = mapOperations.printIntersection(abc, abc2);
		result.forEach(a -> System.out.print(a + " "));

	}

}
