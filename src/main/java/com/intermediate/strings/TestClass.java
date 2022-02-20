package com.intermediate.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class TestClass {

	public int sum(int A, ArrayList<Integer> B) {
		long sum = 0l;
		for(int i=0;i<A;i++) {
			for(int j=i+1;j<A;j++) {
				int a = B.get(i);
				int b= B.get(j);
				if(Math.abs(a-b)>1) {
					sum += b-a;
				}else if(Math.abs(a-b)<=1) {
					sum += 0;
				}
			}
		}
		
		int result = (int) sum % 1000000007;
		
		
		return result;
	}

	public static void main(String[] args) {

		TestClass t = new TestClass();
		int result = t.sum(3, new ArrayList<Integer>(Arrays.asList(1,2,3)));
		System.out.println(">>>"+result);

	}

}
