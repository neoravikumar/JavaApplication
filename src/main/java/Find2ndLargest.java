import java.util.ArrayList;
import java.util.Arrays;

public class Find2ndLargest {

	private int solve(ArrayList<Integer> A) {

		int largest = Integer.MIN_VALUE;
		int largest2nd = Integer.MIN_VALUE;
		
		for(int a : A) {
			if(a > largest) {
				largest = a;
			}
			largest2nd = Math.min(largest, a);
		}
		
		for(int a : A) {
			if(a !=largest) {
				if(a > largest2nd) {
					largest2nd = a;
				}
			}
		}
		
		System.out.println("Abc>>:"+largest2nd);		
		return largest;
	}

	public static void main(String[] args) {

		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(12, 15, 8, 9, 10));

		Find2ndLargest find2ndLargest = new Find2ndLargest();
		int result = find2ndLargest.solve(inputArray);
		System.out.println(result);
	}

}
