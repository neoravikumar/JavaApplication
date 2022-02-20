package com.intermediate.searching;

public class AthMagicalNumberII {

	public int solve(int a, int b, int n) {
		long A = a, B = b;
		long mod = 1000000007;
		long l = Math.min(a, b), r = (long) n * Math.min(a, b);
		while (B > 0) {
			long t = A;
			A = B;
			B = t % B;
		}

		long lcm = (a * b) / A;
		while (l < r) {
			long mid = l + (r - l) / 2;

			// if number of magical number till mid is smaller than n ,
			// move right of mid
			if ((mid / a) + (mid / b) - (mid / lcm) < n)
				l = mid + 1;
			else
				r = mid;
		}
		return (int) (l % mod);

	}

	public static void main(String[] args) {
		AthMagicalNumberII amagical = new AthMagicalNumberII();
		int result = amagical.solve(1, 2, 3);
		System.out.println(result);
	}

}
