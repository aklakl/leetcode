package com.leetcode.l806;


/*
//806. Number of Lines To Write String
We are to write the letters of a given string S, from left to right into lines. Each line has maximum width 100 units, and if writing a letter would cause the width of the line to exceed 100 units, it is written on the next line. We are given an array widths, an array where widths[0] is the width of 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.

Now answer two questions: how many lines have at least one character from S, and what is the width used by the last such line? Return your answer as an integer list of length 2.
 

Example :
Input: 
widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S = "abcdefghijklmnopqrstuvwxyz"
Output: [3, 60]
Explanation: 
All letters have the same length of 10. To write all 26 letters,
we need two full lines and one line with 60 units.

Example :
Input: 
widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S = "bbbcccdddaaa"
Output: [2, 4]
Explanation: 
All letters except 'a' have the same length of 10, and 
"bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
For the last 'a', it is written on the second line because
there is only 2 units left in the first line.
So the answer is 2 lines, plus 4 units in the second line.
 

Note:
The length of S will be in the range [1, 1000].
S will only contain lowercase letters.
widths is an array of length 26.
widths[i] will be in the range of [2, 10].


comprehension:https://blog.csdn.net/yuweiming70/article/details/79684506
*/
public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testing();
		Solution solution = new Solution();
		int[] widths1 = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		String s1 = "bbbcccdddaaa";
		int[] result = solution.numberOfLines(widths1,s1);
		System.out.println("result1="+result[0]+" , "+result[1]);
		
		int[] widths2 = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		String s2 = "abcdefghijklmnopqrstuvwxyz";
		result = solution.numberOfLines(widths2,s2);
		System.out.println("result2="+result[0]+" , "+result[1]);
	}
	
	public static void testing() {
		boolean result1 = false && false;
		System.out.println(result1);

		boolean b1 = true;
		boolean b2 = false;

		boolean result2 = b1 && b2;
		System.out.println(result2);
	}

    public int[] numberOfLines(int[] widths, String S) {
    	int len= S.length();
    	int line = 1;
    	int width = 0;
    	int maxwidth =100;
    	int lastWidth = 0; 
    	for(int i = 0; i<len ;i++) {
    		char c = (char) (S.charAt(i) - 'a'); 
    		int indexWidth = S.charAt(i) - 'a';
    		lastWidth =  widths[indexWidth]; 
    		width +=lastWidth;
    		if (width>maxwidth) {
    			line++;
    			width = lastWidth;
    		}
    		System.out.println("char="+c +"|indexWidth="+indexWidth+"|lastWidth="+lastWidth+"|width="+width);
    	}
    	widths = new int[2];
    	widths[0] = line;
    	widths[1] = width;
    	return widths;
    }

	

}
