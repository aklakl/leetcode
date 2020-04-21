package com.iv.i20200325test;

import com.iv.i20200319test.CountWord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;


public class Practice {

	/*
1.  Find X  from array using binary search  int arr[] = { 2, 3, 4, 10, 40 };X=10.
Half search T(n) = T(n/2) + c

2.  Find first repetitive character and first non-repetitive character from string “abcbe”
	 */

	public char firstNonRepeatingCharacter(String str){
		char[] array = str.toCharArray();
		HashMap<Character,Integer> hm= new HashMap<Character,Integer>();
 		for(int i = 0 ;i<array.length; i++){
			if (hm.containsKey(array[i])){
				Integer ii = hm.get(array[i])+1;
				hm.put(array[i],ii);
			}else{
				hm.put(array[i],1);
			}
		}
		char result ='\0';
		for(int i = 0 ;i<array.length; i++){
			if (hm.get(array[i])==1){
				return array[i];
			}
		}
		return result;
		/*
		//https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
		char count[] = new char[256];
		for (int i = 0; i < str.length();  i++)
			count[str.charAt(i)]++;
		int index = -1, i;
		for (i = 0; i < str.length();  i++)
		{
			if (count[str.charAt(i)] == 1)
			{
				index = i;
				break;
			}
		}
		if (index ==-1) return '\0';
		return str.charAt(index);
		*/

	}

	//testSolution
	public char firstRepeatingCharacter(char str[]){
		//my solution

		HashSet<Character> storeC = new HashSet<Character>();
		for(int i=0; i<str.length; i++){
			if (storeC.contains(str[i]))
				return str[i];
			else
				storeC.add(str[i]);
		}
		return '\0';
		//https://www.geeksforgeeks.org/find-repeated-character-present-first-string/
	}

	//recursive
	public int binarySearchWithRecursive(int[] arr, int l, int r,int s){
		int result = -1;
		/*  */
		//my solution  1.boder  2.recursive
		if (arr[r]==s) return r; //checking the tail
		if (l==r){
			return arr[l] == s ? l : result;
		}
		int mid = l+ (r-l)/2;//7/2=3
		if (arr[mid] ==s) return mid;
		//logger.info("search={},left={},right={},middle={}",s,l,r,mid);
		if (s<arr[mid]){
			//value in the left
			result = binarySearchWithRecursive(arr,l,mid-1,s);
		}else{
			//value in the right
			result = binarySearchWithRecursive(arr,mid+1,r,s);
		}
		return result;

		/**/
/*
		int x = s;
		////https://www.geeksforgeeks.org/binary-search/
		// Returns index of x if it is present in arr[l..r], else return -1
		if (arr[r]==x) return r; //checking the tail
		if (r >= l) {
			int mid = l + (r - l) / 2;
			// If the element is present at the middle itself
			logger.info("search={},left={},right={},middle={}",s,l,r,mid);
			if (arr[mid] == x)
				return mid;
			// If element is smaller than mid, then it can only be present in left subarray
			if (arr[mid] > x)
				return binarySearchWithRecursive(arr, l, mid - 1, x);
			// Else the element can only be present in right subarray
			return binarySearchWithRecursive(arr, mid + 1, r, x);
		}
		// We reach here when element is not presentin array
		return -1;
		*/
	}

	//iterative Binary Search
	public int binarySearchWithIterative(int[] arr, int s){



		////https://www.geeksforgeeks.org/binary-search/
		int x = s;
		int l = 0, r = arr.length - 1;
		if (arr[r] == s) return r;
		while (l <= r) {
			int m = l + (r - l) / 2;

			// Check if x is present at mid
			if (arr[m] == x)
				return m;

			// If x greater, ignore left half
			if (arr[m] < x)
				l = m + 1;
				// If x is smaller, ignore right half
			else
				r = m - 1;
		}
		// if we reach here, then element was not present
		return -1;


	}

	public void printResult(Object r,String msg){
		logger.info("{}|resutl = {}",msg,r);
		int result = (int) r;
		if (result == -1)
			logger.info("Element not present");
		else
			logger.info("Element found at " + "index " + result);
	}
	public void testSolution() {
		int[] arr = array;
		int n = arr.length;
		int x = 2;
//		logger.info("arr={}",arr);
//		int result = this.binarySearchWithRecursive(arr,0, n-1, x);
//		printResult(result,"binarySearchWithRecursive");
//		result = this.binarySearchWithIterative(arr, x);
//		printResult(result,"binarySearchWithIterative");


		char[] arrChars = strings.toCharArray();
		logger.info("arrChars={}",arrChars);
		logger.info("firstRepeatingCharacter = {}",firstRepeatingCharacter(arrChars));
		logger.info("firstNonRepeatingCharacter = {}",firstNonRepeatingCharacter(strings));



	}

	public void testBinarySearch(){

		for(int i =0 ; i<=array.length-1;i++){
			int n = array.length;
			int x = array[i];
			int result = this.binarySearchWithRecursive(array,0, n-1, x);
			if (result != i) logger.error("binarySearchWithRecursive result is wrong with value ={} ",array[i]);

			result = this.binarySearchWithIterative(array, x);
			if (result != i) logger.error("binarySearchWithIterative result is wrong with value ={} ",array[i]);

		}

	}

	private static final Logger logger = LoggerFactory.getLogger(CountWord.class);
	private int array[] = { 1,2, 3, 4,5, 10, 40,11 };
	private String strings ="abcdbefghijklmnssssss";


	public static void main(String[] args) {
		Practice t = new Practice();
		t.testSolution();
		t.testBinarySearch();

	}


}

