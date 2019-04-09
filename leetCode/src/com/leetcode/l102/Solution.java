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
    	int i= 0;
        if (root == null)  return result;
    	Queue queue = new LinkedList();
    	queue.offer(root);
    	while (!queue.isEmpty()) {
    		int size = queue.size();
    		List<Integer> tmpList = new ArrayList<Integer>();
            while(size!=0){
                TreeNode node = (TreeNode)queue.poll();
                System.out.println("node="+node+"|i="+i);
                tmpList.add(node.val);
                if (node.left !=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
    		    size--;
			    i++;
            }
            result.add(tmpList);
		}
    	return result;
    }
	
    //=================================================================================
    //use inOrderTraversal record the level,maybe the space complexity is a little high;
    public List<List<Integer>> levelOrder1(TreeNode root) {
        return inOrderTraversal(root);
    }
    int allmidCount = 0;
    List result = new ArrayList();
    Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
    public List inOrderTraversal(TreeNode root){
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
        if (root.left != null)
            inOrder(root.left,level+1);
        List<Integer> list = new ArrayList<Integer>(); 
        if (map.containsKey(level)){
            list = map.get(level);
        }else{
            map.put(level,list);
        }
        list.add(root.val);
        allmidCount++;
        if (root.right != null)
            inOrder(root.right,level+1);
    }
    
    
	
}
