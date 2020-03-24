package com.others.practice;

public class TestNothing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNothing execution = new TestNothing();
		execution.testing();
	}

	public void testing() {
		int input = 1234; 
		int r=sum(input);
		System.out.println("input="+input+"|sum="+r);
	        
	}
	
	public int sum(int n) {
        int res = 0;
        while(n>0){
        	res += (n%10);
            n=n/10; 
            System.out.println("res="+res+"|n="+n);
        }
        return res;
	}
	
}
