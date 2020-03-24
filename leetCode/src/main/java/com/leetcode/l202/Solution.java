package com.leetcode.l202;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

//leetcode202
public class Solution {
	public static void main(String[] arg) {
		Solution execution = new Solution();
		execution.testSolution();
		System.out.println("============================");
		//execution.testNumberToString();
		System.out.println("isHappyNew(i)="+execution.isHappyNew(3));
		System.out.println("============================");
	}

	public void testSolution() {
		System.out.println("testSolution");
		int i = 0;
		while (i<999) {
			boolean flag = isHappy(i);
			if (flag) System.out.println("isHappy(i)="+i);
			//int s = getSquareSumOfDigits(i);
			//System.out.println("getSquareSumOfDigits(i)="+s);
			i++;
		}
	}
	
	//http://www.cnblogs.com/grandyang/p/4447233.html
	//fast slow  algorithm
	//这道题还有一种快慢指针的解法,跟 Linked List Cycle 检测环的方法类似，不同的是这道题环一定存在.we only need the cycle is slow=1 
	public boolean isHappyNew(int n) {
		if (n<0) return false;
		int slow = n;
		int fast = n;
		while(true) {
			System.out.println("1slow="+slow+"|fast="+fast);
			slow = getSquareSum(slow);
			fast = getSquareSum(fast);
			System.out.println("2slow="+slow+"|fast="+fast);
			fast = getSquareSum(fast);
			System.out.println("3slow="+slow+"|fast="+fast);
			if (slow==fast) break;
			
		}
		return slow ==1;
	}
	
	
    public boolean isHappy(int n){
        if (n<=0 ) return false;
        Set<Integer> history = new HashSet<>();
        while(n != 1) {
        	if (history.contains(n)) {
        		return false;
        	}else {
        		history.add(n);
        		n = getSquareSum(n);
        	}
        }
        return true;
    }
    
    public int getSquareSum(int n){
        int res = 0;
        while(n > 0) {
        	res = res + (n%10) * (n%10);
        	n =n/10;
        }
    	return res;
    }
	
	
	//easy way to understand
	public boolean isHappy111(int n) {
		if (n <= 0)
			return false;
		Set<Integer> set = new HashSet<>();
		while (n != 1) {
			if (set.contains(n))
				return false;
			else {
				set.add(n);
				n = getSquareSumOfDigits111(n);
			}
		}
		return true;
	}
	private int getSquareSumOfDigits111(int n) {
		int res = 0;
		while (n > 0) {
			res += (n % 10) * (n % 10);
			n /= 10;
		}
		return res;
	}
	
	
	Random random = new Random();
	public void testNumberToString() {
		System.out.println("testNumberToString");
		int i = 0;
		while (i<20) {
			int tmpInt = random.nextInt(99999);	
			System.out.println("tmpInt="+tmpInt);
			testNumberToString(tmpInt);
			testHappyNumber(i);
			i++;
		}
		//double random = Math.random() * 49 + 1;
	}
	
	public void testNumberToString(Object o) {
		String tmpStr = Objects.toString(o);
		int len = tmpStr.length();
		char[] cas = tmpStr.toCharArray();
		System.out.println("len=" + len + ",cas.length="+cas.length);
		
	}
	
	public void testHappyNumber(Object o) {
		String tmpStr = Objects.toString(o);
		int len = tmpStr.length();
		char[] cas = tmpStr.toCharArray();
 
		for(int i=0; i< cas.length;i++) {
			
			Math.pow(i,2);
		}
		
	}
	
	//https://blog.csdn.net/Cloudox_/article/details/52593030 
	public boolean isHappy2(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow((n % 10), 2);
            n = n / 10;
        }
        if (sum >= 10) return isHappy2(sum);
        else if (sum == 1 || sum == 7) return true;
        else return false;
    }
	
	//https://blog.csdn.net/mine_song/article/details/62050098
	public  boolean isHappy1(int n) {
		if (n == 0)
			return false;
		if (n == 1)
			return true;
		int temp = 0;
		//set 储存中间的结果
		Set<Integer> set=new HashSet<>();
		while (n != 1) {
			if (set.contains(n))
				return false;
			set.add(n);
			while (n != 0) {
				temp=temp+(n%10)*(n%10);
				n /= 10;
			}
			n = temp;
			temp=0;
		}
		return true;
	}
 
	
	public boolean isHappy4(int n) {
        if (n < 1) {
            return false;
        }
        // 用于保存中间出现的结果
        HashSet<Integer> set = new HashSet<>(32);
        int tmp;
        int newN;
        // n不为1，并且n的值不能重复出现，否则会死循环
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            newN = 0;
            while (n > 0) {
                tmp = n % 10;
                n /= 10;
                newN += tmp * tmp;
            }

            n = newN;
        }

        return n == 1;
    }

	public static boolean isHappy5(int n) {
		int ans = 0;
		if (n == 1 || n == 7) {
			return true;
		} else if (n > 1 && n < 10) {
			return false;
		} else {
			String numString = "" + n;
			char numChar[] = numString.toCharArray();
			for (char aNumChar : numChar) {
				ans += (aNumChar - '0') * (aNumChar - '0');
			}
		}
		return isHappy5(ans);
	}

//	原文：https://blog.csdn.net/fuxuemingzhu/article/details/49180507 
	
	public boolean isHappy3(int n) {
		while (n > 6) {
			int next = 0;
			while (n>0) {
				next += (n % 10) * (n % 10);
				n /= 10;
			}
			n = next;
		}
		return n == 1;
	}

	//原文：https://blog.csdn.net/Dream_angel_Z/article/details/46432687 

	

}
