package com.leetcode.l227;

import java.util.Objects;
import java.util.Stack;

//227. Basic Calculator II
public class Solution {
	public static void main(String[] arg) {
		Solution execution = new Solution();
		execution.testSolution();
		System.out.println("============================");
		
		System.out.println("============================");
	}

	public void testSolution() {
		System.out.println("testSolution");
		String string = " 30+5 / 2 ";
		//string = "10 * 2 + 6 / (3 - 1)";
		//string = "1*2-3/4+5*6-7*8+9/10";
		int result = calculate(string);
		System.out.println("result="+result);
	}
	
	public int calculate(String s) {
		int len;
		if (s == null || (len = s.length())==0) return 0;
		int lastNum = 0;
		char opt = '+';
		Stack<Integer> stack = new Stack<Integer>() ; 
		for(int i = 0; i<len; i++) {
		
			if (Character.isDigit(s.charAt(i))) {
				lastNum = lastNum*10 +s.charAt(i) -'0';
				continue;
			}
			if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len-1) {
				if (opt == '-') {
					stack.push(-lastNum);
				}else if(opt == '+') {
					stack.push(lastNum);
				}else if(opt == '*') {
					stack.push(stack.pop()*lastNum);
				}else if(opt == '/') {
					stack.push(stack.pop()/lastNum);
				}else {
					System.out.println("error.opt="+opt);
					continue;
				}
				opt = s.charAt(i);
				lastNum = 0;
			}
			
		
		}
		
		lastNum = 0;
		while(!stack.isEmpty()) {
			lastNum += stack.pop();
		}
		return  lastNum;
	}
	
	
	
	
	public int calculate1(String s) {
		int len;
		if (s == null || (len = s.length()) == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				System.out.println("s="+s.charAt(i));
				num = num * 10 + s.charAt(i) - '0';//here num* 10 is the decimal
				//num = Integer.parseInt(Objects.toString(s.charAt(i)));
				System.out.println("num="+num);
			}
			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
				if (sign == '-') {
					stack.push(-num);
				}
				if (sign == '+') {
					stack.push(num);
				}
				if (sign == '*') {
					stack.push(stack.pop() * num);
				}
				if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = s.charAt(i);
				num = 0;
			}
		}

		int re = 0;
		for (int i : stack) {
			re += i;
		}
		return re;
	}
}
