package com.intermediate.arrays;

public class SumOfAllSubarrays {
	
	public long subarraySum(int[] A) {
        long sum = 0;
        int N = A.length;
        for(int i=0;i<N;i++){
            long val = ((long)A[i] *(i+1)*(N-i));
            sum += val;
        }
        
        return sum;
    }
	
	public static void main(String[] args) {
		SumOfAllSubarrays sumOfAllSubarrays = new SumOfAllSubarrays();
		int[] A = {1,2,3};
		long result = sumOfAllSubarrays.subarraySum(A);
		System.out.println(result);
	}

}
