package com.intermediate.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Circle of Monsters
Problem Description

You are playing another computer game, and now you have to slay n monsters. These monsters are standing in a circle, numbered clockwise from 1 to n. Initially, the i-th monster has ai health.

You may shoot the monsters to kill them. Each shot requires exactly one bullet and decreases the health of the targeted monster by 1 (deals 1 damage to it). Furthermore, when the health of some monster i becomes 0 or less than 0, it dies and explodes, dealing bi damage to the next monster (monster i+1, if i < n, or monster 1, if i=n). If the next monster is already dead, then nothing happens. If the explosion kills the next monster, it explodes too, damaging the monster after it and possibly triggering another explosion, and so on.

You have to calculate the minimum number of bullets mod 10 9 + 7 you have to fire to kill all n monsters in the circle.

NOTE: If the minimum no. of bullets are x then you have to return x % 1e9 + 7 .



Problem Constraints
2<= n <=300000
1<= A[i], B[i]<= 1e9


Input Format
First Argument is array of integers of N size denoting array A Second Argument is array of integers of N size denoting array B


Output Format
Return the miniumum number of bullets mod 10 9 + 7 you have to fire to kill all of the monsters.


Example Input
Input- 1
A=[7,2,5]
B=[15,14,3]
Input- 2

A=[1 2]
B=[2 1]


Example Output
Output- 1
6
Output- 2

1


Example Explanation
Explanation-1
Firstly we shoot 2nd monster whose health is 2 with 2 bullets and then this monster will create damage of 14 to another monster.
Now 3rd monster health will decrease by 14 units . hence 3rd monster also died . hence it will create damage of 3 units to 1st monster
Now 1st monster health is 7-3=4 . and now 4 more bullets are required to kill 1st monster.
Total bullets required to kill all the monsters = 2+4= 6
Explanation-2

Kill 1st monster with 1 bullet so it will cause 2 units of damage to 2nd monster.
Hence 2nd monster automatically died.
Total bullets required=1
 */
public class CircleofMonsters {

	public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

		int N = A.size();
		int M = B.size();
		long sum = 0l;
		long ans = Long.MAX_VALUE;

		Long MOD = new Long((long) (Math.pow(10, 9) + 7));

		if ((N >= 2 && M >= 2) && (N <= 300000 && N <= 300000)) {

			for (int i = 0; i < N; i++) {
				sum += Math.max(0, A.get(i) - B.get((i - 1 + N) % N));
			}
			long optimalAns = 0l;
			for (int i = 0; i < N; i++) {
				optimalAns = sum - Math.max(0, A.get(i) - B.get((i - 1 + N) % N)) + A.get(i);
				ans = Math.min(ans, optimalAns);
			}

			return new Long(ans % MOD).intValue();
		}

		return new Long(ans % MOD).intValue();
	}

	public static void main(String[] args) {
		CircleofMonsters cms = new CircleofMonsters();

		List<Integer> integers1 = Arrays.asList(10, 13, 25, 14, 24, 49, 43, 48);

		ArrayList<Integer> inputArray1 = new ArrayList<Integer>();
		inputArray1.addAll(integers1);

		List<Integer> integers2 = Arrays.asList(38, 23, 47, 20, 49, 40, 22, 39);

		ArrayList<Integer> inputArray2 = new ArrayList<Integer>();
		inputArray2.addAll(integers2);

		int result = cms.solve(inputArray1, inputArray2);

		System.out.println(result);

	}

}
