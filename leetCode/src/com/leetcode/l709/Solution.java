package com.leetcode.l709;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] arg) {
		Solution execution = new Solution();
		execution.testSolution();
		System.out.println("============================");
		
		
		System.out.println("============================");
	}

	public void testSolution() {
		System.out.println("testSolution");
		String input = "ABC1,MbcdE";
		String result = toLowerCase(input);
		System.out.println("input="+input+"|result = "+result);
	}
	
	
   	//20190514145600 to 20190514151200
    public String toLowerCase1(String str) {
        int len = str.length();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<len;i++){
        	int ascii = str.charAt(i);
        	//System.out.println("str.charAt(i) = " + str.charAt(i)  + " |ascii= "+ascii ); //A=65 Z=90
//            if ( ascii >= 65 &&  ascii <= 90 ){  //26 character
//            	sb.append((char)(str.charAt(i)+32)); //Character ch1 = new Character(char);
//            }else {
//            	sb.append(str.charAt(i)); 
//            }
        	if ( str.charAt(i) >= 'A' &&  str.charAt(i) <= 'Z' ){  //26 character
        	  sb.append((char)(str.charAt(i)+32)); //Character ch1 = new Character(char);
	        }else {
	        	sb.append(str.charAt(i)); 
	        }
        }
        return sb.toString();
    }
	
    
   	//
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
        	char c = chars[i];
        	if ( c  >= 'A' &&  c  <= 'Z' ){  //26 character
        		chars[i] = (char)(c +32 ); //Character ch1 = new Character(char);
	        }
        }
        return new String(chars);
    }

}
