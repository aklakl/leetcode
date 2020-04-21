package com.iv.i20200319test;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class CountWord {

	
	public static void testPractice() {
		Map<String,Long> input = Arrays.asList(inputString).stream()
				.map(s -> s.split(" "))
				.map(array -> Arrays.stream(array).filter(s-> !Objects.isNull(s) ) )
				.map(array -> Stream.of(array) )
				.flatMap(stream -> stream)
				.parallel()
				.collect(Collectors.groupingBy(key -> key.toString().toLowerCase().trim(), Collectors.counting() ));

		
		logger.info("input = {}",input);

		List<Entry<String,Long>> mapList = new ArrayList<Entry<String, Long>>(input.entrySet());

		logger.info("mapList = {}",mapList);
		Collections.sort(mapList,new Comparator<Entry<String, Long>>(){

			@Override
			public int compare(Entry<String, Long> o1, Entry<String, Long> o2){
				return o2.getValue().intValue()-o1.getValue().intValue();
			}
		});
		logger.info("mapListSorted = {}",mapList);
		
	}
	

    
    public static void countWordsWithLambda() {
    	//inputString
    	Map<String, Long> countWords = Arrays.asList(inputString).stream()
    	    .map(String::trim)
    	    .filter(s->{
    	    	return  !s.isEmpty() && !s.equals(" ");
    	    })
	    	.map(s -> s.split(" "))
	    	.map(array -> Stream.of(array))
	    	.flatMap(stream -> stream)
	    	.parallel()
	    	.collect(Collectors.groupingBy(s -> s.toString().trim().toLowerCase(),Collectors.counting()))
	    	;
    	
//    	countWords.forEach( (key,value )->{
//            System.out.println(key+" "+value);
//        });
    	
    	List<Map.Entry<String,Long>> sortList = new ArrayList<Map.Entry<String,Long>>(countWords.entrySet());
    	Collections.sort(sortList, new Comparator<Map.Entry<String, Long>>() {

			@Override
			public int compare(Entry<String, Long> o1, Entry<String, Long> o2) {
				// TODO Auto-generated method stub
				return (int) -(o1.getValue() - o2.getValue());
				//return 0;
			}
    	});
    	
    	sortList.forEach( map -> System.out.println(map.getKey() + " "+map.getValue()) );
    	
    	//Stream
    	/*
    	String tmpstr = "ss";
    	String tmpstr2 = "ss";
    	System.out.println("t1="+tmpstr.hashCode()+"|t2="+tmpstr2.hashCode());
    	*/
    }
    
    public static void countWords() {
    	System.out.println("Hello World");
        String[] input = inputString.split(" ");
        TreeMap<String,Integer> hmkeys = new TreeMap<String,Integer>();
        /*
        TreeMap<String,Integer> hmkeys =  new TreeMap<String,Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
            }
            
        });
        */
        //Arrays.stream(input).
        for(int i =0; i<input.length; i++){
            String tmpString = Objects.toString(input[i]);
            tmpString = tmpString.toLowerCase();
            //System.out.println("debug="+tmpString);
            if (hmkeys.containsKey(tmpString)){
                //System.out.println("debug="+tmpString+"|count="+hmkeys.get(tmpString)); 
                hmkeys.put(tmpString,hmkeys.get(tmpString)+1);
            }else{
                hmkeys.put(tmpString,1);
            }
        }

        
        
        hmkeys.forEach( (key,value )->{
            System.out.println(key+" "+value);
        });
        System.out.println("       ");
        List<Map.Entry<String, Integer>> treeMapList =
    		    new ArrayList<Map.Entry<String, Integer>>(hmkeys.entrySet());

  		Collections.sort(treeMapList, new Comparator<Map.Entry<String, Integer>>() {
  			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
  				//return (o2.getValue()).compareTo(o1.getValue());
  				return (o2.getValue() - o1.getValue());
  			}
  		});
  		logger.info(" treeMapList={}",treeMapList);
  		treeMapList.forEach( treeMap ->{
  			logger.info(treeMap.getKey()+" "+treeMap.getValue());
  		});
    }
    

    private static String inputString = "Java unit tests are written to unit test all lines of java code I    can See everything ok";
    private static final Logger logger = LoggerFactory.getLogger(CountWord.class);
	public static void main(String[] arg){
        //URL url = ClassLoader.getSystemResource("log4j.properties");
        //PropertyConfigurator.configure(url);
//    	String path = CountWord.class.getClassLoader()
//                .getResource("jul-log.properties")
//                .getFile();
//    	System.setProperty("java.util.logging.config.file", path);
		//countWordsWithLambda();
    	//countWords();
        testPractice();
    }
    
	
	public CountWord() {
		// TODO Auto-generated constructor stub
	}

}
