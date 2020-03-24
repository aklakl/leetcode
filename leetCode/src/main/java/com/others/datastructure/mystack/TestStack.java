package com.others.datastructure.mystack;

import java.util.Objects;
import java.util.Stack;

public class TestStack {
	//FILO
	public static void main(String[] args) {
		testStack();
		System.out.println("");
		testArrayStack();
		System.out.println("");
		testLinkListStack();
		//TestStack.testQueue(stack);
	}

	public static void testQueue(Stack stack) {
		System.out.println("CurrentStack="+stack);		
		for(int i = 0;i<6;i++) {
			stack.push("Test"+i);
		}
		System.out.println("after push 6 Test");
		System.out.println("CurrentStack="+stack);
		
		stack.pop();
		stack.pop();
		System.out.println("after pop 2 item");
		System.out.println("CurrentStack="+stack);
		
		stack.push("item1");
		System.out.println("after push 1 item");
		System.out.println("CurrentStack="+stack);
		
		String str;
		while(!stack.isEmpty() ){
			str = Objects.toString(stack.pop(),null);
			System.out.print(str+"[next=" + (!stack.isEmpty() ? stack.peek() : null) +"],");
		}
		System.out.println("after pop all item");
		System.out.println("CurrentStack="+stack);

		for(int i = 0;i<20;i++) {
			stack.push("TestTwice"+i);
		}
		System.out.println("after push  20 TestTwice");
		System.out.println("CurrentStack="+stack);
		
		stack.pop();
		stack.pop();
		System.out.println("after pop 2 item");
		System.out.println("CurrentStack="+stack);
		
		stack.push("item1");
		stack.push("item2");
		stack.push("item3");
		System.out.println("after push 3 item");
		System.out.println("CurrentStack="+stack);
		
		
		
		while(!stack.isEmpty() ){
			str = Objects.toString(stack.pop(),null);
			System.out.print(str+"[next="+ (!stack.isEmpty() ? stack.peek() : null) +"],");
		}
		System.out.println("after pop all item");
		System.out.println("CurrentStack="+stack);
		
	}
	
	
	public static void testStack() {
		System.out.println("testOriganl Stack");
		Stack stack = new Stack();
		TestStack.testQueue(stack);
		
	}
	public static void testArrayStack() {
		
	}
	public static void testLinkListStack() {
		
	}
	
}
