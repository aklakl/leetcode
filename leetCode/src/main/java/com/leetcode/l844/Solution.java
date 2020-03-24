package com.leetcode.l844;

import java.util.Stack;

/*
//844. Backspace String Compare
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?

*/
public class Solution {

	public static void main(String[] args) {
		testing();
		Solution solution = new Solution();
		String s1 = "ab#c#de";
		String s2 = "ae#b#c#de";
		boolean result = solution.backspaceCompare(s1,s2);
		System.out.println("result1=" + result );
		
		//System.out.println("result2="+result[0]+" , "+result[1]);
	}
	
	public static void testing() {
		boolean result1 = false && false;
		System.out.println(result1);

		boolean b1 = true;
		boolean b2 = false;

		boolean result2 = b1 && b2;
		System.out.println(result2);
	}

	//my solution
	public boolean backspaceCompare(String S, String T) {
		char[] sc =  S.toCharArray();
		char[] tc =  T.toCharArray();
		int len = sc.length > tc.length ?  sc.length : tc.length;
		Stack<Object> stack1 = new Stack<Object>();
		Stack<Object> stack2 = new Stack<Object>();
		for(int i = 0; i<len; i++) {
			if (i < sc.length) {
				if (sc[i] =='#') {
					if (!stack1.empty()) stack1.pop();
				}else {
					stack1.push(sc[i]);
				}
			}
			if (i < tc.length) {
				if (tc[i] =='#') {
					if (!stack2.empty()) stack2.pop();
				}else {
					stack2.push(tc[i]);
				}
			}
		}
		System.out.println("sc="+sc.toString()+"|tc="+tc.toString());
		System.out.println("stack1="+stack1+"|stack2="+stack2);
		return stack1.equals(stack2);
    }

	

}
