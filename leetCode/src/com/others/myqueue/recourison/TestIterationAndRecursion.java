package com.others.myqueue.recourison;

/*
https://blog.csdn.net/swliao/article/details/5337896

Iteration and recursion
 */
public class TestIterationAndRecursion {
	public static void main(String[] arg) {
		TestIterationAndRecursion execution = new TestIterationAndRecursion();
		execution.testRecursion();
		System.out.println("============================");
		execution.testIteration();
		System.out.println("============================");
		execution.testIterationAndRecursionWithSum();
		System.out.println("============================");
		execution.testIterationAndRecursionWithStringReverse();
		System.out.println("============================");
		
		//execution.testIterationAndRecursionWithStringReverse();
		System.out.println("============================");
		
	}

	public  void testRecursion() {
		System.out.println("testRecursion");
		
		
	}
	
	public  void testIteration() {
		System.out.println("testRecursion");
		
		
	}
	
	public int testSumWithRecursion(int times) {
		//System.out.println("testSumWithRecursion");
		if (times == 0) return 0;
		return  times + testSumWithRecursion(--times);
		
	}
	
	public int testSumWithIteration(int times) {
		System.out.println("testSumWithIteration");
		int sum =0;
		for(int i=0;i<=times;i++) {
			sum += i;
		}
		return sum;
	}
	
	public  void testIterationAndRecursionWithSum() {
		System.out.println("testIterationAndRecursionWithSum");
		int times = 100;
		System.out.println("testSumWithRecursion = "+testSumWithRecursion(times));
		System.out.println("testSumWithIteration = "+testSumWithIteration(times));
		
	}
	
	
	
	public String testStringReverseWithRecursion(String string) {
		if (string.length() == 0) return ""; 
		return (string.substring(1, string.length())) + string.charAt(0);
		
	}
	
	public String testStringReverseWithIteration(String string) {
		System.out.println("testSumWithIteration");
		String tmp = "";
		for(int i = string.length()-1; i >=0 ;i--) {
			tmp += string.charAt(i);
		}
		return tmp;
	}
	public void testIterationAndRecursionWithStringReverse() {
		System.out.println("testIterationAndRecursionWithStringReverse");
		String string = "ABCDEFGHIGKLMN";
		System.out.println("testStringReverseWithRecursion = "+testStringReverseWithRecursion(string));
		System.out.println("testStringReverseWithIteration = "+testStringReverseWithIteration(string));
		
	}
	
	
}
