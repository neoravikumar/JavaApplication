package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Multiple left rotations of the array
Problem Description

Given an array of integers A and multiple values in B which represents number of times array A needs to be left rotated.

Find the rotated array for each value and return the result in the from of a matrix where i'th row represents the rotated array for the i'th value in B.



Problem Constraints
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000


Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.


Output Format
Return the resultant matrix.


Example Input
Input 1:
 
    A = [1, 2, 3, 4, 5]
    B = [2, 3]

Input 2:

  
    A = [5, 17, 100, 11]
    B = [1]




Example Output
Output 1:
 
    [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]


Output 2:

    
    [ [17, 100, 11, 5] ]



Example Explanation
for input 1 -> B[0] = 2 which requires 2 times left rotations

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

B[1] = 3 which requires 3 times left rotation

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

2: [4, 5, 1, 2, 4]

*/
public class MultipleLeftRotationsOfTheArray {

	public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

		ArrayList<ArrayList<Integer>> resultArray = new ArrayList<ArrayList<Integer>>();

		int aN = null != A ? A.size() : null;
		int bN = null != B ? B.size() : null;

		if ((aN >= 1 && aN <= 2000) && (bN >= 1 && bN <= 2000)) {
			ArrayList<Integer> result = null;

			for (int i = 0; i < bN; i++) {
				ArrayList<Integer> tempArray = new ArrayList<Integer>();
				tempArray.addAll(A);
				int times = B.get(i);
				// times = times % B.size();
				if (times > 0) {
					while (times > 0) {
						result = rotatedArray(tempArray);
						times--;
					}
					resultArray.add(result);
				} else {
					resultArray.add(A);
				}

			}
		}
		for (ArrayList<Integer> result : resultArray) {
			result.forEach(a -> System.out.print(a + " "));
			System.out.println();
		}
		return resultArray;
	}

	private ArrayList<Integer> rotatedArray(ArrayList<Integer> A) {
		int N = A.size();
		int temp = A.get(0);
		for (int i = 0; i < N; i++) {
			if (i == N - 1) {
				A.set(N - 1, temp);
			} else {
				A.set(i, A.get(i + 1));
			}
		}
		return A;
	}

	public static void main(String[] args) {

		MultipleLeftRotationsOfTheArray multipleLeftRotationsOfTheArray = new MultipleLeftRotationsOfTheArray();

		List<Integer> array1 = Arrays.asList(1, 2, 3, 4, 5);

		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.addAll(array1);

		List<Integer> array2 = Arrays.asList(2, 3);

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(array2);

		multipleLeftRotationsOfTheArray.solve(list1, list2);

	}

}
