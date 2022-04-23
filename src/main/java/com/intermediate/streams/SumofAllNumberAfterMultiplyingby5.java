package com.intermediate.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class SumofAllNumberAfterMultiplyingby5 {
	
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		
		int totalNumer = myList.stream().map(a -> a*5).reduce(0, Integer::sum);
		System.out.println(totalNumer);
		
		int average = myList.stream().map(a -> a*5).mapToInt(e-> e).sum();
		System.out.println(average);
		
		
		double averages = myList.stream().map(a -> a*5).mapToInt(e-> e).average().getAsDouble();
		System.out.println(averages);
		
		// Intersect of two list
		List<Integer> listOne = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer> listTwo = new ArrayList<Integer>(Arrays.asList(12,33));
		List<Integer> intersectElements = listOne.stream()
				.filter(listTwo :: contains)
				.collect(Collectors.toList());
		
		System.out.println(intersectElements);
		System.out.println(listOne);
		System.out.println(listTwo);
		System.out.println(listOne.retainAll(listTwo));
		System.out.println(listOne);
		
		
		
		
				
		
	}

}
