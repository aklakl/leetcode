package com.leetcode.l212;

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
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain","oaan"};
		List<String> result = findWords(board,words);
		System.out.println("result = "+result);
	}
	
	
   	//20190408105800 to 20190408112600
    public List<String> findWords(char[][] board, String[] words) {
    	List<String> result = new ArrayList<String>();
        if (board.length == 0 || words.length == 0 ) return result; //defensive coding

        for(int i = 0; i < words.length;i++){
            System.out.println(i);
            boolean flag = false;
            for(int row = 0 ;row < board.length; row++){
                for(int col =0; col < board[row].length; col++){
                    if ( board[row][col] == words[i].charAt(0) && searchLetter(board,words[i],row,col,0)){
                        result.add(words[i]);
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break ; 
                }
            }
        }
        return result;
    }
    
    //using DFS traversal  traversal
    public boolean searchLetter (char[][] board,String word,int row,int col,int index){
        //found the last char
        if(index == word.length()) return true;
        
        if (row<0 || row >= board.length || col<0 || col >= board[row].length || word.charAt(index) !=board[row][col] ) return false;
        //if (word.length() > board.length+board[row].length ) return false;
            
        
        char cur = board[row][col];
        board[row][col] = '*';
        
        boolean found = searchLetter(board,word,row-1,col,index+1) ||
                        searchLetter(board,word,row+1,col,index+1) ||
                        searchLetter(board,word,row,col-1,index+1) ||
                        searchLetter(board,word,row,col+1,index+1) ;
        board[row][col] = cur;
        return found;
    }
	

}
