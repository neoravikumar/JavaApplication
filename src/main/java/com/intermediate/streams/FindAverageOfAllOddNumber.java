package com.intermediate.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindAverageOfAllOddNumber {
	
	public static void main(String[] args) {
		
		List<Integer> input = Arrays.asList(1,2,3,4,5);
		
		double result = input.stream().filter(a -> a % 2 != 0).mapToInt(e -> e).average().getAsDouble();
		
		double intersectElements = input.stream().filter(a -> a % 2 != 0).mapToInt(e -> )
		
		/*
		 * List<Integer> listOne = Arrays.asList(1,2,3,4); List<Integer> listTwo =
		 * Arrays.asList(3,3,4,5); List<Integer> intersectElements = listOne.stream()
		 * .filter(listTwo :: ) .collect(Collectors.toList());
		 * 
		 * System.out.println(result); System.out.println(intersectElements);
		 */
		
		System.out.println(result); System.out.println(intersectElements);
		
	}

}
