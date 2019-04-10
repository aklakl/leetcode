package com.others.datastructure.tree;


public class Solution {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static TreeNode newNode(int value) {
		return new TreeNode(value);
	}
	
	//https://www.geeksforgeeks.org/print-leaf-nodes-left-right-binary-tree/
	public static void main(String[] args) {
		// Driver program to test above functions 
		    // Let us create binary tree shown in  
		    // above diagram 
			TreeNode root = newNode(1); 
		    root.left = newNode(2); 
		    root.right = newNode(3); 
		    root.left.left = newNode(4); 
		    root.right.left = newNode(5); 
		    root.right.right = newNode(8); 
		    root.right.left.left = newNode(6); 
		    root.right.left.right = newNode(7); 
		    root.right.right.left = newNode(9); 
		    root.right.right.right = newNode(10); 
		   
		    // print leaf nodes of the given tree 
		    printLeafNodes(root); //the result should be 4 6 7 9 10
		    
	} 
	
	//program to print leaf nodes from left  to right
	public static void printLeafNodes(TreeNode root) {
		if (root == null) return;
		//the no
		if (root.left==null && root.right==null ) {
			System.out.println(root.val);
		}
		// recursively 
		if (root.left!=null) {
			printLeafNodes(root.left);
		}
		// recursively 
		if (root.right!=null) {
			printLeafNodes(root.right);
		}
	}
	
	//preOrder
	public static void preOrder(TreeNode root) {
		if (root == null) return;
		System.out.println(root.val);
		if (root.left!=null) {
			preOrder(root.left);
		}
		if (root.right!=null) {
			preOrder(root.right);
		}
	}
	
	//posOrder
	public static void posOrder(TreeNode root) {
		if (root == null) return;
		if (root.left!=null) {
			printLeafNodes(root.left);
		}
		if (root.right!=null) {
			printLeafNodes(root.right);
		}
		System.out.println(root.val);
	}
	
	//inOrder
	public static void inOrder(TreeNode root) {
		if (root == null) return;
		if (root.left!=null) {
			printLeafNodes(root.left);
		}
		System.out.println(root.val);
		if (root.right!=null) {
			printLeafNodes(root.right);
		}
		
	}
	

}
