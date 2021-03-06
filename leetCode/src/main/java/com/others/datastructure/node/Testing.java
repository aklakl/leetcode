package com.others.datastructure.node;


public class Testing {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Testing execution = new Testing();
		//execution.testingStart();
		System.out.println("=========================================");
		
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
		
		result = testingDeleteListNodeAfterIndex(result,2);
		System.out.println("testingDeleteListNodeAfterIndex="+result);
		System.out.println("==========================================");
		
		testingPointerManipulation();
		System.out.println("");
		System.out.println("testingPointerManipulation=");
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
	
	//delete after index
	public ListNode testingDeleteListNodeAfterIndex(ListNode head,int index) {
		System.out.println("testingDeleteListNodeAfterIndex.head="+head);
		ListNode curr = head;			//made changes with tail pointer only tail changing, the head is no changed
		int i = 1;
		while(curr.next!=null) {
			ListNode next = curr.next.next;
			if (i==index) {
				curr.next = next;
				break;
			}
			curr = curr.next;
			i++;
			System.out.println("head="+head+"|curr="+curr+"|next="+next);
		}
		System.out.println("head="+head);
		return head;	
	}
	
	
	public void print(ListNode head){
	    for(ListNode node = head; node != null; node = node.next){
	        System.out.print(node.val);
	        System.out.print("->");
	        System.out.print("null");
	    }
	}
	
	//https://blog.csdn.net/qilei2010/article/details/51226866
	//1234567890
	public void testingPointerManipulation(){
	    ListNode node1 = new ListNode(1);
	    ListNode node2 = new ListNode(2);
	    ListNode node3 = new ListNode(3);

	    ListNode head = node1;
	    node1.next = node2;
	    node2.next = node3;
	    ListNode headBak = head;
	    headBak = new ListNode(0);
	    ListNode headBak1 = head;
	    headBak1 = headBak1.next;	
	    
	    print(head);//语句1
	    System.out.println("");
	    node1= node2;
	    print(head);//语句2
	    
	    System.out.println("");
	    System.out.println("headBak=>");
	    print(headBak);//语句3
	    
	    System.out.println("");
	    System.out.println("headBak1=>");
	    print(headBak1);//语句3
	}
	//如语句1会输出：123
	//那么请问语句2输出什么？

	private void testingSortTwoListNode() {
		int[] unSortList1 = {3,4,9,5,6,7,1,2,8,10};  
		int[] unSortList2 = {12,13,14,15,11};  
		
		ListNode result = mergeTwoUnSortListNode(ListNode.arrayToListNode(unSortList1),ListNode.arrayToListNode(unSortList2));
		System.out.println("sortTwoListNode="+result);
		System.out.println("==========================================");
		
		
		
	}
	
	
	public ListNode mergeTwoUnSortListNode(ListNode n1, ListNode n2) {
		
		ListNode result = n1;
		ListNode minListNode = n1;
		
//		while() {
//			
//		}
				
		return result ;
	}
	
}
