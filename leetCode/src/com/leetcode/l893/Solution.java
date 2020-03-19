package com.leetcode.l893;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/*
893. Groups of Special-Equivalent Strings
Easy

142

607

Favorite

Share
You are given an array A of strings.

Two strings S and T are special-equivalent if after any number of moves, S == T.

A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].

Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.

Return the number of groups of special-equivalent strings from A.

 

Example 1:

Input: ["a","b","c","a","c","c"]
Output: 3
Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
Example 2:

Input: ["aa","bb","ab","ba"]
Output: 4
Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
Example 3:

Input: ["abc","acb","bac","bca","cab","cba"]
Output: 3
Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
Example 4:

Input: ["abcd","cdab","adcb","cbad"]
Output: 1
Explanation: 1 group ["abcd","cdab","adcb","cbad"]
 

Note:

1 <= A.length <= 1000
1 <= A[i].length <= 20
All A[i] have the same length.
All A[i] consist of only lowercase letters.
Accepted
14,513
Submissions
23,274
 */
public class Solution {
	public static void main(String[] arg) {
		Solution execution = new Solution();
		execution.testSolution();
		System.out.println("============================");
		
		
		System.out.println("============================");
	}
	
	//https://zhuanlan.zhihu.com/p/46651766
	
	public void testSolution() {
		System.out.println("testSolution");
		//String[] input = {"a","b","c","d"}; //except 4
		//String[] input = {"a","b","c","a","c","c"};
		//{"c","b","a","a","c","c"}; acc,bac
		//String[] input = {"abcd","cdab","adcb","cbad"};
		String[] input = {"a","b","c","a","b","c","b"};
		int result = numSpecialEquivGroups2(input);
		System.out.println("input="+input+"|result = "+result);
		
		//{"c","a","a","b","c","c"};
		
	}
	
	//
    public int numSpecialEquivGroups1(String[] A) {
        
    	return 0;
    }
    
    public int numSpecialEquivGroups2(String[] A) {
        Set<String> groups = new HashSet<>();
        for (String a: A) {
          char[] odd = new char[(a.length() + 1) / 2];
          char[] even = new char[(a.length() + 1) / 2];
          for (int i = 0; i < a.length(); ++i) {
            if (i % 2 == 0)
              even[i / 2] = a.charAt(i);
            else
              odd[i / 2] = a.charAt(i);          
          }
          Arrays.sort(odd);
          Arrays.sort(even);
          String s = new String(odd) + new String(even);
          System.out.println("s = "+s +"|odd="+odd+"|even="+even.toString());
          groups.add(s);
        }
        System.out.println("groups = "+groups.toString());
        return groups.size();
	}
    
    
    public int numSpecialEquivGroups(String[] A) {
        Set<String> strSet = new HashSet<>();
        for (String tmp : A) {
            strSet.add(strHash(tmp));
        }
        return strSet.size();
    }

    private String strHash(String tmp) {
        if (tmp.length() == 1) return tmp;
        int[] cArr = new int[52];
        int odd = 0;
        for (char c : tmp.toCharArray()) {
            cArr[(odd++ % 2 == 0 ? 26 : 0) + c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : cArr) {
            sb.append(i);
        }
        return sb.toString();
    }

}
