package com.others.datastructure.node;

public class TestForSwapNode {
	
	
	public static void main(String[] arg) {
		TestForSwapNode execution = new TestForSwapNode();
		execution.testSwapNode();
		
	}
	
	public void  testSwapNode(){
		int[] array = {1,2,3,4,5,6,7,8,9,0};
		ListNode listNode = ListNode.arrayToListNode(array);
		
		
		System.out.println("==============swap head==============");
		System.out.println("before listNode=" + listNode.toString(listNode));
		listNode = swapNode(1,2,listNode);
		//swapNode(2,1,listNode);
		System.out.println("after listNode=" + listNode.toString(listNode));
		System.out.println("==============swap head==============");
		
		
		System.out.println("==============swap middle node==============");
		listNode = ListNode.arrayToListNode(array);
		System.out.println("before listNode=" + listNode.toString(listNode));
		swapNode(2,9,listNode);
		//swapNode(9,2,listNode);
		System.out.println("after listNode=" + listNode.toString(listNode));
		System.out.println("==============swap middle node==============");

		
		System.out.println("==============swap tail==============");
		listNode = ListNode.arrayToListNode(array);
		System.out.println("before listNode=" + listNode.toString(listNode));
		swapNode(0,3,listNode);
		//swapNode(3,0,listNode);
		System.out.println("after listNode=" + listNode.toString(listNode));
		System.out.println("==============swap tail==============");
		
		
		
		
		
	}
	
	public ListNode swapNode(int a, int b, ListNode head) {
		return swapNode_my(a,b,head);
		//return swapNode2(a,b,head);
		//return swapNode1(a,b,head);
	}
	
	//my solution not correct
	public ListNode swapNode_my(int a, int b, ListNode head) {
		if (head == null || head.next == null || a == b ) return head;
		ListNode curr = head;
		ListNode prevA = null;
		ListNode pA = curr;
		
		//search A and record prevA
		while(curr != null) {
			if ( curr.val == a) {
				pA = curr;
				break;
			}
			prevA = curr;
			curr = curr.next;
		}
		//debug("pA="+ pA.toString(pA) +"|prevA="+prevA.toString(prevA));
		
		//search B and record prevB
		ListNode prevB = null;
		ListNode pB = curr;
		curr = head;
		while( curr != null && curr.val != b) {
			prevB = curr;
			curr = curr.next;
		}
		pB = curr;
		//debug("pB="+ pB.toString(pB) +"|prevB="+prevB.toString(prevB));
		
		
		//swap 0 A x y B 
		ListNode temp = pA.next;
		pA.next = pB.next;
		pB.next = temp;
		
		//check prevA is head or not
		if (prevA == null) {
			head = pB;
			prevB.next = pA;
		}
		
		//check prevB is head or not
		if (prevB == null) {
			head = pA;
			prevA.next = pB;
		}
		
		//check  none of the head
		if (prevA != null && prevB != null) {
			//temp = prevA.next;
			prevA.next = pB;
			prevB.next = pA;
		}
		
		return head;
	}
	
	//https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
	static ListNode swapNode2( int x, int y,ListNode head_ref) {
		ListNode head = head_ref;
		// Nothing to do if x and y are same
		if (x == y)
			return null;

		ListNode a = null, b = null;

		// search for x and y in the linked list
		// and store therir pointer in a and b
		while (head_ref.next != null) {

			if ((head_ref.next).val == x) {
				a = head_ref;
			}

			else if ((head_ref.next).val == y) {
				b = head_ref;
			}

			head_ref = ((head_ref).next);
		}

		// if we have found both a and b
		// in the linked list swap current
		// pointer and next pointer of these
		if (a != null && b != null) {
			ListNode temp = a.next;
			a.next = b.next;
			b.next = temp;
			temp = a.next.next;
			a.next.next = b.next.next;
			b.next.next = temp;
		}
		return head;
	}
	
	//https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
	public void swapNode1(int x, int y , ListNode head) 
    { 
        // Nothing to do if x and y are same 
        if (x == y) return; 
  
        // Search for x (keep track of prevX and CurrX) 
        ListNode prevX = null, currX = head; 
        while (currX != null && currX.val != x) 
        { 
            prevX = currX; 
            currX = currX.next; 
        } 
  
        // Search for y (keep track of prevY and currY) 
        ListNode prevY = null, currY = head; 
        while (currY != null && currY.val != y) 
        { 
            prevY = currY; 
            currY = currY.next; 
        } 
  
        // If either x or y is not present, nothing to do 
        if (currX == null || currY == null) 
            return; 
  
        // If x is not head of linked list 
        if (prevX != null) 
            prevX.next = currY; 
        else //make y the new head 
            head = currY; 
  
        // If y is not head of linked list 
        if (prevY != null) 
            prevY.next = currX; 
        else // make x the new head 
            head = currX; 
  
        // Swap next pointers 
        ListNode temp = currX.next; 
        currX.next = currY.next; 
        currY.next = temp; 
    } 
	
	boolean debug = true;
	private void debug(String msg) {
		if (debug)
			System.out.println(msg);
	}
	
    public ListNode switchFristTwo(ListNode head) {
    	ListNode currA = head;
    	ListNode currB = head.next;
    	ListNode temp = currA.next;
    	currA.next = currB;
    	
        // Swap next pointers 
//        Node temp = currX.next; 
//        currX.next = currY.next; 
//        currY.next = temp; 
    	return head;
    }
    
    public ListNode sortListInsertion(ListNode head) {
    	if (head == null || head.next == null) return head;
    	
    	//1,2,3
    	
    	ListNode temp = head.next;
    	head.next = null;
    	ListNode fakeNode = new ListNode(0);
    	fakeNode.next = head;
    	
    	ListNode result = fakeNode.next;
    	head.next = temp;
    	
    	result.next = null;
    
    	ListNode curr = head;
    	
    	
    	while(curr != null ) {
    		
    	}
    	
    	//loop curr(head)
    	//compare loop from 1 - n;
    	//if  curr < n insert curr to n-1
    	
    	System.out.println("curr = " + curr);
    	
    	
    	return head;
    }
}
