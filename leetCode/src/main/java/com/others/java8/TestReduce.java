package com.others.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
//https://www.geeksforgeeks.org/stream-reduce-java-examples/
class TestReduce { 
  
	
	
	
	
	
	
	
	
	
	
    // Driver code 
    public static void testReduce1() 
    { 
        // creating a list of Strings 
        List<String> words = Arrays.asList("GFG", "Geeks", "for", 
                                           "GeeksQuiz", "GeeksforGeeks"); 
  
        // The lambda expression passed to 
        // reduce() method takes two Strings 
        // and returns the longer String. 
        // The result of the reduce() method is 
        // an Optional because the list on which 
        // reduce() is called may be empty. 
        Optional<String> longestString = words.stream() 
                                   .reduce((word1, word2) 
                             -> word1.length() > word2.length() 
                                           ? word1 : word2); 
  
        // Displaying the longest String 
        longestString.ifPresent(System.out::println); 
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestReduce testing = new TestReduce();
		testing.testReduce1();
		//testing.testFunctional();
		
	}
} 