package com.others.datastructure.myqueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;

//链表实现队列
class LinkedListOtherQueue<T> implements Queue<T> {

	public static void main(String[] args) {
		testLinkedListQueue();
	}

	public static void testLinkedListQueue(){
		//System.out.println("testLinkedListQueue");
		Queue<String> queue = new LinkedListOtherQueue<String>();
		TestQueue.testQueue(queue);
	}

	 
	int size;
	QueueNode head;
	QueueNode tail;
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		QueueNode temp = head;
		while (temp != null) {
			sb.append(temp.getData() + " ");
			temp = temp.getNext();
		}
		return "LinkedListOtherQueue{" + "size=" + size + ", head=" + (head != null ? head.getData():"" ) + ", tail=" + (tail != null ? tail.getData() : "")
				+ ", queue=" + sb.toString() + '}';
	}

	private class QueueNode {
		private T data;
		private QueueNode next;

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public QueueNode getNext() {
			return next;
		}

		public void setNext(QueueNode next) {
			this.next = next;
		}
	}
	
	
    @Override
    public boolean offer(T k) {
        //System.out.println("enQueue: " + k);
        QueueNode queueNode = new QueueNode();
        queueNode.setData(k);

        if (tail==null){
            tail=queueNode;
            head=tail;
        }else {
            tail.setNext(queueNode);
            tail=queueNode;
        }
        size++;
        return true;
    }
 

	@Override
    public T poll() {
        if (size == 0) {
            return null;
        }
        T tempdata = head.getData();
        head=head.getNext();
        //System.out.println("deQueue:"+tempdata);
        size--;
        if (size==0) tail = null;
        return  tempdata;
    }

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (head==null) return null;
		return (T)head.getData();
	}

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        size = 0;
        head=null;
        tail=null;
    }

    //@Override
    public int length() {
        return size;
    }

    
    
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





}
