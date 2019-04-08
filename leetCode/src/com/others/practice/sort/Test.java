package com.others.practice.sort;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
	
	
	
	
	public static void main(String[] arg) {
		ArrayList<Employee> list = new ArrayList<>();
		Employee e = new Employee(1l, "Alex", LocalDate.of(2018, Month.APRIL, 21));
		list.add(new Employee(1l, "Alex", LocalDate.of(2018, Month.APRIL, 21)));
		list.add(new Employee(4l, "Brian", LocalDate.of(2018, Month.APRIL, 22)));
		list.add(new Employee(3l, "Piyush", LocalDate.of(2018, Month.APRIL, 25)));
		list.add(new Employee(2l, "Pawan", LocalDate.of(2018, Month.APRIL, 24)));
		list.add(new Employee(5l, "Charles", LocalDate.of(2018, Month.APRIL, 23)));
		
		
		//Collections.sort(list);
		Collections.sort(list, new NameSorter());
		 
		System.out.println(list);
	}
	
	
}
