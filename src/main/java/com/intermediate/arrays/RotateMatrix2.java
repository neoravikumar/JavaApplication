package com.intermediate.arrays;

public class RotateMatrix2 {

	public void solve(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return;
        }
 
        int N = mat.length;
 
        // Transpose the matrix
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < i; j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
 
        // swap columns
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N / 2; j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[i][N - j - 1];
                mat[i][N - j - 1] = temp;
            }
        }
        
        printMatrix(mat);
	}

	private void printMatrix(int arr[][])
	{
		int N = arr.length;
	    for (int i = 0; i < N; i++)
	    {
	        for (int j = 0; j < N; j++) {
	        	System.out.print( arr[i][j] + " ");
		        System.out.println();
	        }
	        
	    }
	}
	
	public static void main(String[] args) {
		
		RotateMatrix2 rotateArix2 = new RotateMatrix2();
		int[][] A = {{1, 2},{3,4}};
		rotateArix2.solve(A);

	}

}
