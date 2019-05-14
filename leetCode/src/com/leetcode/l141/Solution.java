package com.leetcode.l141;

import java.util.HashMap;

import com.others.datastructure.node.ListNode;

/*
141. Linked List Cycle
Easy

1442

143

Favorite

Share
Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

 

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.


 

Follow up:

Can you solve it using O(1) (i.e. constant) memory?
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
		
		
		ListNode listNode1 = ListNode.arrayToListNode(arrays);
		boolean result = hasCycle(listNode1);
		System.out.println("1hasCycle="+result);
		System.out.println("===================================================");
		
		result = hasCycle(node1);
		System.out.println("2hasCycle="+result);
		System.out.println("===================================================");
		

	}
	
	//smart solution 
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast== slow) return true;
		}
		return false;
	}
	
	
	//my solution cost space complexity
	public boolean hasCycle1(ListNode head) {
		ListNode curr = head;
		HashMap<Integer, Integer> exist = new HashMap<Integer, Integer>();
        while(curr!= null) {
        	int key = curr.val;
        	if (exist.containsKey(key)) {
        		return true;
        	}else {
        		exist.put(key, key);
        	}
        	curr = curr.next;
        }
        return false;
    }

}
