package com.intermediate.arithmetic.combinatorics;

/**
 Sorted Permutation Rank with Repeats
Problem Description

Given a string A, find the rank of the string amongst its permutations sorted lexicographically. Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations. Look at the example for more details.

NOTE:

The answer might not fit in an integer, so return your answer % 1000003 where 1000003 is a prime number.
String A can consist of both lowercase and uppercase letters. Characters with lesser ascii value are considered smaller i.e. 'a' > 'Z'.


Problem Constraints
1 <= len(A) <= 1000000



Input Format
First argument is a string A.



Output Format
Return an integer denoting the rank.



Example Input
Input 1:

 A = "aba"
Input 2:

 A = "bca"


Example Output
Output 1:

 2
Output 2:

 4


Example Explanation
Explanation 1:

 The order permutations with letters 'a', 'a', and 'b' :
    aab
    aba 
    baa
 So, the rank is 2.
Explanation 2:

 The order permutations with letters 'a', 'b', and 'c' :
    abc
    acb 
    bac
    bca
    cab
    cba
 So, the rank is 4.
 */



/*
 long long fact(int n){
    long long f=1; 
    for(int i=2;i<=n;i++){
        f = (f*i)%1000003;
    }
    return f;
}
long long power(long long x,long long y,long long mod){
    long long res=1; 
    while(y){
        if(y&1) res = (res*x)%mod; 
        y>>=1; 
        x = (x*x)%mod;
    }
    return res;
}

int Solution::findRank(string s) {
    int n = s.size(); 
    long long mod = 1000003;
    long long ans = 1; // As we have to add 1 to get rank. 
    for (int i = 0; i < n; i++) { 
        long long less_than = 0; 
        for (int j = i + 1; j < n; j++) { 
            if ((int)s[i] > (int)s[j]) { 
                less_than += 1; 
            } 
        } 
        vector<int> freq(52, 0); 
        for (int j = i; j < n; j++) { 
            if(s[j]>='A' && s[j]<='Z')
                freq[s[j]-'A'] += 1;
            else
                freq[s[j] - 'a' + 26] += 1; 
        } 
        long long denominator = 1; 
        for (long long ele : freq) {
            denominator = (denominator*fact(ele))%mod; 
        }
        
        long long inverse = power(denominator,mod-2,mod); // inverse = (1/denominator)%mod
        
        long long permutation = (fact(n-i-1) * inverse) % mod;
        long long total_permutation = (less_than * permutation) % mod;
        
        ans = (ans + total_permutation)%mod; 
    } 
    return ans; 
}
 */
public class SortedPermutationRankWithRepeats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
