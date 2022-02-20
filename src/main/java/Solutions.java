import java.util.Arrays;

public class Solutions {

	public int findMaxConsecutiveOnes(int[] nums) {
        
        int maxOne = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
            	max = Math.max(maxOne, max);
                maxOne=0;
            }else{
            	maxOne = maxOne + 1;
            	max = Math.max(maxOne, max);
            }
        }
        return max;
    }
	
	/*
	 Given an array nums of integers, return how many of them contain an even number of digits.

	Example 1:
	
	Input: nums = [12,345,2,6,7896]
	Output: 2
	Explanation: 
	12 contains 2 digits (even number of digits). 
	345 contains 3 digits (odd number of digits). 
	2 contains 1 digit (odd number of digits). 
	6 contains 1 digit (odd number of digits). 
	7896 contains 4 digits (even number of digits). 
	Therefore only 12 and 7896 contain an even number of digits.
	Example 2:
	
	Input: nums = [555,901,482,1771]
	Output: 1 
	Explanation: 
	Only 1771 contains an even number of digits.
	
	 */
	public int findNumbers(int[] nums) {
		
		int evenCounter = 0;
		int digitCount = 0;
		
		for(int i=0;i<nums.length;i++) {
			int input = nums[i];
			while(input>=1) {
				input = input /10;
				digitCount++;
			}
			if(digitCount%2==0) {
				evenCounter++;
			}
			digitCount=0;
		}
		
		return evenCounter;
    }
	
	public int[] sortedSquares(int[] nums) {
        int result[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int squr = nums[i] * nums[i];
            result[i] = squr;
        }
        Arrays.sort(result);
        return result;
    }

	public static void main(String[] args) {
		Solutions solutions = new Solutions();
		int[] input = {1,0,1,1,1,1,0,1,0,1};
		int result = solutions.findMaxConsecutiveOnes(input);
		System.out.println(result);
		
		int[] input2 = {0};
		int result2 = solutions.findNumbers(input2);
		System.out.println(result2);
		
		int[] input3 = {-1};
		int[] result3 = solutions.sortedSquares(input3);
		System.out.println("3rd::>>"+Arrays.toString(result3));
	}

}
