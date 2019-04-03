package com.leetcode.l387;


//387. First Unique Character in a String
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String string1 = "3876620623801494171";
		String string2 = "bdfhaa";
	
		string1 = solution.testing();
		System.out.println("result = "+string1);
		int result = solution.firstUniqChar(string2);
		System.out.println("result = "+result);
	}
	
	//using ASCII  A=65,B=66,Y=89,Z=90,a=97,b=98,y=121,z=122
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
    
    //my solution 20190329
    public int firstUniqChar1(String s) {
        if (s == null || s.length()==0) return -1;
        int index = 0;
        boolean flag = false;
        for(int i=0; i< s.length() ;i++ ){ 
            for(int j=0; j<s.length();j++){
                if (i == j) continue;
                if (s.charAt(i) == s.charAt(j)) {
                    flag = true;
                    break;
                }else{
                    flag = false;
                }
            }
            
            if(!flag) return index = i;             
        }
        return -1;
    }
	public String testing() {
		String string = "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMN";
		int i = 0;
		while(i<string.length()) {
			int c = string.charAt(i) - 'a';
			System.out.println("c="+string.charAt(i)+"|ci="+c);
			i++;
		}
		return null;
	}
}
