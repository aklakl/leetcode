package com.leetcode.l443;

import java.util.HashMap;
import java.util.Objects;

/*
//443. String Compression
 /

*/
public class Solution {

	public static void main(String[] args) {
		testing();
		Solution solution = new Solution();
		//char[] c1 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		//char[] c1 = {'a'};
		char[] c1 = {'b','l','l','l','l','l','l','4','4','W','W','&','d','d','d','@','D','D','.','.','.','8','8','8','U','V','>','J','J','k','H','H','=','l','[','[','[','[','[','[','[','a','a','"','<','[','[','y','V','l','l','"','$','E','`','v','k','E','E','t','t','t','t','t','=','=','0','C','a','l','l','l','r','R','M','M','c','c','c','A','A','S','9','9','9','9',')',')','\\','s','\\','\\','y','W','W','W','J','J','J','J','6','6','<','<','E','u','e','e','e','e','e','e','e','e','e','9','9','9','9','R','8','?','F','3','&','&','&','&','f','%','%','2','2','2',')',')',')','J','p','|','D','D','D','s','t','V','V','?','^','^','S','3','3','3','3','h','*','|','|','b','b','a','a','a','r','r','r','r','J','.','^','^','~','g',':',':',':','(','4','4','4','4','w','w','w','w','w','w','w','C','?','=','d','L',':','0','0','c','w','w','w','w','w','w','{','{','t','k','k','k','&','&','&','h','j','j','j','0','3','l',';',';',';',';',';','.','.','.','%','1','1','1','l','9','?','?','?','t','>','E','N','N','@','>','.','.','I','a','a','a','a','B','7','7','{','o','o','-','+','+','+','+','o','o','}','B','B','r','r','r','q','4','4','4','9','W','W','W','W','W','"','"','"','g','J','(','(','(','(','t','t','?',';','g','g','g','0',']',']',']'};
		int result = solution.compress(c1);
		System.out.println("result1=" + result );
		
		//System.out.println('result2='+result[0]+' , '+result[1]);
	}
	
	
	public static void testing() {
		boolean result1 = false && false;
		System.out.println(result1);

		boolean b1 = true;
		boolean b2 = false;

		boolean result2 = b1 && b2;
		System.out.println(result2);
	}
	
	public int compress(char[] chars) {
		int len = chars.length;
		int cur = 0;
		for(int i = 0,c = 0 ; i<len; i=c) { //i = j
			while(c < len && chars[c] == chars[i]) c++;
			chars[cur++] = chars[i];
			if (c - i == 1 ) continue;
			String nums = "" + (c - i);
			for(int k =0; k< nums.length();k++) {
				chars[cur++] = nums.charAt(k);	
			}
		}
		return cur;
	}

	
	//http://www.cnblogs.com/grandyang/p/8742564.html
	public int compress3(char[] chars) {
		int n = chars.length;
		int cur = 0;
	    for (int i = 0, count = 0; i < n; i = count) {
	    	System.out.println("i="+i+"|count="+count);
	        while (count < n && chars[count] == chars[i]) ++count;
	        chars[cur++] = chars[i];
	        if (count - i == 1) continue;
	        String tmps = Objects.toString(count-i);
	        for (int k=0;k < tmps.length(); k++) {
	        	chars[cur++] = tmps.charAt(k);
	        }
	    }
	    return cur;
	}
	
	//my solution incorrect
	public int compress2(char[] chars) {
		int index = 0;  //write index
		int count = 0;  //calc counts
		char lastChar = chars[0];
		chars[index] = lastChar;
		for(int i = 0 ; i < chars.length; i++) {
			if (lastChar == chars[i]) { //same char
				chars[index] = chars[i];
				count++;
			}
			if (lastChar != chars[i] || i == chars.length-1 ) {	//different char
				if (count == 1) {
					chars[++index] = chars[i];
					
				}else {
					String tmps = Objects.toString(count);
	        		int l = tmps.length();
	        		for(int j = 1; j <= l ; j++) {
	        			chars[index+j] = tmps.charAt(j-1);
	        		}
	        		index = index+l+1;
				}
				lastChar = chars[i];
				count=1;
			}
		}
		//System.out.println("chars="+chars);
		return index+1;
	}

	//my solution not correct
	//Output ["a","5","b","2"]
	//Expected ["a","3","b","2","a","2"]
    public int compress1(char[] chars) {
    	HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
         
        for(int i = 0 ; i< chars.length; i++) {
        	 if (hm.containsKey(chars[i])) {
        		 hm.put(chars[i], hm.get(chars[i])+1);
        	 }else {
        		 hm.put(chars[i], 1);
        	 }
        	 chars[i] = '#'; 
        	 
        }
        int i = 0;
        for(Character c : hm.keySet()) {
        	chars[i] = c;
        	if (hm.get(c) == 1) {
        		i++;
        	} else {
        		String tmps = Objects.toString(hm.get(c));
        		int l = tmps.length();
        		for(int j = 0; j < l ; j++) {
        			chars[i+1+j] = tmps.charAt(j);
        		}
        		i = i+l+1;
        	}
        }
        System.out.println("chars="+chars.toString());
        return i;
    }

	

}
