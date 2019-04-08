package com.leetcode.l944;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//my solution
	public int minDeletionSize(String[] A) {
    	int r = 0;
    	int len = A.length;
        int colsize = A[0].length();
    	if (len == 0) return r;
        if (colsize <= 1) return r;
        for(int col =0; col< colsize ; col++){
            char lastChar = A[0].charAt(col);
            for(int row = 1; row< len; row++){
            	char currentChar = A[row].charAt(col);
                System.out.println("lastChar="+lastChar+"("+(int)lastChar+")|current="+currentChar+"("+(int)currentChar+")");
                if (lastChar >= currentChar){
                    r++;
                    break;
                }
                lastChar = A[row].charAt(col);
            }   
        }
        return r;
        
    }
	
}
