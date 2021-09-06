package com.intermediate.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Replicating Substring
 *
Problem Description

Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.

Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".

If it is possible, return 1, else return -1.



Problem Constraints
1 <= Length of string B <= 1000

1 <= A <= 1000

All the alphabets of S are lower case (a - z)



Input Format
First argument is an integer A.
Second argument is a string B.



Output Format
Your function should return 1 if it is possible to re-arrange the characters of the string B so that it can be represented as a concatenation of A similar strings. If it is not, return -1.



Example Input
Input 1:

 A = 2
 B = "bbaabb"
Input 2:

 A = 1
 B = "bc"


Example Output
Output 1:

 1
Output 2:

 1


Example Explanation
Explanation 1:

 We can re-order the given string into "abbabb".
Explanation 2:

 String "bc" is already arranged.*/
public class ReplicatingSubstring {

	public int solve(int A, String B) {
		int N = null != B ? B.length() : 0;
		int resultInt = 1;
		if (A >= 1 && A <= 1000) {
			if(A>N) {
				return -1;
			}
			if (N >= 0 && N <= 1000) {
				char[] arrayString = B.toCharArray();
				HashSet<Character> dataSet = new HashSet<Character>();
				if (checkOnlyLowerCase(arrayString)) {

					for (char a : arrayString) {
						dataSet.add(a);
					}

					for (char a : dataSet) {
						int count = 0;
						for (int k = 0; k < B.length(); k++) {
							if (a == arrayString[k]) {
								count++;
							}
						}
						if (count % A != 0) {
							return -1;
						}
					}

				}

			}

		}
		return resultInt;

	}

	private boolean checkOnlyLowerCase(char[] a) {

		for (int i = 0; i < a.length; i++) {
			int k = a[i];
			if (k < 97 || k > 122) {
				return false;
			}
		}

		return true;

	}

	public static void main(String[] args) {
		ReplicatingSubstring repeReplicatingSubstring = new ReplicatingSubstring();
		int result = repeReplicatingSubstring.solve(5, "aaaaa");
		System.out.println("REsult is:>" + result);

	}

}
