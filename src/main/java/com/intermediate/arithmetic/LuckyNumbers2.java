package com.intermediate.arithmetic;

import java.util.HashMap;
import java.util.Objects;

/*
 * 
 Lucky Numbers
Problem Description

A lucky number is a number which has exactly 2 distinct prime divisors.

You are given a number A and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).



Problem Constraints
1 <= A <= 50000



Input Format
The first and only argument is an integer A.



Output Format
Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.



Example Input
Input 1:

 A = 8
Input 2:

 A = 12


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 Between [1, 8] there is only 1 lucky number i.e 6.
 6 has 2 distinct prime factors i.e 2 and 3.
Explanation 2:

 Between [1, 12] there are 3 lucky number: 6, 10 and 12.
 */
public class LuckyNumbers2 {
	
	static HashMap<Integer,Divisor> numbers = new HashMap<>();
    
	public static void main(String[] args) {
		/*
		 * int[] testSet = new int[]{ 12, 8 }; for(int testData : testSet){
		 * System.out.println(testData + " => "+solve(testData)); }
		 */
		System.out.println(solve(21));
    }

    public static int solve(int A) {
        for(int i=2;i<=A;i++){
            numbers.put(i,new Divisor(i));
        }

        for(int i=2;i<=A;i++){
            if(numbers.get(i).isPrimePower){
                continue;
            }
            int lastPrimePower = i*i;
            for(int j=i;j<=A;j+=i){
                if(i == j){
                    if(numbers.get(j).prime1 == 0){
                        numbers.get(j).prime1 = i;
                    }
                    continue;
                }

                if(j == lastPrimePower){
                    numbers.get(j).addDivisor(i);
                    numbers.get(j).isPrimePower = true;
                    lastPrimePower *= i;
                    continue;
                }

                numbers.get(j).addDivisor(i);
            }
        }
        numbers.entrySet().removeIf(integerDivisorEntry -> integerDivisorEntry.getValue().isDeletable());
        //System.out.println(new JSONObject(numbers));

        return numbers.size();
    }

    static class Divisor{
        int prime1;
        int prime2;
        int prime3;
        boolean isPrimePower;
        int num;
        Divisor(int num){
            this.num = num;
        }

        boolean isDeletable(){
            return !(prime1!= 0 && prime2!=0 && prime3==0);
        }

        public void addDivisor(int number){
            Divisor divisor = numbers.get(number);
            updateDivisor(divisor.prime1);
            updateDivisor(divisor.prime2);
            updateDivisor(divisor.prime3);
        }

        public void updateDivisor(int number){
            if(this.isPrimePower || number == 0){
                return;
            }
            if(prime1 == 0 || number == prime1){
                prime1 = number;
                return;
            }


            if( prime2 == 0 || number == prime2){
                prime2 = number;
                return;
            }

            if(prime3 == 0){
                prime3 = number;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Divisor divisor = (Divisor) o;
            return this.num == divisor.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }

        @Override
        public String toString() {
            return "{" +
                    "prime1:" + prime1 +
                    ", prime2:" + prime2 +
                    ", prime3:" + prime3 +
                    ", isPrimePower : " + isPrimePower +
                    '}';
        }

    }

}
