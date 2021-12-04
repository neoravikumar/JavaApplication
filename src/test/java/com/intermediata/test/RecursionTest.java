package com.intermediata.test;

import org.omg.Messaging.SyncScopeHelper;

import java.util.Arrays;

public class RecursionTest {

    public void solve(int n){
        if(n<=1) return;
        System.out.println(n);
        solve(n-1);
        System.out.println(n);
        solve(n/2);
        System.out.println(n);
    }

    public void callByValueCallByRefernce(Integer n, int[] an){

        System.out.println("N in method:>"+n);
        n = n +1;
        System.out.println("Arrays N:>"+ Arrays.toString(an));
        an[0] = 100;
    }

    public static void main(String[] args) {

        RecursionTest recursionTest = new RecursionTest();
        //recursionTest.solve(4);
        int[] aN = {10, 20, 30};
        Integer n = new Integer(4);
        recursionTest.callByValueCallByRefernce(n,aN);
        System.out.println("Call By Value: n in main method:>>"+n);
        System.out.println("Call By reference: aN in main method:>>"+Arrays.toString(aN));

    }
}
