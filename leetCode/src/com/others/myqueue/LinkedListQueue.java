package com.others.myqueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;

//链表实现队列
class LinkedListQueue<T> implements Queue<T> {

	public static void main(String[] args) {
		testLinkedListQueue();
	}

	public static void testLinkedListQueue(){
		System.out.println("testLinkedListQueue");
		Queue<String> queue = new LinkedListQueue<String>();
		TestQueue.testQueue(queue);
	}
	 

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode tempNode = head;
		while (tempNode != null) {
			sb.append(tempNode.getData() + " ");
			tempNode = tempNode.getNext();
		}
		return "LinkedListQueue{" + "size=" + size + ", head=" + (head != null ? head.getData():"" ) + ", tail=" + (tail != null ? tail.getData() : "")
				+ ", queue=" + sb.toString() + '}';
	}

	private class ListNode {
		private T data;
		private ListNode next;

		public ListNode(T data, LinkedListQueue<T>.ListNode next) {
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

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}
	}
	
	int size;
	ListNode head;
	ListNode tail;
	
	@Override
	public boolean offer(T e) {
		//12.13-12.58
		ListNode tmpNode= new ListNode(e,null);
		if(tail == null) {
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
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (size==0) return null;
		return (T)head.getData();
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		if (head == null) return null;
		T result = head.getData();
		head = head.getNext();
		size--;
		if (size == 0) {
			tail = null;
		}
		return result;
	}
	
//===============================================================================
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
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

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
