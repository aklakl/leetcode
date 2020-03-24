package com.others.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//testing 
public class Testing {


	
	
	public void testFunctional () {
		System.out.println("testFunctional");
		Runnable r = new Runnable(){
			@Override
			public void run() {
				System.out.println("My Runnable");
			}};
		Runnable r1 = () -> {
			System.out.println("My Runnable lambda");
		};	
		Interface1 i1 = (s) -> System.out.println(s);
		
		i1.method1("abc");
		r.run();
		r1.run();
		
	}
	
	public void testLambdaForEach() {
		System.out.println("testLambdaForEach");
		List<Object> list = createList(10);
		
		list.forEach( (obj) ->{
			System.out.println("index="+obj);
		});

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Testing testing = new Testing();
		testing.testLambdaForEach();
		testing.testFunctional();
		//testing.testFunctional();
	}
	

	
	public static List<Object> createList( int count){
		if (Objects.isNull(count)) count = 100;
		//creating sample Collection
		List<Object> myList = new ArrayList<Object>();
		for(int i=0; i<count; i++) myList.add(i);
		return myList;
	}

}
