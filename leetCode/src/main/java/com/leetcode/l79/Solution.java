package com.leetcode.l79;



public class Solution {
	public static void main(String[] arg) {
		Solution execution = new Solution();
		execution.testSolution();
		System.out.println("============================");
		
		String[][] strings = {{"a","a"}};
		int r = strings[0].length+strings.length;
		System.out.println(r);
		System.out.println("============================");
	}

	public void testSolution() {
		System.out.println("testSolution");
		int i = 0;
		while (i<999) {
			boolean flag = false;
			if (flag) System.out.println("isHappy(i)="+i);
						//System.out.println("getSquareSumOfDigits(i)="+s);
			i++;
		}
	}
	
    public boolean exist(char[][] board, String word) {
        if (board.length ==0  || word.length()==0) return false; //defensive coding
        //if (word.length() >= board[0].length+board.length ) return false;
        for(int row =0;row<board.length; row++){
            for(int col =0; col<board[row].length;col++){
                if ( word.charAt(0)==board[row][col] && searchLetter(board,row,col,word,0) ){//fist half to save some search; index is for word
                    System.out.println("true");
                    return true;
                }
            }
        }
        return false; 
    }
    
    public boolean searchLetter(char[][] board,int row, int col, String word,int index){
        //found the last char
        if (index == word.length()){
        	//System.out.println("char="+word.charAt(index)+"|i="+index+"|row="+row+"|col="+col+"|value="+board[row][col]);
            return true; 
        } 
        
        if ( row < 0 || row >= board.length ) return false;
        if ( col < 0 || col >= board[row].length ) return false;
        if ( index < 0 || index >= word.length() ) return false;
        if (word.charAt(index) != board[row][col] ) return false;
        char cur = board[row][col];
        board[row][col] = '*';//or we can do borad[row][col]^=255, to make it not a valid letter
        boolean found = searchLetter(board,row-1,col,word,index+1) 
            || searchLetter(board,row+1,col,word,index+1) 
            || searchLetter(board,row,col-1,word,index+1) 
            || searchLetter(board,row,col+1,word,index+1);
        board[row][col] = cur ;//recover by doing borad[row][col]^=255
        
        return found; 
        
    } 
    
	

}
