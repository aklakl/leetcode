package com.leetcode.l148;

import com.others.datastructure.node.ListNode;

//148. Sort List
/**
 * 
 * @author MingLi
 *148. Sort List
Medium

1324

69

Favorite

Share
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 */

/*
 O(n*logn) 时间排序算法，无法是 quick sort, merge sort, head sort。quick sort 需要灵活访问前后元素，适合于数组，merge sort 只需要从左到右扫过去即可，可用于列表结构。
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
		//int[] arrays = {};  //Expected {1,2,2,3,4,5,6,2,7,8,9,0}; 
		//int[] arrays = {1};  //Expected {1,2,2,3,4,5,6,2,7,8,9,0}; 
		ListNode result = findTheNodeBeforeMiddleListNode(ListNode.arrayToListNode(arrays));
		System.out.println("findTheNodeBeforeMiddleListNode="+result.toString(result));
		
		
		result = sortList(ListNode.arrayToListNode(arrays));
		System.out.println("sortList="+result.toString(result));
	 
		result = sortList1(ListNode.arrayToListNode(arrays));
		System.out.println("sortList1="+result.toString(result));
		
		result = sortListInsertion(ListNode.arrayToListNode(arrays));
		System.out.println("sortListInsertion="+result.toString(result));
		
		
	}
	//==========================================================
	
	//same logic
	/*
Break the list to two in the middle
Recursively sort the two sub lists
Merge the two sub lists
12345678901
1,2
2,4
3,6,
4,8
5,0
6,

	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null ) return head;
		
		//partition the list
		ListNode listNod1 = head;
		ListNode middleListNode = findTheNodeBeforeMiddleListNode(head);
		//System.out.println("middleListNode = " + middleListNode);
		ListNode listNod2 = middleListNode.next;	//end the head pointer
		middleListNode.next = null;
		
		//sort each list
		listNod1 = sortList(listNod1);
		listNod2 = sortList(listNod2);
		
		//merge two lists
		return mergeTwoSortedListNode(listNod1,listNod2);
	}
	
	public ListNode findTheNodeBeforeMiddleListNode(ListNode head) {
		
		ListNode faster = head;
		ListNode slower = head;
		while(faster != null && slower != null) {
			if (faster.next == null || faster.next.next == null ) {//|| 
				return slower;
			}
			faster = faster.next.next;
			slower = slower.next;
		}
		return slower;
	}
	
	public ListNode mergeTwoSortedListNode(ListNode n1, ListNode n2) {
		if (n1 == null || n2 ==null) return n1!= null ? n1 : n2;
		ListNode fakeHead = new ListNode(0);
		ListNode curr = fakeHead;
		ListNode minListNode = n1 != null ? n1 : n2 ;
		ListNode tempNode = null;
		if (n1.val > n2.val) {
			tempNode = n1;
			n1 = n2;
			n2 = tempNode;
		}
		minListNode = n1;	//find the first Node is min in (n1,n2) make a minListNode,  and switch the two n1,n2 ,
		while( n2 != null ) { //here make the n2 always is max value
			while( minListNode.next != null && minListNode.next.val <= n2.val ) {
				minListNode = minListNode.next; //move the minListNode pointer to next postion
			}
			tempNode = minListNode.next;
			minListNode.next = n2;
			n2 = tempNode;
		}
		return n1;
	}
	
	
	
	///
	public ListNode sortList1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        int nodeSum = 0;
        ListNode tmp = head;
        while(tmp!=null){
            tmp = tmp.next;
            nodeSum++;
        }
        tmp = head;
        for(int i=1; i<nodeSum/2; i++){
            tmp=tmp.next;
        }

        ListNode l1 = head; //将原链表分拆为两个子链表，分别排序然后合并
        ListNode l2 = tmp.next;
        tmp.next=null;
        System.out.println("l1 = " +l1);
        System.out.println("l2 = " +l2);
        
        ListNode result = mergeSortedListNode(sortList(l1), sortList(l2));
        return result;
    }

    public ListNode mergeSortedListNode(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cursor.next=l1;
                l1 = l1.next;
            }else{
                cursor.next=l2;
                l2=l2.next;
            }
            cursor = cursor.next;
        }
        if(l1!=null){
            cursor.next = l1;
        }else {
            cursor.next = l2;
        }
        return head.next;
    }
    

    public ListNode sortListInsertion(ListNode head) {
    	
    	return head;
    }

}
