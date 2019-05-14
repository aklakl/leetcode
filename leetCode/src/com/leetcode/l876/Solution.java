package com.leetcode.l876;

import com.others.datastructure.node.ListNode;

//876. Middle of the Linked List
/*
876. Middle of the Linked List
Easy

450

34

Favorite

Share
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Note:

The number of nodes in the given list will be between 1 and 100.
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution execution = new Solution();
		execution.testingStart();
		System.out.println("=========================================");
	}
	
	public  void testingStart() {
		int[] arrays = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};  //Expected[1,2,3,4,6,5,1,9]
		//int[] arrays = {1,2,3,4,5};
		ListNode listNodeResult = null;
		int n = 6;
		ListNode  result = middleNode(ListNode.arrayToListNode(arrays));
		System.out.println("middleNode="+result);
	 
		
	}
	//tricks(fast slow) solution :https://www.youtube.com/watch?v=UitXxwVeOrk&feature=youtu.be
	public ListNode middleNode(ListNode head) {
		System.out.println("input|head="+head);
		if (head == null) return head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            System.out.println("fast="+fast+"|slow="+slow);
        }
        return slow;
    }
	
	//mu solution easy
    public ListNode middleNode1(ListNode head) {
        System.out.println("head="+head);
        int count = 0 ;
        ListNode curr = head;
        while(curr!= null) {
        	curr = curr.next;
        	count++;
        }
        curr = head;
        for(int i = 0; i <count/2;i++) {
        	curr = curr.next;
        }
        System.out.println(count+"|head="+head+"|curr"+curr);
        return curr;
    }

}
