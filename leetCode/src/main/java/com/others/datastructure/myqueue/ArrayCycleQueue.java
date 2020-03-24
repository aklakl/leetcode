package com.others.datastructure.myqueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;

//mysolution
public class ArrayCycleQueue<T> extends ArrayLinerQueue<T>{

 
	//=========================main implement method=================

	
	public static void main(String[] args) {
		
		Queue<String> queue = new ArrayCycleQueue<String>();
		testArrayCycleQueue(queue);
	}

	public static void testArrayCycleQueue(Queue queue){


	}
	
	@Override
	public void resize() {
		Object[] newData = new Object[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;	
	}
	
	@Override
	public boolean offer(T e) {
		if (size==data.length) {
			resize();
		}
		if (head == tail && size ==0) {
			head = 0;
			tail = 0;
		}
		data[tail++] = e;
		size++;
		return true;
	}


	@Override
	public T poll() {
		// TODO Auto-generated method stub
		if (size==0)  return null;
		T result = (T)data[head++];
		data[head-1] = null;
		size--;
		if (size == 0) {
			head=0;
			tail=0;
		}
		return result;
		
	}



}
