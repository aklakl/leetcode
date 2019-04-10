package com.others.tmptest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TmpTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tmpTesting();
		testMapSize();
		tmpTestingChar();
		testObjectsToString();
	}
	
	public static void tmpTestingChar(){
		char a ='a';
		char b ='b';
		System.out.println("a="+a+"|"+(int)a);
		System.out.println("b="+b+"|"+(int)b);
		System.out.println("a<b="+(a<b));
	}
	
	public static void tmpTesting() {
		System.out.println("tmpTesting");
		int i=2;
		for(int j =0 ;j<999;j++) {
			double m = j % i;
			System.out.println("j("+j+") mod i("+i+") ="+m+"");
			
		}
	}
	
	public static void testMapSize() {
		Map map = new HashMap<Character,Integer>();
		map.put('a', 10);
		map.put('b', 1);
		map.put('a', 1);
		System.out.println("mapSize="+map.size());
	}

	private String getTest() {
		return null;
	}
	
	public static void testObjectsToString() {
		TmpTesting execution = new TmpTesting();
		boolean result = Objects.toString(execution.getTest()).equals(execution.getTest());
		System.out.println("1result="+result);
		
		result = Objects.toString(execution.getTest()).equals("null");
		System.out.println("2result="+result);
		
		Object o =  Objects.toString(execution.getTest(),null);
		result = o == null ? true : false;
		System.out.println("3result="+result);
		
		
	}
	
}
