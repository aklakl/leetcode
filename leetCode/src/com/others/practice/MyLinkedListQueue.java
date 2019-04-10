package com.others.practice;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import com.others.datastructure.myqueue.TestQueue;

//设计一个queue，不可以用数组，Stack，等数据结构
public class MyLinkedListQueue<T> implements Queue<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testLinedListQueue();
	}

	public static void testLinedListQueue() {
		Queue<String> queue = new MyLinkedListQueue<String>();
		TestQueue.testQueue(queue);
		
	}
	
	class LinkNode<T> {
		T data;
		LinkNode<T> next;
		
		public LinkNode(T data, LinkNode<T> next) {
			super();
			this.data = data;
			this.next = next;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public LinkNode<T> getNext() {
			return next;
		}
		public void setNext(LinkNode<T> next) {
			this.next = next;
		}
		
		
	}
	
	int size = 0;
	private LinkNode<T> head;
	private LinkNode<T> tail;
	
	@Override
	public boolean offer(T e) {
		// TODO Auto-generated method stub
		LinkNode<T> tmpNode = new LinkNode<T>(e,null);
		if (tail == null) {
			tail = tmpNode;
			head = tail;
		}else {
			tail.setNext(tmpNode);
			tail = tmpNode;
		}
		size++;
		return true;
	}

	
	@Override
	public T poll() {
		if (size==0) return null;
		T r = head.getData();
		head = head.getNext();
		size--;
		if (size==0) tail = null;
		return r;
	}
	
	@Override
	public T peek() {
		if (size==0) return null;
		return head.getData();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0 ) return true;
		return false;
	}
	
	@Override
	public void clear() {
		size = 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LinkNode temp = head;
		while (temp != null) {
			sb.append(temp.getData() + " ");
			temp = temp.getNext();
		}
		return "MyLinkedListQueue{" + "size=" + size + ", head=" + (head != null ? head.getData():"" ) + ", tail=" + (tail != null ? tail.getData() : "")
				+ ", queue=" + sb.toString() + '}';
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
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
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
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
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
