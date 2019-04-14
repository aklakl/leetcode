package com.leetcode.l21;

import com.others.datastructure.node.ListNode;

/*
21. Merge Two Sorted Lists
Easy

2086

286

Favorite

Share
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
Accepted
549,717
Submissions
1,180,188
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution execution = new Solution();
		execution.testingStart();
		System.out.println("=========================================");
	}
	
	public  void testingStart() {
		//int[] arrayListNode1 = {1,2,4,5};
		//int[] arrayListNode2 = {1,3,4,5};
		int[] arrayListNode1 = {1,1,1,1,2,5,6};
		int[] arrayListNode2 = {1,3,7,8};
		int len = arrayListNode1.length > arrayListNode2.length ? arrayListNode1.length : arrayListNode2.length;
		
		ListNode listNode1 =null;
		ListNode listNode2 =null;
		ListNode listNode1Last = null;
		ListNode listNode2Last = null;
		for(int i = 0; i <len; i++ ) {
			
			if (i < arrayListNode1.length) {
				ListNode newNode = new ListNode(arrayListNode1[i]);
				if (listNode1 == null) {
					listNode1 = newNode; 
					listNode1Last = newNode;
				}else {
					listNode1Last.next = newNode;
					listNode1Last = newNode;
				}
			}

			if (i < arrayListNode2.length) {
				ListNode newNode = new ListNode(arrayListNode2[i]);
				if (listNode2 == null) {
					listNode2 = newNode; 
					listNode2Last = newNode;
				}else {
					listNode2Last.next = newNode;
					listNode2Last = newNode;
				}
			}
			
		}
		
		System.out.println("listNode1="+listNode1);
		System.out.println("listNode2="+listNode2);
		testingTwoLists(listNode1,listNode2);
		
		ListNode listNodeResult = mergeTwoLists(listNode2,listNode1);
		System.out.println("mergeTwoLists="+listNodeResult);
	 
		//listNodeResult = mergeTwoLists_good(listNode1,listNode2); 
		//System.out.println("mergeTwoLists_good="+listNodeResult);
		
		listNodeResult = mergeTwoLists_betterSolution(listNode2,listNode1); 
		System.out.println("mergeTwoLists_betterSolution="+listNodeResult);
		
	}

	private void testingTwoLists(ListNode listNode1, ListNode listNode2) {
		System.out.println("testing=begin");
		ListNode tmpListNode = listNode1;
		System.out.println("tmpListNode="+tmpListNode);
		//listNode1.val = 3;	//this can be change the tmpListNode
		//listNode1.next = new ListNode(0);	//this can be change the tmpListNode
		listNode1 = null;		//this cann't change the tmpListNode
		
		System.out.println("tmpListNode="+tmpListNode);
		listNode1 = listNode2;
		listNode2 = tmpListNode;
		System.out.println("tmpListNode="+tmpListNode);
		System.out.println("testing=end");
	}

	
	
	//==================================================================================================
	
	//better solution(according with listNode1 //always keep order is the lower number first )
	public ListNode mergeTwoLists_betterSolution(ListNode l1, ListNode l2) {
		if (l1 == null || l2 ==null) return l1!= null ? l1 : l2;
		System.out.println("l1="+l1+"|l2="+l2);
		System.out.println();
		ListNode tempNode = null;
		if (l1.val > l2.val) {
			tempNode = l1;
			l1 = l2;
			l2 = tempNode;
			System.out.println("afterSwitch|l1="+l1+"|l2="+l2);
		}
		ListNode minValueNode = l1;
		while(l2 != null) {
			while(minValueNode.next != null && minValueNode.next.val <= l2.val ) 
				minValueNode = minValueNode.next;
			tempNode = minValueNode.next;
			minValueNode.next = l2;
			l2 = tempNode;
		}
		return l1;
	}
	
	
	//common solution
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 ==null) return l1!= null ? l1 : l2;
		System.out.println("l1="+l1);
		System.out.println("l2="+l2);
		ListNode tail = new ListNode(0);
		ListNode head = tail;
		ListNode tempNode = null;
		while(l1 != null && l2 !=null) {
			if (l1.val > l2.val) {
				tempNode =  new ListNode(l2.val); //l2;//
				l2 = l2.next;
			}else {
				tempNode =  new ListNode(l1.val); // l1;
				l1 = l1.next;
			}
			System.out.println("l1="+l1+"|l2="+l2);
			tail.next = tempNode;
			tail = tempNode;
		}
		tail.next = l1 != null ? l1 : l2;
		return head.next;//remove the first ListNode
	}
	
	
	//here consider about the value or the pointer(or reference,quote)
	public ListNode mergeTwoLists_good(ListNode l1, ListNode l2) {
		System.out.println("l1="+l1);
		System.out.println("l2="+l2);
		ListNode head = null;
		ListNode tail = null;
		while (l1 != null && l2 != null) {
			if(l1.val > l2.val) {
				l2 = addListNodeToHead(head,tail, l2);
				System.out.println("mergeTwoLists_good|head="+head+"|tail="+tail+"|l1="+l1+"|l2="+l2);
			}else {
				l1 = addListNodeToHead(head,tail,l1);
				System.out.println("mergeTwoLists_good|head="+head+"|tail="+tail+"|l1="+l1+"|l2="+l2);
			}	
			
		}
		while (l1 != null) {
			l1 = addListNodeToHead(head,tail,l1);
		}
		while (l2 != null) {
			l2 = addListNodeToHead(head,tail,l2);
		}
		return head;
	}
	
	public ListNode addListNodeToHead(ListNode head,ListNode tail,ListNode ln) {
		ListNode newNode = new ListNode(ln.val);
		if (head == null) {
			head = tail = ln;
		}else {
			tail.next = ln;
			tail = ln;
		}
		ln = ln.next;
		System.out.println("addListNodeToHead|ln="+ln+"|head="+head+"|tail="+tail);
		return ln;
	}
	
	
	
	// my solution not correct  _bad
	public ListNode mergeTwoLists_bad(ListNode l1, ListNode l2) {
		ListNode resultNode = null;
		ListNode lastNode = null;
		while (l1 != null || l2 != null) {
			if (lastNode == null) { // the fist ListNode 
				int minValue = l1.val >= l2.val ? l2.val : l1.val;
				int biggerValue = l1.val >= l2.val ? l1.val : l2.val;
				resultNode = new ListNode(minValue);
				lastNode = new ListNode(biggerValue);
				resultNode.next = lastNode;
			} else {
				ListNode currentBiggerNode = new ListNode(lastNode.val);
				
				if (l1 != null) {
					if (lastNode.val > l1.val) {
						currentBiggerNode = new ListNode(lastNode.val);
						lastNode.val = l1.val;
					} else {// <=
						currentBiggerNode = new ListNode(l1.val);
					}
					lastNode.next = currentBiggerNode;
					lastNode = currentBiggerNode;
				}
				
				if (l2 != null) {
					if (lastNode.val > l2.val) {
						currentBiggerNode = new ListNode(lastNode.val);
						lastNode.val = l2.val;
					} else {// <=
						currentBiggerNode = new ListNode(l2.val);
					}
					lastNode.next = currentBiggerNode;
					lastNode = currentBiggerNode;
				}

			}
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
			System.out.println("currentNode="+resultNode);
		}
		return resultNode;

	}
 
}
