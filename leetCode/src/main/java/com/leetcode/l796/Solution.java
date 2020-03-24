package com.leetcode.l796;

//796. Rotate String
/*
We are given two strings, A and B.
A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false

*/
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testing();
		Solution solution = new Solution();
		String s1 = "abcdefghij1klmn";
		String s2 = "defghij1klmnabc";
		boolean s = solution.rotateString(s1,s2);
		System.out.println("s="+s);
		
	}
	
	public static void testing() {
		boolean result1 = false && false;
		System.out.println(result1);

		boolean b1 = true;
		boolean b2 = false;

		boolean result2 = b1 && b2;
		System.out.println(result2);
	}

	// abcde cbeda
	// sample solution
	public boolean rotateString1(String A, String B) {
		return A.length() == B.length() && (A + A).contains(B);
	}

	public boolean rotateString(String A, String B) {
		int a_len = A.length();
		int b_len = B.length();
		if (a_len != b_len)
			return false;

		int i = 0, j = 0;
		while (j < b_len) {
			if (A.charAt(i) != B.charAt(j)) {
				if (i == 0) {
					j++;
				} else {
					i = 0;
				}
			} else {
				i++;
				j++;
			}
		}

		j = 0;
		while (i < a_len) {
			if (A.charAt(i) != B.charAt(j)) {
				return false;
			} else {
				i++;
				j++;
			}
		}
		return true;
	}

}
