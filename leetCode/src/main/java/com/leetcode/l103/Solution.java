package com.leetcode.l103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
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
        line = "[3,9,20,null,null,15,7]";	//expected 
        line = "[1,2,3,4,5]";	//expected [[1],[3,2],[4,5]]
        line = "[1,2,3,4,null,null,5]";		//expected [[1],[3,2],[4,5]]
        System.out.println(line);
        TreeNode root = stringToTreeNode(line);
        List<List<Integer>> ret = new Solution().zigzagLevelOrder(root);
        String out = int2dListToString(ret);
        System.out.println("1output="+out);
        
        System.out.println("==============================================");
        ret = new Solution().zigzagLevelOrder1(root);
        out = int2dListToString(ret);
        System.out.println("2output="+out);
        
        
        
    }
	//=============================upper these is the testing code=========================================================


	
    //my solution using level not correct
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        queueNode.offer(root);
        int layerIndex = 1;  //the odd even flag
        while(!queueNode.isEmpty()){
            int levelCount = queueNode.size();
            List<Integer> sublist = new ArrayList<Integer>();
            
            while(levelCount != 0 ) {  //traversal each node for the same level 
            	TreeNode currentNode = queueNode.poll();
                sublist.add(currentNode.val);
                System.out.println("layerIndex="+layerIndex+"|levelCount="+levelCount+"|val="+currentNode.val+"|left="+ (currentNode.left != null ? currentNode.left.val : "") +"|right="+(currentNode.right !=null ? currentNode.right.val : ""));
                if (layerIndex%2 == 0){
                    if (currentNode.left != null)  queueNode.offer(currentNode.left);
                    if (currentNode.right != null) queueNode.offer(currentNode.right);
                }else{
                    if (currentNode.right != null) queueNode.offer(currentNode.right); 
                    if (currentNode.left != null)  queueNode.offer(currentNode.left);
                }
             	levelCount--;
            }
            layerIndex++;
            result.add(sublist);
        }
        return result;
    }
    
    //my solution using  level flag and reverse list
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	if (root == null) return result;
    	Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    	nodeQueue.add(root);
    	int layerIndex = 1;
    	while(!nodeQueue.isEmpty()) {
    		int layerSubCount = nodeQueue.size();
    		List<Integer> subList = new LinkedList<Integer>();
    		while(layerSubCount != 0) {
    			TreeNode currentNode = nodeQueue.poll();
    			if (currentNode.left != null)  nodeQueue.offer(currentNode.left);
    			if (currentNode.right != null) nodeQueue.offer(currentNode.right); 
    			subList.add(currentNode.val);
    			layerSubCount--;
    		}
    		if (layerIndex%2 == 0)  {
    			System.out.println(0);
    			Collections.reverse(subList);
    		}
    		result.add(subList);
    		layerIndex++;
    	}
		return result;
    }

}
