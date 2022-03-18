package com.intermediate.stack;

import java.util.Stack;

/**
 Simplify Directory Path
 Simplify Directory Path
Given a string A representing an absolute path for a file (Unix-style).

Return the string A after simplifying the absolute path.

Note:

Absolute path always begin with '/' ( root directory ).

Path will not have whitespace characters.


Input Format

The only argument given is string A.
Output Format

Return a string denoting the simplified absolue path for a file (Unix-style).
For Example

Input 1:
    A = "/home/"
Output 1:
    "/home"

Input 2:
    A = "/a/./b/../../c/"
Output 2:
    "/c"
 */
public class SimplifyDirectoryPath {
	
	public String simplifyPath(String A) {
		
		Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        String[] p =A.split("/");
        for(int i=0;i<p.length;i++){
            if(!stack.isEmpty()  && p[i].equals("..")) stack.pop();
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
            	stack.push(p[i]);
        }
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
        	result.insert(0,stack.pop()).insert(0,"/");
        }
        return result.toString();
    }

	public static void main(String[] args) {
		SimplifyDirectoryPath smpdP = new SimplifyDirectoryPath();
		String result = smpdP.simplifyPath("/home/./data/");
		System.out.println(result);

	}

}
