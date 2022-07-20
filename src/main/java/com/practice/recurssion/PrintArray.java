package com.practice.recurssion;

public class PrintArray {

    static void printArrayNto1(int[] arr, int n){
        if(n==0) return ;
        System.out.println(arr[n-1]);
        printArrayNto1(arr, n-1);
    }

    static void printArray1toN(int[] arr, int a){
        if(a==arr.length) return ;

        printArray1toN(arr, a+1);
        System.out.println(arr[a]);
        /*a=0 -> 1;
        a=1 -> 2;
        a=2 -> 3;
        a=3 -> 4;
        a=4 -> 89;
        a=5 -> ( == length of the array so return)*/
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 89};
        //printArrayNto1(arr, arr.length);
        printArray1toN(arr,0);
    }
}
