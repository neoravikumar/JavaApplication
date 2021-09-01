package com.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*K Occurrences
Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].

He wants to select some trees to replace his broken branches.

But he wants uniformity in his selection of trees.

So he picks only those trees whose heights have frequency K.

He then sums up the heights that occur K times. (He adds the height only once to the sum and not K times).

But the sum he ended up getting was huge so he prints it modulo 10^9+7.

In case no such cluster exists, Groot becomes sad and prints -1.

Constraints:

1.   1<=N<=100000
2.   1<=K<=N
3.   0<=H[i]<=10^9
Input: Integers N and K and array of size A

Output: Sum of all numbers in the array that occur exactly K times.

Example:

Input:

N=5 ,K=2 ,A=[1 2 2 3 3]
Output:

5
Explanation:

There are 3 distinct numbers in the array which are 1,2,3.
Out of these, only 2 and 3 occur twice. Therefore the answer is sum of 2 and 3 which is 5.*/
public class K_Occurrences {

	public int getSum(int N, int K, ArrayList<Integer> C) {
		int sum = 0;
		boolean isSumZero = false;
		if (N >= 1 && N <= 100000) {
			if (K >= 1 && K <= N) {

				Map<Integer, Integer> mapOne = new LinkedHashMap<Integer, Integer>();

				for (int h : C) {
					if (h >= 0 && h <= Math.pow(10, 9)) {

						if (mapOne.containsKey(h)) {
							int value = mapOne.get(h);
							mapOne.put(h, value + 1);
						} else {
							mapOne.put(h, 1);
						}

					}
				}

				if(mapOne.containsValue(K)) {
					for (Integer b : mapOne.keySet()) {
						int value = mapOne.get(b);
						if (value >= K) {
							sum += b;
						}
					}
				}else {
					return -1;
				}
				
				if(isSumZero) {
					return 0;
				}
				sum = (int) (sum % (Math.pow(10, 9) + 7));
			}
		}
		return sum;
	}

	public static void main(String[] args) {

		K_Occurrences koK_Occurrences = new K_Occurrences();
		//List<Integer> lst2 = Arrays.asList(1, 2, 2, 3, 3);
		List<Integer> lst2 = Arrays.asList(0,0,3);
		ArrayList<Integer> abc2 = new ArrayList<Integer>();
		abc2.addAll(lst2);

		int result = koK_Occurrences.getSum(5, 2, abc2);
		System.out.println(result);
	}

}
