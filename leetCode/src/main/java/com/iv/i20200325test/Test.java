package com.iv.i20200325test;



public class Test {
 /*
Array of Strings
Need to know the number of capital letters in each String
Also we need to know the index of each capital letter in each string
  */
    public static void main(String[] arg){

        String[] strings = {"HarisH","sdfasaxT"};
        Integer[] result = new Integer[strings.length];
        //List<String> list = new ArrayList<String>();
        System.out.println("");

        for(int i=0; i< strings.length;i++){
            result[i] = countCaptial(strings[i]);
            System.out.println("strings i ="+i+" has captital "+result[i]+" letters ");
        }
        splitSentence(stringTest);
    }

    public static Integer countCaptial(String s){
        Integer count = 0;
        for(int i =0 ;i<s.length();i++){
            if (s.charAt(i) >'A'  && s.charAt(i) < 'Z'){
                count++;
            }
        }
        return count;
    }

    /*
    Display Fibonacci series using for loop  Upto 100: 0 + 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 +
    1+2+3+4+5+6+7+8
     */
    /*

     */


/*
Sentence
I want to split the sentence into strings
I am working from Walmart from 5 years
https://www.geeksforgeeks.org/split-string-substrings-using-delimiter/
 */

    private static String stringTest = "I am working from Walmart from 5 years";
    public static void splitSentence(String sentence){
        String[] array = sentence.split(" ");

        for(int i=0; i<array.length; i++){
            String tmp = array[i].trim();
            if (tmp.length()>=1)
                System.out.println(tmp);
        }

    }

}
