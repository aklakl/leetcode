package com.iv.i20190325test;

import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class Test {
	//https://coderpad.io/KRQAQZNX
	//https://coderpad.io/KW6CFWXY
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "2^3-1";
		string = "1+3+1-1";
		int result = calactor(string);
		System.out.println("result="+result);
		
		double dd = calactorWithScriptEngine(string);
		System.out.println("result-dd="+dd);
		
	}
	public static double calactorWithScriptEngine(String s) {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine execution = scriptEngineManager.getEngineByName("nashorn");
		String result = "";
		
		try {
			result = String.valueOf(execution.eval(s));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Double.parseDouble(result);
		
	}

	public static int calactor(String s){
		int len = s.length();
		if(s == null || len ==0) return 0; //Defensive coding
		int lastNum = 0;
		char opt = '+';
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i<len;i++) {
			char tmpChar = s.charAt(i);
			if (Character.isDigit(tmpChar)) {
				lastNum = lastNum * 10 + tmpChar -'0';
			}
			if ( ( !Character.isDigit(tmpChar) && tmpChar != ' ') || i == len-1) {
				if (opt =='-') {
					stack.push(-lastNum);
				}else if (opt =='+'){
					stack.push(lastNum);
				}else if (opt=='*') {
					stack.push(stack.pop()*lastNum);
				}else if (opt=='/') {
					stack.push(stack.pop()/lastNum);
				}else if (opt=='^') {
					stack.push((int)Math.pow(stack.pop(),lastNum));
				}else {
					System.out.println("error="+opt);
				}
				opt = tmpChar;
				lastNum = 0;
			}
		}
		
		int res = 0;
		for( int n : stack) {
			res +=n;
		}
		return res;
		
	}

}

/*
 * This is the Scratch Pad. The contents of this pad are synced to the other
 * participants, but are not saved. Use it ONLY for things you don't want saved
 * in the CodePair report.
 * 
 * // s = "1 + 2 "" // output 3
 * 
 * 
 * // s = "2 * 3" //output 6
 * 
 * //x [2^31, 2^31-1] //x = 2^31-1 //y = 2^31-1 //c +
 * 
 * //什么输入使得解析正常并且会抛异常？ x= 1 y= 0 c= /
 * 
 */
//foo => operation | calculate
