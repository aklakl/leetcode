package com.leetcode.l145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	
	public List<Integer> postorderTraversal(TreeNode root) {
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
				// 后序遍历：左子树--->右子树--->根结点 ,stack is the First in Last Out
				stack.push(new Guide(1,current.node));
                stack.push(new Guide(0,current.node.right));
				stack.push(new Guide(0,current.node.left));
			}
		}
		return result;
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
   
   public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
