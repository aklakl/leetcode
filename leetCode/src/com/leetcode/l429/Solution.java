package com.leetcode.l429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};

	 /*
	    //
	    public List<List<Integer>> levelOrder(Node root) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if (root == null) return result; 
	        Queue<Node> queue = new LinkedList<Node>();
	        queue.offer(root);
	        
	        while(queue.size()>0){
	            System.out.println("queue="+queue);
	            List<Integer> list = new ArrayList<Integer>();
	            Node currentNode = queue.poll();
	            list.add(currentNode.val);
	            int cs = currentNode.children == null ? 0 : currentNode.children.size()-1;
	            while(cs>0){
	                queue.offer(currentNode.children.get(cs--)); 
	            }
	            result.add(list);
	            
	        }
	        return result;
	    }
	    
	    public List bfs(Node node){
	        if (node !=null)
	        
	    }
	*/
	/*
	 public List<List<Integer>> levelOrder(Node root) {
	     
	    List<List<Integer>> retList = new ArrayList<>();
	    if (root == null) return retList;
	    Queue<Node> nodeQueue = new LinkedList<>();
	    nodeQueue.offer(root);
	    while(!nodeQueue.isEmpty()) {
	        List<Integer> layerNodeList = new ArrayList<>();
	        int curLayerSize = nodeQueue.size();
	        for (int i = 0; i < curLayerSize; i++) {
	            Node cur = nodeQueue.poll();
	            layerNodeList.add(cur.val);
	            if (cur.children != null) {
	                for (Node tmp : cur.children) {
	                    nodeQueue.offer(tmp);
	                }
	            }
	        }
	        retList.add(layerNodeList);
	    }
	    return retList;
	}
	   

	    //my solution use BFS ,
	    public List<List<Integer>> levelOrder(Node root) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if (root == null) return result; 
	        
	        Queue<Node> queue = new LinkedList<Node>();
	        queue.offer(root);
	        
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            List<Integer> list = new ArrayList<Integer>();
	            
	            while(size != 0){    //traveral each node for the same level
	                Node node = queue.poll();
	                list.add(node.val);
	                if (node.children !=null ){
	                    for(Node n : node.children){
	                        queue.offer(n);
	                    }
	                }
	                size--;
	            }   
	            result.add(list);   
	        }
	        return result;
	        
	    }
	    
	 */
    //my solution use BFS , clear  comment
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        Queue<Node> nodeQueue = new LinkedList<Node>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()){
            List<Integer> sublist = new ArrayList<Integer>();
            int layerloop = nodeQueue.size();
            for (int i =0 ; i<layerloop; i++){
                Node currentNode = nodeQueue.poll();
                sublist.add(currentNode.val);
                for(int j = 0; j < (currentNode.children != null ? currentNode.children.size() : 0 );j++){
                    nodeQueue.offer(currentNode.children.get(j));
                }
            }
            result.add(sublist);
        }
        return result;
    }  
	    
	    
}
