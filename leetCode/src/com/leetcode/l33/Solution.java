package com.leetcode.l33;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] arg) {
		Solution execution = new Solution();
		execution.testSolution();
		System.out.println("============================");
		
		
		System.out.println("============================");
	}

	public void testSolution() {
		System.out.println("testSolution");
		int[] nums = {1,2,3,4,5,6,7,8};
		int target = 0;
		int result = search(nums,target);
		System.out.println("result = "+result);
	}
	
	//my solution
    public int search(int[] nums, int target) {
        if (nums.length ==0 ) return -1;
        for(int i = 0 ; i < nums.length;i++){
            if(nums[i] == target ){
                return i;
            }
        }
        return -1;
    }
	
    
    //more solution
    public int search1(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;
            
            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }
	
}
