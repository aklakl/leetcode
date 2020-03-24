package com.leetcode.l438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		solution.testSolution();
	}
	
	
	public void testSolution() {
		//String s1 = "cbaebabacdf123cba";
		//String s2 = "abc";
		List<Integer> result = findAnagrams(s1,s2);
		System.out.println("result="+result.toString());
		
	}
	
	//https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
	//https://www.jianshu.com/p/869f6d00d962
	//similler solution  using Sliding Window Algorithm 
	//String s1 = "cbaaabbabacdf123cba";
	String s1 = "cbaebabaacccbad";
	String s2 = "abc";
	public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int begin = 0, end = 0;
        
        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            System.out.println("1|counter="+counter+"|begin="+begin+"|end="+end+"|endValue="+c+"|map="+map.toString());
            end++;
            while(counter == 0){
                char tempc = s.charAt(begin);
                System.out.println("2|counter="+counter+"|begin="+begin+"|end="+end+"|endValue="+c+"|beginValue="+tempc+"|map="+map.toString());
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }
            
        }
        return result;
    }
	
	// Time Limit Exceeded
	public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (p.length() > s.length()) return result;
        HashMap<Character,Integer> mapSource = new HashMap<Character,Integer>();
        for(int i =0; i < p.length(); i++ ){
            char c = p.charAt(i);
            mapSource.put(c,mapSource.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> map = (HashMap<Character, Integer>) mapSource.clone() ;
        int counter = map.size() ;
        for(int cur = 0; cur< s.length();cur++){
            if (cur+p.length() > s.length()) return result;
            for(int i = 0;i<p.length();i++){
                char key = s.charAt(cur+i);
                if (map.containsKey(key)){
                    map.put(key,map.get(key)-1);
                    if (map.get(key) == 0) counter--;     
                }
            }
            if (counter ==0)  result.add(cur);
        	counter = map.size() ;
        	map = (HashMap<Character, Integer>) mapSource.clone() ; ;
        }
        return result;
    }
	
	//my solution
	public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        
        int[] intp = new int[26];
        for(int i = 0;i<p.length();i++){
            intp[p.charAt(i) - 'a']++;
        }
        
        for(int index = 0; index < s.length(); index++){
            if (index + p.length() > s.length()) break;
            
            int[] ints = new int[26];
            boolean flag = true;
            for(int i = 0;i<p.length();i++){
                ints[s.charAt(index+i) - 'a']++;
                if (ints[s.charAt(index+i) - 'a'] > intp[s.charAt(index+i) - 'a'] ){
                    flag = false;
                    break; 
                }
                
            }
            //if (intp.equals(ints)) result.add(index);
            /*
            for(int i = 0; i<26; i ++){
                if (ints[i] != intp[i]){
                    flag = false;
                    break;
                }
            }
            */
            if (flag) result.add(index);
            
        }
        return result;
    }

}
