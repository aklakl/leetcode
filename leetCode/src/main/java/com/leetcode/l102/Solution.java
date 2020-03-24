package com.leetcode.l102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
        line= "[3,9,20,null,null,15,7]";
        System.out.println(line);
        TreeNode root = stringToTreeNode(line);
        List<List<Integer>> ret = new Solution().levelOrder(root);
        String out = int2dListToString(ret);
        System.out.print("output="+out);
    }
	//=============================upper these is the testing code=========================================================

    
    
	
	//BFS-Queue solution
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	int totalNodeCount = 0;
        if (root == null)  return result;
    	Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    	nodeQueue.offer(root);
    	int layerIndex = 1;
    	while (!nodeQueue.isEmpty()) {
    		int eachLayerSize = nodeQueue.size();
    		List<Integer> tmpList = new ArrayList<Integer>();
            while(eachLayerSize!=0){
                TreeNode currentNode = (TreeNode)nodeQueue.poll();
                System.out.println("node="+currentNode.val+"|NodeIndex="+totalNodeCount);
                tmpList.add(currentNode.val);
                if (currentNode.left !=null) {
                	nodeQueue.offer(currentNode.left);
                }
                if (currentNode.right!=null) {
                	nodeQueue.offer(currentNode.right);
                }
                eachLayerSize--;
    		    totalNodeCount++;
            }
            result.add(tmpList);
            layerIndex++;
		}
    	return result;
    }
	
    //=================================================================================
    //use inOrderTraversal record the level,Because the space complexity is a little high;
    public List<List<Integer>> levelOrder1(TreeNode root) {
        return inOrderTraversal(root);
    }
    int allmidCount = 0;
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
    public List<List<Integer>> inOrderTraversal(TreeNode root){
        inOrder(root,0);
        System.out.println("map="+map+"|allmidCount="+allmidCount);
        for(int i =0 ; i<allmidCount;i++){
            if (!map.containsKey(i)) break;
            result.add(map.get(i));
        }
        return result;
        
    }
    public void inOrder(TreeNode root,int level){
        if (root == null) return;
        System.out.println("root="+root+"|level="+level);
        List<Integer> list = new ArrayList<Integer>(); 
        if (root.left != null)
            inOrder(root.left,level+1);
        if (map.containsKey(level)){
            list = map.get(level);
        }else{
            map.put(level,list);
        }
        list.add(root.val);
        if (root.right != null)
            inOrder(root.right,level+1);
        allmidCount++;
    }
    
    
	
}
