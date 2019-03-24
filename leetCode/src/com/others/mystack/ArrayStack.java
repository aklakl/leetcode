package com.others.mystack;

import java.util.Stack;


public class ArrayStack<T> extends Stack<T>{

	
	private Object[] data = new Object[3];
	private int size = 0;
	private int index = 0;
	
	
	public static void main(String[] args) {
		testArrayStack();
	}
	
	public static void testArrayStack() {
		Stack stack = new ArrayStack();
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
		for(int i= 0 ; i<data.length;i++) {
			sb.append(data[i] + ",");
		}
		return "ArrayStack{" + "size=" + size + ", index=" + index 
				+ ", queue=" + sb.toString() + '}';
	}
	
	private void resize() {
		
		Object[] newArray = new Object[data.length *2]; 
		for(int i = 0;i<data.length;i++) {
			newArray[i] = data[i];
			data[i] = null;
		}
		data = newArray;
		//System.out.println("resize,currentSize="+newArray.length);
	}
	
	@Override
	public T peek() {
        return (T)data[index-1];
    }
	
	@Override
	public T push(T item) {
		//20190323-13:23 to 20190323-13:58
		if (index >= data.length )
			resize();
		data[index++] = item;
		size++;
        return item;
    }
	
	//1,2,3,4
	@Override
	public T pop() {
		if (size ==0) return null;
		T result = (T)data[--index];
		data[index] = null;
		size--;
        return result;
    }
	
}
