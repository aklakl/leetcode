package com.leetcode.l657;



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
		boolean result = judgeCircle(input);
		System.out.println("input="+input+"|result = "+result);
	}
	
	
   	//MYSOLUTION
	public boolean judgeCircle_mysolution(String moves) {
        int rcount = 0;
        int lcount = 0;
        int ucount = 0;
        int dcount = 0;
        int ocount = 0;
        for(int i=0;i<moves.length();i++){
            switch(moves.charAt(i)) {
                case 'R':
                    rcount++;
                    break;
                case  'L':
                    lcount++;
                    break;
                case  'U':
                    ucount++;
                    break;
                case  'D':
                    dcount++;
                    break;
                default : 
                    ocount++;
            }
        }
        return (rcount - lcount == 0) && (ucount - dcount ==0);
    }
	
	 public boolean judgeCircle(String moves) {
	        int x = 0;
	        int y = 0;
	        for (char ch : moves.toCharArray()) {
	            if (ch == 'U') y++;
	            else if (ch == 'D') y--;
	            else if (ch == 'R') x++;
	            else if (ch == 'L') x--;
	        }
	        return x == 0 && y == 0;
	}


}
