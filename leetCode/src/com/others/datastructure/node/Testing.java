package com.others.datastructure.node;


public class Testing {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Testing execution = new Testing();
		execution.testingStart();
		System.out.println("=========================================");
	}
	
	

	private void testingStart() {
		System.out.println("testing=begin");
		int[] arrayListNode1 = {1,2,3,4,5};
		ListNode result = null;
		result = testingListNode(ListNode.arrayToListNode(arrayListNode1));
		System.out.println("testingListNode="+result);
		System.out.println("==========================================");
		
		result = testingInsertListNodeAfterIndex(ListNode.arrayToListNode(arrayListNode1),new ListNode(0),2);
		System.out.println("testingInsertListNodeAfterIndex="+result);
		System.out.println("==========================================");
		
		System.out.println("==========================================");
		
		
		
		System.out.println("testing=end");
		
	}
	
	
	public ListNode testingListNode(ListNode head) {
		System.out.println("head="+head);
		ListNode tail = head;			//made changes with tail pointer only tail changing, the head is no changed
		ListNode headshadow = head;		//made changes with tail pointer headshadow not changing
		ListNode tailshadow = tail; 	//made changes with tail pointer tailshadow not changing
		while(tail.next!=null) {
			tail = tail.next;
			//System.out.println("head="+head+"|tail="+tail+"|tmp="+tmp);
		}
		tail.next = new ListNode(99);
		System.out.println("head="+head+"|tail="+tail+"|headshadow="+headshadow+"|tailshadow="+tailshadow);
		return head;	
	}

	
	//insert after index
	public ListNode testingInsertListNodeAfterIndex(ListNode head,ListNode newNode,int index) {
		System.out.println("head="+head);
		ListNode curr = head;			//made changes with tail pointer only tail changing, the head is no changed
		int i = 1;
		while(curr.next!=null) {
			ListNode next = curr.next;
			if (i==index) {
				curr.next = newNode;
				newNode.next = next;
				break;
			}
			curr = next;
			i++;
			System.out.println("head="+head+"|curr="+curr+"|next="+next);
		}
		System.out.println("head="+head);
		return head;	
	}
	
}
