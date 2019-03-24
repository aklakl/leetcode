package com.others;

public class TmpTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tmpTesting();
	}
	
	public static void tmpTesting() {
		System.out.println("tmpTesting");
		int i=4;
		for(int j =1 ;j<999;j++) {
			int m = j % i;
			System.out.println("j("+j+") mod i("+i+") ="+m+"");
			
		}
		
	}
	
	

}
