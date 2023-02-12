package com.year2023.algo.sorting;

import java.util.Arrays;

public class SelectionSort {

    // Let's consider that, minimum element at the first index of the Array now, find the minimum element in the array and swap.

    public void selectionSortAlgo(int[] input){

        for(int i=0;i<input.length-1;i++){
            int minIndex = i;
            // find the minimum and swap
            for(int j=i+1;j<input.length;j++){
                if(input[j]<input[minIndex]){
                    minIndex=j;
                }
            }
            swap(input,i, minIndex);
        }

    }

    public void swap(int[] input, int startIndex, int minIndex){
        int temp = input[minIndex];
        input[minIndex] = input[startIndex];
        input[startIndex] = temp;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] input = {4,8, 0, 85,18,41,3,9};
        selectionSort.printArray(input, "Before");
        selectionSort.selectionSortAlgo(input);
        selectionSort.printArray(input, "After");
    }

    public void printArray(int[] input,String text){
        System.out.println(text+"\n");
        Arrays.stream(input).forEach(i -> System.out.print(i+" "));

    }


}