package com.leetcode.l107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;


public class Solution {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
		@Override
		public String toString() {
			return "val="+Objects.toString(val) ;
			//return "val="+Objects.toString(val) +"|left="+ (left!= null ? left.toString() : null )+"|right="+(right!= null ? right.toString() : null);
			
		}
	}
	public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
//        while ((line = in.readLine()) != null) {
//            TreeNode root = stringToTreeNode(line);
//            List<List<Integer>> ret = new Solution().levelOrder(root);
//            String out = int2dListToString(ret);
//            System.out.print(out);
//        }
        line= "[3,9,20,null,null,15,7]";
        System.out.println(line);
        TreeNode root = stringToTreeNode(line);
        Solution solution = new Solution();
        List<List<Integer>> ret = solution.levelOrderBottom(root);
        String out = int2dListToString(ret);
        System.out.println("1output="+out);
        
        System.out.println("==============================");
        ret = solution.levelOrderBottom1(root);
        out = int2dListToString(ret);
        System.out.println("2output="+out);
   
    }
	//=============================upper these is the testing code=========================================================
 
    //my solution
    //Runtime: 16 ms, faster than 10.67% of Java online submissions for Binary Tree Level Order Traversal II.
    //Memory Usage: 37.5 MB, less than 5.32% of Java online submissions for Binary Tree Level Order Traversal II.
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)  return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(size!=0 ) {
	            TreeNode node = (TreeNode)queue.poll();
	            System.out.println("node="+node+"|size="+size);
	            list.add(node.val);
	            if (node.left!=null)
	                queue.offer(node.left);
	            if (node.right!=null)
	                queue.offer(node.right);
	            size--;
            }   
            stack.push(list);
        }
        
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        
        return result;
    }
	
	/*
	the tree like this
    3
   / \
  9  20
    /  \
   15   7

	 */
    //another solution with  Postorder Traversal also recursion
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
        System.out.println("level="+level+"|val="+root.val+"|left="+ (root.left != null ? root.left.val : "") +"|right="+(root.right !=null ? root.right.val : ""));
    }

}
