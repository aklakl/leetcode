package com.others;

import java.util.HashMap;
import java.util.Map;

public class TmpTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tmpTesting();
		testMapSize();
		tmpTestingChar();
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

}
