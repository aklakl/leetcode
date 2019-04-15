package com.leetcode.l83;

import java.util.HashMap;

import com.others.datastructure.node.ListNode;

/*
83. Remove Duplicates from Sorted List
Easy

713

78

Favorite

Share
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution execution = new Solution();
		execution.testingStart();
		System.out.println("=========================================");
	}
	
	public  void testingStart() {
		int[] arrays = {1,1,2,3,3,3,3,3,3,4,4,5,6,7,8,9,0};
		ListNode listNodeResult = null;
		
		listNodeResult = deleteDuplicates(ListNode.arrayToListNode(arrays));
		System.out.println("deleteDuplicates="+listNodeResult);
	 
		//listNodeResult = swapPairs_good(listNode1,listNode2); 
		//System.out.println("swapPairs_good="+listNodeResult);
	}
	
	//recursive solution :https://leetcode.com/problems/remove-duplicates-from-sorted-list/discuss/28625/3-Line-JAVA-recursive-solution
	public ListNode deleteDuplicates(ListNode head) {
		//System.out.println("deleteDuplicates.input="+head);
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
	}
	
	//https://leetcode.com/problems/remove-duplicates-from-sorted-list/discuss/28614/My-pretty-solution.-Java.
	public ListNode deleteDuplicates3(ListNode head) {
		ListNode list = head;
		while (list != null) {
			if (list.next == null) {
				break;
			}
			if (list.val == list.next.val) {
				list.next = list.next.next;
			} else {
				list = list.next;
			}
		}
		return head;
	}
	
	//my iterator solution only for sorted ListNode
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;
        System.out.println("deleteDuplicates.input="+head);
        ListNode curr = head;
        int lastValue = head.val;
        while(curr.next!=null){
            int value =  curr.next.val;
            if (value == lastValue){
                ListNode next = curr.next.next;
                curr.next = next;
            }else {
            	curr = curr.next;
            }
            lastValue = value ;
            //System.out.println("deleteDuplicates.runing="+head+"|curr="+curr);
        }
        //System.out.println("deleteDuplicates.end="+head);
        return head; 
    }
	
	
	//my solution using hashMap cost space complexity,but it fit any sorted or not sorted ListNode
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return head;
        //System.out.println("deleteDuplicates.input="+head);
        HashMap<Integer, Integer> existhm = new HashMap<Integer, Integer>();
        existhm.put(head.val, head.val);
        ListNode curr = head;
        while(curr.next!=null){
            int value =  curr.next.val;
            if (existhm.containsKey(value)){
            	//delete node.
            	ListNode temp = curr.next.next;
            	curr.next = temp;
            }else{
            	existhm.put(value, value);
            	curr = curr.next; 
            }
            //System.out.println("deleteDuplicates.runing="+head+"|curr="+curr);
        }
        //System.out.println("deleteDuplicates.end="+head);
        return head; 
    }

}
