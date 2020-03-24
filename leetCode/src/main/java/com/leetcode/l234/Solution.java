package com.leetcode.l234;


import java.util.Stack;

import com.others.datastructure.node.ListNode;

/*
234. Palindrome Linked List
Easy

1519

230

Favorite

Share
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution execution = new Solution();
		execution.testingStart();
		System.out.println("=========================================");
	}
	
	public  void testingStart() {
		//int[] arrays = {1,2,2,3,4,5,6,6,7,8,9,0};  //Expected false
		//int[] arrays = {1,1,2,3,3,2,1,1}; //Expected true
		//int[] arrays = {1,0,0}; //Expected false
		int[] arrays = {1,0,1}; //Expected true
		ListNode listNodeResult = reverse(ListNode.arrayToListNode(arrays)); 
		System.out.println("reverse="+listNodeResult);
		System.out.println("=========================================");
		
		boolean result = isPalindrome_my(ListNode.arrayToListNode(arrays));
		System.out.println("isPalindrome_my="+result);
		System.out.println("=========================================");
		
		
		result = isPalindrome(ListNode.arrayToListNode(arrays)); 
		System.out.println("isPalindrome2="+result);
		System.out.println("=========================================");
		

		
		
	}
	
	
	/*
	Explanation
	..........................................................................................
	Example :
	1-> 2-> 3-> 4-> 2-> 1

	ref points 1 initially.
	Make recursive calls until you reach the last element - 1.
	On returning from each recursion, check if it is equal to ref values. 
	ref values are updated to on each recurssion.
	So first check is ref 1 -  end 1
	Second ref 2 - second last 2 ...and so on.
	..........................................................................................
	 */
	//another solution using recursion
    ListNode ref;
    public boolean isPalindrome(ListNode head) {
        ref = head;        
        return check(head);
    }
    
    public boolean check(ListNode node){
        if(node == null) return true;
        System.out.println("ref.val="+ref+"|node.val="+node);
        boolean ans = check(node.next);
        boolean isEqual = (ref.val == node.val)? true : false; 
        ref = ref.next;
        return ans && isEqual;
    }
	
    
    
    //another solution
	ListNode h;
    public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;
        if (h == null) h = head;
        boolean tmp = true;        
        if (head.next != null) tmp &= isPalindrome(head.next);
        tmp &= (head.val == h.val);
        h = h.next;
        return tmp;
    }
	
	//https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
	/*
	 This can be solved by reversing the 2nd half and compare the two halves. Let's start with an example [1, 1, 2, 1].

	In the beginning, set two pointers fast and slow starting at the head.
	
	1 -> 1 -> 2 -> 1 -> null 
	sf
	(1) Move: fast pointer goes to the end, and slow goes to the middle.
	
	1 -> 1 -> 2 -> 1 -> null 
	          s          f
	(2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
	
	1 -> 1    null <- 2 <- 1           
	h                      s
	(3) Compare: run the two pointers head and slow together and compare.
	
	1 -> 1    null <- 2 <- 1             
	     h            s
	 */
	public boolean isPalindrome1(ListNode head) {
		if (head == null || head.next == null) return true;
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
		}
		if (fast != null) { // odd nodes: let right half smaller
	        slow = slow.next;
	    }
		slow = reverse(slow);
		fast = head;
		while(slow != null) {
			if (slow.val != fast.val)
				return false;
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}
	
	//1,2,3,4
	public ListNode reverse(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		while(curr!=null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			//System.out.println("prev="+prev);
		}
		return prev;
	}
	
	public ListNode reverse2(ListNode head) {
		ListNode cur = head;
		ListNode prev = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev; // Previous node is current node's next
			prev = cur; // Current node as previous node for the next loop
			cur = next; // Advance current node pointer
		}
		return prev;

		// Why is this code not using O(1) constant of space complexity?
		// Here, I use cur, prev, next to reference datas from memory.
		// All I do is link and delink the data nodes. And it is constant space O(3) =
		// O(1) by using 3 pointers
		// What am I missing here, why reversing a singly linkedlist requires O(n) space
	}
	
	//my solution is not correct
	public boolean isPalindrome_my(ListNode head) {
		if (head == null || head.next == null) return true;
		Stack<Integer> stack = new Stack<Integer>();
		ListNode fakeNode = new ListNode(-1);
		fakeNode.next = head;
		ListNode curr = head;
		int lastValue = -1;
		boolean result = false;
		while(curr!=null) {
			if (curr.val == lastValue) {//first equals
				if (!stack.isEmpty()) stack.pop();
				result = true;
			}else {
				stack.push(curr.val);
				result = false;
			}
			lastValue =  stack.isEmpty() ? -1 : stack.peek();
			curr = curr.next;
		}
		return stack.isEmpty() && result;
    }

}
