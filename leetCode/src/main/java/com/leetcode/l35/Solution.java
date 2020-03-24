package com.leetcode.l35;

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
		int target = 7;
		int result = searchInsert(nums,target);
		System.out.println("result = "+result);
	}
	
	//my solution
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++ ){
            if (target <=nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    
    public int searchInsert1(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
