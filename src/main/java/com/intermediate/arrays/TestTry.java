package com.intermediate.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestTry {

	public static void main(String[] args) {
		
		int k = 29142408;
		System.out.println(Integer.MAX_VALUE);

		// Enter data using BufferReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		String name;
		try {
			//name = reader.readLine();
			
			int[] array = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int[] timesarray = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			Collections.addAll(list, Arrays.stream(array).boxed().toArray(Integer[]::new));
			
			int times = timesarray[0];
			
			for(int i=0;i<array.length;i++) {
				System.out.println(array[i]);
			}
			
			//int times = timesarray[0];
			System.out.println(times);
			
			// Printing the read line
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
