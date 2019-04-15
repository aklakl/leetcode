package com.leetcode.l203;


import com.others.datastructure.node.ListNode;

/*
203. Remove Linked List Elements
Easy

769

43

Favorite

Share
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution execution = new Solution();
		execution.testingStart();
		System.out.println("=========================================");
	}
	
	public  void testingStart() {
		//int[] arrays = {1,2,2,3,4,5,6,2,7,8,9,0};  //Expected[1,2,3,4,6,5,1,9]
		int[] arrays = {1,2,3,4,5}; 
		ListNode result = removeElements(ListNode.arrayToListNode(arrays),2);
		System.out.println("removeElements="+result);
	 
		result = removeElements2(ListNode.arrayToListNode(arrays),2); 
		System.out.println("removeElements2="+result);
		
	}
	
	//recursion solution: https://leetcode.com/problems/remove-linked-list-elements/discuss/57306/3-line-recursive-solution
	//so smart
	public ListNode removeElements(ListNode head, int val) {
		System.out.println("head="+head+"|val="+val);
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
        //return head;
	}
	
	//another smiler to my solution
	public ListNode removeElements2(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
//        	System.out.println("head="+head);
//            System.out.println("fakeHead="+fakeHead);
//            System.out.println("curr="+curr);
//            System.out.println("prev="+prev);
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
            
        }
        return fakeHead.next;
    }
	
	//my easy sample solution
	public ListNode removeElements1(ListNode head,int d) {
		if (head == null) return null;
		ListNode fistDumpNode = new ListNode(0);	//fake node
		fistDumpNode.next = head;
		ListNode curr = fistDumpNode;
		while(curr.next!=null) {
			int currentValue = curr.next.val;
			ListNode next = curr.next;
			if (currentValue == d ) {
				next = curr.next.next;
				curr.next = next;
			}else {
				curr = next;
			}
		}
		return fistDumpNode.next;
	}
	
	

	
	
}
