package com.others.datastructure.mystack;

import java.util.Stack;



public class LinkedStack<T> extends Stack<T>{

	
	
	private int size = 0;
	private LinkedNode currentStack = null;
	
	
	public static void main(String[] args) {
		testArrayStack();
	}
	
	public static void testArrayStack() {
		Stack stack = new LinkedStack();
		TestStack.testQueue(stack);
	}

	@Override
	public int size() {
        return size;
    }
	
	@Override
	public boolean isEmpty() {
        return size == 0 ;
    }
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LinkedNode tempNode = currentStack;
		for(int i= 0 ; i<size();i++) {
			sb.append(tempNode.getData() + ",");
			tempNode = tempNode.getPre();
		}
		return "LinkedStack{" + "size=" + size + ", queue=" + sb.toString() + '}';
	}
	
	class LinkedNode{
		T data;
		LinkedNode pre;

		public LinkedNode(T data, LinkedStack<T>.LinkedNode pre) {
			super();
			this.data = data;
			this.pre = pre;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public LinkedNode getPre() {
			return pre;
		}
		public void setPre(LinkedNode pre) {
			this.pre = pre;
		}

		
	}

	@Override
	public T peek() {
		if (size==0) return null;
        return (T)currentStack.getData();
    }
	
	@Override
	public T push(T item) {
		//20190323-14:10 to 20190323-14:29
		LinkedNode tmpNode = new LinkedNode(item,currentStack); 
		currentStack = tmpNode;
		size++;
        return item;
    }
	
	//1,2,3,4
	@Override
	public T pop() {
		if (size ==0) return null;
		T result = (T)currentStack.getData();
		currentStack = currentStack.getPre();
		size--;
        return result;
    }
	
}
