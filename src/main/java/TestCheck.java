import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.intermediate.twoPointers.CountSubarrays;

public class TestCheck {

	public int sum(int A, ArrayList<Integer> B) {
        int N = B.size();
        int sum =0;
        int MOD = (int) Math.pow(10,9)+7;
        if(N==A){
//            for(int i=0;i<N;i++){
//                for(int k = i;k<N;k++){
//                    if(i!=k){
//                        sum += check(B.get(i),B.get(k));
//                    }
//                }
//            }
        	
        	
        	HashSet<Integer> s = new HashSet<>();
            for (int i = 0; i < N; i++)
            {
                s.add(B.get(i));
            }
        	
        	
        	
        	Collections.sort(B);
            int i = 0;
            int j = N -1; 
            while (i < j)
            {
            	int data = check(B.get(i),B.get(j));
            	if(data > 1){
             	   sum += data;
             	  i = i+1;
            	}
                else {
                	 j = j-1;
                	 sum += data;
                }
            }
        } 
        if(sum<0) {
        	sum = ( sum + MOD ) % MOD;
        }
        return sum % MOD;
    }
    
    private int check(int a, int b){
        
        int result = Math.abs(a-b);
        if(result >1){
            return (b-a);
        }else if(result <=1){
            return 0;
        }
        return 0;
    }
	
    
    
    
    
    public void search(int[] arr, int low, int high, int result)
    {
        if (low > high)
            return;
        if (low == high) {
            result = arr[low];
            return;
        }
 
        int mid = (low + high) / 2;
 
        if (mid % 2 == 0) {
            if (arr[mid] == arr[mid + 1])
            	search(arr, mid + 2, high,result);
            else
            	search(arr, low, mid,result);
        }
        // If mid is odd
        else if (mid % 2 == 1) {
            if (arr[mid] == arr[mid - 1])
                search(arr, mid + 1, high,result);
            else
                search(arr, low, mid - 1,result);
        }
        
    }
    
    public int solve(int[] A) {
    	int result = 0;
    	search(A, 0, A.length - 1, result);
        return result;
    }
    
    
	public int numSetBits(int A) {
		int result = 0;
		int reminder = 0;
		while (A > 0) {
			reminder = A % 2;
			if (reminder == 1) {
				result++;
			}
			A = A / 2;
		}
		return result;
	}
    
    
    
	public static void main(String[] args) {
		
		/*
		 * TestCheck subarrayWithGivenSum = new TestCheck(); ArrayList<Integer>
		 * inputArray = new ArrayList<Integer>(Arrays.asList(4,2,5,1));
		 * System.out.println(subarrayWithGivenSum.sum(4, inputArray));
		 */
		int[] aa= {1, 1, 7};
		TestCheck test = new TestCheck();
		int reslut = new TestCheck().solve(aa);
		System.out.println(reslut);
		System.out.println(":>>"+test.numSetBits(450676354));
	}

}
