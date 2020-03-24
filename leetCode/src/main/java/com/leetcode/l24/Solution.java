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
		int[] arrays = {1,2,3,4,5,6,7,8,9,0};
		ListNode listNodeResult = null;
		
		listNodeResult = swapPairs(ListNode.arrayToListNode(arrays));
		System.out.println("swapPairs="+listNodeResult);
	 
		//listNodeResult = swapPairs_good(listNode1,listNode2); 
		//System.out.println("swapPairs_good="+listNodeResult);
		
	}

	
	//==================================================================================================
	
	
	//my solution
	public ListNode swapPairs(ListNode head) {
		//if (head == null) return head;
		ListNode temp = null;
		ListNode curr = head;
		ListNode prev = null ;
		ListNode tail = null ;
		ListNode result = null;
//dummy
		while(curr.next.next!= null) {
			//1,2
			//1,2,3,4,5,6 =>2,1,4,3,6,5
			ListNode next = curr.next.next;	//the next is after two number
			prev = curr.next;
			prev.next = curr;
			//prev = temp;
			prev.next.next = prev.next;
			if (result == null) {
				result = prev;
			}else {
				
			}
			prev = prev.next;
			curr = next;
			
			/*
			tail = cur.next.next;
			temp = cur.next;
			cur.next = new ListNode(cur.val);	
			cur.next.next =tail;
			cur = temp;
			*/
			
			System.out.println("head="+head+"|result="+result+"|prev="+prev);
			//System.out.println("head="+head+"|last="+tail);
		}
		return result;
    }
	
	
	
}
