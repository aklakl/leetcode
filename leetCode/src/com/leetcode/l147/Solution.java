package com.leetcode.l147;

import com.others.datastructure.node.ListNode;

/*
147. Insertion Sort List
Medium

335

396

Favorite

Share
Sort a linked list using insertion sort.


A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution execution = new Solution();
		execution.testingStart();
		System.out.println("=========================================");
	}
	
	public void testingStart() {
		int[] arrays = {8,4,6,9,0,2,1,3,7,5};  //Expected {1,2,2,3,4,5,6,2,7,8,9,0}; 
		//int[] arrays = {1};  //Expected {1,2,2,3,4,5,6,2,7,8,9,0}; 
		ListNode result = insertionSortList(ListNode.arrayToListNode(arrays));
		System.out.println("insertionSortList="+result);
		
		/*
		result = sortList(ListNode.arrayToListNode(arrays));
		System.out.println("sortList="+result);
	 
		result = sortList1(ListNode.arrayToListNode(arrays));
		System.out.println("sortList1="+result);
		
		result = sortListInsertion(ListNode.arrayToListNode(arrays));
		System.out.println("sortListInsertion="+result);
		*/
		
	}
	//==========================================================
	//5,4,3,2,1
    public ListNode insertionSortList(ListNode head) {
    	if (head == null ) return head;
    	ListNode result = null;
    	ListNode pre = null;
    	ListNode curr = head.next;
    
    	while(curr != null) {
    		ListNode next = curr.next;
    		if (pre != null && curr.val < pre.val)
    			insertBeforeThisValue(head,curr);
    			//pre = insertBeforeThisValue(pre,curr);
    			//pre = pre.next;
    		curr = next;
    		System.out.println("curr="+curr.val);
    	}
    	
    	return head;
    }
    
    public ListNode insertBeforeThisValue(ListNode mainList,ListNode current ) {
    	ListNode cur = mainList;
    	while(cur != null) {
    		//if cur.
    		//cur = cur.next;
    	}
    	
    	return mainList;
    }
	
}
