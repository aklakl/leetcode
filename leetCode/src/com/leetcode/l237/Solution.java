package com.leetcode.l237;

import com.others.datastructure.node.ListNode;
/*
237. Delete Node in a Linked List
Easy

670

3162

Favorite

Share
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:



Example 1:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
Example 2:

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 

Note:

The linked list will have at least two elements.
All of the nodes' values will be unique.
The given node will not be the tail and it will always be a valid node of the linked list.
Do not return anything from your function.
Accepted
 */
//237. Delete Node in a Linked List
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution execution = new Solution();
		execution.testingStart();
		System.out.println("=========================================");
	}
	
	public  void testingStart() {
		int[] arrays = {1,2,2,3,4,5,6,6,7,8,9,0};  //Expected[1,2,3,4,6,5,1,9]
		ListNode listNodeResult = null;
		int n = 6;
		deleteNode(ListNode.arrayToListNode(arrays));
		System.out.println("deleteNode="+listNodeResult);
	 
		//listNodeResult = swapPairs_good(listNode1,listNode2); 
		//System.out.println("swapPairs_good="+listNodeResult);
		
	}
	//https://blog.csdn.net/fuxuemingzhu/article/details/51285004
	//编写一个函数删除单链表中（除末尾节点外）的一个节点，只提供待删除节点。
	//假如链表是1 -> 2 -> 3 -> 4 给你第3个节点，值为3，则调用你的函数后链表为1 -> 2 -> 4
	//==================================================================================================
	public void deleteNode(ListNode node) {
		System.out.println("input="+node);
        //System.out.println("this.head");//this.getClass().getEnclosingMethod().getName()
       //System.out.println("node.val="+node.val+"|node.next.val="+node.next.val); 
       node.val = node.next.val;
       node.next = node.next.next;
       System.out.println("end="+node);
   }

}
