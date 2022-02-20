package com.intermediate.strings;

public class ZAlgorithms {

	private int[] zArray (String str) {
		int n = str.length();
		int Z[] = new int[n];
		int left = 0, right = 0;

		for (int i = 1; i < n; ++i) {
			if (i > right) {

				left = right = i;
				while (right < n && str.charAt(right - left) == str.charAt(right))
					right++;

				Z[i] = right - left;
				right--;

			} else {
				int k = i - left;
				if (Z[k] < right - i + 1)
					Z[i] = Z[k];
				else {
					left = i;
					while (right < n && str.charAt(right - left) == str.charAt(right))
						right++;

					Z[i] = right - left;
					right--;
				}
			}
		}
		return Z;
	}

	public void search(String text, String pattern) 
    { 
		int Z[] = zArray(text); 
        String concat = pattern + "$" + text; 
        int l = concat.length(); 
        for(int i = 0; i < l; ++i){ 
           if(Z[i] == pattern.length()){ 
                System.out.println("Pattern at : "
                              + ((i+1) - pattern.length() - 1)); 
            } 
        } 
    }
	
	public static void main(String[] args) {
		ZAlgorithms zalgo = new ZAlgorithms();
		String text = "xxyzxxyzwxxyzxxyzx"; 
        String pattern = "ab"; 
  
		zalgo.search(text, pattern);
	}
}
