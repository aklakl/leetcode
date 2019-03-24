package com.others.myqueue;

import java.util.Queue;
//nocorrect
public class ArrayCycleOthersQueue<T> extends ArrayLinerQueue<T> {

	public static void main(String[] args) {
		
		Queue<String> queue = new ArrayCycleOthersQueue<String>();
		ArrayCycleQueue.testArrayCycleQueue(queue);
	}
	
	@Override
	public boolean offer(T k) {
		// 判断是否需要进行数组扩容
		if (size>=data.length) resize();
		if (head == tail && head != 0) {
			resize();
		}
		if (tail >= data.length && head > 0) {
			tail = 0;
		}
		//System.out.println("enQueue: " + k);
		data[tail++] = k;
		size++;
		return true;
	}

	@Override
	public void resize() {
		//System.out.println("数组空间不够，扩容");
		Object[] temp = new Object[data.length * 2];
		for (int i = head + data.length; i < temp.length; i++, head++) {
			temp[i] = data[head];
		}
		for (int i = 0; i < tail; i++) {
			temp[i] = data[i];
		}

		data = temp;
	}

	@Override
	public T poll() {
		if (size == 0) {
			return null;
		}
		//System.out.println("deQueue:" + (T) data[head]);
		size--;
		return (T) data[head++];
	}

//原文：https://blog.csdn.net/c601097836/article/details/49883607 

}
