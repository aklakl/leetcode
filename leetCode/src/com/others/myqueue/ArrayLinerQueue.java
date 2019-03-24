package com.others.myqueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


class ArrayLinerQueue<T> implements Queue<T>{


	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//==============================================================================
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size ==0;
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
        //GC
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
        head=0;
        tail=0;

	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i= 0 ; i<data.length;i++) {
			sb.append(data[i] + ",");
		}
		return "ArrayLinerQueue{" + "size=" + size + ", head=" + head + ", tail=" + tail
				+ ", queue=" + sb.toString() + '}';
	}
	
	//=========================main implement method=================
	Object[] data = new Object[3];
	int tail = 0;
	int head = 0;
	int size = 0;
	
	public static void main(String[] args) {
		testArrayLinerQueue();
	}

	public static void testArrayLinerQueue(){
		System.out.println("testArrayLinerQueue");
		Queue<String> queue = new ArrayLinerQueue<String>();
		TestQueue.testQueue(queue);
	}
	
	public void resize() {
		Object[] newData = new Object[data.length * 2];
		//for (int i = 0; i < data.length; i++) {
		for (int i = 0; i < tail; i++) {
			newData[i] = data[i];
		}
		data = newData;	
	}
	
	@Override
	public boolean offer(T e) {
		// TODO Auto-generated method stub
		if (tail>=data.length) {
			resize();
		}
		data[tail++] = e;
		size++;
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (size==0) return null;
		return (T)data[head];
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		if (head>=tail) {
			return null;
		}
		T result = (T)data[head++];
		data[head-1] = null;
		size--;
		return result;
	}


	
	
}