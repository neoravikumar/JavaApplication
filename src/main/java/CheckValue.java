import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class CheckValue {

	public int solve(ArrayList<Integer> A) {

		/*
		 * // Insert all elements in hash. HashMap<Integer, Integer> hash = new
		 * HashMap<Integer, Integer>(); int N = A.size();
		 * 
		 * for (int i = 0; i < N; i++) if (hash.containsKey(A.get(i)))
		 * hash.put(A.get(i), hash.get(A.get(i)) + 1); else hash.put(A.get(i), 1);
		 * 
		 * // find the max frequency int max_count = 0; Set<Integer> s = hash.keySet();
		 * 
		 * for (int i : s) if (max_count < hash.get(i)) max_count = hash.get(i);
		 * 
		 * // return result return (N - max_count);
		 */
		
		
		
		
		/*
		 * int N = A.size(); HashMap<Integer, Integer> hash = new
		 * HashMap<Integer,Integer>();
		 * 
		 * for(int i=0;i<N;i++){ if(hash.containsKey(A.get(i))){ hash.put((int)
		 * Math.floor(A.get(i)/2), hash.get(A.get(i)) + 1); }else{ hash.put((int)
		 * Math.floor(A.get(i)/2),1); } }
		 * 
		 * int max = 0; Set<Integer> sat = hash.keySet();
		 * 
		 * for(int i:sat){ if(max < hash.get(i)){ max = hash.get(i); } } return ( N -
		 * max);
		 */
		
		int n=A.size();
        int min=A.get(0);

        for (int i = 1; i < n; i++) {
            int b= A.get(i);
            while(min!=b){
                if(min>b){
                    min>>=1;
                }else{
                    b>>=1;
                }
            }
        }

        int count = 0;
        for (int x : A) {
            if (x == min) {
                continue;
            }
            while (min != x) {
                count++;
                x >>= 1;
            }
        }
        return count;
		
		

	}

	public static void main(String[] args) {
		//System.out.println((int) Math.floor(5 / 2));

		CheckValue subarrayWithGivenSum = new CheckValue();
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(4,1,2,5,4));
		int result = subarrayWithGivenSum.solve(inputArray);
		System.out.println(result);

	}

}
