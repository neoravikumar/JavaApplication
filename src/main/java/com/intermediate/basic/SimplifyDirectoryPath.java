package com.intermediate.basic;

import java.io.File;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*Simplify Directory Path
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
    "/c"*/
public class SimplifyDirectoryPath {

	public String simplifyPath(String A) {

		Deque<String> stack = new LinkedList<>();
		Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
		for (String dir : A.split("/")) {
			if (dir.equals("..") && !stack.isEmpty())
				stack.pop();
			else if (!skip.contains(dir))
				stack.push(dir);
		}
		String res = "";
		for (String dir : stack)
			res = "/" + dir + res;
		return res.isEmpty() ? "/" : res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
