package com.leetcode.l206;

import java.util.Stack;

import com.others.datastructure.node.ListNode;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution execution = new Solution();
		execution.testingStart();
		System.out.println("=========================================");
	}
	
	

	private void testingStart() {
		System.out.println("testing=begin");
		int[] arrayListNode1 = {1,2,3,4,5,6,7,9,0,1,2,3,4,5,6,7,8,9};
		//ListNode listNode1 =  ListNode.arrayToListNode(arrayListNode1);
		//System.out.println("listNode1="+listNode1);
		ListNode result = null;
		result = reverseListNode(ListNode.arrayToListNode(arrayListNode1));
		System.out.println("reverseListNode="+result);
		System.out.println("==========================================");
		
		//result = reverseListNodeWithStack(ListNode.arrayToListNode(arrayListNode1));
		//System.out.println("reverseListNodeWithStack="+result);
		System.out.println("==========================================");
		
		result = reverseListNodeWithCecursion(ListNode.arrayToListNode(arrayListNode1));
		System.out.println("reverseListNodeWithCecursion="+result);
		System.out.println("==========================================");
		
		
		
		System.out.println("testing=end");
		
	}

	
	
	//==================================================================================================
	//recursion solution
	public ListNode reverseListNodeWithCecursion(ListNode input) {
		System.out.println("reverseListNodeWithCecursion|input="+input);
		
		
		return input;
	}
	
	//my solution
	public ListNode reverseListNodeWithStack(ListNode head) {
		System.out.println("reverseListNode|input="+head);
		Stack<ListNode> stack = new Stack<ListNode>();
		while(head!=null) {
			stack.add(head);
			head = head.next;
		}
		ListNode result = null;
		ListNode last = null;
		for(ListNode node : stack) {
			if (result == null) {
				result = last = node;
			}else {
				last.next = node;
				last = node;
			}
		}
		return result;
	}
	
	//easy understand Solution: https://www.youtube.com/watch?v=esl_A_pzBcg
	//iterator solution
	public ListNode reverseListNode(ListNode head) {
		System.out.println("reverseListNode|input="+head);
		ListNode prev = null;
		ListNode curr = head;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			//System.out.println("prev="+prev);
			//System.out.println("curr="+curr);
			System.out.println("head="+head);
		}
		return prev;
	}
	
}	