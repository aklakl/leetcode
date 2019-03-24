package com.others.myqueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
public class TestQueue {
	//FIFO
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testDeQueue();
		System.out.println("");
		testArrayQueue();
		System.out.println("");
		testLinkListQueue();
		
	}
	/*
add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
offer       添加一个元素并返回true       如果队列已满，则返回false
poll         移除并返问队列头部的元素    如果队列为空，则返回null
peek       返回队列头部的元素             如果队列为空，则返回null
put         添加一个元素                      如果队列满，则阻塞
take        移除并返回队列头部的元素     如果队列为空，则阻塞
	*/

	
	public static void testQueue(Queue queue) {
		
		queue.offer("Test1!");
		queue.offer("Test2!");
		queue.offer("Test3!");
		queue.offer("Test4!");
		queue.offer("Test5!");
		queue.offer("Test6!");
		System.out.println(queue);
		String str;
		System.out.println("FirstPeek="+queue.peek());
		System.out.println("FirstPoll="+queue.poll());
		System.out.println(queue);
		while((str = Objects.toString(queue.poll(),null))!=null){
			System.out.print(str+"[next="+queue.peek()+"],");
		}
		System.out.println();
		System.out.println(queue);
		queue.offer("Test7!");
		queue.offer("Test8!");
		System.out.println(queue);
		while((str = Objects.toString(queue.poll(),null))!=null){
			System.out.print(str+"[next="+queue.peek()+"],");
		}
		
		System.out.println();
		System.out.println(queue);
		
		for(int i = 0 ; i<20;i++) {
			queue.offer("loop"+i);
		}
		System.out.println(queue);
		
		while((str = Objects.toString(queue.poll(),null))!=null){
			System.out.print(str+"[next="+queue.peek()+"],");
		}
		System.out.println();
		System.out.println(queue);
	}
	
	public static void testQueueSample(Queue queue){
		queue.offer("Test1!");
		queue.offer("Test2!");
		queue.offer("Test3!");
		queue.offer("Test4!");
		queue.offer("Test5!");
		queue.offer("Test6!");
		System.out.println(queue);
		System.out.println(queue.size());
		String str;
		System.out.println("FirstPeek="+queue.peek());
		
		while((str = Objects.toString(queue.poll(),null))!=null){
			System.out.print(str+"[next="+queue.peek()+"],");
		}
		
		queue.offer("Test7!");
		queue.offer("Test8!");
		
		while((str = Objects.toString(queue.poll(),null))!=null){
			System.out.print(str+"[next="+queue.peek()+"],");
		}
		
		System.out.println();
		System.out.println(queue.size());
		System.out.println(queue);
	}
	
	public static void testArrayQueue() {
		System.out.println("testArrayQueue");
		Queue queue = new ArrayDeque();
		testQueue(queue);

	}

	public static void testLinkListQueue() {
		System.out.println("testLinkListQueue");
		Queue queue = new LinkedList();
		testQueue(queue);
	}
	
	
	public static void testDeQueue() {
		ArrayDeque stack = new ArrayDeque();
		stack.push(2);
		stack.push(5);
		stack.push(7);
		stack.push(12);
		System.out.println(stack);
		/**
		 * peek()，element()该方法获�?�队列头部的元素，但是�?删除该元素。 poll()该方法也是获�?�队列头部的元素，但是删除该元素。
		 */
		System.out.println("peek=" + stack.peek());
		System.out.println(stack);
		System.out.println("pop=" + stack.pop());
		System.out.println(stack);
		System.out.println("poll=" + stack.poll());
		System.out.println(stack);
		// System.out.println("poll="+queue.poll()); //返回第一个元素，并在队列中删除
	}
}
