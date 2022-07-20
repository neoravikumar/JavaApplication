package com.practice;

public class SquareGranites {

	public int solve(int a, int b, int c) {
		long i, j;
		i = a / c;
		j = b / c;
		if (i * c != a)
			i++;
		if (j * c != b)
			j++;
		return new Long(i * j).intValue();
	}


	public static void main(String[] args) {
		SquareGranites sq = new SquareGranites();
		int result = sq.solve(6,6,4);


		System.out.println("REsut is:" + result);

	}

}
