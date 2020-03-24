package com.leetcode.l942;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
//942. DI String Match

not easy
*/
public class Solution {
	
	public static void main(String[] arg) {
		Solution solution = new Solution();
		String string = "IDID";	// [0,4,1,3,2]
		string = "III";	//[0,1,2,3]
		string = "DDI";//[3,2,0,1]
		string = "DIDI";//[4,0,3,1,2]
		int[] result = solution.diStringMatch(string);
		
	}

	/*
	class Solution {
		public:
		    vector<int> diStringMatch(string S) {
		        vector<int> ans = {0};
		        int n = S.length();
		        for (int i = 0; i < n; i++) {
		            if (S[i] == 'I') ans.push_back(i + 1);
		            else {
		                for (int j = 0; j < ans.size(); j++)
		                    ans[j]++;
		                ans.push_back(0);
		            }
		        }
		        return ans;
		    }
		};
	 */

	//“I” -> use the smallest possible number
	//“D” -> use the largest possible number
	public int[] diStringMatch(String S) {
		int len = S.length();
		int[] result = new int[len+1];
		int low = 0;
	    int high = len;
	    for (int i = 0; i < len ; i++) {
	    	char c = S.charAt(i);
	    	if (c == 'I')
	    		result[i] = low++;
	    	else
	    		result[i] = high--;
	    }
	    result[len] = low;
	    System.out.println("result="+result);
	    return result;
	}
	
	//bad solution
    public int[] diStringMatch_bad(String S) {
    	int len = S.length();
    	int[] result = new int[len+1];
    	int index = 0;
    	for(int i = 0; i < len ;i ++) {
    		if (S.charAt(i) =='I') {
    			result[i+1] = i+1;
    		}else {//D
    			for(int j = 0 ; i< len; j++) {
    				//result[j]++	
    			}
    			
    		}
    			
    		
    		
    	}
		return result;
    }
	
}
