package com.leetcode.l86;

import com.others.datastructure.node.ListNode;

//86. Partition List
public class Solution {

	public static void main(String[] arg) {
		// TODO Auto-generated method stub
		Solution execution = new Solution();
		execution.testingStart();
		System.out.println("=========================================");
	}

	public void testingStart() {
		int[] arrays = { 1,4,2,3,2,5,2,6,7,0,2 }; // Expected {1,2,2,2,0,2,4,3,5,6,7};
		int x = 3;
		ListNode result = partition(ListNode.arrayToListNode(arrays), x);
		System.out.println("partition=" + result.toString(result));

//		result = sortList(ListNode.arrayToListNode(arrays));
//		System.out.println("sortList=" + result);
//
//		result = sortList1(ListNode.arrayToListNode(arrays));
//		System.out.println("sortList1=" + result);
//
//		result = sortListInsertion(ListNode.arrayToListNode(arrays));
//		System.out.println("sortListInsertion=" + result);

	}
	//==========================================================
	
	//my solution
	public ListNode partition(ListNode head, int x) {
		ListNode left = new ListNode(-1);	//all node < x
		ListNode leftCur = left;
		ListNode right = new ListNode(-2);
		ListNode rightCur = right;
		ListNode cur = head;
		while(cur != null) {
			if (cur.val < x) {
				leftCur.next = cur;
				leftCur = leftCur.next;
			}else {
				rightCur.next = cur;
				rightCur = rightCur.next;
			}
			cur = cur.next;
		}
		rightCur.next = null;
		leftCur.next = right.next;
        return left.next;
    }

}
