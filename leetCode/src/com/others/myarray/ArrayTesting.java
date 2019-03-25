package com.others.myarray;

public class ArrayTesting {

	public static void main(String[] args) {
		arrayTesting();
	}
	
	public static void arrayTesting() {
		System.out.println("arrayTesting");
		Integer[][] array = {
				{11,12,13,14,15},
				{21,22,23,24},
				{31,32,33,34}
				}; 
		System.out.println("array.length="+array.length);
		
		for(int i = 0 ;i<array.length;i++) {
			for(int j =0; j<array[i].length;j++) {
				System.out.println("i="+i+"|j="+j+"|value="+array[i][j]);
			}
		}
		//the arry length is the row,
		
	}
	
	

}
