package com.leetcode.l897;

import java.util.Stack;

import com.others.datastructure.tree.base.TreeNode;

public class Solution {
	//897. Increasing Order Search Tree
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //my idear:traversal binary tree with the left-root-rigth(inorder). and then put in the queue,and make a new tree without left
    public TreeNode increasingBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root; //defensive coding
        traversalInOrder(root);
        TreeNode lastNewNode = null;
        while(!nodeStack.isEmpty()){
            TreeNode newNode = new TreeNode(nodeStack.pop());
            newNode.right = lastNewNode;
            lastNewNode = newNode;             
        }       
        return lastNewNode; 
    }

    
    Stack<Integer> nodeStack = new Stack<Integer>();
    public void traversalInOrder(TreeNode root){
        if (root == null) return ;
        if (root.left !=null)  
            traversalInOrder(root.left);

        nodeStack.push(root.val);
        //System.out.println(root.val);
        
        if (root.right !=null)  
            traversalInOrder(root.right);
        //return void;

    }
    
	

}
