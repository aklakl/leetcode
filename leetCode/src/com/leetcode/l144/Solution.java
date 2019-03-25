package com.leetcode.l144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//L144
public class Solution {
	public static void main(String[] arg) {
		Solution execution = new Solution();
		execution.testSolution();
		System.out.println("============================");
		
		System.out.println("============================");
	}

	public void testSolution() {
		System.out.println("testSolution");
		int i = 0;
		while (i < 999) {
			// int s = getSquareSumOfDigits(i);
			// System.out.println("getSquareSumOfDigits(i)="+s);
			i++;
		}
	}

	private class Guide {
		int ope; //0 visit 1print
		TreeNode node;
		public Guide(int ope, TreeNode node) {
			super();
			this.ope = ope;
			this.node = node;
		}
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<Guide> stack = new Stack<Guide>();
		Guide guide = new Guide(0,root);
		stack.push(guide);
		while(!stack.isEmpty()) {
			Guide current = stack.pop();
			if (current.node == null) continue; //defensive...
			
			if (current.ope==1) {
				result.add(current.node.val);
			}else {
				// 前序遍历： 根结点 --->左子树--->右子树,stack is the First in Last Out
				stack.push(new Guide(0,current.node.right));
				stack.push(new Guide(0,current.node.left));
				stack.push(new Guide(1,current.node));
			}
		}
		return result;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
