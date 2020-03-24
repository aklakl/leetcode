package com.others.java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMapFilter {

    public static void main(String[] args) {
    	testMapFilter();
    	testListFilter();
    	
    }
    
    public static void testListFilter() {
    	List<Object> list = Testing.createList(10);
    	String result = list.stream().filter( obj -> {
    		 int value = Integer.parseInt(obj.toString());
    		 if (value >5) {
    			 return true;
    		 }else {
    			 return false;
    		 }
    	}).map( obj -> obj.toString()).collect(Collectors.joining(";"));
    	
    	System.out.println("result="+result);
    }
    
    public static void testMapFilter() {
        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");
        HOSTING.put(5, "aws.amazon.com1231231");
        HOSTING.put(6, "aws.amazon.comtttttttt");

        // Before Java 8
        String result = "";
        for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
            if ("aws.amazon.com".equals(entry.getValue())) {
                result = entry.getValue();
            }
        }
        System.out.println("Before Java 8 : " + result);

        //Map -> Stream -> Filter -> String
        result = HOSTING.entrySet().stream()
                .filter(map -> map.getValue().startsWith("aws.amazon.com") )
                .map(map -> map.getValue())
                .collect(Collectors.joining(";"));

        System.out.println("With Java 8 : " + result);

        // filter more values
        result = HOSTING.entrySet().stream()
                .filter(x -> {
                    if (!x.getValue().contains("amazon") && !x.getValue().contains("digital")) {
                        return true;
                    }
                    return false;
                })
                .map(map -> map.getValue())
                .collect(Collectors.joining(";"));

        System.out.println("With Java 8 : " + result);

    }

}