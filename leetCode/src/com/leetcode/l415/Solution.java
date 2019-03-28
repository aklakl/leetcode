package com.leetcode.l415;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String string1 = "3876620623801494171";
		String string2 = "6529364523802684779";
	
		string1 = solution.addStrings(string1,string2);
		System.out.println("result = "+string1);
		
	}
	
	//Runtime: 66 ms, faster than 5.13% of Java online submissions for Add Strings.
	//Memory Usage: 38.2 MB, less than 65.60% of Java online submissions for Add Strings.
	public String addStrings(String num1, String num2) {
	    int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
	    StringBuilder sb = new StringBuilder();
	    while(i >= 0 || j >= 0 || carry != 0) {
	        if(i >= 0) carry += num1.charAt(i--) - '0';
	        if(j >= 0) carry += num2.charAt(j--) - '0';
	        System.out.println("i="+i+" |j="+j+" |carry="+carry);
	        sb.append(carry % 10); // after add get the last digit remainder
	        carry /= 10;  //after add get the ten digits(first digit),
	    }
	    return sb.reverse().toString();
	}
	
	
}
