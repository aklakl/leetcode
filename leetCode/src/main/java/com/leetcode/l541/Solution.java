package com.leetcode.l541;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String string = "abcdefghigklmn"; //bacdfeghgiklnm
		int k = 2;
		string = solution.reverseStr(string,k);
		System.out.println("result = "+string);
		
		System.out.println("=============================");
		string = solution.testingReverseStr(string);
		System.out.println("testingReverseStr = "+string);
	}
	
	//testing for reverseStr via recursion like a stack
	public String testingReverseStr(String s) {
		System.out.println("execution in  stack | s="+s +"|c="+s.charAt(0));
		if (s == null || s.length() <= 1) return s;
		String r =  testingReverseStr(s.substring(1)) + s.charAt(0);
		System.out.println("execution out stack | r="+r );
		return r;
	}

	// my solution
	public String reverseStr(String s, int k) {
		if (s == null || s.length() <= 1)
			return s;
		if (s.length() < k)
			return reverseloop(s);
		if (s.length() <= 2 * k)
			return reverseloop(s.substring(0, k)) + s.substring(k, s.length());
		return reverseStr(s.substring(0, 2 * k), k) + reverseStr(s.substring(2 * k, s.length()), k);

		/*
		// System.out.println("s1="+s.substring(2*k,s.length())+"|s2="+s.substring(0,2*k));
		// return
		// reverseStr(s.substring(0,2*k),k)+reverseStr(s.substring(2*k,s.length()),k);
		String result = "";
		for (int i = 0; i < s.length(); i = i + 2 * k) {
			System.out.println(i);
			if (2*k+i>s.length()) {
				result += s.substring(i,s.length()) ;
				break;		
			}
			System.out.println(i + "s1=" + s.substring(i, i+k) + "|s2=" + s.substring(i+k, 2 * k+i));
			result += reverseloop(s.substring(i,i+k)) + s.substring(i+k,2 * k+i);
		}
		return result;
		*/
	}

	public String reverseloop(String s) {
		if (s == null || s.length() <= 1)
			return s;
		char[] cs = s.toCharArray();
		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			char c = cs[i];
			cs[i] = cs[j];
			cs[j] = c;
		}
		return new String(cs);
	}

	// my solution 20190327
	public String reverseStr1(String s, int k) {
		if (s == null || s.length() <= 1)
			return s;
		if (s.length() < k)
			return reverse(s);
		if (s.length() <= 2 * k)
			return reverse(s.substring(0, k)) + s.substring(k, s.length());
		// System.out.println("s1="+s.substring(2*k,s.length())+"|s2="+s.substring(0,2*k));
		return reverseStr(s.substring(0, 2 * k), k) + reverseStr(s.substring(2 * k, s.length()), k);
	}

	public String reverse(String s) {
		if (s.isEmpty())
			return "";
		return reverse(s.substring(1, s.length())) + s.charAt(0);
	}

}
