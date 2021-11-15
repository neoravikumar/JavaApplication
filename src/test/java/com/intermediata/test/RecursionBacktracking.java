package com.intermediata.test;
import java.util.ArrayList;
import java.util.Arrays;

public class RecursionBacktracking {

	// Calculate sum of N natural number using recursion.
	private int nSum(int n) {

		if (n == 0)
			return 0;
		return n + nSum(n - 1);
	}

	private int powerN(int n, int p) {

		if (p == 0)
			return 1;
		return n * powerN(n, p - 1);
	}

	private int fibonacciNumberTillN(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacciNumberTillN(n - 1) + fibonacciNumberTillN(n - 2);
	}

	private boolean CheckSortedArray(ArrayList<Integer> data, int size) {

		if (size == 0 || size == 1) {
			return true;
		}
		if (data.get(size - 1) < data.get(size - 2))
			return false;

		return CheckSortedArray(data, size - 1);

	}

	private void printNumber(int n, int type) {

		if (type == 1) {

			if (n == 0) {
				return;
			}
			printNumber(n - 1, 1);
			System.out.println(n);
		} else {
			if (n == 0) {
				return;
			}

			System.out.println(n);
			printNumber(n - 1, 0);
		}

	}

	private String reverseString(String s, int len,String temp) {
		if(len == 0) {
			return "";
		}
		
		String t = s.substring(0,len-len+1);
		temp +=t;
		s= reverseString(s, s.length()-1, temp);
		System.out.println("::"+s);
		
		return temp;

	}

	public static void main(String[] args) {
		RecursionBacktracking recub = new RecursionBacktracking();
		// System.out.println("N SUM:>>"+recub.nSum(10));
		// System.out.println("N Power:>>"+recub.powerN(2,4));

		// System.out.println("FibbSeries Power:>>"+recub.fibonacciNumberTillN(9));
		// System.out.println("FibbSeries Check Array Sorted or Not::>>"+
		// recub.CheckSortedArray(new ArrayList<Integer>(Arrays.asList(5, 897, 99)),
		// 3));
		// 1 for increasing 0 for decreasing
		//recub.printNumber(10, 1);
		String s = "ravi";
		String temp = "";
		System.out.println(recub.reverseString(s, s.length(), temp));
	}

}
