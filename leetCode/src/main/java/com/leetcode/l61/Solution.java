package com.leetcode.l61;

import com.others.datastructure.node.ListNode;

/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution execution = new Solution();
		execution.testingStart();
		System.out.println("=========================================");
	}
	
	public void testingStart() {
		int[] arrays = {1,2,3,4,5,6,7,8,9,0};  //Expected {1,2,2,3,4,5,6,2,7,8,9,0}; 
		//int[] arrays = {};  //Expected {1,2,2,3,4,5,6,2,7,8,9,0}; 
		//int[] arrays = {1};  //Expected {1,2,2,3,4,5,6,2,7,8,9,0}; 
		ListNode result = rotateListNode(ListNode.arrayToListNode(arrays));
		System.out.println("rotateListNode="+result.toString(result));
		
		int k = 0;
		result = rotateRight(ListNode.arrayToListNode(arrays),k);
		System.out.println("rotateRight="+result.toString(result));
	 
		//result = sortList1(ListNode.arrayToListNode(arrays));
		System.out.println("sortList1="+result);
/*		
		result = sortListInsertion(ListNode.arrayToListNode(arrays));
		System.out.println("sortListInsertion="+result);
*/	
		
	}
	//==========================================================
	//mysolution 
	//1,2,3,4,5,6,7
    public ListNode rotateRight(ListNode head, int k) {
    	if (head == null || k == 0) return head;
    	ListNode result = head;
    	ListNode cur = head;
    	int  len = 0;
    	while(cur != null) {
    		cur = cur.next;
    		len++;
    	}
        k = k % len;
        int leftCount = len - k;
    	System.out.println("len="+len);
    	cur = head;
    	int i = 1;
    	ListNode lastNodePre = null;
    	while(cur != null) {
    		if (i == leftCount-1) {
    			lastNodePre = cur.next ;
    			result = cur.next.next;
    		}
    		if (cur.next == null) {
    			lastNodePre.next = null;
    			cur.next = head;
    			break;
    		}
    		cur = cur.next;
    		i++;
    	}
    	return result;
    }
	
    //reverse ListNode
    public ListNode rotateListNode(ListNode head) {
    	//1,2,3,4,5,6
    	//2-1-
    	ListNode prev = null;
    	ListNode cur = head;
    	while(cur != null) {
    		ListNode next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
        return prev;
    }
	
	
}
