package com.leetcode.l637;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.others.datastructure.tree.base.TreeNode;

class Solution {
	
	//BFS none recursion
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<Double>();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        int layerIndex = 0;
        while(!nodeQueue.isEmpty()){
            int layerNodeSize = nodeQueue.size();
            int currentLayerNodeCount = layerNodeSize;
            Double layerSum = 0.0;
            
            while(layerNodeSize != 0){
                TreeNode currentNode = nodeQueue.poll();
                layerSum +=currentNode.val; 
                //System.out.println("layerSum="+layerSum);
                if (currentNode.left != null) nodeQueue.offer(currentNode.left);
                if (currentNode.right != null) nodeQueue.offer(currentNode.right);
                layerNodeSize--;
            }
            double average = layerSum/currentLayerNodeCount;
            //System.out.println("average="+average);
            result.add(average);   
            
        }
        return result;
        
    }
}