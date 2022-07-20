package com.intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Rotation Game
Problem Description

You are given an integer array A and an integer B. You have to print the same array after rotating it B times towards right.

NOTE: You can use extra memory.



Problem Constraints
1 <= |A| <= 106

1 <= A[i] <= 109

1 <= B <= 109



Input Format
First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
Second line contains a single integer B



Output Format
Print an array of integers which is the Bth right rotation of input array A, on a separate line.



Example Input
Input 1:

 4 1 2 3 4
 2
Input 2:

 3 1 2 2
 3


Example Output
Output 1:

 3 4 1 2
Output 2:

 1 2 2


Example Explanation
Explanation 1:

 [1,2,3,4] => [4,1,2,3] => [3,4,1,2]

Explanation 2:


 [1,2,2] => [2,1,2] => [2,2,1] => [1,2,2]
 
 *A : [ 1, 2, 3, 4, 5 ]
B : 3
 */
public class RotationGame2On {

	public void rotateGame(ArrayList<Integer> A, int times) {
		
		times = times % A.size();
		swap(A,0,A.size()-times -1);
		swap(A,A.size()-times, A.size()-1);
		swap(A,0,A.size()-1);
		A.forEach(a -> System.out.print(a + " "));
	}

	private void swap(ArrayList<Integer> A, int start, int end) {
		
		for(int i = start, j= end; i<j;i++,j-- ) {
			int temp = A.get(i);
			A.set(i, A.get(j));
			A.set(j, temp);
		}

	}

	public static void main(String[] args) {

		/*
		 * try (Scanner scanner = new Scanner(System.in)) { int arrayLength = 0;
		 * ArrayList<Integer> list = new ArrayList<Integer>(); BufferedReader reader =
		 * new BufferedReader(new InputStreamReader(System.in)); int[] array; try {
		 * array =
		 * Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).
		 * toArray(); int[] timesarray =
		 * Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).
		 * toArray(); int times = 0;
		 * 
		 * if (null != array) { arrayLength = array[0]; for (int i = 1; i <=
		 * arrayLength; i++) { list.add(array[i]); } } if (timesarray != null) { times =
		 * timesarray[0]; }
		 * 
		 * // Conditions check if (arrayLength >= 1 && arrayLength <= Math.pow(10, 6)) {
		 * if (times >= 1 && times <= Math.pow(10, 9)) { //Main rotationGame = new
		 * Main(); RotationGame rotationGame = new RotationGame();
		 * rotationGame.rotateGame(list, times);
		 * 
		 * } }
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 * 
		 * }
		 */
		// A : [ 78432416, 39344977, 38228784, 57325761, 60282367, 84265033, 63527579, 15529028, 76229935, 87054738, 47211001, 82731635, 36813982, 4169668, 55914552, 12027462, 17930700, 67817015, 41017139, 54822431, 17267843, 73752906, 22934317, 30372396, 40917027, 58255953, 97430138, 66011487, 88831003, 87563581, 14759687, 62289524, 80043288, 93305932, 60045835, 34775175, 71708982, 13521456, 70916803, 79564495, 47497778, 76891507, 33633753, 25980940, 17495141, 98432856, 34060524, 39503983, 76233890, 78112853, 94992362, 73854302, 99974733, 95940483, 57769085, 95781478, 44868251, 25134768, 62379200, 34620786, 59296114, 73445208, 65521223, 4369329, 58242973, 50948180, 13760741, 83376278, 35078320, 73819927, 42680313, 19906657, 8756890, 27880209, 49060699, 12035297, 24938869, 68320610, 12365383, 1268056, 13268749, 88078150, 59816659, 6843742, 4224998, 16774792, 15097414, 66687149, 32409618, 50596307, 75491843, 89100752, 24980243, 70861700, 29145804, 79514921, 41044171, 98777394, 37895564, 12028885, 42320630, 14979248, 65538576, 23617315, 55136978, 67247368, 12885196, 75497640, 98029519, 51320541, 63540884, 7 ]
		// B : 
		
		  RotationGame2On rotationGame = new RotationGame2On(); 
		  //ArrayList abc = new ArrayList(); abc.add(1); abc.add(2); abc.add(3); abc.add(4); //abc.add(3); //abc.add(4);
		  
		  //List<Long> lst = Arrays.asList(78432416, 39344977, 38228784, 57325761, 60282367, 84265033, 63527579, 15529028, 76229935, 87054738, 47211001, 82731635, 36813982, 4169668, 55914552, 12027462, 17930700, 67817015, 41017139, 54822431, 17267843, 73752906, 22934317, 30372396, 40917027, 58255953, 97430138, 66011487, 88831003, 87563581, 14759687, 62289524, 80043288, 93305932, 60045835, 34775175, 71708982, 13521456, 70916803, 79564495, 47497778, 76891507, 33633753, 25980940, 17495141, 98432856, 34060524, 39503983, 76233890, 78112853, 94992362, 73854302, 99974733, 95940483, 57769085, 95781478, 44868251, 25134768, 62379200, 34620786, 59296114, 73445208, 65521223, 4369329, 58242973, 50948180, 13760741, 83376278, 35078320, 73819927, 42680313, 19906657, 8756890, 27880209, 49060699, 12035297, 24938869, 68320610, 12365383, 1268056, 13268749, 88078150, 59816659, 6843742, 4224998, 16774792, 15097414, 66687149, 32409618, 50596307, 75491843, 89100752, 24980243, 70861700, 29145804, 79514921, 41044171, 98777394, 37895564, 12028885, 42320630, 14979248, 65538576, 23617315, 55136978, 67247368, 12885196, 75497640, 98029519, 51320541, 63540884);
			//List<Integer> lst = Arrays.asList(1,1,1,1,1);
		  List<Integer> lst = Arrays.asList(0);
			
			ArrayList<Integer> abc = new ArrayList<Integer>();
			abc.addAll(lst);
		  
		  
		  rotationGame.rotateGame(abc, 3);
		 

	}

}
