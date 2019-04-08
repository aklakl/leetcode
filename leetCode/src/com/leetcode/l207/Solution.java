package com.leetcode.l207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



//207
/*
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 */
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

	//BFS  --https://www.youtube.com/watch?v=zkTOIVUdW-I
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        HashMap<Integer,List> graphic = new HashMap<Integer,List>(); 
        for(int i = 0 ; i< prerequisites.length;i++){
            int pc = prerequisites[i][1];//prerequisite course
            int ac = prerequisites[i][0];//after course;
            indegree[ac]++;
            if (graphic.containsKey(pc)){
                List aclist = graphic.get(pc); 
                aclist.add(ac);
                graphic.put(pc,aclist);
            }else{
                List aclist = new ArrayList();
                aclist.add(ac);
                graphic.put(pc,aclist);
            }
       
        }
        
        Queue<Integer> queue = new LinkedList();
        for(int i =0; i<numCourses;i++){
            if (indegree[i] == 0)
                queue.offer(i); 
        }
        //BFS
        while(!queue.isEmpty()){
            int indexcourse = queue.poll();
            List<Integer> afterCourses = graphic.get(indexcourse);
            for(int i =0; afterCourses != null && i<afterCourses.size();i++){
                if(--indegree[afterCourses.get(i)]==0) queue.offer(afterCourses.get(i));    
            }        
        }

        for(int i =0;i<indegree.length;i++){
            if (indegree[i] != 0) return false;
        }
        return true;
    }
}
