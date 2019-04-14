package com.leetcode.l24;

import com.others.datastructure.node.ListNode;

/*

24. Swap Nodes in Pairs(Medium)

Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.


Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution execution = new Solution();
		execution.testingStart();
		System.out.println("=========================================");
	}
	
	public  void testingStart() {
		int[] arrays = {1,2,3,4,5,6,7,9,0,1,2,3,4,5,6,7,8,9};
		ListNode listNodeResult = null;
		
		listNodeResult = swapPairs(ListNode.arrayToListNode(arrays));
		System.out.println("swapPairs="+listNodeResult);
	 
		//listNodeResult = swapPairs_good(listNode1,listNode2); 
		//System.out.println("swapPairs_good="+listNodeResult);
		
		
	}

	private void testingTwoLists(ListNode listNode1, ListNode listNode2) {
		System.out.println("testing=begin");
		ListNode tmpListNode = listNode1;
		System.out.println("tmpListNode="+tmpListNode);
		//listNode1.val = 3;	//this can be change the tmpListNode
		//listNode1.next = new ListNode(0);	//this can be change the tmpListNode
		listNode1 = null;		//this cann't change the tmpListNode
		
		System.out.println("tmpListNode="+tmpListNode);
		
		System.out.println("testing=end");
	}

	
	
	//==================================================================================================
	
	
	//my solution
	public ListNode swapPairs(ListNode head) {
		//if (head == null) return head;
		ListNode temp = null;
		ListNode curr = head;
		ListNode prev = null ;
		ListNode tail = null ;
		
		while(curr!= null) {
			//1,2,3,4,5,6
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			
			//prev = curr.next; 
			
			
			/*
			tail = cur.next.next;
			temp = cur.next;
			cur.next = new ListNode(cur.val);	
			cur.next.next =tail;
			cur = temp;
			*/
			
			System.out.println("head="+head+"|last="+tail+"|prev="+prev);
			//System.out.println("head="+head+"|last="+tail);
		}
		return prev;
    }
	
	
	
}
