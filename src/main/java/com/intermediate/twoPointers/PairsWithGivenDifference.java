package com.intermediate.twoPointers;

import java.util.*;

/*
 Pairs with Given Difference
Problem Description

Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.



Problem Constraints
1 <= N <= 104

0 <= A[i], B <= 105



Input Format
First argument is an one-dimensional integer array A of size N.

Second argument is an integer B.



Output Format
Return an integer denoting the count of all distinct pairs with difference equal to B.



Example Input
Input 1:

 A = [1, 5, 3, 4, 2]
 B = 3
Input 2:

 A = [8, 12, 16, 4, 0, 20]
 B = 4
Input 3:

 A = [1, 1, 1, 2, 2]
 B = 0


Example Output
Output 1:

 2
Output 2:

 5
Output 3:

 2


Example Explanation
Explanation 1:

 There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2} 
Explanation 2:

 There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20} 
Explanation 3:

 There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
 */
public class PairsWithGivenDifference {
	
	
	
	int countPairsWithDiffK(ArrayList<Integer> A, int B) 
	{ 
	    int count = 0; 
	    int n = A.size();
	      
	    // Pick all elements one by one 
	    for (int i = 0; i < n; i++) 
	    {        
	        // See if there is a pair of this picked element 
	        for (int j = i+1; j < n; j++) 
	            if (Math.abs(A.get(i) - A.get(j)) == B || Math.abs(A.get(j) - A.get(i)) == B ) 
	                  count++; 
	    } 
	    return count; 
	} 
	  
	

	public int solve(ArrayList<Integer> A, int B) {
		int N = A.size();
		int start = 0;
		int end =0;
		int counter = 0;
		Collections.sort(A);
		Set<Integer> resultSet = new HashSet<Integer>();
		while(end<N) {
			int diffrence = Math.abs(A.get(end)- A.get(start));
			if(diffrence == B) {
				start++;
				counter++;
				end++;
				if(end<N) {
					String key = A.get(start) +""+A.get(end);
					System.out.println(key);
					if(!resultSet.contains(key)) {
						resultSet.add(Integer.valueOf(key));
					}
				}
			}
			else if(diffrence>B) {
				start++;
			}
			else  {
				end++;
			}
		}
		return counter;
		
		/*
		 * // sort array in ascending order Collections.sort(A);
		 * 
		 * // maintain two indices in the array int start = 0, end = 0; int n =
		 * A.size(); int counter=0;
		 * 
		 * if(n==2) { if(A.get(1) - A.get(0) == B) { return 1; }else { return 0; } }
		 * 
		 * // run till the end of the array is reached while (start < n && end < n) {
		 * int difference = A.get(end) - A.get(start); // to avoid printing duplicates
		 * while (start < n - 1 && A.get(start) == A.get(start+1)) { start++; }
		 * 
		 * while (end < n - 1 && A.get(end) == A.get(end+1)) { end++; }
		 * 
		 * // increment `i` if the current difference is more than // the desired
		 * difference if (difference > B) { start++; }
		 * 
		 * // increment `j` if the current difference is less than // the desired
		 * difference else if (difference < B) { end++; } else { counter++; start++;
		 * end++; } } return counter;
		 */
	}

	public static void main(String[] args) {
		PairsWithGivenDifference subarrayWithGivenSum = new PairsWithGivenDifference();
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList( 8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3));
		//ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(1,2));
		//ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ));
		//int result = subarrayWithGivenSum.solve(inputArray, 3);
		int result2 = subarrayWithGivenSum.countPairsWithDiffK(new ArrayList<Integer>(Arrays.asList(1, 5, 3, 4, 2)), 3);
		System.out.println(result2);
		//System.out.println(result);

	}

}
