package com.leetcode.l206;

import java.util.Stack;

import com.others.datastructure.node.ListNode;

/*
206. Reverse Linked List
Easy

2160

60

Favorite

Share
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
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
		
		result = reverseListNodeWithRecursion(ListNode.arrayToListNode(arrayListNode1));
		System.out.println("reverseListNodeWithRecursion="+result);
		System.out.println("==========================================");
		
		
		
		System.out.println("testing=end");
		
	}

	
	
	//==================================================================================================
	//https://www.geeksforgeeks.org/reverse-a-linked-list/
	//recursion solution  https://www.cs.cmu.edu/~pattis/15-1XX/15-200/lectures/llrecursion/index.html
	//1,2,3,4,5,6 this is a little hard to understand
	public ListNode reverseListNodeWithRecursion(ListNode input) {
		//System.out.println("reverseListNodeWithCecursion|input="+input);
		//System.out.println("1input="+input.toString1());
		if (input == null || input.next == null) return input;
		ListNode newNode = reverseListNodeWithRecursion(input.next);
		//System.out.println("2newNode="+newNode.toString1());
		// change references for middle chain 
		input.next.next = input;
		input.next = null;
		//System.out.println("3newNode="+newNode.toString1());
		// send back new head node in every recursion 
		return newNode ;
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