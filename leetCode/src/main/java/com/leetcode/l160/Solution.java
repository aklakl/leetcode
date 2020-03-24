package com.leetcode.l160;
//160. Intersection of Two Linked Lists

import com.others.datastructure.node.ListNode;

public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution execution = new Solution();
		execution.testingStart();
		System.out.println("=========================================");
	}
	
	public  void testingStart() {
		//int[] arrays = {1,2,2,3,4,5,6,2,7,8,9,0};  //Expected[1,2,3,4,6,5,1,9]
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node2;
		
		ListNode prev11 = new ListNode(11);
		ListNode prev12 = new ListNode(12);
		ListNode prev13 = new ListNode(13);
		prev11.next = prev12;
		prev12.next = prev13;
		prev13.next = node1;
		
		ListNode prev21 = new ListNode(11);
		ListNode prev22 = new ListNode(12);
		ListNode prev23 = new ListNode(13);
		//prev21.next = prev22;
		//prev22.next = prev23;
		prev21.next = node1;
		
		
		ListNode result = getIntersectionNode(prev21,prev11 );
		System.out.println("removeElements="+result);
	 
		//result = getIntersectionNode(ListNode.arrayToListNode(arrays),ListNode.arrayToListNode(arrays2)); 
		//System.out.println("removeElements2="+result);
		
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null ||headB ==null) return null;
		ListNode a = headA;
		ListNode b = headB;
		while(a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
			System.out.println(a);
			System.out.println(b);
		}
		return a;
    }
	

}
