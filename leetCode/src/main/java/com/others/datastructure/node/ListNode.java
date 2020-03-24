package com.others.datastructure.node;



public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}


	//@Override
//	public String toString() {
//		return this.toString(this);
//	}
	public String toString(ListNode node) {
		if (node == null) return "";
		StringBuilder sb = new StringBuilder();
		ListNode currentNode = node;
		int count = 0 ;
		while(currentNode!=null) {
			sb.append(currentNode.val+",");
			currentNode = currentNode.next;
			count++;
		}
		//sb.append(val+",");
		//sb.append(recursion(next));
		sb.append("size="+count);
		return sb.toString();
	}
	private int count = 1;
	private String recursion(ListNode next){
		count++;
		if (next == null) return "";
		if (next.next!= null) return next.val +"," +  recursion(next.next);
		return next.val +",";
	}
	
	static public ListNode arrayToListNode(int[] arrays) {
		ListNode result = null;
		ListNode lastNode = null;
		for(int i = 0; i < arrays.length; i++ ) {
			ListNode newNode = new ListNode(arrays[i]);
			if (result == null) {
				result = newNode; 
				lastNode = newNode;
			}else {
				lastNode.next = newNode;
				lastNode = newNode;
			}
		}
		return result;
	}
	
	static public void testingStart() {
		//int[] arrayListNode1 = {1,2,4,5};
		//int[] arrayListNode2 = {1,3,4,5};
		int[] arrayListNode1 = {1,2,3,4,5,6,7,9,0,1,2,3,4,5,6,7,8,9};
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
		//testingTwoLists(listNode1,listNode2);
		
	
		
	}
	
	
	
}
