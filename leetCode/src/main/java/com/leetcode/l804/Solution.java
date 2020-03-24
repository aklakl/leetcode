package com.leetcode.l804;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	public static void main(String[] arg) {
		Solution execution = new Solution();
		execution.testSolution();
		System.out.println("============================");
		
		
		System.out.println("============================");
	}

	public void testSolution() {
		System.out.println("testSolution");
		String[]  input = {"gin", "zen", "gig", "msg"};
		int result = uniqueMorseRepresentations(input);
		System.out.println("input="+input+"|result = "+result);
	}
	
	/*
	The length of words will be at most 100.
	Each words[i] will have length in range [1, 12].
	words[i] will only consist of lowercase letters.
	 */
	//my solution
    public int uniqueMorseRepresentations_mysolution(String[] words) {
    	HashMap hm = new HashMap();
    	for(String s : words) {
    		String morse = convertToMorse(s);
    		System.out.println("s="+s+"|morse="+morse);
    		hm.put(morse, morse);
    	}
    	return hm.size();
    }
    
    //uperCase A=65 to Z=90  lowerCase a=97 to z=122  |26 Character 32 http://www.asciitable.com/
    public String convertToMorse(String string) {
    	String[] morses = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    	if (string.length() == 0) return string;
    	int ascii = string.charAt(0);
    	//System.out.println(""+string.charAt(0)+"|"+ascii + "|"+(ascii-97));
    	return morses[ascii-97] + convertToMorse(string.substring(1));
    	//return string.charAt(0) + convertToMorse(string.substring(1));
    }
    
    //https://leetcode.com/problems/unique-morse-code-words/discuss/120675/C%2B%2BJavaPython-Easy-and-Concise-Solution
    public int uniqueMorseRepresentations(String[] words) {
        String[] d = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> s = new HashSet<>();
        for (String word : words) {
            String code = "";
            for (char c : word.toCharArray()) code += d[c - 'a'];
            s.add(code);
        }
        return s.size();
    }
    

}
