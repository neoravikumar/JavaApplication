package com.intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSortClass {

	private void swap(ArrayList<Integer> A, int indexA, int indexB) {
		int temp = A.get(indexA);
		A.set(indexA, A.get(indexB));
		A.set(indexB, temp);
	}
	
	public void quickSort(ArrayList<Integer> A, int start, int end) {
		
		if (start < end)  
	    {  
	        int p = partition(A, start, end);  //p is partitioning index  
	        quickSort(A, start, p - 1);  
	        quickSort(A, p + 1, end);  
	    }  
		
	}

	private int partition(ArrayList<Integer> A, int start, int end) {
		int p = start, j;
	    for(j=start+1; j <= end; j++) {
	        if(A.get(j) < A.get(start)) {
	            swap(A, ++p, j);}
	    }
	    swap(A, start, p);
	    return p;
	}

	public static void main(String[] args) {
		
		QuickSortClass qsc = new QuickSortClass();
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 4, 10, 2, 1, 5));
		qsc.quickSort(input, 0, input.size()-1);
		System.out.println(input);
		
		//

	}

}
