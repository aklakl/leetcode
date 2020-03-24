package com.iv.i20190325test;

import java.util.Stack;

public class TestRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pow(31);
		pow(32);
		String string = "2^3-1";
		testing(string);
		testingCalactor();
	}
	
	
	public static void pow(int square){
		System.out.println("square="+square);
		double d = Math.pow(2, square);
		long l  = (long)Math.pow(2, square);
		int i  = (int)Math.pow(2, square);
		System.out.println("d="+d+"|l="+l+" |i="+i+" |intmax="+Integer.MAX_VALUE+"|longmax="+Long.MAX_VALUE);
	}

	public static double testingCalactor(){
		double d =  5.0/3;
		System.out.println("d="+d);
		return d;
		
	}
	
	public static int testing(String string){
		System.out.println("square="+string);
		int len = string.length();
		if(string == null ||  len ==0 ) return 0; //defensive
		Stack<Integer> stack = new Stack<Integer>();
		int lastNum = 0;
		char opt = '+';
		for(int i=0; i<len;i++) {
			char c = string.charAt(i);
			if (Character.isDigit(c)) {
				lastNum = 0*10 + c-'0';
				//stack.push(lastNum);
			}
			if ((!Character.isDigit(c) && c != ' ') || i == len-1 ) {
				if (opt=='^') {
					Integer pre = stack.pop();
					stack.push((int) Math.pow(pre, lastNum) );
				}else if (opt=='-') {
					stack.push(-lastNum);
				}else if (opt=='+') {
					stack.push(lastNum);
				}
				opt = c;
				lastNum = 0;
			}
			
		}
		lastNum = 0;
		for(int s :stack) {
			lastNum +=s;
		}
		System.out.println("lastNum="+lastNum);
		return lastNum;
		
		
 
	}
	
	
	
	
}
