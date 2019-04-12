package com.others.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	// Root of Binary Tree 
	Node root; 

	BinaryTree() 
	{ 
		root = null; 
	} 

	/* Given a binary tree, print its nodes according to the 
	"bottom-up" postorder traversal. */
	void printPostorder(Node node) 
	{ 
		if (node == null) 
			return; 

		// first recur on left subtree 
		printPostorder(node.left); 

		// then recur on right subtree 
		printPostorder(node.right); 

		// now deal with the node 
		System.out.print(node.key + " "); 
	} 

	/* Given a binary tree, print its nodes in inorder*/
	void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 

		/* first recur on left child */
		printInorder(node.left); 

		/* then print the data of node */
		System.out.print(node.key + " "); 

		/* now recur on right child */
		printInorder(node.right); 
	} 

	/* Given a binary tree, print its nodes in preorder*/
	void printPreorder(Node node) 
	{ 
		if (node == null) 
			return; 

		/* first print data of node */
		System.out.print(node.key + " "); 

		/* then recur on left sutree */
		printPreorder(node.left); 

		/* now recur on right subtree */
		printPreorder(node.right); 
	} 

	// Wrappers over above recursive functions 
	void printPostorder() {	 printPostorder(root); } 
	void printInorder() {	 printInorder(root); } 
	void printPreorder() {	 printPreorder(root); } 

	// Driver method 
	public static void main(String[] args) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 

		System.out.println("Preorder traversal of binary tree is "); 
		tree.printPreorder(); 

		System.out.println("\nInorder traversal of binary tree is "); 
		tree.printInorder(); 

		System.out.println("\nPostorder traversal of binary tree is "); 
		tree.printPostorder(); 
		
		System.out.println("");
		System.out.println("============traversal bfs====================");
		tree.bfs(tree.root);
		System.out.println("");
		System.out.println("============traversal bfs====================");
		
		
		System.out.println("");
		System.out.println("============traversal Bfs_tree====================");
		tree.Bfs_tree(tree.root);
		System.out.println("");
		System.out.println("============traversal Bfs_tree====================");
		
		
		System.out.println("");
		System.out.println("============traversalWithDFSUsingPreorder====================");
		tree.traversalWithDFSUsingPreorder(tree.root);
		System.out.println("");
		System.out.println("============traversalWithDFSUsingPreorder====================");
		
		
		
	} 
	
	//traversal tree using bfs
	private List<Node> bfs(Node root) {
		int curNum = 1;
		int nextNum = 0;
		Queue<Node> queue = new LinkedList<>();
		List<Node> res = new ArrayList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			res.add(node);
			
			curNum--;
			if (node.left != null) {
				queue.add(node.left);
				nextNum++;
			}

			if (node.right != null) {
				queue.add(node.right);
				nextNum++;
			}
			System.out.print(node.key+" ");
			if (curNum == 0) {
				curNum = nextNum;
				nextNum = 0;
			}
		}
		return res;
	}
	
	//traversal tree using bfs (same of above)
	public List<Node> Bfs_tree(Node root){
        Queue<Node> myq = new LinkedList<>();
        List<Node> res = new ArrayList<>();
        if(root==null) return null;
        myq.add(root);
        while(!myq.isEmpty()){
            int len = myq.size();
            for(int i=0;i<len;i++){
                if(myq.peek().left!=null) myq.add(myq.peek().left);
                if(myq.peek().right!=null) myq.add(myq.peek().right);
                Node node = myq.poll();
            	res.add(node);
                System.out.print(node.key+" ");
            }
        }
        return res;
    }
	
	//
	private List<Node> traversalWithDFSUsingPreorder(Node root) {
        List<Node> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
        	Node  node = stack.peek();
        	
        	stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
            res.add(node);
            
        }
        
        for(Node node : res) {
        	System.out.print(node.key+" ");
        }
        return res;
    }
	
} 



// Java program for different tree traversals 

/* Class containing left and right child of current 
node and key value*/
class Node 
{ 
	int key; 
	Node left, right; 

	public Node(int item) 
	{ 
		key = item; 
		left = right = null; 
	} 
} 
