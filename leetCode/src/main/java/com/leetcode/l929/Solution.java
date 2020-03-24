package com.leetcode.l929;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] arg) {
		Solution execution = new Solution();
		execution.testSolution();
		System.out.println("============================");
		
		System.out.println("============================");
	}

	public void testSolution() {
		System.out.println("testSolution");
		String[] input = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		int result = numUniqueEmails(input);
		System.out.println("input="+input+"|result = "+result);
	}
	
	
   	//20190514160000 to 20190514160700
    public int numUniqueEmails_mysolution(String[] emails) {
    	HashSet<String> count = new HashSet<String>();
    	for(String email : emails) {
    		String[] emaila = email.split("@");
    		String name  = emaila[0];
    		name = name.replace(".", "");
    		if (name.indexOf("+") >= 0) name = name.substring(0,name.indexOf("+"));
    		email = name +"@"+ emaila[1];
    		System.out.println(email);
    		count.add(email );
    	}
    	return count.size();
    }

    //https://leetcode.com/problems/unique-email-addresses/discuss/186798/Java-7-liner-with-comment.
    public int numUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>(); // used to save simplified email address, cost O(n) sapce.
        for (String email : emails) {
            String[] parts = email.split("@"); // split into local and domain parts.
            String[] local = parts[0].split("\\+"); // split local by '+'.
            normalized.add(local[0].replace(".", "") + "@" + parts[1]); // remove all '.', and concatenate '@' and domain.        
        }
        return normalized.size();
    }
}
