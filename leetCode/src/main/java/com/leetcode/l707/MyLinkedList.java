package com.leetcode.l707;

import com.others.datastructure.node.ListNode;

/*
["MyLinkedList","addAtHead","get","addAtTail","deleteAtIndex","addAtHead","deleteAtIndex","get","addAtTail","addAtHead","addAtTail","addAtTail","addAtTail","addAtIndex","get","addAtIndex","addAtHead","deleteAtIndex","addAtIndex","addAtHead","addAtIndex","deleteAtIndex","get","addAtTail","deleteAtIndex","deleteAtIndex","addAtTail","addAtTail","addAtIndex","addAtHead","get","get","addAtTail","addAtTail","addAtTail","addAtTail","addAtIndex","addAtIndex","addAtHead","addAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","addAtHead","deleteAtIndex","addAtHead","get","addAtHead","get","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtTail","deleteAtIndex","get","addAtIndex","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtIndex","deleteAtIndex","deleteAtIndex","deleteAtIndex","addAtHead","addAtTail","addAtTail","addAtHead","addAtTail","addAtIndex","deleteAtIndex","deleteAtIndex","addAtIndex","addAtHead","addAtHead","addAtTail","get","addAtIndex","get","addAtHead","addAtHead","addAtHead","addAtIndex","addAtIndex","get","addAtHead","get","get","addAtTail","addAtHead","addAtHead","addAtTail","addAtTail","get","addAtTail"]
[[],[8],[1],[81],[2],[26],[2],[1],[24],[15],[0],[13],[1],[6,33],[6],[2,91],[82],[6],[4,11],[3],[7,14],[1],[6],[99],[11],[7],[5],[92],[7,92],[57],[2],[6],[39],[51],[3],[22],[5,26],[9,52],[69],[5,58],[79],[7],[41],[33],[88],[44],[8],[72],[93],[18],[1],[9],[46],[9],[92],[71],[69],[11,54],[27],[83],[12],[20],[19,97],[77],[36],[3],[35],[16,68],[22],[36],[17],[62],[89],[61],[6],[92],[28,69],[23],[28],[7,4],[0],[24],[52],[1],[23,3],[7],[6],[68],[79],[45,90],[41,52],[28],[25],[9],[32],[11],[90],[24],[98],[36],[34],[26]]

 */

class MyLinkedList {
	
	ListNode node;
	ListNode tail;
	int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	if (index >= size || index < 0) return -1; 
    	int i = 0 ;
    	ListNode cur = node;
    	while(i < index ) {
    		cur = cur.next;
    		i++;
    	}
		return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	ListNode newNode = new ListNode(val);
    	newNode.next = node;
    	if (node == null) {
    		tail = newNode;
    	}
    	node = newNode;
    	size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (tail == null) return;
        ListNode newNode = new ListNode(val);
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
    	if (index >= size || index < 0) return ;
    	if (index ==0) {
    		this.addAtHead(val);
    		return ;
    	}
    	int i = 0 ;
    	ListNode newNode = new ListNode(val);
    	ListNode cur = node;
    	while(i < index-1 ) {
    		cur = cur.next;
    		i++;
    	}
    	ListNode next = cur.next;
    	cur.next = newNode;
    	newNode.next = next;
    	size++;
    }
    
    public void deleteHead() {
    	node = node.next;
		size--;
		return ;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
    	if (index >= size || index < 0) return ;
    	if (index ==0) {
    		this.deleteHead();
    		return;
    	}
    	int i = 0;
    	ListNode curr = node;
    	while(i < index-1 ) {
    		curr = curr.next;
    		i++;
    	}
    	ListNode next = curr.next.next;
    	curr.next = next;
    	size--;
    }
    
    public static void main(String[] arg) {
    	testing2();
    }
    
    public static void testing2() {
    	MyLinkedList linkedList = new MyLinkedList();
    	linkedList.addAtHead(1);
    	linkedList.addAtTail(3);
    	linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
    	System.out.println("node="+linkedList.node.toString()+"|s="+linkedList.size);
    	int result = linkedList.get(1);            // returns 2
    	System.out.println("result=" + result);
    	System.out.println("node="+linkedList.node.toString()+"|s="+linkedList.size);
    	linkedList.deleteAtIndex(1);  // now the linked list is 1->3
    	System.out.println("node="+linkedList.node.toString()+"|s="+linkedList.size);
    	result = linkedList.get(1);            // returns 3
    	System.out.println("result=" + result);
    	System.out.println("node="+linkedList.node.toString()+"|s="+linkedList.size);
    	
    	linkedList.addAtIndex(0, 0);  // linked list becomes 0-1->3
    	System.out.println("node="+linkedList.node.toString()+"|s="+linkedList.size);
    	
    	linkedList.deleteAtIndex(2);  // linked list becomes 0-1 
    	System.out.println("node="+linkedList.node.toString()+"|s="+linkedList.size);
    	linkedList.deleteAtIndex(0);  // linked list becomes 0 
    	System.out.println("node="+linkedList.node.toString()+"|s="+linkedList.size);
    	
    }
    
    public static void testing() {
   	 MyLinkedList obj = new MyLinkedList();
   	 for(int i = 0;i<10 ; i++) {
   		 obj.addAtHead(i);
   	 }
   	 System.out.println("node="+obj.node.toString()+"|s="+obj.size);
   	 obj.addAtTail(11);
   	 System.out.println("node="+obj.node.toString()+"|s="+obj.size);
   	 obj.addAtIndex(5,5);
   	 System.out.println("node="+obj.node.toString()+"|s="+obj.size);
   	 obj.deleteAtIndex(5);
   	 System.out.println("node="+obj.node.toString()+"|s="+obj.size);
   	 int param_1 = obj.get(5);
   	 System.out.println(param_1);
   	 System.out.println("node="+obj.node.toString()+"|s="+obj.size);
   	 
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
