package com.practice.recurssion;

public class Fibonacci {

    public static int getnthTermfib(int n){
        if(n == 1 || n == 2){
            return 1;
        }else{
            return getnthTermfib(n-1) + getnthTermfib( n - 2);
        }
    }

    public static void main(String[] args) {
        int result = getnthTermfib(6);
        System.out.println(result);

    }

}
